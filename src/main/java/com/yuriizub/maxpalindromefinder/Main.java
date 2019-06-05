package com.yuriizub.maxpalindromefinder;

import com.yuriizub.maxpalindromefinder.MaxPalindromeResolver.InputParameters;
import com.yuriizub.maxpalindromefinder.MaxPalindromeResolver.MaxPalindromeResolver;
import com.yuriizub.maxpalindromefinder.MaxPalindromeResolver.MaxPalindromeResolverFromFileToFile;


/**
 * Created by Yurii on 6/1/2019.
 */
public class Main {

    String inputSourceAddress;
    String outputSourceAddress;
    boolean parallel = false;
    int typeOfReading = 0;
    int typeOfInputSource = 0;
    int typeOfOutputSource = 0;

    public static void main(String args[]) {
        try {
            new Main().getAndSaveMaximalPalinrome(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAndSaveMaximalPalinrome(String args[]) throws Exception {

        if(args.length == 0)
        {
            System.out.println("Input and output file names have to be set!");
            System.exit(0);
        }

        if(args.length == 1)
        {
            System.out.println("Output file name have to be set!");
            System.exit(0);
        }

        setInputParemeters(args);

        InputParameters inputParameters
                = new InputParameters(inputSourceAddress, outputSourceAddress, parallel, typeOfReading);

        if (typeOfInputSource == 0 && typeOfOutputSource == 0) {
            MaxPalindromeResolver maxPalindromeResolver = new MaxPalindromeResolverFromFileToFile();
            maxPalindromeResolver.resolveMaximalPalindrome(inputParameters);
        }
    }

    private void setInputParemeters(String args[]) {

        inputSourceAddress = args[0];
        outputSourceAddress = args[1];

        try {
            if (args[2] != null) parallel = Boolean.getBoolean(args[2]);
            if (args[3] != null) typeOfReading = Integer.parseInt(args[3]);
            if (args[4] != null) typeOfInputSource = Integer.parseInt(args[4]);
            if (args[5] != null) typeOfOutputSource = Integer.parseInt(args[5]);
        } catch (Exception e) {
            System.out.println("Incorrect input parameters" + e.getMessage());
        }
    }
}
