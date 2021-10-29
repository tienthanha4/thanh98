function showPage() {

	document.getElementById("loader").style.display = "none";
	document.getElementById("all-1").style.display = "block";
	document.getElementById("all-2").style.display = "block";
	document.getElementById("all-3").style.display = "block";
	document.getElementById("all-4").style.display = "block";
}
function myFunction() {

	document.getElementById("all-1").style.display = "none";
	document.getElementById("all-2").style.display = "none";
	document.getElementById("all-3").style.display = "none";
	document.getElementById("all-4").style.display = "none";
	document.getElementById("loader").style.display = "block";
	myVar = setTimeout(showPage, 3000);


}


function ls(baseUrl, productId, quanlity) {
	// javascript object.  data la du lieu ma day len action cua controller

	let data = {
		productId: productId, // lay theo id
		quanlity: quanlity, // lay theo id
	};

	// $ === jQuery
	// json == javascript object

	jQuery.ajax({
		url: baseUrl + "/ajax/ls", //->action
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json", // kieu du lieu tra ve tu controller la json
		success: function(jsonResult) {
			$("#soluong").html(jsonResult.totalItems);
			$("#demo").html(jsonResult.data.productId);
			/*$([document.documentElement, document.body]).animate({
				scrollTop: $("#scroll").offset().top
			}, 2000);*/
			 $("html, body").animate({ scrollTop: 0 }, "slow");

		},
		error: function(jqXhr, textStatus, errorMessage) {

		}
	});
}






