;(function ($) {
	"use strict";
	$(document).ready(function () {
		$('body').scrollspy({
			target: ".header-area",
			offset: 50
		});

		$('[data-toggle="tooltip"]').tooltip();

		$('.mainmenu').slicknav({
			label: '',
			duration: 500,
			prependTo: '',
			closedSymbol: '<i class="fa fa-angle-right"></i>',
			openedSymbol: '<i class="fa fa-angle-right"></i>',
			appendTo: '.header-area',
			menuButton: '.toggle',
			closeOnClick: 'true',
		});

		$(".toggle").on('click', function () {
			$(this).toggleClass("active");
		});


		$(".t-carousel").owlCarousel({
			loop: true,
			autoplay: true,
			smartSpeed: 1000,
			autoplayTimeout: 5000,
			dots: false,
			nav: false,
			responsive: {
				0: {
					items: 1,
				},
				600: {
					items: 2,
				},
				1000: {
					items: 3,
				},
			}
		});

		$(".t-c-4").owlCarousel({
			loop: true,
			autoplay: true,
			autoplayTimeout: 5000,
			smartSpeed: 1000,
			dots: false,
			nav: false,
			responsive: {
				0: {
					items: 1,
				},
				600: {
					items: 1,
				},
				1000: {
					items: 2,
				},
			}
		});

		$(".t-c-5").owlCarousel({
			items: 1,
			loop: true,
			autoplay: true,
			autoplayTimeout: 5000,
			smartSpeed: 1000,
			dots: true,
			nav: false,
		});

		$(".c-logo-carousel").owlCarousel({
			margin: 30,
			loop: true,
			autoplay: true,
			smartSpeed: 1000,
			autoplayTimeout: 5000,
			dots: false,
			nav: false,
			responsive: {
				0: {
					items: 1,
				},
				600: {
					items: 3,
				},
				1000: {
					items: 5,
				},
			}
		});

		$(".t6-carousel").owlCarousel({
			loop: true,
			autoplay: true,
			smartSpeed: 1000,
			autoplayTimeout: 5000,
			dots: false,
			nav: true,
			navText: ["<i class='far fa-angle-left'></i>", "<i class='far fa-angle-right'></i>", ],
			responsive: {
				0: {
					items: 1,
				},
				600: {
					items: 2,
				},
				1000: {
					items: 3,
				},
			}
		});

		$(".hero-7").owlCarousel({
			items: 1,
			loop: true,
			autoplay: false,
			autoplayTimeout: 5000,
			smartSpeed: 1000,
			dots: false,
			nav: true,
			navText: ["<i class='far fa-long-arrow-alt-left'></i>", "<i class='far fa-long-arrow-alt-right'></i>", ],
		});

		$(".t9-content").owlCarousel({
			items: 1,
			loop: true,
			autoplay: false,
			autoplayTimeout: 5000,
			smartSpeed: 1000,
			dots: false,
			nav: true,
			navText: ["<i class='far fa-long-arrow-alt-left'></i>", "<i class='far fa-long-arrow-alt-right'></i>", ],
		});

		$(".progress-slider").owlCarousel({
			loop: true,
			autoplay: false,
			autoplayTimeout: 5000,
			smartSpeed: 1000,
			dots: false,
			nav: true,
			navText: ["<i class='far fa-angle-left'></i>", "<i class='far fa-angle-right'></i>", ],
			responsive: {
				0: {
					items: 1,
				},
				600: {
					items: 2,
				},
				1000: {
					items: 4,
				},
			}
		});

		var owl = $('.nav-bar');
		$('.prevbtn').on('click', function () {
			owl.trigger('next.owl.carousel');
		})
		$('.nextbtn').on('click', function () {
			owl.trigger('prev.owl.carousel', [300]);
		})

		$('.counter-number span').counterUp({
			delay: 10,
			time: 2000
		});



		$("#mainmenu-area").sticky({
			topSpacing: 0
		});

		new WOW().init({
			mobile: false,
		});

		$(".preloader").fadeOut("slow");

	
		
		if (typeof Typed === 'function') {
			var typed = new Typed('.typing', {
				strings: ["Work Speed"],
				loop: true,
				typeSpeed: 100,
				backSpeed: 80,
			});
		}

	
		$(".single-progress").on('mouseenter', function(){
			$(".single-progress").removeClass("active");
			$(this).addClass("active");
		});


	});
})(jQuery);