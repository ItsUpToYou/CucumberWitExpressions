package com.training.helper;

public class Operation {

    private String operationName;

    public Operation(String operationName) {
        this.setOperationName(operationName);
    }

    public String getName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
