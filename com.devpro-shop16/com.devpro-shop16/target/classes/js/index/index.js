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
  loop:true,
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

 function loader(){
   document.querySelector('.loader-container').classList.add('fade-out');
 }

 function fadeOut(){
   setInterval(loader, 3000);
 }

 window.onload = fadeOut;
//ssesion sl cart

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
			//alert(jsonResult.data.PriceUnit);
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
} ;
$(window).scroll(function() {
   if($(window).scrollTop() + $(window).height() == $(document).height()){
       alert("bottom!");
		console.log("dscdscds");
       // getData();
   }
});	












