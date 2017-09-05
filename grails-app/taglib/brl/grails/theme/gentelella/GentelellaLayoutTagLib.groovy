package brl.grails.theme.gentelella

import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder

class GentelellaLayoutTagLib {
    static namespace = "gent"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    final defaultMenuConfFile = "menuConf.json"
    // Menu structure holder (to avoid parsing of file uppon each request)
    static menuData = null

    /**
      * Renders a left-side main menu
      *
      * @attr data Map defining menu structure
      * @attr confFile Path to json file containing menu structure
      * If ommited, file will be loaded from default location
      * Menu structure loading priorities:
      * 1) data attribute
      * 2) from provided file name (file must be in classpath!)
      * 3) From default menuConf file (/conf/menuConf.json)
      */
    def mainMenu = { attrs, body ->
        // get menu content
        def content = attrs.data
        def confFile = attrs.confFile ?: defaultMenuConfFile

        // if content not defined - use one from file
        if( !content ){
            // if menu content has not been loaded yet - load it
            if( !menuData ){
                // load file with menu content
                def menuContentFile = this.class.classLoader.getResource(confFile)
                // parse JSON into structure
                JsonSlurper jsonSlurper = new JsonSlurper()
                menuData = jsonSlurper.parse( menuContentFile )
            }

            // use saved menuData as content
            content = menuData
        }

        def writer = new StringWriter()
        def menu = new MarkupBuilder(writer)

        menu{
            // main menu wrapper div
            div(id:"sidebar-menu", 'class':"main_menu_side hidden-print main_menu"){

                // if content is empty - display error
                if( !content ){
                    p("ERROR: Menu structure not loaded")
                } else {
                    // start rendering menu
                    content.sections.each{ section ->
                        // section wrapper
                        div('class':"menu_section"){
                            h3 section.caption
                            ul('class':"nav side-menu"){
                                // submenu wrapper
                                section.menues.each{ menuGroup ->
                                    li{
                                        a{
                                            i('class':"fa $menuGroup.icon", '') 
                                            mkp.yield(menuGroup.caption) 
                                            span('class':"fa fa-chevron-down", '')
                                        }
                                        ul('class':"nav child_menu"){
                                            // individual item wrapper
                                            menuGroup.items.each{ item ->
                                                li{
                                                    // if direct href is not defined - create g:link
                                                    if( !item.href ){
                                                        "asdfasdf"
                                                    } else {
                                                        a(href:item.href, item.caption)
                                                    }
                                                    
                                                }
                                            }
                                        } 
                                    }                                                                
                                       
                                }                                
                            }
                        }
                    }                    

                }

            }
        }
        out << writer
    }    

    /**
      * Renders a Navigation title section
      *
      * @attr siteTitle 
      * @attr siteIcon Name of icon to be used as logo (TODO: add support for custom logo)
      * @attr homeUrl Url of home page
      */
    def navTitle = { attrs, body ->
        def siteTitle = attrs.siteTitle ?: "Gentelella Grails"
        def siteIcon = attrs.siteIcon ?: "fa-paw"
        def homeUrl = attrs.homeUrl ?: "/"

        out << "<div class='navbar nav_title' style='border: 0;'>"
        out << "   <a href='${homeUrl}' class='site_title'><i class='fa ${siteIcon}'></i> <span>${siteTitle}</span></a>"
        out << "</div>"
    }    

    /**
      * Renders a profile info section (left panel)
      *
      * @attr name Name of user (if ommited, default value will be used)
      * @attr picture Path to user profile picture (if ommited, default image will be used)
      * @attr greeting  Greeting message to be displayed (if ommited, default value will be used))
      */
    def profileInfo = { attrs, body ->
        // User name to be displayed
        def name = attrs.name ?: "User"
        // Path to user picture to be displayed
        def picture = attrs.picture ?: assetPath(src: 'unknownUser.jpg')
        // Greeting message to be displayed
        def greeting = attrs.greeting ?: "Welcome, "

        out << "<div class='profile clearfix'>"
        out << "<div class='profile_pic'>"
        out << "    <img src='${picture}' alt='...' class='img-circle profile_img'>"
        out << "</div>"
        out << "<div class='profile_info'>"
        out << "    <span>${greeting}</span>"
        out << "    <h2>${name}</h2>"
        out << "</div>"
        out << "<div class='clearfix'></div>"
        out << "</div>"
    } 

    /**
      * Renders a top-menu bar containing menu toggle button
      *
      * @attr body Content of list to be displayed
      */
    def topMenu = { attrs, body -> 
        out << "<div class='top_nav'>"
        out << "  <div class='nav_menu'>"
        out << "    <nav>"
        out << "      <div class='nav toggle'>"
        out << "        <a id='menu_toggle'><i class='fa fa-bars'></i></a>"
        out << "      </div>"
        // placeholder for submenues
        out << "      <ul class='nav navbar-nav navbar-right'>"
                            // add content from body
                            out << body()
        out << "      </ul>"
        out << "    </nav>"
        out << "  </div>"
        out << "</div>"        

    }

    /**
      * Renders a top-menu item with list of links
      *
      * @attr title REQUIRED Title of menu to be displayed
      * @attr picture Path to picture to be displayed (e.g. profile picture)
      * @attr body Content of list to be displayed in <li> format (do not use <ul> tag)
      */
    def topMenuDropdown = { attrs, body -> 
        // Menu title
        def title = attrs.title ?: "Menu"
        // Path to picture to be displayed
        def picture = attrs.picture ?: assetPath(src: 'unknownUser.jpg')        

        out << "<li class=''>"
        out << "    <a href='javascript:;' class='user-profile dropdown-toggle' data-toggle='dropdown' aria-expanded='false'>"
        out << "        <img src='${picture}' alt=''>${title}"
        out << "        <span class=' fa fa-angle-down'></span>"
        out << "    </a>"
        out << "    <ul class='dropdown-menu dropdown-usermenu pull-right'>"
        
        // add content from body
        out << body()

        out << "    </ul>"
        out << "</li>"    
    }

    /**
      * Renders a top-menu 'presentation' type item 
      *
      * @attr icon REQUIRED Name of icon to be displayed
      * @attr badge Name of badge to be displayed on top of icon
      * @attr body Content of list to be displayed in <li> format (do not use <ul> tag)
      */
    def topMenuPresentation = { attrs, body -> 
        // Icon name
        def icon = attrs.icon ?: "fa-list"
        // badge name
        def badge = attrs.badge
        // badge value
        def badgeValue = attrs.badgeValue       

        out << "<li role='presentation' class='dropdown'>"
        out << "    <a href='javascript:;' class='dropdown-toggle info-number' data-toggle='dropdown' aria-expanded='false'>"
        out << "    <i class='fa ${icon}'></i>"
        if( badge ){
        out << "    <span class='badge ${badge}'>${badgeValue}</span>"
        }        
        out << "    </a>"
        // dropdown panel
        out << "<ul id='menu1' class='dropdown-menu list-unstyled msg_list' role='menu'>"
        // add content from body
        out << body()        
        out << "</ul>"
        out << "</li>"  
    }    


}
