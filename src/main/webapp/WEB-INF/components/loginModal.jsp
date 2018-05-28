<div class="modal" tabindex="-1" role="dialog" id="loginModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Идентификация</h5>
            </div>
            <div class="modal-body">
                <p>Пожалуйста, скажите нам, кто Вы:</p>
                <form>
                    <c:forEach items="${lprs}" var="lpr">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="exampleRadios" value="${lpr.id}">
                            <label class="form-check-label">
                                ${lpr.name}
                            </label>
                        </div>
                    </c:forEach>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Поехали!</button>
            </div>
        </div>
    </div>
</div>
