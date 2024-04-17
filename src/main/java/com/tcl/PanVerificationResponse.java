package com.tcl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;


public class PanVerificationResponse {

    @JacksonXmlProperty(localName = "AadhaarSeedingStatus")
    @JsonProperty("AadhaarSeedingStatus")
    public String AadhaarSeedingStatus;
    @JacksonXmlProperty(localName = "FirstName")
    @JsonProperty("FirstName")
    public String FirstName;
    @JacksonXmlProperty(localName = "NameOnCard")
    @JsonProperty("NameOnCard")
    public String NameOnCard;
    @JacksonXmlProperty(localName = "PanNo")
    @JsonProperty("PanNo")
    public String PanNo;

    @JacksonXmlProperty(localName = "PanStatus")
    @JsonProperty("PanStatus")
    public String PanStatus;
    @JacksonXmlProperty(localName = "LastName")
    @JsonProperty("LastName")
    public String LastName;
    @JacksonXmlProperty(localName = "PanTitle")
    @JsonProperty("PanTitle")
    public String PanTitle;
    @JacksonXmlProperty(localName = "MiddleName")
    @JsonProperty("MiddleName")
    public String MiddleName;

    @JacksonXmlProperty(localName = "Filler")
    @JsonProperty("Filler")
    public String Filler;

    @JacksonXmlProperty(localName = "LastUpdateDate")
    @JsonProperty("LastUpdateDate")
    public String LastUpdateDate;

}
