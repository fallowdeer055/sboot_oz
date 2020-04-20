package com.example.webapp.demo.problems;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class BinTriNumbers {


    long evaluateNumberRecord(String representation, int base) {
        long value = 0;
        for (char c : representation.toCharArray()) {
            value = value * base + Character.digit(c, base);
        }
        return value;
    }


    int[] generateOtherDigitsThan(int excludedValue, int base) {
        // return new int[]{1, 2, 3};

        return IntStream
                .rangeClosed(0, base - 1)
                .filter(i -> i != excludedValue)
                .toArray();
    }

    List<String> generateWrongOptionsSingleChar (String originalRecord, int charNumber, int base){

       // StringBuilder prefix = new StringBuilder(originalRecord.substring(0,))

      // generateOtherDigitsThan( Character.digit(originalRecord.charAt(charNumber),base), base )
        return null;

    }


}
