package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface ValueToCharacterFI{
    char convertToChar(int value);
}

interface DoubleToIntegerFI{
    int convertToInt(double value);
}

public class Streams {

    ValueToCharacterFI toCharacter = value -> (char) value;
    DoubleToIntegerFI toInteger = value -> (int) value;

    private static Predicate<Integer> getOddNumberPredicate() {
        return number -> number % 2 != 0;
    }


    public List<Integer> getOddNumbersList(List<Integer> integerList) {
        return integerList
                .stream()
                .filter(getOddNumberPredicate())
                .toList();
    }

    public List<String> getListOfStrings(List<Integer> integerList){
        return integerList
                .stream()
                .map(String::valueOf)
                .toList();
    }

    public List<String> getOddNumberListAsString(List<Integer> integerList) {
        return integerList
                .stream()
                .filter(getOddNumberPredicate())
                .map(String::valueOf)
                .sorted()
                .toList();
    }


    public int serialSum(int[] integers){
        return Arrays
                .stream(integers)
                .sum();
    }

    public int serialMultiply(int[] integerArray) {
        return Arrays
                .stream(integerArray)
                .reduce(1, (operandA, operandB) -> operandA*operandB);
    }

    public int findFirstEven(int[] integerArray){
        return Arrays
                .stream(integerArray)
                .filter(number -> number % 2 == 0)
                .findFirst()
                .orElse(0);
    }

    public Map<Integer, Long> countNumbers (int[] numbers) {

        return Arrays
                .stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(identity -> identity, Collectors.counting()));
    }

    public String squareEachNumber(int number){
        String digitString = String.valueOf(number);

        return digitString
                .chars()
                .mapToObj(toCharacter::convertToChar)
                .mapToDouble(Character::getNumericValue)
                .map(digit -> Math.pow(digit, 2))
                .mapToInt(toInteger::convertToInt)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

    }
}
