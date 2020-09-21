package com.thoughtworks.basic;

public class FlagType {
    private String flag;
    private ValueType valueType;
    public FlagType(String flag,ValueType valueType){
        this.flag=flag;
        this.valueType=valueType;
    }
    public String getFlag(){
        return this.flag;
    }
    public Object getDefaultValue(){
        return this.valueType.getDefaultValue();
    }
    public ValueType getValueType(){
        return this.valueType;
    }

}
