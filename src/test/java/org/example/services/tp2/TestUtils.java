package org.example.services.tp2;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUtils {
    // Compara dois valores decimais com uma margem de erro de 0.01
    public static void assertEqualsWithTolerance(double expected, double actual, String message) {
        double tolerance = 0.01;
        assertTrue(Math.abs(expected - actual) <= tolerance, message);
    }
}