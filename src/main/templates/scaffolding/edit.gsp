<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="gentelella" />
    <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}" />
    <title>
        <g:message code="default.edit.label" args="[entityName]" />
    </title>
</head>

<body>

    <g:if test="\${flash.message}">
        <div class="message" role="status">\${flash.message}</div>
    </g:if>
    <g:hasErrors bean="\${this.${propertyName}}">
        <ul class="errors" role="alert">
            <g:eachError bean="\${this.${propertyName}}" var="error">
                <li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>>
                    <g:message error="\${error}" />
                </li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <!-- gentelella -->
    <div class="col-md-12 col-sm-12 col-xs-12">

        <!-- Action buttons -->
        <a class="btn btn-app" href="\${createLink(uri: '/')}">
            <i class="fa fa-home"></i>
            <g:message code="default.home.label" />
        </a>
        <g:link action="index" class="btn btn-app">
            <i class="fa fa-list-ul"></i>
            <g:message code="default.list.label" args=" " />
        </g:link>

        <div class="x_panel">
            <div class="x_title">
                <h2>
                    <g:message code="default.edit.label" args="[entityName]" />
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <g:form resource="\${this.${propertyName}}" method="POST" class="form-horizontal form-label-left">

                    <f:all bean="${propertyName}" widget-class="form-control" />
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button class="btn btn-primary" type="reset">Reset</button>
                            <g:link class="btn btn-primary" url="\${request.getHeader('referer')}"> \${message(code: 'default.button.cancel.label', default: 'cancel')} </g:link>
                            <g:submitButton name="update" class="save btn btn-success" value="\${message(code: 'default.button.edit.label', default: 'edit')}" />
                        </div>
                    </div>

                </g:form>
            </div>
        </div>
    </div>
    <!-- gentelella end -->


</body>

</html>