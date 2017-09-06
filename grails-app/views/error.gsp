<!doctype html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>
        <g:if env="development">Grails Runtime Exception</g:if>
        <g:else>Error</g:else>
    </title>

    <asset:stylesheet src="gentelella.css" />
    <g:if env="development">
        <asset:stylesheet src="errors.css" />
    </g:if>


</head>

<head>
    <meta name="layout" content="gentelellaBase" />
    <title>Page Not Found</title>
</head>

<body>
    <!-- page content -->
    <div class="row">
        <div class="col-md-12">
            <div class="col-middle">
                <div class="text-center">
                    <h1 class="error-number">500</h1>
                    <h2>Internal Server Error</h2>
                    <p>We track these errors automatically, but if the problem persists feel free to contact us. In the meantime, try refreshing.
                    </p>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="x_panel">

                <div class="x_content">

                    <g:if env="development">
                        <g:if test="${Throwable.isInstance(exception)}">
                            <g:renderException exception="${exception}" />
                        </g:if>
                        <g:elseif test="${request.getAttribute('javax.servlet.error.exception')}">
                            <g:renderException exception="${request.getAttribute('javax.servlet.error.exception')}" />
                        </g:elseif>
                        <g:else>
                            <ul class="errors">
                                <li>An error has occurred</li>
                                <li>Exception: ${exception}</li>
                                <li>Message: ${message}</li>
                                <li>Path: ${path}</li>
                            </ul>
                        </g:else>
                    </g:if>
                </div>
            </div>
        </div>
    </div>
    <!-- /page content -->
</body>

</html>