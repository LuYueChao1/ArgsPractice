package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Args {
    public String ArgText;
    public Args(String argText){
        this.ArgText=argText;
    }
    public List<Arg> getArgList(){
        List<String> argListOfSplit= Arrays.asList(this.ArgText.split("-"));
        System.out.println(argListOfSplit); 
        argListOfSplit=argListOfSplit.subList(1,argListOfSplit.size());
        System.out.println(argListOfSplit);
        argListOfSplit=argListOfSplit.stream().map(String::trim).collect(Collectors.toList());
        List<List<String>> flagValueList=argListOfSplit.stream().map(flagValue->Arrays.asList(flagValue.split(" "))).collect(Collectors.toList());
        System.out.println(flagValueList);
        List<Arg> argList=new ArrayList<>();
        flagValueList.stream().forEach(argOfSplit->argList.add(new Arg(argOfSplit.get(0),argOfSplit.get(1))));
        return argList;
    }
}
