// This is a manifest file that'll be compiled into application.js.

//= require jquery/dist/jquery.min.js
//= require bootstrap/dist/js/bootstrap.min.js

//= require fastclick/lib/fastclick.js
//= require nprogress/nprogress.js
//= require iCheck/icheck.js
//= require moment/moment.js
//= require bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js
//= require jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js
//= require pnotify/dist/pnotify.js
//= require pnotify/dist/pnotify.buttons.js
//= require pnotify/dist/pnotify.nonblock.js
//= require custom.js

$(document).ready(function() {

    // prepare all datepicker fields
    $('.datepicker').datetimepicker({
        //format: 'L',              
        format: 'DD/MM/YYYY'
    });

});