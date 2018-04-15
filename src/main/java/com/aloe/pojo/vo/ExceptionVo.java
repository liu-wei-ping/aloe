package com.aloe.pojo.vo;

import lombok.Data;

public class ExceptionVo {
    private String requestUrl;
    private String error;
    private String status;

    public ExceptionVo(String requestUrl, String error, String status) {
        this.requestUrl = requestUrl;
        this.error = error;
        this.status = status;
    }

    public ExceptionVo() {
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
