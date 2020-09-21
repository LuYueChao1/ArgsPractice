package com.thoughtworks.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlagTypeTest {
    @Test
    public void should_return_right_type_value_when_use_getargvalue_of_flagtype(){
        FlagType flagTypeBoolean=new FlagType("l",ValueType.BOOLEAN);
         FlagType flagTypeInteger=new FlagType("p",ValueType.INTEGER);
        assertEquals(false,flagTypeBoolean.getDefaultValue());
        assertEquals(0,flagTypeInteger.getDefaultValue());
    }
}
