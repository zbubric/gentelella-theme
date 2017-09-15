<%@ page defaultCodec="html" %>
    <div class="item form-group ${invalid ? 'bad' : ''}">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="${property}">${label}
    <span class="required">*</span>
    </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
            <%= widget %>
        </div>
        <g:if test="${invalid}">
            <div class="alert">${errors.join('<br>')}</div>
        </g:if>
    </div>