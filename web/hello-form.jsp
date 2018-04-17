<%--
  Created by IntelliJ IDEA.
  User: julien
  Date: 17/04/2018
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Hello</title>
    <script>
        document.addEventListener('DOMContentLoaded', function(){
            var now = new Date;
            var nowUtc = new Date( now.getTime() - (now.getTimezoneOffset() * 60000));
            document.getElementById('datetime').value = nowUtc.toISOString().substr(11,8);
        }, false);
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/simple-hello" enctype="application/x-www-form-urlencoded" method="post">
    <label>first name:</label>
    <input name="firstName" type="text">
    <br/>
    <label>last name:</label>
    <input name="lastName" type="text">
    <br/>
    <label>Date:</label>
    <input id="datetime" name="datetime" type="text" >
    <br/>
    <button type="submit">Go!</button>
</form>

</body>
</html>

