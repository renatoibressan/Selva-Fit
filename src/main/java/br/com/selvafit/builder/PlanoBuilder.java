package br.com.selvafit.builder;

import br.com.selvafit.exception.DadoInvalidoException;
import br.com.selvafit.model.PlanoAlimentar;

public class PlanoBuilder {
    
    private PlanoAlimentar plano;

    public PlanoBuilder() {
        plano = new PlanoAlimentar();
    }

    public PlanoBuilder calorias(double calorias) throws DadoInvalidoException {
        plano.setCalorias(calorias);
        return this;
    }

    public PlanoBuilder proteinas(double proteinas) throws DadoInvalidoException {
        plano.setProteinas(proteinas);
        return this;
    }

    public PlanoBuilder carboidratos(double carboidratos) throws DadoInvalidoException {
        plano.setCarboidratos(carboidratos);
        return this;
    }

    public PlanoBuilder gorduras(double gorduras) throws DadoInvalidoException {
        plano.setGorduras(gorduras);
        return this;
    }

    public PlanoAlimentar build() {
        return plano;
    }

}
