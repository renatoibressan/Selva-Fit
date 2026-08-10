package br.com.selvafit.builder;

import br.com.selvafit.exception.DadoInvalidoException;
import br.com.selvafit.model.Alimento;

public class AlimentoBuilder {
    
    private Alimento alimento;

    public AlimentoBuilder() {
        alimento = new Alimento();
    }

    public AlimentoBuilder nome(String nome) {
        alimento.setNome(nome);
        return this;
    }

    public AlimentoBuilder calorias(double calorias) throws DadoInvalidoException {
        alimento.setCalorias(calorias);
        return this;
    }

    public AlimentoBuilder proteinas(double proteinas) throws DadoInvalidoException {
        alimento.setProteinas(proteinas);
        return this;
    }

    public AlimentoBuilder carboidratos(double carboidratos) throws DadoInvalidoException {
        alimento.setCarboidratos(carboidratos);
        return this;
    }

    public AlimentoBuilder gorduras(double gorduras) throws DadoInvalidoException {
        alimento.setGorduras(gorduras);
        return this;
    }

    public Alimento build() {
        return alimento;
    }

}
