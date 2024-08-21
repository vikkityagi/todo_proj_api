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

    public static ProgressEnum fromValue(int value) {
        for (ProgressEnum progressEnum : ProgressEnum.values()) {
            if (progressEnum.getValue() == value) {
                return progressEnum;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
