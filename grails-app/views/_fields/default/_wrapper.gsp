<%
// default css class to use
def widgetClazz
// mask to use
def widgetMask
// field icon (a.k.a. feedback icon) content
def fieldIconArea 
// list of types that can apply mask
def maskedTypes = [String, Number, URL, Date, Calendar, java.sql.Date, java.sql.Time]

// set base class depending on widget type
if( type in [boolean, Boolean] ){
    // radio and checkboxes does not implement form-control
    widgetClazz = "flat"
} else {
    widgetClazz = "form-control"
}

// set mask properties for applicable widgets
if( 
    ( type in maskedTypes ) && 
    ( pageScope.variables.attrs.containsKey('mask') ) &&
    ( !persistentProperty.properties.containsKey('associatedEntity') ) // not applicable to associations
  ){
    widgetMask = "'mask' : '$mask'"    
}

// create "field icon area"
if( fieldIcon ){
    fieldIconArea = "<span class='${fieldIcon} form-control-feedback ${fieldIconSide=='right'? 'right': 'left'}' aria-hidden='true'></span>"
}



%>
    <div class="item form-group ${invalid ? 'bad' : ''}">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="${property}">${label}
        <span class="required">*</span>
    </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
            <f:widget bean="${bean}" property="${property}" widget="${widgetFolder}" class="${widgetClazz}" data-inputmask="${widgetMask}" />
        </div>
        ${raw(fieldIconArea)}
        <g:if test="${invalid}">
            <div class="alert">${errors.join('<br>')}</div>
        </g:if>
    </div>