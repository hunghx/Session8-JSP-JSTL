<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%response.sendRedirect(request.getContextPath()+"/HomeServlet?action=Home");%>
<%!
    int count;
    public void jspInit(){
      count =0;
        System.out.println("jsp is init");
    }

%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>
<%count++; System.out.println(count);%>
<h1>Số lần tải trang index là <%=count%>
</h1>
<c:set scope="request" var="count" value='10'></c:set>
<span>số lần tải trang là <c:out value="${count}"></c:out> lần</span>
<br>
<%-- câu lệnh điều kiện nếu - thì--%>
<c:if test="${count%2==0}">
    <span>${count} chia hết cho 2</span>
</c:if>

<%-- choose when--%>
<c:choose>
    <c:when test="">

    </c:when>
    <c:when test="">

    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>

<%
request.setAttribute("list",new int[]{1,6,78,56,5} );
%>
<%--vòng lặp--%>
<c:forEach items="${list}" var="item" varStatus="loop">
    <li>Vòng lặp thứ ${loop.count} : giá trị phần tử là : ${item}</li>
</c:forEach>

<%!
public void jspDestroy(){
    System.out.println("This jsp is destroyed");
}
%>
</body>

</html>
