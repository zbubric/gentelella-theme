<g:set var="dateFormat" value="${dateFormat ?: grailsApplication.config.getProperty('gentelella.datepicker.dateFormat', " DD/MM/YYYY ")}" />
<g:textField class="form-control datepicker has-feedback-left" data-date-format="${dateFormat}" name="${property}" value="${value?.format('dd/MM/yyyy')}" />
<span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>