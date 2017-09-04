<%@ page defaultCodec="html" %>
<%
println bean
println property
println type
println label
println value
println constraints
println persistentProperty
println errors
println required
println invalid
println prefix
%>
<div class="form-group">
  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="${property}">${label}
    <span class="required">*</span>
  </label>
  <div class="col-md-6 col-sm-6 col-xs-12">
    <%= widget %>
  </div>
</div>
