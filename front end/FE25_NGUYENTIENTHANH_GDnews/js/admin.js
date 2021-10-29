
$("#show_hide_sidebar").on('click', function(){
	var left_sidebar = $('.sidbar_left').css('left');
	if(left_sidebar == '0px'){
		$('.sidbar_left').css('left', '-320px');
		$('.content').css('margin-left', '0px');
	}else{
		$('.sidbar_left').css('left', '0px');
		$('.content').css('margin-left', '320px');
	}
});
function test(){

	var stt = 1;
	
	$('.info-account-content').each(function(){

		$('#'+stt).text(stt);

		stt++;
			
});
	
	return stt;
};
test();


$(document).on('click','.btn-del',function(){
	
	
	$(this).closest('.info-account-content').remove();
	

});

$(document).on('click','.btn-add',function(){
	 var count = test();

	
	// 	$('.info-account-content').each(function(){
	// 		stt++		
	// });

	$('.ds').append('<li class="list-group-item info-account-content">'
		+'<span id="'+(count)+'">'+(count)+'</span>'
		+'<span>Thanh98</span>'
		+'<span>3755142</span>'
		+'<span><input type="" name="email" value="Tienthanha4@gmail.com" disabled></span>'
		+'<span>'
		+'<button type="button" class="btn btn-secondary btn-sua">Sua</button>'
		+'<button type="button" class="btn btn-secondary ml-1 btn-del">Xoa</button>'
		+'</span>'
		+'</li>'
		);
});
$(document).on('click', '.btn-sua',function(){
	// 
	
	$(this).closest('.info-account-content').find('input[name="email"]').removeAttr('disabled');

	



});

$(document).on('click','btn-save',function(){
	
	$(this).closest('.info-account-content').find('input[name="email"]').attr('disabled','False');
})



$(document).on('keyup ',function(){
	var tieude = $('.tieude').val();
	if(tieude == ''){
		$('#re_error-1').text('Bạn chưa nhập');
	}
	else{
		$('#re_error-1').text('');	
	}
	var email = $('.email').val();
	if(email == ''){
		$('#re_error-2').text('Bạn chưa nhập');
	}
	else{
		$('#re_error-2').text('');	
	}
	var mota = $('.mota').val();
	if(mota == ''){
		$('#re_error-3').text('Bạn chưa nhập');
	}
	else{
		$('#re_error-3').text('');	
	}
	
});


$('.btn_account').on('click', function(){
	$('.info').css("display","block");
	var isClassHideInfo = $('.info').hasClass('hide_info');
	if(isClassHideInfo){
		$('.info').removeClass('hide_info');
		$('.info').css("display","block");
	}else{
		$('.info').addClass('hide_info');
		$('.info').css("display","none");	
	}
});

