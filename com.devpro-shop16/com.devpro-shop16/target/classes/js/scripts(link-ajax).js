function SaveContact(baseUrl) {
	// javascript object.  data la du lieu ma day len action cua controller
	let data = {
		name: jQuery("#name").val(), // lay theo id
		email: jQuery("#email").val(), // lay theo id
	};

	// $ === jQuery
	// json == javascript object
	jQuery.ajax({
		url: baseUrl + "/ajax/contact", //->action
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),

		dataType: "json", // kieu du lieu tra ve tu controller la json
		success: function(jsonResult) {
			alert("Chuc mung! da luu thanh cong dia chi email " + jsonResult.Message.email);
		},
		error: function(jqXhr, textStatus, errorMessage) {

		}
	});
}