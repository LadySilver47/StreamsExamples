package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTest {

    Streams streams = new Streams();

    @Test
    void shouldReturnListOfOddNumbers(){
        List<Integer> integerList = List.of(5, 6, 7, 8, 9, 10);
        List<Integer> expectedList = List.of(5, 7, 9);
        List<Integer> resultList = streams.getOddNumbersList(integerList);

        assertEquals(expectedList, resultList);
    }

    @Test
    void shouldReturnListOfStrings(){
        List<Integer> integerList = List.of(5, 6, 7, 8, 9, 10);
        List<String> expectedList = List.of("5", "6", "7", "8", "9", "10");
        List<String> resultList = streams.getListOfStrings(integerList);

        assertEquals(expectedList, resultList);
    }

    @Test
    void shouldReturnSortedListOfOddNumbersAsStrings(){
        List<Integer> integerList = List.of(8, 9, 10, 5, 6, 7);
        List<String> expectedList = List.of("5", "7", "9");
        List<String> resultList = streams.getOddNumberListAsString(integerList);

        assertEquals(expectedList, resultList);
    }

    @Test
    void shouldReturnSingleIntResultThatIsTheSumOfNumbers(){
        int[] integerArray = {2, 2};
        int expected = 4;
        int result = streams.serialSum(integerArray);
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnSingleIntResultThatIsNumbersMultiplied(){
        int[] integerArray = {2, 2, 2};
        int expected = 8;
        int result = streams.serialMultiply(integerArray);
        assertEquals(expected, result);
    }

    @Test
    void shouldFindFirstEvenNumber(){
        int[] integerArray = {4, 3, 2, 5};
        int expected = 4;
        int result = streams.findFirstEven(integerArray);
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnMapOfNumbersAndTheCount(){
        Map<Integer, Long> expectedLongMap = new HashMap<>();
        expectedLongMap.put(5, 3L);
        expectedLongMap.put(6, 2l);
        expectedLongMap.put(7, 1L);
        int[] inputArray = {5,5,5,6,6,7};
        Map<Integer, Long> resultMap = streams.countNumbers(inputArray);
        assertEquals(expectedLongMap, resultMap);

    }

    @Test
    void shouldReturnStringOfSquaredNumbers(){
        String expected = "641164";
        String result = streams.squareEachNumber(8118);
        assertEquals(expected, result);
    }
}