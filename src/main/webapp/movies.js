/**
 * 
 */
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/movies/webapi/movies"
    }).then(function(data) {
    	var select_tag = 
    		'  <select class="rating" name="rating">' +
    		jQuery.map(["1","2","3","4","5","6","7","8","9","10"], function(v,i) {return('    <option value="' + v + '">' + v + '</option>\n'); }).join("") +
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