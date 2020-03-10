<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class='page-item <c:if test="${p.pageNum==1}">disabled</c:if>'>
      <a class="page-link" href="javascript:goPage(1)" tabindex="-1"  <c:if test="${p.pageNum==1}">aria-disabled="true"</c:if> >首页</a>
    </li>
    
    <c:forEach begin="1" end="${p.pages}" var="currentPage">
    	<li class="page-item"><a class="page-link" href="javascript:goPage(${currentPage})">${currentPage}</a></li>
    </c:forEach>
    
    <li class='page-item <c:if test="${p.pageNum==p.pages}">disabled</c:if>' >
      <a class="page-link" href="javascript:goPage(${p.pages})" <c:if test="${p.pageNum==p.pages}">aria-disabled="true"</c:if> >尾页</a>
    </li>
  </ul>
</nav>