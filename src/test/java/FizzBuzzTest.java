import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void returnsNumberForNormalNumber() {
        assertEquals("1", FizzBuzz.fizzBuzz(1).get(0), " test failed for 1" );
    }

    @Test
    void returnsFizzForMultipleOfThree() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3).get(2), " test failed for 3" );
    }

    @Test
    void returnsBuzzForMultipleOfFive() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5).get(4), " test failed for 5" );
    }

    @Test
    void returnsFizzBuzzForMultipleOfFifteen() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15).get(14), " test failed for 15" );
    }

    @Test
    void returnsEmptyListForZero() {
        assertTrue(FizzBuzz.fizzBuzz(0).isEmpty(), " test failed for 0" );
    }

}