<g:each in="${value}" var="p">
    <div class="checkbox">
        <label>
        <g:checkBox class="flat" name="${property}" value="${item?.id}" /> ${p}
    </label>
    </div>
</g:each>