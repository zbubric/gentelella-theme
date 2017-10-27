// This is a manifest file that'll be compiled into application.js.

//= require jquery/dist/jquery.min.js
//= require bootstrap/dist/js/bootstrap.min.js
//= require fastclick/lib/fastclick.js
//= require nprogress/nprogress.js
//= require pnotify/dist/pnotify.js
//= require pnotify/dist/pnotify.buttons.js
//= require pnotify/dist/pnotify.nonblock.js
//= require iCheck/icheck.js
//= require moment/moment.js
//= require moment-jdateformatparser/moment-jdateformatparser.min
//= require bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js
//= require jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js
//= require select2/js/select2.min.js
//= require gentelellaOrigin.js

/**
 * Load dateTimePicker for date fields
 */
$(document).ready(function() {

    // Load dateTimePicker for date fields
    $('.datepicker').datetimepicker({
        //format: 'L'
    });

    // Load Select2 component for select controls
    $('.select2').select2();

    // Load input masks for all fields
    $(".masked").inputmask();

});