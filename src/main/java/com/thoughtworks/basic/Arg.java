package com.thoughtworks.basic;

public class Arg {
    private String flag;
    private String value;
    public Arg(String flag,String value){
        this.flag=flag;
        this.value=value;
    }
    public String getFlag(){
        return this.flag;
    }
    public String getValue(){
        return this.value;
    }
}
