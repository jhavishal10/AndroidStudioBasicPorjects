package com.abhiwan.gramoday.gramodaysankalp;

public class Request {
private String requestId;
private String requestName;
public Request(){
}

    public Request(String requestId, String requestName) {
        this.requestId = requestId;
            this.requestName = requestName;

    }

    public String getRequestId() {
        return requestId;
    }

    public String getRequestName() {
        return requestName;
    }


}
