<%@ include file="/WEB-INF/utils/pageMeta.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/utils/head.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-12">
            <div id="carouselExampleControls" class="carousel slide smart-carousel" data-ride="carousel"
                 data-interval="false" data-wrap="false">
                <div class="carousel-inner smart-carousel__inner">
                    <c:forEach items="${smartPairs}" var="pair" varStatus="i">
                        <div class="carousel-item ${i.index == 0 ? 'active' : ''}">
                            <div class="row align-items-center">
                                <div class="col-sm-12 col-md-5">
                                    <my:vector vector="${smartPairs[0].key}"/>
                                </div>
                                <div class="col-sm-12 col-md-2 operations">
                                    <ul class="operations__list">
                                        <li class="operations__item">
                                            <form method="post">
                                                <button type="submit" class="btn btn-primary"><</button>
                                            </form>
                                        </li>
                                        <li class="operations__item">
                                            <form method="post">
                                                <button type="submit" class="btn btn-primary">=</button>
                                            </form>
                                        </li>
                                        <li class="operations__item">
                                            <form method="post">
                                                <button type="submit" class="btn btn-primary">></button>
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-sm-12 col-md-5">
                                    <my:vector vector="${smartPairs[0].value}"/>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <a class="carousel-control-prev smart-carousel__control" href="#carouselExampleControls" role="button"
                   data-slide="prev">
                    <i class="fa fa-chevron-left"></i>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next smart-carousel__control" href="#carouselExampleControls" role="button"
                   data-slide="next">
                    <i class="fa fa-chevron-right"></i>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>