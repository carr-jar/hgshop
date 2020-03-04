<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
   添加
</button>

<table class="table">
	
	<tr> 
		<th>id</th>
		<th>名称</th>
		<th>首字母</th>
		<th>状态</th>
	</tr>
	<c:forEach items="${p.list}" var="brand">
		<tr>
			<td>${brand.id}</td>
			<td>${brand.name}</td>
			<td>${brand.firstChar}</td>
			<td>${brand.deletedFlag==0?'在售':'未售'}</td>		
		</tr>
	</c:forEach>
	
	<!-- pageInfo -->
</table>    
