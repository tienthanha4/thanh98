let menu = document.querySelector('#menu-bars');
let navbar = document.querySelector('.navbar');

menu.onclick = () =>{
  menu.classList.toggle('fa-times');
  navbar.classList.toggle('active');
}

let section = document.querySelectorAll('section');
let navLinks = document.querySelectorAll('header .navbar a');

window.onscroll = () =>{

  menu.classList.remove('fa-times');
  navbar.classList.remove('active');

  section.forEach(sec =>{

    let top = window.scrollY;
    let height = sec.offsetHeight;
    let offset = sec.offsetTop - 150;
    let id = sec.getAttribute('id');

    if(top >= offset && top < offset + height){
      navLinks.forEach(links =>{
        links.classList.remove('active');
        document.querySelector('header .navbar a[href*='+id+']').classList.add('active');
      });
    };

  });

}

document.querySelector('#search-icon').onclick = () =>{
  document.querySelector('#search-form').classList.toggle('active');
}

document.querySelector('#close').onclick = () =>{
  document.querySelector('#search-form').classList.remove('active');
}

var swiper = new Swiper(".home-slider", {
  spaceBetween: 30,
  centeredSlides: true,
  autoplay: {
    delay: 7500,
    disableOnInteraction: false,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  loop:true,
});

var swiper = new Swiper(".review-slider", {
  spaceBetween: 20,
  centeredSlides: true,
  autoplay: {
    delay: 7500,
    disableOnInteraction: false,
  },
  loop:true,
  breakpoints: {
    0: {
        slidesPerView: 1,
    },
    640: {
      slidesPerView: 2,
    },
    768: {
      slidesPerView: 2,
    },
    1024: {
      slidesPerView: 3,
    },
  },
});

// function loader(){
//   document.querySelector('.loader-container').classList.add('fade-out');
// }

// function fadeOut(){
//   setInterval(loader, 3000);
// }

// window.onload = fadeOut;



function deleteSessionCart(baseUrl, productId) {
	// javascript object.  data la du lieu ma day len action cua controller
	alert(productId);

	let data = {
		productId: productId, // lay theo id
		
	};

	// $ === jQuery
	// json == javascript object

	jQuery.ajax({
		url: baseUrl + "/home/shopcart/ajax/delete", //->action
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json", // kieu du lieu tra ve tu controller la json
		success: function(jsonResult) {
			alert("xoa thanh cong"+jsonResult.id);
			location.reload();
		
			/*$("tr").remove("#id"+jsonResult.id);*/
			/*$("#soluong").html(jsonResult.totalItems);
			$("#demo").html(jsonResult.data.productId);*/
			/*$([document.documentElement, document.body]).animate({
				scrollTop: $("#scroll").offset().top
			}, 2000);*/
			 $("html, body").animate({ scrollTop: 0 }, "slow");

		},
		error: function(jqXhr, textStatus, errorMessage) {

		}
	});
} ;

function test() {
	alert(dscds);
 
	let data = {
		productId: Jquery("#productId").val(), // lay theo id
		quanlity:Jquery("#quanlity").val(),
	};

	// $ === jQuery
	// json == javascript object

	jQuery.ajax({
		url: "${base}/ajax/tt", //->action
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json", // kieu du lieu tra ve tu controller la json
		success: function(jsonResult) {
			alert("xoa thanh cong"+jsonResult.toltal);
			
		
			/*$("tr").remove("#id"+jsonResult.id);*/
			/*$("#soluong").html(jsonResult.totalItems);
			$("#demo").html(jsonResult.data.productId);*/
			/*$([document.documentElement, document.body]).animate({
				scrollTop: $("#scroll").offset().top
			}, 2000);*/
			 $("html, body").animate({ scrollTop: 0 }, "slow");

		},
		error: function(jqXhr, textStatus, errorMessage) {

		}
	});










