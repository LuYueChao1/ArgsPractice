package com.thoughtworks.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArgTest {
    @Test
    public void should_return_right_flag_when_use_getFlag_method_and_return_right_value_when_use_getValue_method() throws Throwable {
        FlagType flagTypeL=new FlagType("l",ValueType.BOOLEAN);
        FlagType flagTypeP=new FlagType("p",ValueType.INTEGER);
        FlagType flagTypeD=new FlagType("d",ValueType.STRING);
        List<FlagType> flagTypes=new ArrayList<>();
        flagTypes.add(flagTypeD);
        flagTypes.add(flagTypeL);
        flagTypes.add(flagTypeP);
        Schema schema=new Schema(flagTypes);
        Arg arg=new Arg("l","true",schema);
        try {
            Arg argThrow=new Arg("b","true",schema);
        }catch (Throwable throwable){
            assertEquals("java.lang.Throwable: 指令b不支持,请输入受支持的指令",throwable.toString());
        }
        assertEquals("l",arg.getFlag());
        assertEquals(true,arg.parseValue());
        assertEquals(true,arg.withFlag("p"));


    }
}
