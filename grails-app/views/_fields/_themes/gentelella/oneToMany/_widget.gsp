<g:if test="${dataset}">
    <%-- Include full list of options from dataset --%>
        <g:each in="${dataset}" var="item">
            <div class="checkbox">
                <label>
                    
                <g:checkBox class="flat" name="${property}" value="${item.id}" checked="${value.find { p -> p.id == item.id }}"/> ${item}
            </label>
            </div>
        </g:each>
</g:if>
<g:else>
    <%-- Just selected items (default Grails behavior) --%>
        <g:each in="${value}" var="p">
            <div class="checkbox">
                <label>
                    <g:checkBox class="flat" name="${property}" value="${item.id}" /> ${p}
                </label>
            </div>
        </g:each>
</g:else>