package com.thoughtworks.basic;

public enum ValueType {
    BOOLEAN(false),INTEGER(0),STRING("");
    private Object defaultValue;
    ValueType(Object defaultValue){
        this.defaultValue=defaultValue;
    }
    public Object getDefaultValue(){
        return this.defaultValue;
    }
    public ValueType getType(){
        return this;
    }

}
