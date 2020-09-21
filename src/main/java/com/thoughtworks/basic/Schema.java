package com.thoughtworks.basic;

import java.util.List;
import java.util.stream.Collectors;

public class Schema {
    public List<FlagType> flagTypes;
    public Schema(List<FlagType> flagTypes){
        this.flagTypes=flagTypes;
    }
    public Object getDefaultValueOf(String flag){
        List<FlagType> filterFlagTypes=filterFlagTypesOf(flag);
        return filterFlagTypes.get(0).getDefaultValue();
    }
    public ValueType getValueTypeOf(String flag){
        List<FlagType> filterFlagTypes=filterFlagTypesOf(flag);
        return filterFlagTypes.get(0).getValueType();
    }

    public List<FlagType> filterFlagTypesOf(String flag){
        return this.flagTypes.stream().filter(flagType -> flagType.getFlag().equals(flag)).collect(Collectors.toList());
    }

}
