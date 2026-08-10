package br.com.selvafit.model;

import br.com.selvafit.exception.DadoInvalidoException;

public class PlanoAlimentar {
    
    private double calorias;
    private double proteinas;
    private double carboidratos;
    private double gorduras;

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) throws DadoInvalidoException {
        if (calorias <= 0.0) {
            throw new DadoInvalidoException("Quantidade invalida!");
        }
        this.calorias = calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) throws DadoInvalidoException {
        if (proteinas <= 0.0) {
            throw new DadoInvalidoException("Quantidade invalida!");
        }
        this.proteinas = proteinas;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) throws DadoInvalidoException {
        if (carboidratos <= 0.0) {
            throw new DadoInvalidoException("Quantidade invalida!");
        }
        this.carboidratos = carboidratos;
    }

    public double getGorduras() {
        return gorduras;
    }

    public void setGorduras(double gorduras) throws DadoInvalidoException {
        if (gorduras <= 0.0) {
            throw new DadoInvalidoException("Quantidade invalida!");
        }
        this.gorduras = gorduras;
    }

}
