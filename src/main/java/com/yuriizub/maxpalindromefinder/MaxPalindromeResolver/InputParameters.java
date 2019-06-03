package com.yuriizub.maxpalindromefinder.MaxPalindromeResolver;

public class InputParameters {

    private final String inputSourceAddress;
    private final String outputSourceAddress;
    private final boolean parallel;
    private final int resolvingType;

    public InputParameters(String inputSourceAddress, String outputSourceAddress, boolean parallel, int resolvingType) {
        this.inputSourceAddress = inputSourceAddress;
        this.outputSourceAddress = outputSourceAddress;
        this.parallel = parallel;
        this.resolvingType = resolvingType;
    }

    public String getInputSourceAddress() {
        return inputSourceAddress;
    }

    public String getOutputSourceAddress() {
        return outputSourceAddress;
    }

    public boolean isParallel() {
        return parallel;
    }

    public int getResolvingType() {
        return resolvingType;
    }

}
