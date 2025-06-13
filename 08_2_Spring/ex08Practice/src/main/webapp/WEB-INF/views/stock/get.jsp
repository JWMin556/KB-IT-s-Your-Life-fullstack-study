<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp"%>

<h1 class="page-header-my-4"><i class="far fa-file-alt"></i>${stock.stockName}</h1>

<div class="p-3 rounded" style="background-color: #e6f2ff; font-family: sans-serif;">
  <div class="mb-2 fw-bold"><i class="fas fa-barcode text-primary me-2"></i> 종목 코드: ${stock.stockCode}</div>
  <div class="mb-2 fw-bold"><i class="fas fa-coins text-primary me-2"></i> 현재가: ${stock.price} 원</div>
  <div class="mb-2 fw-bold"><i class="fas fa-calendar-alt text-primary me-2"></i> 등록일: <fmt:formatDate pattern="yyyy-MM-dd" value="${stock.regDate}"/></div>
  <div class="fw-bold"><i class="fas fa-info-circle text-primary me-2"></i> 설명: <br> ${stock.description}</div>
</div>
<hr>

<div>${board.content}</div>

<div class="mt-4">
  <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
  <a href="update?no=${board.no}" class="btn btn-success"><i class="fa-solid fa-cart-plus"></i> 매수하기</a>
</div>

<script src="/resources/js/board.js"></script>

<%@include file="../layouts/footer.jsp"%>