package com.example.mirsaifuddin.soapusingsimple.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class Envelope {

    @Element(name = "Header", required = false)
    String header;

    @Element(name = "Body", required = false)
    Body body;

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String value) {
        this.header = value;
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body value) {
        this.body = value;
    }

    public static class ExceptionInformationException {

        @Element(name = "ExceptionSource", required = false)
        String exceptionSource;

        @Element(name = "ExceptionLevel", required = false)
        String exceptionLevel;

        @Element(name = "ExceptionDescription", required = false)
        String exceptionDescription;

        @Element(name = "ExceptionCode", required = false)
        String exceptionCode;

        public String getExceptionSource() {
            return this.exceptionSource;
        }

        public void setExceptionSource(String value) {
            this.exceptionSource = value;
        }

        public String getExceptionLevel() {
            return this.exceptionLevel;
        }

        public void setExceptionLevel(String value) {
            this.exceptionLevel = value;
        }

        public String getExceptionDescription() {
            return this.exceptionDescription;
        }

        public void setExceptionDescription(String value) {
            this.exceptionDescription = value;
        }

        public String getExceptionCode() {
            return this.exceptionCode;
        }

        public void setExceptionCode(String value) {
            this.exceptionCode = value;
        }

    }

    public static class RetrieveSecurityTokenResult {

        @Element(name = "SecurityToken", required = false)
        String securityToken;

        @Element(name = "Exceptions", required = false)
        Exceptions exceptions;

        public String getSecurityToken() {
            return this.securityToken;
        }

        public void setSecurityToken(String value) {
            this.securityToken = value;
        }

        public Exceptions getExceptions() {
            return this.exceptions;
        }

        public void setExceptions(Exceptions value) {
            this.exceptions = value;
        }

    }

    public static class RetrieveSecurityTokenResponse {

        @Element(name = "RetrieveSecurityTokenResult", required = false)
        RetrieveSecurityTokenResult retrieveSecurityTokenResult;

        public RetrieveSecurityTokenResult getRetrieveSecurityTokenResult() {
            return this.retrieveSecurityTokenResult;
        }

        public void setRetrieveSecurityTokenResult(RetrieveSecurityTokenResult value) {
            this.retrieveSecurityTokenResult = value;
        }

    }

    public static class Exceptions {

        @Element(name = "ExceptionInformation.Exception", required = false)
        ExceptionInformationException exceptionInformationException;

        public ExceptionInformationException getExceptionInformationException() {
            return this.exceptionInformationException;
        }

        public void setExceptionInformationException(ExceptionInformationException value) {
            this.exceptionInformationException = value;
        }

    }

    public static class Body {

        @Element(name = "RetrieveSecurityTokenResponse", required = false)
        RetrieveSecurityTokenResponse retrieveSecurityTokenResponse;

        public RetrieveSecurityTokenResponse getRetrieveSecurityTokenResponse() {
            return this.retrieveSecurityTokenResponse;
        }

        public void setRetrieveSecurityTokenResponse(RetrieveSecurityTokenResponse value) {
            this.retrieveSecurityTokenResponse = value;
        }

    }

}