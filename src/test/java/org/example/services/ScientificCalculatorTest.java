package org.example.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ScientificCalculatorTest {
    // Exercise 1
    @Test
    public void testAdd() {
        ScientificCalculator calculator = new ScientificCalculator();
        double result = calculator.add(5.0, 3.0);
        assertEquals(5.0, result, "2 + 3 should equal 5");
    }

    // Exercise 2
    @Test
    public void testAddition() {
        ScientificCalculator calculator = new ScientificCalculator();
        double result = calculator.add(2.0, 3.0);
        assertEquals(5.0, result, "2 + 3 should equal 5");
    }

    // Exercise 3
    @Test
    public void testSubtract() {
        // Setup: Inicializar os objetos necessários e organizar os dados de entrada, no caso A e B.
        ScientificCalculator calc = new ScientificCalculator();
        double a = 10.0;
        double b = 5.0;
        double expected = 5.0;

        // Execution: Chamar o método a ser testado, no caso o método de subtração.
        double result = calc.subtract(a, b);

        // Assertion: Verificar se o resultado é o esperado.
        assertEquals(expected, result, "10 - 5 should equal 5");

        // Teardown: Não é necessário neste caso, pois não há recursos externos a serem liberados.
    }

    // Exercise 4
    private ScientificCalculator calc;

    @BeforeEach
    public void setUpCalc() {
        calc = new ScientificCalculator();
    }

    @Test
    public void testSecondAddition() {
        double a = 2.0;
        double b = 3.0;
        double expected = 5.0;

        double result = calc.add(a, b);

        assertEquals(expected, result, "2 + 3 should equal 5");
    }

    @Test
    public void testSecondSubtraction() {
        double a = 5.0;
        double b = 3.0;
        double expected = 2.0;

        double result = calc.subtract(a, b);

        assertEquals(expected, result, "5 - 3 should equal 2");
    }

    // Exercise 5
    @Test
    public void testSquareRootPositive() {
        double input = 16.0;
        double expected = 4.0;

        double result = calc.squareRoot(input);

        assertEquals(expected, result, "Square root of 16 should be 4");
    }

    // Exercise 6
    @Test
    void testSquareRootNegative() {
        double negativeInput = -16.0;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.squareRoot(negativeInput);
        });

        assertEquals("Negative number", exception.getMessage());
    }

    // Exercise 7
    @Test
    public void testDivideByZero() {
        double a = 10.0;
        double b = 0.0;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(a, b);
        });

        assertEquals("Division by zero", exception.getMessage());
    }

    // Exercise 8
    @Test
    public void testLogPositive() {
        double input = Math.E;
        double expected = 1.0;
        // Delta vi na documentação que é o valor de precisão para comparação
        double delta = 0.0001;

        double result = calc.log(input);

        assertEquals(expected, result, delta, "Log of e should be 1");
    }

    @Test
    public void testSin() {
        double degrees = 30.0;
        double expected = 0.5;

        double result = calc.sin(degrees);

        assertEquals(expected, result, 0.0001, "Sin of 30 degrees should be 0.5");
    }

    // Exercise 9

    // Quais métodos da calculadora merecem mais atenção nos testes?

    // Os métodos que merecem mais atenção estão nessa ordem:
    // 1. Métodos com verificação de condicão
    // 2. Métodos que envolvem cálculos matemáticos complexos
    // 3. Métodos que envolvem cálculos matemáticos simples

    // Em exemplos, métodos como divide, SquareRoot merecem mais atençào.
    // Depois sin, log vem em seguida.
    // E por último os métodos de adição e subtração, que são mais simples.

    // Como a cobertura de código pode ajudar a identificar lacunas?

    // A cobertura de código ajuda a identificar lacunas nos testes
    // Uma vez que fornece uma métrica que indica quais partes do código foram executadas durante os testes.
    // Isso permite identificar áreas que não foram testadas e garantam que todos os caminhos no código sejam verificados.
    // Além disso, a cobertura de código pode ajudar a identificar testes redundantes, permitindo uma melhor otimização dos testes.

    // Exercise 10

    // Revisão da Nomenclatura

    // Escolhi as classes e sua nomenclatura com base em "Código auto-explicativo".
    // Nesse sentido, ao ler o código e sua nomenclatura, outros devs ou leitores entenderão o que está acontecendo.

    // Por exemplo, TestAddition.
    // Test de Teste. Addition de Adição.
    // Portanto, presume-se que o teste seja de adição.

    // Outro exemplo, TestSquareRootPositive.
    // Test de Teste. SquareRoot de Raiz Quadrada. Positive de Positivo.
    // Portanto, presume-se que o teste seja de Raiz Quadrada Positiva.

    //Exercise 11

    // Agrupamento de testes:

    // Sem querer, acabei agrupando os testes por tipo de operação.
    // Por exemplo, os testes de adição estão juntos, os de subtração também.

    // Mas, por fins didáticos petedirei novamente.

    private ScientificCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new ScientificCalculator();
    }

    // Aritmetica básica
    @Test
    public void testAdditionCalculator() {
        double result = calculator.add(2.0, 3.0);
        assertEquals(5.0, result, "2 + 3 should equal 5");
    }

    @Test
    public void testSubtractionCalculator() {
        double result = calculator.subtract(5.0, 3.0);
        assertEquals(2.0, result, "5 - 3 should equal 2");
    }

    // Arimetica avançada
    @Test
    public void testPowerCalculator() {
        double result = calculator.power(2.0, 3.0);
        assertEquals(8.0, result, "2^3 should equal 8");
    }

    @Test
    public void testSquareRootCalculator() {
        double result = calculator.squareRoot(16.0);
        assertEquals(4.0, result, "Square root of 16 should be 4");
    }

    // Trigonometria
    @Test
    public void testSinCalculator() {
        double result = calculator.sin(30.0);
        assertEquals(0.5, result, 0.0001, "Sin of 30 degrees should be 0.5");
    }

    // Cenários de erro
    @Test
    public void testDivisionByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10.0, 0.0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    // Caso esteja revisando, verá que alguns testes estão repetidos.
    // Repeti somente pela didática! Normalmente, não se repete.
    // Ah, e não repeti os testes de Multiply e Cos, pois não são tão relevantes. para esse exemplo.

}
