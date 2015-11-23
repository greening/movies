/**
 * 
 */
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/movies/webapi/movies"
    }).then(function(data) {
    	var newHTML = jQuery.map(data.movies, function(value,index) {
    	    return('<h3>' + $(value).attr("movie_name") + '</h3>\n' +
    	    		'  <div><img src="' + $(value).attr("image_url") + '" height="180px" width="auto" style="float: left; padding-right: 20px; vertical-align: text-top;"" />\n' +
    	    		'  <select class="rating" name="rating" style="display: block;">' +
											'    <option value="1">1</option>\n' +
											'    <option value="2">2</option>\n' +
											'    <option value="3">3</option>\n' +
											'    <option value="4">4</option>\n' +
											'    <option value="5">5</option>\n' +
											'    <option value="6">6</option>\n' +
											'    <option value="7">7</option>\n' +
											'    <option value="8">8</option>\n' +
											'    <option value="9">9</option>\n' +
											'    <option value="10">10</option>\n' +
										'  </select>\n' +
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
       debugger;
    });
});