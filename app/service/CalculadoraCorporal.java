package app.service;

import app.enums.NivelAtividade;
import app.enums.SexoBiologico;
import app.model.Usuario;

public class CalculadoraCorporal {
    
    public record Macronutrientes(double proteinas, double carboidratos, double gorduras) {}

    public double calcularIMC(Usuario usuario) {
        return usuario.getPeso() / (usuario.getAltura() * usuario.getAltura());
    }

    public double calcularTMB(Usuario usuario) {
        double tmb = (10.0 * usuario.getPeso()) + (6.25 * usuario.getAltura()) - (5.0 * usuario.getIdade());
        return (usuario.getSexo() == SexoBiologico.MASCULINO) ? tmb + 5.0 : tmb - 161.0;
    }

    public double calcularPesoIdeal(Usuario usuario) {
        if (usuario.getAltura() >= 1.52) {
            double aux = 90.55 * (1.52 - usuario.getAltura());
            return (usuario.getSexo() == SexoBiologico.MASCULINO) ? 50.0 - aux : 45.5 - aux;
        } else {
            return 21.7 * (usuario.getAltura() * usuario.getAltura());
        }
    }

    public double calcularAguaDiaria(Usuario usuario) {
        return (usuario.getIdade() < 18) ? usuario.getPeso() * 0.04 :
                (usuario.getIdade() >= 18 && usuario.getIdade() < 55) ? usuario.getPeso() * 0.035 :
                (usuario.getIdade() >= 55 && usuario.getIdade() < 66) ? usuario.getPeso() * 0.03 :
                usuario.getPeso() * 0.025;
    }

    public double calcularGastoEnergetico(Usuario usuario) {
        double tmb = calcularTMB(usuario);
        return (usuario.getNivelAtividade() == NivelAtividade.SEDENTARIO) ? tmb * 1.2 :
                (usuario.getNivelAtividade() == NivelAtividade.LEVEMENTE_ATIVO) ? tmb * 1.375 :
                (usuario.getNivelAtividade() == NivelAtividade.MODERADAMENTE_ATIVO) ? tmb * 1.55 :
                tmb * 1.725;
    }

    public double calcularCaloriasDiarias(Usuario usuario) {
        double get = calcularGastoEnergetico(usuario);
        return switch (usuario.getObjetivo()) {
            case EMAGRECIMENTO -> get - 400.0;
            case HIPERTROFIA -> get + 400.0;
            case RECOMPOSICAO_CORPORAL -> get - 150.0;
            case MANUTENCAO -> get;
            case GANHO_DE_FORCA -> get + 250.0;
            case CONDICIONAMENTO_FISICO -> get;
        };
    }

    public Macronutrientes calcularMacronutrientes(Usuario usuario) {
        double get = calcularGastoEnergetico(usuario);
        double proteinas = (usuario.getNivelAtividade() == NivelAtividade.SEDENTARIO) ? usuario.getPeso() * 0.9 :
                            (usuario.getNivelAtividade() == NivelAtividade.MODERADAMENTE_ATIVO ||
                            usuario.getNivelAtividade() == NivelAtividade.LEVEMENTE_ATIVO) ? usuario.getPeso() * 1.4 :
                            usuario.getPeso() * 1.9;
        double calorias = proteinas * 4.0;
        double gorduras = usuario.getPeso();
        calorias += gorduras * 9.0;
        calorias = get - calorias;
        double carboidratos = calorias / 4.0;
        return new Macronutrientes(proteinas, carboidratos, gorduras);
    }

}
