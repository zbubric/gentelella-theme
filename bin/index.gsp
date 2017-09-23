<!doctype html>
<html>

<head>
    <meta name="layout" content="gentelella" />
    <title>Welcome to Grails - gentelella</title>
</head>

<body>


    <div class="row top_tiles" style="margin: 10px 0;">
        <div class="col-md-2 tile tile_stats_count">
            <span>Environment</span>
            <h2>${grails.util.Environment.current.name}</h2>
        </div>
        <div class="col-md-2 tile">
            <span>App version</span>
            <h2>
                <g:meta name="info.app.version" />
            </h2>
        </div>
        <div class="col-md-2 tile">
            <span>Grails version</span>
            <h2>${grails.util.Environment.current.grailsVersion}</h2>
        </div>
        <div class="col-md-2 tile">
            <span>Groovy version</span>
            <h2>${GroovySystem.getVersion()}</h2>
        </div>
        <div class="col-md-2 tile">
            <span>JVM version</span>
            <h2>${System.getProperty('java.version')}</h2>
        </div>
        <div class="col-md-2 tile">
            <span>Reloading active</span>
            <h2>${grails.util.Environment.reloadingAgentEnabled}</h2>
        </div>
    </div>


    <div class="row">
        <gent:infoWidget highlight="${grailsApplication.domainClasses.size()}" icon="fa fa-database" title="Domains" />
        <gent:infoWidget highlight="${grailsApplication.controllerClasses.size()}" icon="fa fa-random" title="Controllers" />
        <gent:infoWidget highlight="${grailsApplication.serviceClasses.size()}" icon="fa fa-gears" title="Services" />
        <gent:infoWidget highlight="${grailsApplication.tagLibClasses.size()}" icon="fa fa-puzzle-piece" title="Tag Libraries" />
    </div>

    <br/>

    <div class="row ">

        <div class="col-md-4 col-sm-4 col-xs-12">
            <gent:panel title="Welcome to Gentelella on Grails " class="fixed_height_390" settingsLinks="${[[title:'Title 1',href:'#'],[title:'Title 1',href:'#']]}">
                <p>
                    Congratulations, you have successfully started your first Grails application! At the moment this is the default page, feel free to modify it to either redirect to a controller or display whatever content you may choose.
                </p>
                <br/>
                <p>
                    <h2>Gentelella Admin</h2>
                    <h5><a href="https://github.com/puikinsh/gentelella">More info</a></h5>
                    Gentelella Admin is a free to use Bootstrap admin template. This template uses the default Bootstrap 3 styles along with a variety of powerful jQuery plugins and tools to create a powerful framework for creating admin panels or back-end dashboards.
                </p>

                <p>
                    <h2>Gentelella Grails Theme</h2>
                    <h5><a href="https://github.com/zbubric/gentelella-theme">More info</a></h5>
                    Gentelella Theme is Grails 3.x plugin that provided Gentelella-based skin and scaffold templates to Grails application.
                </p>

            </gent:panel>
        </div>

        <div class="col-md-4 col-sm-4 col-xs-12">
            <gent:panel title="Controllers" class="fixed_height_390" closeBtn="false">
                <p>Below is a list of controllers that are currently deployed in this application, click on each to execute its default action:</p>
                <ul class="quick-list">
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="fa fa-slider">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </gent:panel>
        </div>

        <div class="col-md-4 col-sm-4 col-xs-12">
            <gent:panel title="Plugins" class="fixed_height_390">
                <p>Grails plugins installed:</p>
                <p>
                    <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">

                        <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="top" title="" data-original-title="${plugin.version}">${plugin.name}</button>
                    </g:each>

                </p>
            </gent:panel>
        </div>

    </div>

</body>

</html>