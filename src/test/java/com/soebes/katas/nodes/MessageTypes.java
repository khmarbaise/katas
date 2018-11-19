package com.soebes.katas.nodes;

public enum MessageTypes
{
    MESSAGE_1(Values.MESSAGE_1),
    MESSAGE_2(Values.MESSAGE_2);
    
    public class Values {
        public static final String MESSAGE_1 = "Message_1";
        public static final String MESSAGE_2 = "Message_2";
        
    }
    
    private String value;
    
    private MessageTypes(String value)
    {
        this.value = value;
    }
    
    public String toString() {
        return this.value;
    }
}
