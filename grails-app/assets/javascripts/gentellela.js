// This is a manifest file that'll be compiled into application.js.

//= require vendors/jquery/dist/jquery.min.js
//= require vendors/bootstrap/dist/js/bootstrap.min.js

//= require vendors/fastclick/lib/fastclick.js
//= require vendors/nprogress/nprogress.js
//= require vendors/iCheck/icheck.js
//= require vendors/moment/moment.js
//= require vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js
//= require vendors/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js
//= require vendors/pnotify/dist/pnotify.js
//= require vendors/pnotify/dist/pnotify.buttons.js
//= require vendors/pnotify/dist/pnotify.nonblock.js
//= require custom.js

$( document ).ready(function() {

  // prepare all datepicker fields
  $('.datepicker').datetimepicker({              
              //format: 'L',              
              format: 'DD/MM/YYYY'
  });

});
