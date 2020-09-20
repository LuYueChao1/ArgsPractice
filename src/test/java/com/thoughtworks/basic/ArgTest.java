package com.thoughtworks.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgTest {
    @Test
    public void should_return_right_flag_when_use_getFlag_method_and_return_right_value_when_use_getValue_method(){
        Arg arg=new Arg("l","true");
        assertEquals("l",arg.getFlag());
        assertEquals("true",arg.getValue());

    }
}
