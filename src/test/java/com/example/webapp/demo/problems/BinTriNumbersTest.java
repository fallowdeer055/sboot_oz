package com.example.webapp.demo.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.util.ArrayUtils;
import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.ArrayUtils.toObject;
import static org.junit.jupiter.api.Assertions.*;

class BinTriNumbersTest {

    BinTriNumbers codeUnderTest;

    @BeforeEach
    void setUp() {
        codeUnderTest = new BinTriNumbers();
    }

    @Test
    void evaluateNumberRecord() {
        assertThat(codeUnderTest.evaluateNumberRecord("0", 2), is(0));
        assertThat(codeUnderTest.evaluateNumberRecord("1", 2), is(1));
        assertThat(codeUnderTest.evaluateNumberRecord("1", 3), is(1));
        assertThat(codeUnderTest.evaluateNumberRecord("10", 2), is(2));
        assertThat(codeUnderTest.evaluateNumberRecord("10", 3), is(3));
        assertThat(codeUnderTest.evaluateNumberRecord("11", 2), is(3));
        assertThat(codeUnderTest.evaluateNumberRecord("12", 3), is(5));
        assertThat(codeUnderTest.evaluateNumberRecord("100", 2), is(4));
        assertThat(codeUnderTest.evaluateNumberRecord("1010", 2), is(10));
        assertThat(codeUnderTest.evaluateNumberRecord("21", 3), is(7));
        assertThat(codeUnderTest.evaluateNumberRecord("2000", 3), is(54));
        assertThat(codeUnderTest.evaluateNumberRecord("2001", 3), is(55));
        assertThat(codeUnderTest.evaluateNumberRecord("2011", 3), is(58));
    }


    @Test
    void generateOtherDigitsThan() {
        assertThat(toObject(codeUnderTest.generateOtherDigitsThan(0, 4)),
                is(arrayContaining(1, 2, 3)));

        assertThat(toObject(codeUnderTest.generateOtherDigitsThan(4, 5)),
                is(arrayContaining(0, 1, 2, 3)));

        assertThat(toObject(codeUnderTest.generateOtherDigitsThan(2, 5)),
                is(arrayContaining(0, 1, 3, 4)));
    }


    @Test
    void generateWrongOptionsSingleChar() {
       // assertThat(codeUnderTest.generateWrongOptionsSingleChar("120120", 0, 3),
       //         is(arrayContaining( "020120","220120" )));

       // assertE
    }
}