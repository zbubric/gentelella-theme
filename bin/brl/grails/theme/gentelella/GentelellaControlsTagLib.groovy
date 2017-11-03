package brl.grails.theme.gentelella

import groovy.xml.MarkupBuilder
import grails.core.GrailsDomainClassProperty
import org.grails.datastore.mapping.model.PersistentEntity
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.datastore.mapping.model.types.*
import grails.plugin.formfields.FormFieldsTagLib
import grails.plugin.formfields.BeanPropertyAccessor
import grails.plugin.formfields.BeanPropertyAccessorFactory



class GentelellaControlsTagLib {
    static namespace = "gent"  
    private static final MASKED_TYPES = [String, Number, URL, Date, Calendar, java.sql.Date, java.sql.Time]

    /**
      * Renders a icon within field
      *
      * @attr icon REQUIRED icon class to show
      * @attr side Left or right, default is left
      */
    def fieldIcon = { attrs -> 
        def icon = attrs.icon
        def side = attrs.side ?: 'left'

        out << "<span class='${icon} form-control-feedback ${side}' aria-hidden='true'></span>"
    }
 
    /**
      * Renders a one-to-many checkbox group
      * If dataSet is provided, group will be rendered out of it
      * If dataSet is not provided, full data set of associated class will 
      * be used
      *
      * @attr values REQUIRED
      * @attr persistentProperty 
      * @attr dataSet 
      */
    def checkBoxGroup = { attrs, body -> 
        // Data to be loaded
        def propertyName = attrs.propertyName
        def values = attrs.values
        def dataSet = attrs.dataSet
        def persistentProperty = attrs.persistentProperty
        // if dataset is not explicitelly defined - use association class
        if( !dataSet ){
            Class referencedPropertyType
            if (persistentProperty instanceof GrailsDomainClassProperty) {
                GrailsDomainClassProperty gdcp = ((GrailsDomainClassProperty) persistentProperty)
                referencedPropertyType = gdcp.referencedPropertyType
            } else if (persistentProperty instanceof Association) {
                Association prop = ((Association) persistentProperty)
                PersistentEntity entity = prop.getAssociatedEntity()
                if (entity != null) {
                    referencedPropertyType = entity.getJavaClass()
                } else if (prop.isBasic()) {
                    referencedPropertyType = ((Basic)prop).getComponentType()
                }
            }

            dataSet = referencedPropertyType?.list()
        }

        dataSet.each{ item ->
            def selected = values?.find{ it.id == item.id } ? true : false
            out << "<div class='checkbox'>"
            out << "<label>"
            out << "<input type='checkbox' class='flat' name='${propertyName}' value='${item?.id}' ${selected ? 'checked' : ''}/> ${item}"
            out << "</label>"
            out << "</div>"
        }
    } 

    /**
      * Renders a one-to-many pillbox control (requires select2 js lib)
      * If dataSet is provided, group will be rendered out of it
      * If dataSet is not provided, full data set of associated class will 
      * be used
      *
      * @attr values REQUIRED
      * @attr persistentProperty 
      * @attr dataSet 
      */
    def pillBox = { attrs, body -> 
        // Data to be loaded
        def propertyName = attrs.propertyName
        def values = attrs.values
        def dataSet = attrs.dataSet
        def persistentProperty = attrs.persistentProperty
        // if dataset is not explicitelly defined - use association class
        if( !dataSet ){
            Class referencedPropertyType
            if (persistentProperty instanceof GrailsDomainClassProperty) {
                GrailsDomainClassProperty gdcp = ((GrailsDomainClassProperty) persistentProperty)
                referencedPropertyType = gdcp.referencedPropertyType
            } else if (persistentProperty instanceof Association) {
                Association prop = ((Association) persistentProperty)
                PersistentEntity entity = prop.getAssociatedEntity()
                if (entity != null) {
                    referencedPropertyType = entity.getJavaClass()
                } else if (prop.isBasic()) {
                    referencedPropertyType = ((Basic)prop).getComponentType()
                }
            }

            dataSet = referencedPropertyType?.list()
        }

        out << select( name: propertyName,
                       from: dataSet,
                       value: values,
                       optionKey: 'id',
                       class: "form-control select2" )


    }     

}


