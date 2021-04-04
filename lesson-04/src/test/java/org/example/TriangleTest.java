package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {
    Triangle tr = new Triangle(22, 23, 42);
    Triangle tr1 = new Triangle(2, 4, 6);
    Triangle tr2 = new Triangle(-2, 4, 6);

    @Test
    void testEvenNumberForIsEven() {
        double p;
        p = tr.function();
        boolean result = tr.square(p);
        assertThat(result).as("Checking for the area of a triangle").isTrue();
    }

    @Test
    void testEvenNumberForIsEvenFailed() {
        double p;
        p = tr1.function();
        boolean result = tr1.square(p);
        assertThat(result).as("Checking for the area of a triangle").isFalse();

        p = tr2.function();
        result = tr2.square(p);
        assertThat(result).as("Checking for the area of a triangle").isFalse();
    }
}