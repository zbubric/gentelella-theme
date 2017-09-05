<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="gentelella" />
    <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}" />
    <title>
        <g:message code="default.list.label" args="[entityName]" />
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
        <g:link action="create" class="btn btn-app">
            <i class="fa fa-plus"></i>
            <g:message code="default.new.label" args=" " />
        </g:link>

        <div class="x_panel">
            <div class="x_title">
                <h2>
                    <g:message code="default.list.label" args="[entityName]" />
                </h2>
                <div class="clearfix"></div>
            </div>

            <div class="x_content">
                <exa:datatable id="${propertyName}Table" items="\${${propertyName}List}" add="ctrls" reorder="ctrls">

                    <exa:customColumn name="ctrls">
                        <a href="/\${entityName}/show/\${it?.id}"><i class="fa fa-search"></i></a>
                        <a href="/\${entityName}/edit/\${it?.id}"><i class="fa fa-edit"></i></a>
                    </exa:customColumn>
                </exa:datatable>
            </div>

            <div class="pagination">
                <g:paginate total="\${${propertyName}Count ?: 0}" />
            </div>

        </div>
    </div>

</body>

</html>