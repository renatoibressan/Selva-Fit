package br.com.selvafit.model;

import java.util.ArrayList;
import java.util.List;

public class Refeicao {
    
    private List<Alimento> cafeManha;
    private List<Alimento> lancheTarde;
    private List<Alimento> almoco;
    private List<Alimento> jantar;

    public Refeicao() {
        this.cafeManha = new ArrayList<>();
        this.lancheTarde = new ArrayList<>();
        this.almoco = new ArrayList<>();
        this.jantar = new ArrayList<>();
    }

    public List<Alimento> getCafeManha() {
        return cafeManha;
    }

    public void setCafeManha(List<Alimento> cafeManha) {
        this.cafeManha = cafeManha;
    }

    public List<Alimento> getLancheTarde() {
        return lancheTarde;
    }

    public void setLancheTarde(List<Alimento> lancheTarde) {
        this.lancheTarde = lancheTarde;
    }

    public List<Alimento> getAlmoco() {
        return almoco;
    }

    public void setAlmoco(List<Alimento> almoco) {
        this.almoco = almoco;
    }

    public List<Alimento> getJantar() {
        return jantar;
    }

    public void setJantar(List<Alimento> jantar) {
        this.jantar = jantar;
    }

}
