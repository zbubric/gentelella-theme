package gentelella.theme

class GentelellaTagLib {
    static namespace = "gent"
    // static defaultEncodeAs = [taglib:'text']
    // static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    
    def popOver = { attrs, body -> 
        // type of alert
        def type = attrs.type ?: "info"
        // close button available
        boolean dismisable = attrs.dismisable ?: true

        def cssClass = "alert alert-${type} fade in"

        // add dismisable class if needed
        if( dismisable ){
            cssClass += " alert-dismisible"
        }

        // printout tag
        out << "<div class=\"${cssClass}\" role=\"alert\">"

        // if it is dismissable - enable close button
        if( dismisable ){
            out << "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">"
            out << "<span aria-hidden=\"true\">×</span>"
            out << "</button>"            
        }

        // printout body
        out << body()

        // close tag
        out << "</div>"
    }

    // data structure holder
    static menuData = null

    /* Tag for displaying profile info */
    def menu = { attrs, body ->
        // get menu content
        def content = attrs.data

        // if content not defined - use one from file
        if( !content ){
            // if menu content has not been loaded yet - load it
            if( !menuData ){
                // load file with menu content
                // TODO: enable configurable manu file location
                def menuContentFile = this.class.classLoader.getResource('menu_structure.json')
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


    /* Tag for displaying profile info */ 
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
    

    /* Taglib for diyplaying pNotify notifications */    
    def pnotify = { attrs, body -> 
        // type of notification
        def type = attrs.type ?: "info"
        // title
        def title = attrs.title ?: "Notification"
        // content: remove newlines because pNotify can not work with them
        def content = body().replaceAll("\n", "")

        def jsCall = """
            \$(function(){
                new PNotify({
                            title: '${title}',
                            text: '${content}',
                            type: '${type}',
                            styling: 'bootstrap3'
                        });
            });        
        """

        // open javascript block
        out << "<script type=\"text/javascript\">"

        // trigger notification
        out << jsCall

        // close javascript block
        out << "</script>"
    }   
}
