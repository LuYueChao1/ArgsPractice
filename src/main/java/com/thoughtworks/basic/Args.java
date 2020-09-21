package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Args {
    public String ArgText;
    private Schema schema;
    private List<Arg>argList=new ArrayList<>();
    public Args(String argText,Schema schema) throws Throwable {
        this.ArgText=argText;
        this.schema=schema;
        this.argList=this.getArgList();
    }
    public List<Arg> getArgList() throws Throwable {
        List<String> argListOfSplit=splitToArgs(this.ArgText);
        argListOfSplit=argListOfSplit.subList(1,argListOfSplit.size());
        isArgValid(argListOfSplit);
        List<List<String>> flagValueList=argListOfSplit.stream().map(flagValue->Arrays.asList(flagValue.trim().split(" "))).collect(Collectors.toList());
        List<Arg> argList=new ArrayList<>();
        flagValueList.stream().forEach(argOfSplit-> {
                String strIndex1=argOfSplit.size()==1?"":argOfSplit.get(1);
            try {
                argList.add(new Arg(argOfSplit.get(0),strIndex1,schema));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return argList;
    }

    private List<String> splitToArgs(String commandText){
        return Arrays.asList(commandText.split("-"));
    }

    private void isArgValid(List<String> argSplitSubList) throws Throwable {
        argSplitSubList.stream().forEach(arg-> {
            if(arg.charAt(0) == ' '){
                try {
                    throw new Throwable("-后面不可跟空格字符");
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            if (arg.length()==1){
                try {
                    throw new Throwable("参数之间不用空格分割非法");
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            if(Arrays.asList(arg.split(" ")).size()>2){
                try {
                    throw new Throwable("value中间不能有空格");
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });

    }
    public Object getValueOf(String flag) throws Throwable {
        List<Arg> args=this.argList.stream().filter(arg -> arg.getFlag().equals(flag)).collect(Collectors.toList());
        if(args.size()>0){
            try{
                return args.get(0).parseValue();
            }catch (Throwable throwable){
                return schema.getDefaultValueOf(flag);
            }
        }else {
            return schema.getDefaultValueOf(flag);
        }
    }
}
