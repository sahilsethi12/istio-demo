package com.tcl;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component(value = "RequestProcessor")
public class RequestProcessor implements Processor {

    @Override
    public void process(Exchange ex) throws Exception {

        String json = ex.getIn().getBody(String.class);

        String rectifiedJson = json.replace("[]", "\"\"");

        ex.getIn().setBody(rectifiedJson);

    }

    public void validateProduct(Exchange ex) throws Exception {

        String product = ex.getProperty("product", String.class);

        if (product.equals("HFL") || product.equals("FSL")) {

            ex.setProperty("status", "yes");

        } else {

            ex.setProperty("status", "no");

        }

    }
    public void requestProcessor(Exchange ex) throws Exception {

        String json = ex.getIn().getBody(String.class);

        String rectifiedJson = json.replace("[]", "\"\"");

        rectifiedJson = rectifiedJson.replace("[ ]", "\"\"");

        ex.getIn().setBody(rectifiedJson);
    }
    public void trackWizzSearchRequest(Exchange ex) throws Exception{
        String trackWizzData=ex.getIn().getBody().toString();
        String trackWizzFinalRequest = StringUtils.substringAfter(trackWizzData,"<A50SearchInCkycRequest>");
        trackWizzFinalRequest="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
                + "<A50SearchInCkycRequest>\r\n"+"<ApiToken>"+ex.getProperty("apiToken").toString()+"</ApiToken>\r\n"+"<RequestId>"+ex.getProperty("TransactionId").toString()+"</RequestId>"+"<ParentCompany>"+ex.getProperty("parentCompany").toString()+"</ParentCompany>"+trackWizzFinalRequest;
        ex.getIn().setBody(trackWizzFinalRequest);
    }
    public void trackWizzFinalRequestBody(Exchange ex) throws Exception{
        String trackWizzData=ex.getProperty("OriginalRequestAsXML").toString();
        String trackWizzFinalRequest = StringUtils.substringAfter(trackWizzData,"<A51DownloadFromCkycRequest>");
        trackWizzFinalRequest="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
                + "<A51DownloadFromCkycRequest>\r\n"+"<ApiToken>"+ex.getProperty("apiToken").toString()+"</ApiToken>\r\n"+"<RequestId>"+ex.getProperty("TransactionId").toString()+"</RequestId>"+"<ParentCompany>"+ex.getProperty("parentCompany").toString()+"</ParentCompany>"+trackWizzFinalRequest;
        ex.getIn().setBody(trackWizzFinalRequest);
    }
    public void trackWizzFinalRequestFailedBody(Exchange ex) throws Exception{
        ex.getIn().setBody("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
                + "<Response>\r\n"
                + "    <retStatus>ERROR</retStatus>\r\n"
                + "    <sysErrorCode>ERRESB205</sysErrorCode>\r\n"
                + "    <sysErrorMessage>Invalid Request!</sysErrorMessage>\r\n"
                + "    <errorMessage>oppID is required for CFD or  webtopNo is required for CFAB to push documents in DMS for "+ex.getIn().getBody().toString()+"</errorMessage>\r\n"
                + "</Response>");
    }
    public void trackWizzRequestValidation(Exchange ex) throws Exception {

        String oppID=ex.getProperty("OppId").toString();
        String webtopNo=ex.getProperty("webtopNo").toString();
        String trackWizzData=ex.getIn().getBody().toString();
        if(oppID.equals("") && webtopNo.equals("")) {
            ex.setProperty("InvalidReq", "Y");
            ex.getIn().setBody("CKYCNumber:"+ex.getProperty("CKYCNumber"));

        }
        else if(!oppID.equals("") && !webtopNo.equals("")) {
            ex.setProperty("InvalidReq", "Y");
            ex.getIn().setBody("CKYCNumber:"+ex.getProperty("CKYCNumber"));

        }
        else if (!oppID.equals("") && webtopNo.equals("")) {
            ex.setProperty("InvalidReq", "N");
            ex.getIn().setBody("");
        }
        else if(oppID.equals(null) && webtopNo.equals(null)) {
            ex.setProperty("InvalidReq", "Y");
            ex.getIn().setBody("CKYCNumber:"+ex.getProperty("CKYCNumber"));

        }
        else {
            ex.setProperty("InvalidReq", "N");
            ex.getIn().setBody("");
        }


    }

}
