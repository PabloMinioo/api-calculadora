package api_calculadora.service;

import api_calculadora.model.Calculo;
import api_calculadora.repository.CalculoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalculoService {

    private final CalculoRepository calculoRepository;

    CalculoService(CalculoRepository calculoRepository) {
        this.calculoRepository = calculoRepository;
    }

    public Calculo calcular(Double valor1, Double valor2, String operacion) {
        Double resultado;

        switch (operacion) {
            case "suma":
                resultado = valor1 + valor2;
                break;
            case "resta":
                resultado = valor1 - valor2;
                break;
            case "multiplicacion":
                resultado = valor1 * valor2;
                break;
            case "division":
                if (valor2 == 0) {
                    throw new RuntimeException("No se puede dividir por cero");
                }
                resultado = valor1 / valor2;
                break;
            default:
                throw new RuntimeException("Operacion no valida: " + operacion);
        }

        Calculo calculo = new Calculo();
        calculo.setValor1(valor1);
        calculo.setValor2(valor2);
        calculo.setOperacion(operacion);
        calculo.setResultado(resultado);
        calculo.setFecha(LocalDateTime.now());

        return calculoRepository.save(calculo);
    }

    public List<Calculo> obtenerHistorial() {
        return calculoRepository.findAll();
    }
}