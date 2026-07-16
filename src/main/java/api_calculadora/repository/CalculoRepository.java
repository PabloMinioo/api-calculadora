package api_calculadora.repository;

import api_calculadora.model.Calculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculoRepository extends JpaRepository<Calculo, Long> {
    
}