package br.com.selvafit.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import br.com.selvafit.dto.EvolucaoMedidas;
import br.com.selvafit.dto.EvolucaoPeso;
import br.com.selvafit.dto.ResumoCorporal;
import br.com.selvafit.dto.ResumoRelatorio;
import br.com.selvafit.exception.UsuarioNaoEncontradoException;
import br.com.selvafit.model.AvaliacaoFisica;
import br.com.selvafit.model.Usuario;
import br.com.selvafit.repository.interfaces.Repository;

public class RelatorioService {

    private final Repository<Usuario> usuarioRepository;
    private final Repository<AvaliacaoFisica> avaliacaoRepository;

    private List<AvaliacaoFisica> buscarAvaliacoes(UUID usuarioId) {
        return avaliacaoRepository.listarTodos()
                                .stream()
                                .filter(a -> a.getUsuarioId().equals(usuarioId))
                                .sorted(Comparator.comparing(AvaliacaoFisica::getData))
                                .toList();
    }

    public RelatorioService(Repository<Usuario> usuarioRepository, Repository<AvaliacaoFisica> avaliacaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public ResumoRelatorio gerarResumoRelatorio(UUID usuarioId) {
        Usuario usuario = usuarioRepository.buscarPorId(usuarioId)
                                            .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário " + usuarioId + " não encontrado!"));
        List<AvaliacaoFisica> avaliacoes = avaliacaoRepository.listarTodos()
                                                            .stream()
                                                            .filter(a -> a.getUsuarioId().equals(usuarioId))
                                                            .sorted(Comparator.comparing(AvaliacaoFisica::getData))
                                                            .toList();
        String nomeUsuario = usuario.getNome();
        LocalDate primeiraAvaliacao = avaliacoes.getFirst().getData();
        LocalDate ultimaAvaliacao = avaliacoes.getLast().getData();
        int quantidadeAvaliacoes = avaliacoes.size();
        double pesoInicial = avaliacoes.getFirst().getPeso();
        double pesoAtual = avaliacoes.getLast().getPeso();
        double variacaoPeso = Math.abs(pesoAtual - pesoInicial);
        return new ResumoRelatorio(nomeUsuario, primeiraAvaliacao, ultimaAvaliacao, quantidadeAvaliacoes, pesoInicial, pesoAtual, variacaoPeso);
    }

    public List<EvolucaoPeso> gerarEvolucaoPeso(UUID usuarioId, LocalDate inicio, LocalDate fim) {
        return buscarAvaliacoes(usuarioId).stream()
                                        .filter(a -> !a.getData().isBefore(inicio) && !a.getData().isAfter(fim))
                                        .map(a -> new EvolucaoPeso(
                                            a.getData(), 
                                            a.getPeso()
                                        ))
                                        .toList();
    }

    public List<EvolucaoMedidas> gerarEvolucaoMedidas(UUID usuarioId, LocalDate inicio, LocalDate fim) {
        return buscarAvaliacoes(usuarioId).stream()
                                        .filter(a -> !a.getData().isBefore(inicio) && !a.getData().isAfter(fim))
                                        .map(a -> new EvolucaoMedidas(
                                            a.getData(), 
                                            a.getCintura(), 
                                            a.getPeito(), 
                                            a.getBraco(), 
                                            a.getQuadril(), 
                                            a.getCoxa(), 
                                            a.getPanturrilha()
                                        ))
                                        .toList();
    }

    public ResumoCorporal gerarResumoCorporal(UUID usuarioId) {
        List<AvaliacaoFisica> avaliacoes = avaliacaoRepository.listarTodos()
                                                            .stream()
                                                            .filter(a -> a.getUsuarioId().equals(usuarioId))
                                                            .sorted(Comparator.comparing(AvaliacaoFisica::getData))
                                                            .toList();
        double pesoInicial = avaliacoes.getFirst().getPeso();
        double pesoAtual = avaliacoes.getLast().getPeso();
        double variacaoPeso = Math.abs(pesoAtual - pesoInicial);
        double percentualGorduraInicial = avaliacoes.getFirst().getPercentualGordura();
        double percentualGorduraAtual = avaliacoes.getLast().getPercentualGordura();
        double variacaoPercentualGordura = Math.abs(percentualGorduraAtual - percentualGorduraInicial);
        return new ResumoCorporal(pesoInicial, pesoAtual, variacaoPeso, percentualGorduraInicial, percentualGorduraAtual, variacaoPercentualGordura);
    }

}
