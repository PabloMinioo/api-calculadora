package api_calculadora.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// Indicamos a Spring que Calculo es una tabla
@Entity 
@Table(name = "calculos")

public class Calculo {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valor1;

    @Column(nullable = false)
    private Double valor2;

    @Column(nullable = false)
    private String operacion;

    @Column(nullable = false)
    private Double resultado;

    @Column(nullable = false)
    private LocalDateTime fecha;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getValor1() { return valor1; }
    public void setValor1(Double valor1) { this.valor1 = valor1; }

    public Double getValor2() { return valor2; }
    public void setValor2(Double valor2) { this.valor2 = valor2; }

    public String getOperacion() { return operacion; }
    public void setOperacion(String operacion) { this.operacion = operacion; }

    public Double getResultado() { return resultado; }
    public void setResultado(Double resultado) { this.resultado = resultado; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}