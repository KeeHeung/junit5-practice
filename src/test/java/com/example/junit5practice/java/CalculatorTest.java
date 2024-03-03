package com.example.junit5practice.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
//    @Test
//    void sum(){
//        // given
//        Calculator calculator = new Calculator();
//        int a = 10;
//        int b = 5;
//
//        int expected = 15;
//
//        // when
//        int actual = calculator.sum(a, b);
//
//        // then
//        assertEquals(expected, actual);

    @ParameterizedTest
    @MethodSource("numberProvider")
    void sum(int a, int b, int expected){
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.sum(a, b);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.arguments(10, 5, 15),
                Arguments.arguments(-10, -20, -30),
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(10, -20, -10)
        );
    }
}