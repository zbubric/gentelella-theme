<g:if test="${dataset}">
    <%-- Include full list of options from dataset --%>
        <select class="select2_multiple form-control" multiple="multiple">
        <g:each in="${dataset}" var="item">
                <option value="${item.id}" <%= value.find { p -> p.id == item.id }?'selected':''  %> > ${item}</option>
        </g:each>
    </select>
</g:if>
<g:else>
    <%-- Just selected items (default Grails behavior) --%>
        <select class="select2_multiple form-control" multiple="multiple">
        <g:each in="${value}" var="p">
            <option value="${item.id}">${item}</option>
        </g:each>
    </select>
</g:else>