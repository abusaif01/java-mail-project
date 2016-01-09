// JavaScript Document
	$(document).ready(function() {
		// get current rating
		getRating();
		// get rating function
		function getRating(){
		var tutorialid = $("input[name='tutorialid']").attr("value"); 


			$.ajax({
				type: "GET",
				url: "/d1/rating/update.php",
				data: "do=getrate&tutorialid="+tutorialid,
				cache: false,
				async: false,
				cacheResponse: false,
				success: function(result) {
					// apply star rating to element
					$("#current-rating").css({ width: "" + result + "%" });
				},
				error: function(result) {
					alert("some error occured, please try again later");
				}
			});
		}
		
		// link handler
		$('#ratelinks li a').click(function(){
			var tutorialid = $("input[name='tutorialid']").attr("value"); 
			$.ajax({
				type: "GET",
				url: "/d1/rating/update.php",
				data: "rating="+$(this).text()+"&do=rate&tutorialid="+tutorialid,
				cache: false,
				async: false,
				success: function(result) {
					// remove #ratelinks element to prevent another rate
					$("#ratelinks").remove();
					// get rating after click
					getRating();
				},
				error: function(result) {
					alert("some error occured, please try again later");
				}
			});
			
		});
	});

