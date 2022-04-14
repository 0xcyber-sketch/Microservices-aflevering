package com.lange.domain.exception;


public class DomainValidation extends  Exception{

    private final Sid sid;

    public DomainValidation(Sid sid, String message) {
        super(message);
        this.sid = sid;
    }

    public DomainValidation(Sid sid, String message, Throwable cause) {
        super(message, cause);
        this.sid = sid;
    }

    public Sid getSid() {
        return sid;
    }
}
