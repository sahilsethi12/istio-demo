<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:param name="RetStatus" />
    <xsl:param name="SysErrorCode" />
    <xsl:param name="SysErrorMessage" />
    <xsl:param name="ReturnCode" />

    <xsl:param name="ErrorMessage" />
    <xsl:template match="/LinkedHashMap">
        <Response>
            <RetStatus>
                <xsl:value-of select="$RetStatus" />
            </RetStatus>
            <SysErrorCode>
                <xsl:value-of select="$SysErrorCode" />
            </SysErrorCode>
            <SysErrorMessage>
                <xsl:value-of select="$SysErrorMessage" />
            </SysErrorMessage>
            <ErrorMessage>
                <xsl:value-of select="$ErrorMessage" />
            </ErrorMessage>
            <ReturnCode>
                <xsl:value-of select="$ReturnCode" />
            </ReturnCode>
            <PanVerificationResponse>
                <xsl:copy-of select="PanVerificationResponse/*"/>
             </PanVerificationResponse>
        </Response>
    </xsl:template>
</xsl:stylesheet>
