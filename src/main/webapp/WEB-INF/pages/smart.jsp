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
                                        <my:vector vector="${pair.key}" strike="true"/>
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
                                        <my:vector vector="${pair.value}" strike="true"/>
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

<div class="modal hide" tabindex="-1" role="dialog" id="resultModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Готово</h5>
            </div>
            <div class="modal-body">
                <p>Ваш выбор сохранен.</p>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary" href="/matrix" role="button">Получить результат!</a>
            </div>
        </div>
    </div>
</div>

<div class="modal hide" tabindex="-1" role="dialog" id="transitivityModal" aria-hidden="true" data-backdrop="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Упс!</h5>
            </div>
            <div class="modal-body">
                <p id="transitivityErrorMessage"></p>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary" href="/smart" role="button">Пройти заново</a>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/components/loginModal.jsp"%>
<%@include file="/WEB-INF/utils/footer.jsp" %>
<script src="/static/vendor/mustache.min.js"></script>
<script src="/static/js/showModalOnStartup.js"></script>
<script src="/static/js/sendLoginData.js"></script>
<script type="text/javascript">
    $('#loginButton').click(function (e) {
        e.preventDefault();
        sendLoginData();
        $('#loginModal').modal('hide');
    })
</script>
<script type="text/javascript">
    $('.operation-radio').change(function () {

        var data = $(this).closest('form').serialize();
        $.post('/smart', data);

        var curSlide = $('div.active');
        if (curSlide.is(':last-child')) {
            $.get('/transitivity', function(data){
                var response = JSON.parse(data);
                if (response.valid) {
                    $('#resultModal').modal('show');
                } else {
                    var output = Mustache.render('Ваш выбор невалиден.');
                    $('#transitivityErrorMessage').text(output);
                    $('#transitivityModal').modal('show');
                }
            });
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
    $('._criterionCheck').change(function(){
        $(this).closest('tr').toggleClass('disabled-row');
    });
</script>
</body>
</html>