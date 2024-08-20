package com.example.todo_api.enums;


public enum TaskEnum {

    ENGLISHPRACTICE(1),EXERCISE(2),LEARNNEWSKILL(3),STARTBUISNESS(4),READABOOK(5);

    private final int value;

    TaskEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }

    public static TaskEnum fromValue(int value) {
        for (TaskEnum taskEnum : TaskEnum.values()) {
            if (taskEnum.getValue() == value) {
                return taskEnum;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    
}
