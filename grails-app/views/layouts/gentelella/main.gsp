<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>

    <!-- Grails Assets -->
    <asset:stylesheet src="gentelella.css" />
    <g:layoutHead/>

</head>

<body class="nav-md">
    <div class="container body">
        <div class="main_container">
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                    <div class="navbar nav_title" style="border: 0;">
                        <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
                    </div>

                    <div class="clearfix"></div>

                    <!-- menu profile quick info -->
                    <gent:userProfile name="John Doe" greeting="Howdy, " />
                    <!-- /menu profile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <gent:menu />
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <g:render template="/layouts/gentelella/sideMenuFooter" />
                    <!-- /menu footer buttons -->
                </div>
            </div>

            <!-- top navigation -->
            <g:render template="/layouts/gentelella/topNavigation" />
            <!-- /top navigation -->

            <!-- page content -->
            <div class="right_col" role="main">
                <g:layoutBody/>
            </div>
            <!-- /page content -->

            <!-- footer content -->
            <g:render template="/layouts/gentelella/footer" />
            <!-- /footer content -->

        </div>
    </div>

</body>

<!-- Grails Assets -->
<asset:javascript src="gentelella.js" />

</html>