<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <!-- Grails Assets -->
    <asset:stylesheet src="gentelella.css" />
    <g:layoutHead/>

</head>

<body class="nav-md">
    <div class="container body">
        <div class="main_container">
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                    <!-- Nav title section -->
                    <gent:navTitle />

                    <div class="clearfix"></div>

                    <!-- menu profile quick info -->
                    <gent:profileInfo name="John Doe" greeting="Howdy, " />
                    <!-- /menu profile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <gent:mainMenu />
                    <!-- /sidebar menu -->

                    <!-- /menu footer area with buttons -->
                    <div class="sidebar-footer hidden-small">
                        <gent:tooltipLink title="Settings" icon="glyphicon glyphicon-cog" />
                        <gent:tooltipLink title="FullScreen" icon="glyphicon glyphicon-fullscreen" />
                        <gent:tooltipLink title="Lock" icon="glyphicon glyphicon-eye-close" />
                        <gent:tooltipLink title="Logout" icon="glyphicon glyphicon-off" />
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>

            <!-- top navigation -->
            <gent:topMenu>
                <!-- dropDown menu -->
                <gent:topMenuDropdown>
                    <li><a href="#">Profile</a></li>
                    <li><a href="#">Settings</a></li>
                    <li><a href="#">Help</a></li>
                    <li><a href="#"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                </gent:topMenuDropdown>

                <gent:topMenuPresentation icon="fa-envelope-o" badge="bg-green" badgeValue="10">
                    <gent:msgList>
                        <gent:msgListItem caption="John Doe" sideCaption="3 minutes ago">This is message 1</gent:msgListItem>
                        <gent:msgListItem caption="Zoran Doe" sideCaption="3 minutes ago">This is message 2</gent:msgListItem>
                        <gent:msgListItem caption="Zoran Doe" sideCaption="3 minutes ago">This is message 3</gent:msgListItem>
                    </gent:msgList>

                </gent:topMenuPresentation>

            </gent:topMenu>
            <!-- /top navigation -->

            <!-- page content -->
            <div class="right_col" role="main">
                <g:layoutBody/>
            </div>
            <!-- /page content -->

            <!-- Footer area-->
            <footer>
                <div class="pull-right">
                    Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer area -->

        </div>
    </div>

</body>

<!-- Grails Assets -->
<asset:javascript src="gentelella.js" />

</html>