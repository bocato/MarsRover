package com.bocato.mars.model;

public enum Direction {
	
	N("N", 1), E("E", 2), W("W", 3), S("S", 4);

    private final String charValue;
    private final int intValue;

    private Direction(String charValue_, int intValue_) {
        charValue = charValue_;
        intValue = intValue_;
    }
    
    public String charValue() {
        return charValue;
    }
    
    public int intValue(){
    	return intValue;
    }
}
