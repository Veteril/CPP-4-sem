package com.example.lab_1.response;

import lombok.Getter;
import lombok.Setter;

public class Response {
    @Setter
    @Getter
    private String message;
    @Getter
    @Setter
    private double volume;

    public Response() {}

    public Response(double volume, String message) {
        this.volume = volume;
        this.message = message;
    }

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
