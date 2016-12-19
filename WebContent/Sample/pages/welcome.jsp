<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>
<h1>welcome Page</h1>

<h4>Welcome User <s:property value="username"/></h4>
List of Miracle vendors<br>
<br><b> The below Data is from web service </b> <br> <br>
<s:iterator value="orgNames" id="names">
            <s:property value="names"/><br />

</s:iterator>
</body>
</html>