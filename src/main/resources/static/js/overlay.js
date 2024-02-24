(function() {

// Localize jQuery variable
var jQuery;

/******** Load jQuery if not present *********/
/*  Removed Version check  || window.jQuery.fn.jquery !== '1.9.2' */
if (window.jQuery === undefined) {
    var script_tag = document.createElement('script');
    script_tag.setAttribute("type","text/javascript");
    script_tag.setAttribute("src",
        "https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js");
    if (script_tag.readyState) {
      script_tag.onreadystatechange = function () { // For old versions of IE
          if (this.readyState == 'complete' || this.readyState == 'loaded') {
              scriptLoadHandler();
          }
      };
    } else {
      script_tag.onload = scriptLoadHandler;
    }
    // Try to find the head, otherwise default to the documentElement
    (document.getElementsByTagName("head")[0] || document.documentElement).appendChild(script_tag);
} else {
    // The jQuery version on the window is the one we want to use
    jQuery = window.jQuery;
    main();
}

/******** Called once jQuery has loaded ******/
function scriptLoadHandler() {
    // Restore $ and window.jQuery to their previous values and store the
    // new jQuery in our local jQuery variable
    jQuery = window.jQuery.noConflict(true);
    // Call our main function
    main();
}

/******** Our main function ********/
function main() {
    jQuery(document).ready(function($) {
        var htmldata = '<style>.twoyears-main-content{height:800px;width:1000px;margin:0 auto}.twoyears-overlay-bg{display:none;position:absolute ;top:1;left:500;height:100%;width:100%;cursor:pointer;z-index:1000;background:#000;background:rgba(0,0,0,.75)}.twoyears-overlay-content{display:none;background:#000;width:40%;position:absolute;top:10%;left:60%;margin:0 0 0 -5%;cursor:default;z-index:10001;border-radius:4px;box-shadow:0 0 5px rgba(0,0,0,.9)}.twoyears-close-btn{background:#000;border-radius:50%;color:#fff;cursor:pointer;font:700 20px/40px verdana;height:40px;position:absolute;right:-17px;text-align:center;top:-12px;width:40px;z-index:999}a.twoyears-close-btn{text-decoration:none}@media only screen and (min-width:0px) and (max-width:480px){.twoyears-overlay-content{width:96%;margin:0 2%;left:0}}</style><div class="twoyears-overlay-bg"></div><div class="twoyears-overlay-content twoyears-popup3"><a href="#" class="twoyears-close-btn"> X </a><a href="https://mofapp.nic.in/budgetmicrosite/index.html" target="blank">\n\
<img width="100%" src="https:///www.mygov.in/overlay/overlay.png" /></a></div>';
        /******* Load HTML *******/
        $('body').append(htmldata);

        // function to show our popups
        function showPopup(whichpopup){
            var docHeight = $(document).height(); //grab the height of the page
            var scrollTop = $(window).scrollTop(); //grab the px value from the top of the page to where you're scrolling
            $('.twoyears-overlay-bg').show().css({'height' : docHeight}); //display your popup background and set height to the page height
            $('.twoyears-popup'+whichpopup).show().css({'top': scrollTop+20+'px'}); //show the appropriate popup and set the content 20px from the window top
        }

        // function to close our popups
        function closePopup(){
            $('.twoyears-overlay-bg, .twoyears-overlay-content').hide(); //hide the overlay
        }

        // timer if we want to show a popup after a few seconds.
        //get rid of this if you don't want a popup to show up automatically
        setTimeout(function() {
            // Show popup3 after 2 seconds
            showPopup(3);
        }, 2000);


        // hide popup when user clicks on close button or if user clicks anywhere outside the container
        $('.twoyears-close-btn, .twoyears-overlay-bg').click(function(){
            closePopup();
        });

        // hide the popup when user presses the esc key
        $(document).keyup(function(e) {
            if (e.keyCode == 27) { // if user presses esc key
                closePopup();
            }
        });
    });
}

})(); // We call our anonymous function immediately