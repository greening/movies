/**
 * 
 */
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/movies/webapi/movies"
    }).then(function(data) {
// If we are supporting IE 8 or earlier, use this instead:   	var select_tag = 
//    		'  <select class="rating" name="rating">' +
//    		jQuery.map(["1","2","3","4","5","6","7","8","9","10"], function(v,i) {return('    <option value="' + v + '">' + v + '</option>\n'); }).join("") +
//			'  </select>\n';
    	var select_tag =
    		'  <select class="rating" name="rating">' +
    		[1,2,3,4,5,6,7,8,9,10].reduce(function(old,v) {return(old + '    <option value="' + v + '">' + v + '</option>\n')}) +
    		'  </select>\n';		
    		
    	var newHTML = jQuery.map(data.movies, function(value,index) {
    	    return('<h3>' + $(value).attr("movie_name") + '</h3>\n' +
    	    		'  <div><img src="' + $(value).attr("image_url") + '" />\n' +
    	    		select_tag +
    	    		$(value).attr("description") +  '</div>\n');
    	});
    	$(".movies").html(newHTML.join(""));
    	$( ".selector" ).accordion({
    		  collapsible: true,
    		  active: false
    		});
    	$('.rating').barrating({
            theme: 'fontawesome-stars',
            showSelectedRating: true
          });
    });
});