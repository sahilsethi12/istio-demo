<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="no"/>
    <xsl:param name="Syserrorcode" />
    <xsl:param name="Syserrormessage" />
    <xsl:template match="/">
        <API>
            <retStatus>FAILURE</retStatus>
            <sysErrorCode>
                <xsl:value-of select="$Syserrorcode" />
            </sysErrorCode>
            <sysErrorMessage>
                <xsl:value-of select="$Syserrormessage" />
            </sysErrorMessage>
            <errorMessage>
                <xsl:value-of select="errorMsg" />
            </errorMessage>
        </API>
    </xsl:template>
</xsl:stylesheet>
