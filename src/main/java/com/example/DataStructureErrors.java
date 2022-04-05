package com.example;

public enum DataStructureErrors {
    POPPING_EMPTY_STACK("Cannot pop an empty stack.");

    private String value;

    DataStructureErrors(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return this.getValue();
    }
}