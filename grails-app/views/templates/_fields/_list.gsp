<g:form class="form-horizontal form-label-left">
<g:each in="${domainClass.persistentProperties}" var="p">
    <div class="form-group">
      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="${property}">
        <g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}"/>:
      </label>
      <div class="col-md-6 col-sm-6 col-xs-12">
        <div class="form-control"> 
            ${body(p)}
        </div>        
      </div>
    </div>
</g:each>
</g:form>