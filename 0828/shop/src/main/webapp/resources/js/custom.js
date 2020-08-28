(function($) {
//	Channel Plugin Scripts
  (function() {
    var w = window;
    if (w.ChannelIO) {
      return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
    }
    var d = window.document;
    var ch = function() {
      ch.c(arguments);
    };
    ch.q = [];
    ch.c = function(args) {
      ch.q.push(args);
    };
    w.ChannelIO = ch;
    function l() {
      if (w.ChannelIOInitialized) {
        return;
      }
      w.ChannelIOInitialized = true;
      var s = document.createElement('script');
      s.type = 'text/javascript';
      s.async = true;
      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
      s.charset = 'UTF-8';
      var x = document.getElementsByTagName('script')[0];
      x.parentNode.insertBefore(s, x);
    }
    if (document.readyState === 'complete') {
      l();
    } else if (window.attachEvent) {
      window.attachEvent('onload', l);
    } else {
      window.addEventListener('DOMContentLoaded', l, false);
      window.addEventListener('load', l, false);
    }
  })();
  ChannelIO('boot', {
    "pluginKey": "a5066842-47e9-4b53-adf5-dd14de00dead"
  });
// End Channel Plugin
    "use strict";
	
	/* ..............................................
	   Loader 
	   ................................................. */
	$(window).on('load', function() {
		$('.preloader').fadeOut();
		$('#preloader').delay(550).fadeOut('slow');
		$('body').delay(450).css({
			'overflow': 'visible'
		});
	});

	/* ..............................................
	   Fixed Menu
	   ................................................. */

	$(window).on('scroll', function() {
		if ($(window).scrollTop() > 50) {
			$('.main-header').addClass('fixed-menu');
		} else {
			$('.main-header').removeClass('fixed-menu');
		}
	});

	/* ..............................................
	   Gallery
	   ................................................. */

	$('#slides-shop').superslides({
		inherit_width_from: '.cover-slides',
		inherit_height_from: '.cover-slides',
		play: 5000,
		animation: 'fade',
	});

	$(".cover-slides ul li").append("<div class='overlay-background'></div>");

	/* ..............................................
	   Map Full
	   ................................................. */

	$(document).ready(function() {
		$(window).on('scroll', function() {
			if ($(this).scrollTop() > 100) {
				$('#back-to-top').fadeIn();
			} else {
				$('#back-to-top').fadeOut();
			}
		});
		$('#back-to-top').click(function() {
			$("html, body").animate({
				scrollTop: 0
			}, 600);
			return false;
		});
	});

	/* ..............................................
	   Special Menu
	   ................................................. */

	var Container = $('.container');
	Container.imagesLoaded(function() {
		var portfolio = $('.special-menu');
		portfolio.on('click', 'button', function() {
			$(this).addClass('active').siblings().removeClass('active');
			var filterValue = $(this).attr('data-filter');
			$grid.isotope({
				filter: filterValue
			});
		});
		var $grid = $('.special-list').isotope({
			itemSelector: '.special-grid'
		});
	});

	/* ..............................................
	   BaguetteBox
	   ................................................. */

	baguetteBox.run('.tz-gallery', {
		animation: 'fadeIn',
		noScrollbars: true
	});

	/* ..............................................
	   Offer Box
	   ................................................. */

	$('.offer-box').inewsticker({
		speed: 3000,
		effect: 'fade',
		dir: 'ltr',
		font_size: 13,
		color: '#ffffff',
		font_family: 'Montserrat, sans-serif',
		delay_after: 1000
	});

	/* ..............................................
	   Tooltip
	   ................................................. */

	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});

	/* ..............................................
	   Owl Carousel Instagram Feed
	   ................................................. */

	$('.main-instagram').owlCarousel({
		loop: true,
		margin: 0,
		dots: false,
		autoplay: true,
		autoplayTimeout: 3000,
		autoplayHoverPause: true,
		navText: ["<i class='fas fa-arrow-left'></i>", "<i class='fas fa-arrow-right'></i>"],
		responsive: {
			0: {
				items: 2,
				nav: true
			},
			600: {
				items: 3,
				nav: true
			},
			1000: {
				items: 5,
				nav: true,
				loop: true
			}
		}
	});

	/* ..............................................
	   Featured Products
	   ................................................. */

	$('.featured-products-box').owlCarousel({
		loop: true,
		margin: 15,
		dots: false,
		autoplay: true,
		autoplayTimeout: 3000,
		autoplayHoverPause: true,
		navText: ["<i class='fas fa-arrow-left'></i>", "<i class='fas fa-arrow-right'></i>"],
		responsive: {
			0: {
				items: 1,
				nav: true
			},
			600: {
				items: 3,
				nav: true
			},
			1000: {
				items: 4,
				nav: true,
				loop: true
			}
		}
	});

	/* ..............................................
	   Scroll
	   ................................................. */

	$(document).ready(function() {
		$(window).on('scroll', function() {
			if ($(this).scrollTop() > 100) {
				$('#back-to-top').fadeIn();
			} else {
				$('#back-to-top').fadeOut();
			}
		});
		$('#back-to-top').click(function() {
			$("html, body").animate({
				scrollTop: 0
			}, 600);
			return false;
		});
	});


	/* ..............................................
	   Slider Range
	   ................................................. */

	$(function() {
		$("#slider-range").slider({
			range: true,
			min: 0,
			max: 4000,
			values: [1000, 3000],
			slide: function(event, ui) {
				$("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
			}
		});
		$("#amount").val("$" + $("#slider-range").slider("values", 0) +
			" - $" + $("#slider-range").slider("values", 1));
	});

	/* ..............................................
	   NiceScroll
	   ................................................. */

	$(".brand-box").niceScroll({
		cursorcolor: "#9b9b9c",
	});
	
	
}(jQuery));