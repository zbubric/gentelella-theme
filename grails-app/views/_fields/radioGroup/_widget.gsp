<g:radioGroup name="${property}"
              labels="${persistentProperty.type.list(it.id)}"
              values="${persistentProperty.type.list(it.naziv)}">
    <p>${it.label} ${it.radio}</p>
</g:radioGroup>


<div class="col-md-9 col-sm-9 col-xs-12">
    <div class="checkbox">
    <label>
        <div class="icheckbox_flat-green checked" style="position: relative;"><input type="checkbox" class="flat" checked="checked" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> Checked
    </label>
    </div>
</div>



