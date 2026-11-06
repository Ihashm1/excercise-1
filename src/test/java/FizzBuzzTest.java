import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class FizzBuzzTest {


    @Test
    void returnsFizzBuzzSequenceUpTo15() {
        assertEquals(List.of(
            "1", "2", "Fizz", "4", "Buzz",
            "Fizz", "7", "8", "Fizz", "Buzz",
            "11", "Fizz", "13", "14", "FizzBuzz"
        ), FizzBuzz.fizzBuzz(15));
    }

    @Test
    void returnsEmptyListForZero() {
        assertTrue(FizzBuzz.fizzBuzz(0).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -15, Integer.MIN_VALUE})
    void returnsEmptyListForNegativeNumbers(int n) {
        assertTrue(FizzBuzz.fizzBuzz(n).isEmpty());
    }

    @Test
    void returnsSingleNumberForOne() {
        assertEquals(List.of("1"), FizzBuzz.fizzBuzz(1));
    }

    @Test
    void endsWithFizzAtThree() {
        assertEquals(List.of("1", "2", "Fizz"), FizzBuzz.fizzBuzz(3));
    }

    @Test
    void endsWithBuzzAtFive() {
        assertEquals(List.of("1", "2", "Fizz", "4", "Buzz"), FizzBuzz.fizzBuzz(5));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "2, 2",
        "7, 7",
        "14, 14",
        "98, 98",
        "3, Fizz",
        "6, Fizz",
        "9, Fizz",
        "5, Buzz",
        "10, Buzz",
        "20, Buzz",
        "15, FizzBuzz",
        "30, FizzBuzz",
        "45, FizzBuzz"
    })
    void lastItemIsCorrectForNumber(int number, String expected) {
        List<String> result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result.get(number - 1));
    }

    @Test
    void returnsOneEntryPerNumber() {
        assertEquals(100, FizzBuzz.fizzBuzz(100).size());
    }

    @Test
    void sequenceRepeatsAfterFifteen() {
        List<String> result = FizzBuzz.fizzBuzz(30);
        for (int i = 0; i < 15; i++) {
            String first = result.get(i);
            String second = result.get(i + 15);
            if (first.equals("Fizz") || first.equals("Buzz") || first.equals("FizzBuzz")) {
                assertEquals(first, second, "word at position " + (i + 1));
            } else {
                assertEquals(String.valueOf(i + 16), second, "number at position " + (i + 16));
            }
        }
    }

    @Test
    void smallerInputIsPrefixOfLargerInput() {
        assertEquals(FizzBuzz.fizzBuzz(15), FizzBuzz.fizzBuzz(30).subList(0, 15));
    }


}