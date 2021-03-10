<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>Coordinates</h3>
                <table border="3" cellspacing="5" cellpadding="5">
                    <tr>
                        <th> </th>
                        <th>x</th>
                        <th>y</th>
                    </tr>
                    <xsl:for-each select="coordinates/point">
                    <tr>
                        <td><xsl:value-of select="name(.)"/></td>
                        <td><xsl:value-of select="x"/> <xsl:value-of select="//point/@unit"/></td>
                        <td><xsl:value-of select="y"/> <xsl:value-of select="//point/@unit"/></td>
                    </tr>
                    </xsl:for-each>
                </table>
             </body>
        </html>
    </xsl:template>
</xsl:stylesheet>