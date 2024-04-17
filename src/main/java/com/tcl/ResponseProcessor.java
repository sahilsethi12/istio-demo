package com.tcl;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component(value = "ResponseProcessor")
public class ResponseProcessor implements Processor {

    @Override
    public void process(Exchange ex) throws Exception {

        String json = ex.getIn().getBody(String.class);

        String rectifiedJson = json.replace("[]", "\"\"");

        ex.getIn().setBody(rectifiedJson);

    }

    public void ResponseStatus(Exchange ex) throws Exception {

        String json = ex.getIn().getBody(String.class);

        if(json.contains("\"RecordStatusCode\" : \"0\"")) {
            ex.setProperty("Status","SUCCESS");
        }
        else {
            ex.setProperty("Status","FAILURE");
        }
    }
    public void ResponseTransform(Exchange ex) throws Exception {

        String json = ex.getIn().getBody(String.class);
        if(json.contains("status")) {


            String jsondata1 = json.substring(json.indexOf("{") + 1);
            jsondata1 = "{" + "\"retStatus\":"+"\""+ex.getProperty("RetStatus")+"\""+ ",\"sysErrorCode\":"+"\""+ex.getIn().getHeader("SysErrorCode")+"\""+ ",\"sysErrorMessage\":"+"\""+ex.getIn().getHeader("SysErrorMessage")+"\""+","+"\"SavePledgeDataResponse\": {"+jsondata1;
            ex.getIn().setBody(jsondata1);

        }
    }
    public void CreateOpportunityReqTransform(Exchange ex) throws Exception {
        JSONObject bodyFromSFDCBackEnd = new JSONObject(ex.getIn().getBody().toString());
        JSONObject createOpportunityResponse = new JSONObject();
        createOpportunityResponse.put("leadId", bodyFromSFDCBackEnd.get("leadID"));
        createOpportunityResponse.put("opportunityId", bodyFromSFDCBackEnd.get("Opportunityid"));
        createOpportunityResponse.put("webtopId", bodyFromSFDCBackEnd.get("Webtopid"));
        createOpportunityResponse.put("message", bodyFromSFDCBackEnd.get("Message"));
        createOpportunityResponse.put("retStatus", ex.getProperty("RetStatus"));
        createOpportunityResponse.put("sysErrorCode", ex.getIn().getHeader("SysErrorCode"));
        createOpportunityResponse.put("sysErrorMessage", ex.getProperty("ErrMessage"));
        ex.getIn().setBody(createOpportunityResponse);
    }
    public void UpdateKycandNachStatusResTransform(Exchange ex) throws Exception {
        JSONObject bodyFromSFDCBackEnd = new JSONObject(ex.getIn().getBody().toString());
        JSONObject updateKycandNachStatusResponse = new JSONObject();
        updateKycandNachStatusResponse.put("leadId", bodyFromSFDCBackEnd.get("leadID"));
        updateKycandNachStatusResponse.put("opportunityId", bodyFromSFDCBackEnd.get("Opportunityid"));
        updateKycandNachStatusResponse.put("webtopId", bodyFromSFDCBackEnd.get("Webtopid"));
        updateKycandNachStatusResponse.put("message", bodyFromSFDCBackEnd.get("Message"));
        updateKycandNachStatusResponse.put("retStatus", ex.getProperty("RetStatus"));
        updateKycandNachStatusResponse.put("sysErrorCode", ex.getIn().getHeader("SysErrorCode"));
        updateKycandNachStatusResponse.put("sysErrorMessage", ex.getProperty("ErrMessage"));
        ex.getIn().setBody(updateKycandNachStatusResponse);
    }
    public void KYCAndAadharDetailUpdationResTransform(Exchange ex) throws Exception {
        JSONObject bodyFromSFDCBackEnd = new JSONObject(ex.getIn().getBody().toString());
        JSONObject kycAndAadharDetailUpdationResponse = new JSONObject();
        kycAndAadharDetailUpdationResponse.put("webtopId", bodyFromSFDCBackEnd.get("webtopId"));
        kycAndAadharDetailUpdationResponse.put("message", bodyFromSFDCBackEnd.get("message"));
        kycAndAadharDetailUpdationResponse.put("opportunityId", bodyFromSFDCBackEnd.get("opportunityId"));
        kycAndAadharDetailUpdationResponse.put("leadId", bodyFromSFDCBackEnd.get("leadId"));
        kycAndAadharDetailUpdationResponse.put("retStatus", ex.getProperty("RetStatus"));
        kycAndAadharDetailUpdationResponse.put("sysErrorCode", ex.getIn().getHeader("SysErrorCode"));
        kycAndAadharDetailUpdationResponse.put("sysErrorMessage", ex.getProperty("ErrMessage"));
        ex.getIn().setBody(kycAndAadharDetailUpdationResponse);
    }
    public void setStatusMessageHeader(Exchange ex) throws Exception{
        String statusmessage=ex.getProperty("Message").toString();
        statusmessage=statusmessage.replaceAll("[^a-zA-Z0-9]","").replaceAll("\\r\\n\\s|\\r|\\n|\\s", "");

        ex.setProperty("StatusMessage",statusmessage);

        //System.out.println("StatusMessage"+statusmessage);
    }
    public void setRetStatusHeader(Exchange ex) throws Exception{
        String trackWizzDownloadResponse=ex.getIn().getBody().toString();
        if(trackWizzDownloadResponse.contains("<TransactionStatus>CKYCSuccess</TransactionStatus>")) {
            ex.setProperty("CKYStatus", "SUCCESS");
        }


    }

}
