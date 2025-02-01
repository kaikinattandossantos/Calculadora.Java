package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular")
public class CalculadoraController {

    @PostMapping
    public Resultado calcular(@RequestBody CalculadoraRequest request) {
        double operando1 = request.getOperando1();
        String operador = request.getOperador();
        double operando2 = request.getOperando2();
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = operando1 + operando2;
                break;
            case "-":
                resultado = operando1 - operando2;
                break;
            case "*":
                resultado = operando1 * operando2;
                break;
            case "/":
                if (operando2 != 0) {
                    resultado = operando1 / operando2;
                } else {
                    throw new IllegalArgumentException("Divisão por zero.");
                }
                break;
            default:
                throw new IllegalArgumentException("Operador inválido.");
        }

        return new Resultado(resultado);
    }
}

class CalculadoraRequest {
    private double operando1;
    private String operador;
    private double operando2;

    // Getters e Setters
    public double getOperando1() {
        return operando1;
    }

    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getOperando2() {
        return operando2;
    }

    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }
}

class Resultado {
    private double resultado;

    public Resultado(double resultado) {
        this.resultado = resultado;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}