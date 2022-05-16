
<%@page import="java.util.Date"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="cp" value="${pageContext.request.contextPath}"/>
	<c:set var="list" value="<%=Arrays.asList(\"mon\",\"tue\",\"sat\") %>"/>
	<c:set var="hobby" value="read,ski,golf,degine"/>
	<h3>jstl 테스트</h3>
	<a href="${cp}">홈으로이동</a>
	<a href="<c:url value="/empList"/>">사원목록</a>
	
	<c:url value="/empList" var="linkEmp">
		<c:param name="page" value="1"/>
		<c:param name="search" value="1111"/>
	</c:url>
	<a href="${linkEmp}">사원</a>
	<hr>
	총갯수: ${fn:length(list)}<br>
	<c:forEach items="${list}" var="week">
		${week}<br>
	</c:forEach>
	<hr>
	
	<ul>
	<c:forTokens items="${hobby}" var="hb" delims=",">
		<li>${hb}
	</c:forTokens>
	</ul>
	<hr>
	
	<select>
	<c:forEach items="${fn:split(hobby,',')}" var="hb">
		<option <c:if test="${hb eq 'degine'}">selected="selected"</c:if>>${hb}</option>
	</c:forEach>
	</select>
	<c:set var="hobbylist" value="${fn:split(hobby,',')}"/>
	총갯수 : ${fn:length(hobbylist)} <br>

	<c:set var="wdate" value="<%=new Date() %>"/>
	<fmt:formatDate value="${wdate}" pattern="yyyy-MM-dd"/> 
	
	<c:set var="sdate" value="2022-10-05 12:34"/>
	<fmt:parseDate var="psdate" value="${sdate}" pattern="yyyy-MM-dd hh:mm" />
	<fmt:formatDate value="${psdate}" pattern="MM-dd"/>
</body>
</html>