// This is set of JS needed for advanced form controls


//= require iCheck/icheck.js
//= require moment/moment.js
//= require bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js
//= require jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js

/**
 * Load dateTimePicker for date fields
 */
$(document).ready(function() {
    $('.datepicker').datetimepicker({
        //format: 'L',              
        format: 'DD/MM/YYYY'
    });

});