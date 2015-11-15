jQuery(document).ready(function () {
    jQuery('#mycreations').hover(
        //When hovering a top-level link, submenu fadein. 
        function () {
            jQuery('.sub-menu', this).stop().fadeIn();
        },
        //When leaving the submenu, fadeout.  
        function () {
            jQuery('.sub-menu', this).stop().fadeOut();
        });
});