package com.heepoke.app.infrastructure.adapter.messaging;

public class ResponseMessage<T> {
    private StatusResponse status;
    private T data;
    private String errorMessage;

    public ResponseMessage(StatusResponse status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseMessage(StatusResponse status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
