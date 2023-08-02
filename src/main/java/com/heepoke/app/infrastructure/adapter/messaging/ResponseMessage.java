package com.heepoke.app.infrastructure.adapter.messaging;

public class ResponseMessage<T> {
    private StatusResponse status;
    private T data;

    public ResponseMessage(StatusResponse status, T data) {
        this.status = status;
        this.data = data;
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
}