package com.thoughtworks.basic;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArgsTest {
    @Test
    public void should_get_right_argList_when_input_argText(){
        Args args=new Args("-l true - 8080 -d /usr/logs");
        List<Arg> argList=args.getArgList();
        System.out.println(argList);
        assertEquals("l",argList.get(0).getFlag());
        assertEquals("true",argList.get(0).getValue());
        assertEquals("p",argList.get(1).getFlag());
        assertEquals("8080",argList.get(1).getValue());
        assertEquals("d",argList.get(2).getFlag());
        assertEquals("/usr/logs",argList.get(2).getValue());
    }
}
