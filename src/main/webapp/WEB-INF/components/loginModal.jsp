<div class="modal hide" tabindex="-1" role="dialog" id="loginModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Идентификация</h5>
            </div>
            <form id="loginForm">
                <div class="modal-body">
                    <p>Пожалуйста, скажите нам, кто Вы:</p>
                    <c:forEach items="${lprs}" var="lpr">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="lpr" value="${lpr.id}">
                            <label class="form-check-label">
                                    ${lpr.name}
                            </label>
                        </div>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button id="loginButton" type="button" class="btn btn-primary">Поехали!</button>
                </div>
            </form>
        </div>
    </div>
</div>
