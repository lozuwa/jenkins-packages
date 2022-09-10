package com.lozuwa.common.http.dto

import groovy.json.JsonSlurper

public class RawHttpResponse {
    private int responseStatusCode
    private String responseMessage
    private String responseBody

    public RawHttpResponse() {
    }

    public RawHttpResponse(int responseStatusCode, String responseMessage) {
        this(responseStatusCode, responseMessage, null)
    }

    public RawHttpResponse(int responseStatusCode, String responseMessage, String responseBody) {
        this.responseStatusCode = responseStatusCode
        this.responseMessage = responseMessage
        this.responseBody = responseBody
    }

    public int getResponseStatusCode() {
        return responseStatusCode
    }

    public String getResponseMessage() {
        return responseMessage
    }

    public String getResponseBody() {
        return responseBody
    }

    public Object getJSONResponseBody() throws Exception {
        JsonSlurper jsonSlurper = new JsonSlurper()
        Object JSONResponse = jsonSlurper.parseText(responseBody)
        return JSONResponse
    }
}
