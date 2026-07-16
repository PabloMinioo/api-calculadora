package api_calculadora.controller;

import api_calculadora.model.Calculo;
import api_calculadora.service.CalculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculoController {

    private final CalculoService calculoService;

    CalculoController(CalculoService calculoService) {
        this.calculoService = calculoService;
    }

    @PostMapping("/calcular")
    public Calculo calcular(@RequestBody CalculoRequest request) {
        return calculoService.calcular(request.getValor1(), request.getValor2(), request.getOperacion());
    }

    @GetMapping("/historial")
    public List<Calculo> obtenerHistorial() {
        return calculoService.obtenerHistorial();
    }

    // Clase interna para representar lo que llega en el body del POST
    public static class CalculoRequest {
        private Double valor1;
        private Double valor2;
        private String operacion;

        public Double getValor1() { return valor1; }
        public void setValor1(Double valor1) { this.valor1 = valor1; }

        public Double getValor2() { return valor2; }
        public void setValor2(Double valor2) { this.valor2 = valor2; }

        public String getOperacion() { return operacion; }
        public void setOperacion(String operacion) { this.operacion = operacion; }
    }
}