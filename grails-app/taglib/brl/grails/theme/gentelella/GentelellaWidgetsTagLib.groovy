package brl.grails.theme.gentelella

class GentelellaWidgetsTagLib {
    static namespace = "gent"
    //static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

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

}


