package com.thoughtworks.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArgsTest {
    @Test
    public void should_get_right_argList_when_input_argText() throws Throwable {
        FlagType flagTypeL=new FlagType("l",ValueType.BOOLEAN);
        FlagType flagTypeP=new FlagType("p",ValueType.INTEGER);
        FlagType flagTypeD=new FlagType("d",ValueType.STRING);
        List<FlagType> flagTypes=new ArrayList<>();
        flagTypes.add(flagTypeD);
        flagTypes.add(flagTypeL);
        flagTypes.add(flagTypeP);
        Schema schema=new Schema(flagTypes);
        Args args=new Args("-l true -p 8080 -d /usr/logs",schema);
        assertEquals(true,args.getValueOf("l"));
        assertEquals(8080,args.getValueOf("p"));
        assertEquals("/usr/logs",args.getValueOf("d"));

        Args argsWithoutP=new Args("-l true -d /usr/logs",schema);
        assertEquals(0,argsWithoutP.getValueOf("p"));

        Args argsWithFalse=new Args("-l -p str -d /usr/logs",schema);
        assertEquals(false,argsWithFalse.getValueOf("l"));
        assertEquals(0,argsWithFalse.getValueOf("p"));
    }

    @Test
    public void should_throw_error_when_input_arg_invalid(){
        FlagType flagTypeL=new FlagType("l",ValueType.BOOLEAN);
        FlagType flagTypeP=new FlagType("p",ValueType.INTEGER);
        FlagType flagTypeD=new FlagType("d",ValueType.STRING);
        List<FlagType> flagTypes=new ArrayList<>();
        flagTypes.add(flagTypeD);
        flagTypes.add(flagTypeL);
        flagTypes.add(flagTypeP);
        Schema schema=new Schema(flagTypes);
        try {
            Args argsThrow=new Args("-l-p str -d /usr/logs",schema);
        }catch (Throwable throwable){
            assertEquals("java.lang.Throwable: 参数之间不用空格分割非法",throwable.toString());
        }
        try {
            Args argsThrow=new Args("-l-p str -d /usr/logs",schema);
        }catch (Throwable throwable){
            assertEquals("java.lang.Throwable: 参数之间不用空格分割非法",throwable.toString());
        }
        try {
            Args argsThrow=new Args("- l true -p str -d /us r/logs",schema);
        }catch (Throwable throwable){
            assertEquals("java.lang.Throwable: -后面不可跟空格字符",throwable.toString());
        }

    }
}
