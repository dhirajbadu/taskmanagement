package com.taskmanagement.core.enumconstant;

public enum TaskStatus {
    PENDING("Pending"), ONGOING("Ongoing"), COMPLETED("Completed");

    private final String value;

    TaskStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static final TaskStatus get(String value){
        if (value == null || value.trim().isEmpty()){
            return null;
        }

        for (TaskStatus s : values()){
            if (s.value.equalsIgnoreCase(value)){
                return s;
            }
        }

        return null;
    }

}
