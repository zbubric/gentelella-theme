package brl.grails.theme.gentelella

import groovy.xml.MarkupBuilder

class GentelellaWidgetsTagLib {
    static namespace = "gent"
    //static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]


    /**
      * Renders a Panel element as a content placeholder
      *
      * @attr title REQUIRED Title of panel
      * @attr closeBtn Show close button (default: true)
      * @attr minBtn Show min button (default: true)
      * @attr settingsLinks List of links to be displayed
      * within setting area. If empty, settings area will not be shown
      * List format: [title:'Title 1',href:'#'],[title:'Title 1',href:'#']]
      */
    def panel = { attrs, body -> 
        def title = attrs.title
        def closeBtn = attrs.closeBtn ? attrs.closeBtn.toBoolean() : true
        def minBtn = attrs.minBtn ? attrs.minBtn.toBoolean() : true
        def settingsLinks = attrs.settingsLinks

        def writer = new StringWriter()
        def uiPanel = new MarkupBuilder(writer)

        uiPanel.div('class':"x_panel " + attrs.class){

                div('class':"x_title"){  
                    h2(title)
                    // button panel
                    ul('class':"nav navbar-right panel_toolbox"){
                        // collapse btn
                        if(minBtn){                            
                            li{
                                a('class':'collapse-link'){
                                    i('class':'fa fa-chevron-down','')
                                }
                            }
                        }
                        
                        if( settingsLinks && (settingsLinks instanceof Collection)){
                            li('class':'dropdown'){
                                a(href:'#', 'class':'dropdown-toggle', 'data-toggle':'dropdown', 'role':'button', 'aria-expanded':'false'){
                                    i('class':'fa fa-wrench','')
                                }
                                ul('class':'dropdown-menu', 'role':'menu'){
                                    settingsLinks.each{ item ->
                                        li{
                                            a(href:item.href, item.title)
                                        }
                                    }
                                }
                            }
                        }

                        // close btn
                        if(closeBtn){                            
                            li{
                                a('class':'close-link'){
                                    i('class':'fa fa-close','')
                                }
                            }                              
                        }
                    }
                    div('class':'clearfix','')
                }
                
                div('class':'x_content'){
                    mkp.yieldUnescaped( body() )
                }                                    
            }   
         
        out << writer
    } 

    /**
      * Renders (and use jscript to trigger it) a pNotify notification 
      *
      * @attr type Type of notification pop-up (notice, info, success, error)
      * @attr title Title of notification pop-up
      * @attr body content of notification
      */ 
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

    /**
      * Renders a 'inbox-style' message list 
      *
      * @attr body Content of list to be displayed in <li> format (do not use <ul> tag)
      */
    def msgList = { attrs, body -> 
        out << "<ul class='list-unstyled msg_list'>"
        // add content from body
        out << body()      
        out << "</ul>"
    } 

    /**
      * Renders a 'inbox-style' message list item
      *
      * @attr caption Caption of the message (e.g. sender name)
      * @attr image Path to image to be displayed with the message (e.g. sender picture)
      * @attr sideCaption Side caption to be displayed on right side of header
      * @attr href Href to follow when item is clicked
      * @attr body Content of message to be displayed
      */
    def msgListItem = { attrs, body -> 
        // Data to be loaded
        def caption = attrs.caption
        def image   = attrs.image
        def sideCaption   = attrs.sideCaption
        def href   = attrs.href ?: "#"
        
        out << "<li>"
        out << "    <a href='${href}'>"
        // show image if it is defined
        if( image ){
            out << "    <span class='image'><img src='${image}' alt='img'></span>"
        }
        out << "    <span>"
        // show caption if it is defined
        if( caption ){
            out << "        <span>${caption}</span>"
        }        
        // show sideCaption if it is defined
        if( sideCaption ){
            out << "        <span class='time'>${sideCaption}</span>"
        }                
        out << "    </span>"
        // show actual message
        out << "    <span class='message'>"
        out << body()
        out << "    </span>"
        out << "    </a>"
        out << "</li>"
    }

    /**
      * Renders a link icon with tooltip 
      *
      * @attr title REQUIRED Tooltip title
      * @attr iconClass REQUIRED Icon class including icon set name (fa or glyphicon)
      * @attr href Link address
      */
    def tooltipLink = { attrs, body -> 
        def title = attrs.title
        def iconClass = attrs.icon
        def href   = attrs.href ?: "#"

        out << "<a href='${href}' data-toggle='tooltip' data-placement='top' title='${title}'>"
        out << "    <span class='${iconClass}' aria-hidden='true'></span>"
        out << "</a>"
    }    

    /**
      * Renders a information panel (can be used for showing numbers and trends)
      *
      * @attr highlight REQUIRED Highlighted information (usually number)
      * @attr icon Icon class to be displayed
      * @attr title REQUIRED Title area text
      * @attr subtitle REQUIRED Subtitle area text
      */
    def infoWidget = { attrs, body ->
        def highlight = attrs.highlight
        def icon = attrs.icon
        def title = attrs.title ?: ""
        def subtitle = attrs.subtitle ?: "" 
        // if css class is not defined, use default ones (sizing)
        def cssClass = attrs.class ?: "col-lg-3 col-md-3 col-sm-6 col-xs-12"        

        out << "<div class='animated flipInY ${cssClass}'>"
        out << "    <div class='tile-stats'>"
        if( icon ){
        out << "        <div class='icon'><i class='${icon}'></i>"
        }
        out << "        </div>"
        out << "        <div class='count'>${highlight}</div>"
        out << "        <h3>${title}</h3>"
        out << "        <p>${subtitle}</p>"
        out << "    </div>"
        out << "</div>"
    }

    /**
      * Renders a tally widget
      *
      * @attr title REQUIRED Title area text
      * @attr ribbon Ribbon (highlighted) area text
      */
    def tallyWidget = { attrs, body ->
        def title = attrs.title ?: ""
        def ribbon = attrs.ribbon
        // if css class is not defined, use default ones (sizing)
        def cssClass = attrs.class ?: "col-md-3 col-xs-12"

        out << "<div class='widget widget_tally_box ${cssClass}'>"
        out << "    <div class='x_panel ui-ribbon-container fixed_height_390'>"
        if( ribbon ){
            out << "    <div class='ui-ribbon-wrapper'>"
            out << "        <div class='ui-ribbon'>"
            out << "        ${ribbon}"
            out << "        </div>"
            out << "    </div>"
        }

        out << "    <div class='x_title'>"
        out << "        <h2>${title}</h2>"
        out << "        <div class='clearfix'></div>"
        out << "    </div>"
        out << "    <div class='x_content'>"
        out << body()
        out << "    </div>"
        out << "    </div>"
        out << "</div>"
    }

}


