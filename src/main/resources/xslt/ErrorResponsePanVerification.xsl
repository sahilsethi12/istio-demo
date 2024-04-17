<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="no"/>
    <xsl:param name="RetStatus" />
    <xsl:param name="SysErrorCode" />
    <xsl:param name="SysErrorMessage" />
    <xsl:param name="ErrorMessage"/>
    <xsl:param name="ReturnCode" />
    <xsl:template match="/">
        <Response>
            <RetStatus>
                <xsl:value-of select="$RetStatus" />
            </RetStatus>
            <ErrorMessage>
                <xsl:value-of select="$ErrorMessage" />
            </ErrorMessage>
            <SysErrorCode>
                <xsl:value-of select="$SysErrorCode" />
            </SysErrorCode>
            <SysErrorMessage>
                <xsl:value-of select="$SysErrorMessage" />
            </SysErrorMessage>
            <ReturnCode>
                <xsl:value-of select="$ReturnCode" />
            </ReturnCode>
        </Response>
    </xsl:template>
</xsl:stylesheet>
