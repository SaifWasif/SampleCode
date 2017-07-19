package com.example.mirsaifuddin.soapusingsimple.model.request;

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

    public static class RetrieveSecurityToken {

        @Element(name = "RetrieveSecurityTokenRequest", required = false)
        RetrieveSecurityTokenRequest retrieveSecurityTokenRequest;

        public RetrieveSecurityTokenRequest getRetrieveSecurityTokenRequest() {
            return this.retrieveSecurityTokenRequest;
        }

        public void setRetrieveSecurityTokenRequest(RetrieveSecurityTokenRequest value) {
            this.retrieveSecurityTokenRequest = value;
        }

    }

    public static class RetrieveSecurityTokenRequest {

        @Element(name = "LogonID", required = false)
        String logonID;

        @Element(name = "CarrierCodes", required = false)
        CarrierCodes carrierCodes;

        @Element(name = "Password", required = false)
        String password;

        public String getLogonID() {
            return this.logonID;
        }

        public void setLogonID(String value) {
            this.logonID = value;
        }

        public CarrierCodes getCarrierCodes() {
            return this.carrierCodes;
        }

        public void setCarrierCodes(CarrierCodes value) {
            this.carrierCodes = value;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String value) {
            this.password = value;
        }

    }

    public static class CarrierCode {

        @Element(name = "AccessibleCarrierCode", required = false)
        String accessibleCarrierCode;

        public String getAccessibleCarrierCode() {
            return this.accessibleCarrierCode;
        }

        public void setAccessibleCarrierCode(String value) {
            this.accessibleCarrierCode = value;
        }

    }

    public static class Body {

        @Element(name = "RetrieveSecurityToken", required = false)
        RetrieveSecurityToken retrieveSecurityToken;

        public RetrieveSecurityToken getRetrieveSecurityToken() {
            return this.retrieveSecurityToken;
        }

        public void setRetrieveSecurityToken(RetrieveSecurityToken value) {
            this.retrieveSecurityToken = value;
        }

    }

    public static class CarrierCodes {

        @Element(name = "CarrierCode", required = false)
        CarrierCode carrierCode;

        public CarrierCode getCarrierCode() {
            return this.carrierCode;
        }

        public void setCarrierCode(CarrierCode value) {
            this.carrierCode = value;
        }

    }

}