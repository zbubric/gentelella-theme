package brl.grails.theme.gentelella

import groovy.xml.MarkupBuilder
import grails.core.GrailsDomainClassProperty
import org.grails.datastore.mapping.model.PersistentEntity
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.datastore.mapping.model.types.*
import grails.plugin.formfields.FormFieldsTagLib
import grails.plugin.formfields.BeanPropertyAccessor
import grails.plugin.formfields.BeanPropertyAccessorFactory


class GentelellaFieldsCustomTagLib{
    static final namespace = 'f'
    private static final MASKED_TYPES = [String, Number, URL, Date, Calendar, java.sql.Date, java.sql.Time]

    @Autowired
    FormFieldsTagLib formFieldsTagLib
    BeanPropertyAccessorFactory beanPropertyAccessorFactory
    
    /**
    * Gentelella owerride of f:field tag
    * Used to inject specific paramts to widget (css classes and masks)
    *
    * TODO: Add config option to skip custom part (default behaviur)
    **/
    def field = { attrs, body ->
            
        // list of types that can apply mask
        final maskedTypes = [String, Number, URL, Date, Calendar, java.sql.Date, java.sql.Time]

        // get bean name
        def bean
        if( attrs.bean ){
            // get bean name from page scope variables (case for f:field)
            bean = pageScope.variables[attrs.bean]
        } else {
            // get bean name from bean stack (case for f:all and f:with)
            bean = formFieldsTagLib.getBeanStack().bean
        }

        // resolve property
        BeanPropertyAccessor propertyAccessor = beanPropertyAccessorFactory.accessorFor(bean, attrs.property)     

        if( propertyAccessor ){
            // field type
            def type = propertyAccessor.propertyType
            // widget class (as defined in gsp tag)
            def widgetClass = attrs.'widget-class' ?: ''

            // set base css class depending on widget type
            if( type in [boolean, Boolean] ){                
                widgetClass += "flat"
            } else {
                widgetClass += "form-control"
            }

            // set mask properties for applicable widgets
            if( attrs.mask && (type in MASKED_TYPES) ){
                // masks are not applicable for associations
                if( !propertyAccessor.persistentProperty.properties.containsKey('associatedEntity')){
                    // apend css class for masked components
                    widgetClass += " masked"  
                    // add widget mask parameter
                    attrs.'widget-data-inputmask' = "'mask' : '$attrs.mask'"
                }
            }

            // add new widget class param
            attrs.'widget-class' = widgetClass            
        }

        // formFieldsTagLib.widget.call(attrs)
        formFieldsTagLib.field.call(attrs, body)   
    }

}


