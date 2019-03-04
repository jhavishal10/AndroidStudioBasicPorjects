package com.studyzone.vishaljha.bloodbasic;

public class Request {
private String requestId;
private String requestName;
private String requestBloodGroup;
public Request(){
}

    public Request(String requestId, String requestName, String requestBloodGroup) {
        this.requestId = requestId;
            this.requestName = requestName;
        this.requestBloodGroup = requestBloodGroup;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getRequestName() {
        return requestName;
    }

    public String getRequestBloodGroup() {
        return requestBloodGroup;
    }
}
