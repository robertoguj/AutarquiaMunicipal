$(function() {

	if ($('body').attr('data-page') == 'login'
			|| $('body').attr('data-page') == 'signup'
			|| $('body').attr('data-page') == 'password') {

		/* For icon rotation on input box foxus */
		$('.input-field').focus(function() {
			$('.page-icon img').addClass('rotate-icon');
		});

		/* For icon rotation on input box blur */
		$('.input-field').blur(function() {
			$('.page-icon img').removeClass('rotate-icon');
		});
	}
	;

	/* Background slide for lockscreen page */
	if ($('body').attr('data-page') == 'lockscreen') {
		$.backstretch([ "../resources/images/background/01.png",
				"../resources/images/background/02.png", "../resources/images/background/03.png",
				"../resources/images/background/04.png", "../resources/images/background/05.png",
				"../resources/images/background/06.png", "../resources/images/background/07.png",
				"../resources/images/background/08.png", "../resources/images/background/09.png" ],
				{
					fade : 600,
					duration : 4000
				});
	}

	/* Background slide for lockscreen page */
	if ($('body').attr('data-page') == 'login'
			|| $('body').attr('data-page') == 'signup') {
		$('#submit-form')
				.click(
						function(e) {
							e.preventDefault();
							var l = Ladda.create(this);
							l.start();
							setTimeout(
									function() {
										window.location.href = "${ctx}/bootstrap/pages/index.jsf";
									}, 2000);

						});
	}

});
