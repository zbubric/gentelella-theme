<!doctype html>
<html lang="en">

<head>
    <meta name="layout" content="gentelellaBase" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Page Not Found</title>

    <asset:stylesheet src="gentelella.css" />
</head>

<head>
    <meta name="layout" content="gentelellaBase" />
    <title>Page Not Found</title>
</head>

<body>
    <!-- page content -->
    <div class="col-md-12">
        <div class="col-middle">
            <div class="text-center text-center">
                <h1 class="error-number">404</h1>
                <h2>Sorry but we couldn't find this page</h2>
                <p>This page you are looking for does not exist: ${request.forwardURI}
                </p>
            </div>
        </div>
    </div>
    <!-- /page content -->
</body>


</html>