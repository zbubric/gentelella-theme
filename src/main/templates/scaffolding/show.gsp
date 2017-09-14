<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="gentelella" />
    <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}" />
    <title>
        <g:message code="default.show.label" args="[entityName]" />
    </title>
</head>

<body>


    <g:if test="\${flash.message}">
        <div class="message" role="status">\${flash.message}</div>
    </g:if>

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
        <g:link action="create" class="btn btn-app">
            <i class="fa fa-plus"></i>
            <g:message code="default.new.label" args=" " />
        </g:link>

        <!-- Main Container -->
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    <g:message code="default.show.label" args="[entityName]" />
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>

                <f:display bean="${propertyName}" />

                <g:form resource="\${this.${propertyName}}" method="DELETE">
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <g:link class="btn btn-primary" action="edit" resource="\${this.${propertyName}}">
                                <g:message code="default.button.edit.label" default="Edit" /></g:link>
                            <input class="btn btn-danger" type="submit" value="\${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('\${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </div>
                    </div>
                </g:form>
            </div>
        </div>
    </div>
    <!-- gentelella end -->

</body>

</html>