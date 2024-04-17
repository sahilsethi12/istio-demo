package com.tcl;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Response {

    @JacksonXmlProperty(localName = "RetStatus")
    @JsonProperty("RetStatus")
    String RetStatus;

    @JacksonXmlProperty(localName = "ReturnCode")
    @JsonProperty("ReturnCode")
    String ReturnCode;

    @JacksonXmlProperty(localName = "SysErrorCode")
    @JsonProperty("SysErrorCode")
    String SysErrorCode;

    @JacksonXmlProperty(localName = "SysErrorMessage")
    @JsonProperty("SysErrorMessage")
    String SysErrorMessage;


    @JacksonXmlProperty(localName = "ErrorMessage")
    @JsonProperty("ErrorMessage")
    String ErrorMessage;

    @JacksonXmlProperty(localName = "PanVerificationResponse")
    @JsonProperty("PanVerificationResponse")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PanVerificationResponse> PanVerificationResponse;

}
