package com.thoughtworks.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SchemaTest {
    @Test
    public void should_return_right_valueType_and_defaultValue_when_use_getValueTypeOf_and_getDefaultValue_method(){
        FlagType flagTypeL=new FlagType("l",ValueType.BOOLEAN);
        FlagType flagTypeP=new FlagType("p",ValueType.INTEGER);
        FlagType flagTypeD=new FlagType("d",ValueType.STRING);
        List<FlagType> flagTypes=new ArrayList<>();
        flagTypes.add(flagTypeD);
        flagTypes.add(flagTypeL);
        flagTypes.add(flagTypeP);
        Schema schema=new Schema(flagTypes);
        assertEquals(false,schema.getDefaultValueOf("l"));
        assertEquals(0,schema.getDefaultValueOf("p"));
        assertEquals("",schema.getDefaultValueOf("d"));

        assertEquals(ValueType.BOOLEAN,schema.getValueTypeOf("l"));
        assertEquals(ValueType.INTEGER,schema.getValueTypeOf("p"));
        assertEquals(ValueType.STRING,schema.getValueTypeOf("d"));
    }
}
