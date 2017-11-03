<g:each in="${value}" var="p">
    <div class="checkbox">
        <label>
            <g:checkBox class="flat" name="${property}"  value="${p.id}" /> ${p}
        </label>
    </div>
</g:each>