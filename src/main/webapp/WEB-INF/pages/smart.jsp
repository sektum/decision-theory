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
            <div id="carousel-smart" class="carousel slide smart-carousel" data-ride="carousel"
                 data-interval="false" data-wrap="false">
                <div class="carousel-inner smart-carousel__inner">
                    <c:forEach items="${smartPairs}" var="pair" varStatus="i">
                        <div class="carousel-item ${i.index == 0 ? 'active' : ''}">
                            <form class="smart-carousel__form">
                                <div class="row align-items-center">
                                    <div class="col-sm-12 col-md-5">
                                        <input type="hidden" name="alt1" value="${pair.key.altName}"/>
                                        <my:vector vector="${pair.key}"/>
                                    </div>
                                    <div class="col-sm-12 col-md-2 text-center">
                                        <div class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
                                            <label class="btn btn-secondary">
                                                <input
                                                        type="radio"
                                                        name="operation"
                                                        autocomplete="off"
                                                        class="operation-radio"
                                                        value="<"
                                                >
                                                <
                                            </label>
                                            <label class="btn btn-secondary">
                                                <input
                                                        type="radio"
                                                        name="operation"
                                                        autocomplete="off"
                                                        class="operation-radio"
                                                        value="="
                                                >
                                                =
                                            </label>
                                            <label class="btn btn-secondary">
                                                <input
                                                        type="radio"
                                                        name="operation"
                                                        autocomplete="off"
                                                        class="operation-radio"
                                                        value=">"
                                                >
                                                >
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-5">
                                        <input type="hidden" name="alt2" value="${pair.value.altName}"/>
                                        <my:vector vector="${pair.value}"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </c:forEach>
                </div>
                <a class="carousel-control-prev smart-carousel__control d-none" href="#carousel-smart" role="button"
                   data-slide="prev">
                    <i class="fa fa-chevron-left"></i>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next smart-carousel__control" href="#carousel-smart" role="button"
                   data-slide="next">
                    <i class="fa fa-chevron-right"></i>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="modal hide" tabindex="-1" role="dialog" id="resultModal" aria-hidden="true" data-backdrop="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Готово</h5>
            </div>
            <div class="modal-body">
                <p>Ваш выбор сохранен.</p>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary" href="/results" role="button">Получить результат!</a>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/utils/footer.jsp" %>
<script type="text/javascript">
    $('.operation-radio').change(function () {

        var data = $(this).closest('form').serialize();
        $.post('/smart', data);

        var curSlide = $('div.active');
        if (curSlide.is(':last-child')) {
            $('#resultModal').show();
        }
        else {
            $('#carousel-smart').carousel('next');
        }
    });
    $('#carousel-smart')
        .on('slid.bs.carousel', function () {
            var curSlide = $('div.active');
            if (curSlide.is(':first-child')) {
                $('.carousel-control-prev').addClass('d-none');
            }
            else {
                $('.carousel-control-prev').removeClass('d-none');
            }
            if (curSlide.is(':last-child')) {
                $('.carousel-control-next').addClass('d-none');
            }
            else {
                $('.carousel-control-next').removeClass('d-none');
            }
        });
</script>
</body>
</html>