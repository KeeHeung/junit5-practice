package com.example.junit5practice.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Calculator1Test {
    @ParameterizedTest
    @MethodSource("numberProvider")
    @DisplayName("양수의 값을 더할 수 있다.")
    void sum(int a, int b, int expected){
        // given
        Calculator1 calculator = new Calculator1();

        // when
        int actual = calculator.sum(a, b);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.arguments(10, 5, 15),
                Arguments.arguments(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("numberProviderForException")
    @DisplayName("음수의 값은 예외가 발생하여야 한다.")
    void sumExceptionTest(int a, int b) {
        // given
        Calculator1 calculator1 = new Calculator1();

        // when & then
        assertThrows(
                RuntimeException.class,
                () -> calculator1.sum(a, b)
        );
    }

    static Stream<Arguments> numberProviderForException() {
        return Stream.of(
                Arguments.arguments(-10, 5),
                Arguments.arguments(1, -100)
        );
    }
}