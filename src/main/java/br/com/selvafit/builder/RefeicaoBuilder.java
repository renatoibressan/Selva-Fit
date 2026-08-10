package br.com.selvafit.builder;

import java.util.List;

import br.com.selvafit.model.Alimento;
import br.com.selvafit.model.Refeicao;

public class RefeicaoBuilder {
    
    private Refeicao refeicao;

    public RefeicaoBuilder() {
        refeicao = new Refeicao();
    }

    public RefeicaoBuilder cafeManha(List<Alimento> cafeManha) {
        refeicao.setCafeManha(cafeManha);
        return this;
    }

    public RefeicaoBuilder lancheTarde(List<Alimento> lancheTarde) {
        refeicao.setLancheTarde(lancheTarde);
        return this;
    }

    public RefeicaoBuilder almoco(List<Alimento> almoco) {
        refeicao.setAlmoco(almoco);
        return this;

    }

    public RefeicaoBuilder jantar(List<Alimento> jantar) {
        refeicao.setJantar(jantar);
        return this;
    }

    public Refeicao build() {
        return refeicao;
    }

}
