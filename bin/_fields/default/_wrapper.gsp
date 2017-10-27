<div class="item form-group ${invalid ? 'bad' : ''}">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="${property}">${label}
        <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <%=widget%>

            <g:if test="${iconLeft}">
                <gent:fieldIcon icon='${iconLeft}' side='left' />
            </g:if>
            <g:elseif test="${iconRight}">
                <gent:fieldIcon icon='${iconRight}' side='right' />
            </g:elseif>
            <g:if test="${invalid} ">
                <div class="alert ">${errors.join('<br>')}</div>
            </g:if>
    </div>


</div>