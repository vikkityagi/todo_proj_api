package com.example.todo_api.enums;

public enum ProgressEnum {
    
    COMPLETED(1),NOTCOMPLETED(2),PARTIAL(3);

    private final  int value;

    ProgressEnum(int val){
        this.value = val;
    }

    public int getValue(){
        return value;
    }
}
