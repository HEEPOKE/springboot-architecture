package com.heepoke.app.infrastructure.adapter.messaging;

public class StatusResponse {
    private String code;
    private String message;
    private String service;
    private String description;

    public StatusResponse(String code, String message, String service, String description) {
        this.code = code;
        this.message = message;
        this.service = service;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
