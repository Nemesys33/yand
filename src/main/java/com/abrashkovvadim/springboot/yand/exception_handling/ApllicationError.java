package com.abrashkovvadim.springboot.yand.exception_handling;

public abstract class ApllicationError {
    private String massage;
    private int code;

    public ApllicationError() {
    }

    public ApllicationError(String massage, int code) {
        this.massage = massage;
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
