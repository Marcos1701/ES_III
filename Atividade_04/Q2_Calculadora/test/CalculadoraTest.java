import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void testCalcular() {
        Calculadora calc = new Calculadora(10, 2);
        List<Double> resultados = calc.calcular(Arrays.asList(
                new Operacao() {
                    public double executar(double a, double b) {
                        return a + b;
                    }
                },
                new Operacao() {
                    public double executar(double a, double b) {
                        return a - b;
                    }
                },
                new Operacao() {
                    public double executar(double a, double b) {
                        return a * b;
                    }
                },
                new Operacao() {
                    public double executar(double a, double b) {
                        return a / b;
                    }
                }));
        assertEquals("Soma incorreta", 12, resultados.get(0), 0);
        assertEquals("Subtração Incorreta", 8, resultados.get(1), 0);
        assertEquals("Multiplicação Incorreta", 20, resultados.get(2), 0);
        assertEquals("Divisão Incorreta", 5, resultados.get(3), 0);
    }

}
