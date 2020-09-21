package com.thoughtworks.basic;

public class Arg {
    private String flag;
    private String value;
    private Schema schema;
    public Arg(String flag,String value,Schema schema) throws Throwable {
        this.flag=flag;
        this.value=value;
        this.schema=schema;
        if(!withFlag(flag)){
            throw new Throwable("指令"+flag+"不支持,请输入受支持的指令");
        }
    }
    public String getFlag(){
        return this.flag;
    }
    public String getValue(){
        return this.value;
    }
    public boolean withFlag(String flag){
        return schema.filterFlagTypesOf(flag).size()>0;
    }
    public Object parseValue(){
        ValueType valueType=this.schema.getValueTypeOf(this.flag);
        if (ValueType.INTEGER.equals(valueType)) {
            return Integer.parseInt(this.value);
        }  else if (ValueType.BOOLEAN.equals(valueType)) {
            return Boolean.parseBoolean(this.value);
        } else if(ValueType.STRING.equals(this.value)){
            return this.value;
        }
        return this.value;
    }
}
