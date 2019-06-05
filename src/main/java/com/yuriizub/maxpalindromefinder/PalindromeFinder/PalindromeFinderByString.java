package com.yuriizub.maxpalindromefinder.PalindromeFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PalindromeFinderByString implements PalindromeFinder {

    StringBuilder compareStringBuilder = new StringBuilder();
    StringBuilder outputStringBuilder = new StringBuilder();

    @Override
    public List<String> findPalindromes(List<String> inputList) {
        List<String> outputList = new ArrayList();
        for (String inputString : inputList) {
            if (findMaxPalindromeInString(inputString).isPresent())
                outputList.add(findMaxPalindromeInString(inputString).get().toString());
        }
        return outputList;
    }

    private Optional findMaxPalindromeInString(String inputString) {

        if (inputString.length() == 1) return Optional.ofNullable(inputString);

        List<String> directList = collectStringToList(inputString);

        for (int windowSize = directList.size(); windowSize > 0; windowSize--) {

            for (int windowPosition = 0; windowPosition < directList.size() - windowSize + 1; windowPosition++) {

                List<String> sublist = directList.subList(windowPosition, windowPosition + windowSize);
                if (checkSublistForPalindrome(sublist).isPresent())
                    return checkSublistForPalindrome(sublist);
            }
        }
        return Optional.ofNullable(null);
    }

    private List<String> collectStringToList(String beforeString) {
        List<String> afterList = Stream.of(beforeString)
                .flatMap(s -> Stream.of(s.split(" ")))
                .collect(Collectors.toList());
        return afterList;
    }

    private Optional<String> checkSublistForPalindrome(List<String> sublist) {

        compareStringBuilder.setLength(0);
        outputStringBuilder.setLength(0);

        for (String directString : sublist) {
            compareStringBuilder.append(directString);
            outputStringBuilder.append(directString + " ");
        }

        if (compareStringBuilder.toString().equals(compareStringBuilder.reverse().toString())) {
            return Optional.ofNullable(outputStringBuilder.toString());
        }
        return Optional.ofNullable(null);
    }
}
