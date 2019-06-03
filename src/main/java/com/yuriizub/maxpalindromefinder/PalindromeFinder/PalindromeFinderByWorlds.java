package com.yuriizub.maxpalindromefinder.PalindromeFinder;

import java.util.List;
import java.util.stream.Collectors;

public class PalindromeFinderByWorlds implements PalindromeFinder {
    @Override
    public List<String> findPalindromes(List<String> inputList) {
        List<String> resultList  = inputList.stream()
                .filter(string -> (string.intern().compareTo(new StringBuffer(string).reverse().toString().intern())==0))                //.reduce((s, x) -> s.concat(s))
                .collect(Collectors.toList());
        return resultList;
    }
}
