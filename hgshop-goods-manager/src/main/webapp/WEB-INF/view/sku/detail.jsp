<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

 <table class="table">
	<tr>
		<th>标题</th>
		<th>${sku.title}</th>
	</tr>
	<tr>
		<th>价格</th>
		<th>${sku.price}</th>
	</tr>
	<tr>
		<th>商品卖点</th>
		<th>${sku.sellPoint}</th>
	</tr>
	<c:forEach items="${sku.specs}" var="op"> 
		<tr>
			<th>${op.specName}:</th>
			<th>${op.optionName}</th>
		</tr>	
 	</c:forEach>
</table>