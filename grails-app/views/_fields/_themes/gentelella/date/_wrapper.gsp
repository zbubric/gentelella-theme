<%@ page defaultCodec="html" %>
    <g:set var="foo" value="${new Date()}" scope="page" />
    <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="${property}">${label}
    <span class="required">*</span>
  </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
            <%= widget %>
        </div>
    </div>