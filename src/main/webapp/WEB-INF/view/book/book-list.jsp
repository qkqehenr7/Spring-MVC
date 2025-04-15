<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>Grepp</title>
    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>
<main class="container">
    <h4>Book List</h4>
    <ul class="collection book-list">
        <c:forEach items="${books}" var="book">
            <li class="collection-item avatar">
                <c:if test="${empty book.images}">
                    <img src="#" alt="thumbnail" class="circle">
                </c:if>

                <c:if test="${not empty book.images}">
                    <c:forEach items="${book.images}" var="image">
                        <c:if test="${image.type.name() == 'THUMBNAIL'}">
                            <img src="${image.url}" alt="thumbnail" class="circle">
                        </c:if>
                    </c:forEach>
                </c:if>
                <span class="title"><c:out value="${book.title}"/></span>
                <p><c:out value="${book.author}"/></p>
                <a href="#" class="secondary-content"><i class="material-icons">grade</i></a>
            </li>
        </c:forEach>
    </ul>
</main>

<ul class="collection" id="bookListTemplate" style="display:none;">
    <li class="collection-item avatar">
        <img src="#" alt="thumbnail" class="circle thumbnail">
        <span class="title"></span>
        <p class="author"></p>
        <a href="#" class="secondary-content"><i class="material-icons">grade</i></a>
    </li>
</ul>
<%--더블 클릭 후 이벤트 발생 시 사용--%>
<%--<span class="target" style="display:none;"></span>--%>

<%--스크롤만으로 이벤트 발생 시 사용--%>
<span class="target" style="display:block;"></span>

<%@include file="/WEB-INF/view/include/footer.jsp" %>
<script src="${context}/assets/js/book-list.js" defer ></script>
</body>
</html>