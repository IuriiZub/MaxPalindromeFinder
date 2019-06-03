package com.yuriizub.maxpalindromefinder;

import com.yuriizub.maxpalindromefinder.MaxPalindromeResolver.InputParameters;
import com.yuriizub.maxpalindromefinder.MaxPalindromeResolver.MaxPalindromeResolver;
import com.yuriizub.maxpalindromefinder.MaxPalindromeResolver.MaxPalindromeResolverFromFileToFile;


/**
 * Created by Yurii on 6/1/2019.
 */
public class Main {

    public static void main(String args[]) {
        try {
            new Main().getAndSaveMaximalPalinrome(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAndSaveMaximalPalinrome(String args[]) throws Exception {
        String inputSourceAddress = args[0];
        if (inputSourceAddress == null) throw new Exception("Input source address Should be set!");
        String outputSourceAddress = args[1];
        if (outputSourceAddress == null) throw new Exception("Output source address Should be set!");
        boolean parallel = false;
        if(args[2] != null) parallel = Boolean.getBoolean(args[2]);
        int typeOfReading = 0;
        if(args[3] != null) typeOfReading = Integer.parseInt(args[3]);
        int typeOfInputSource = 0;
        if(args[4] != null) typeOfInputSource = Integer.parseInt(args[4]);
        int typeOfOutputSource = 0;
        if(args[5] != null) typeOfOutputSource = Integer.parseInt(args[5]);

        InputParameters inputParameters
                = new InputParameters(inputSourceAddress, outputSourceAddress, parallel, typeOfReading);

        if (typeOfInputSource == 0 && typeOfOutputSource == 0) {
            MaxPalindromeResolver maxPalindromeResolver = new MaxPalindromeResolverFromFileToFile();
            maxPalindromeResolver.resolveMaximalPalindrome(inputParameters);
        }
    }
}
