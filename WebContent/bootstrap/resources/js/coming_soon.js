$(function(){

	/*  Initiation of Countdown (time in timestamp)  */
	$('.countdown').final_countdown({
      'start': 1362139200,
      'end': 1394662920,
      'now': 1387461319        
  });

	/*  Background slide  */
	if($('body').attr('data-page') == 'coming-soon'){
		$.backstretch([
			"../resources/images/background/05.png",
			"../resources/images/background/04.png", 
			"../resources/images/background/06.png",
			"../resources/images/background/07.png", 
			"../resources/images/background/08.png"], 
		  {
		    fade: 3000,
		    duration: 0 
		});
	}

});


