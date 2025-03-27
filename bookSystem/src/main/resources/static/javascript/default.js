/**
 *  default.js
 */

$(function(){ //window.onload=function(){}
	$("#menuToggle").click(function(){ //document.getElementByClassName("menuShow")[0].addEventListener
		$(".menuShow").toggle();
		$(".menuHide").toggle();
		var left = $("#userBox").css("left");
		left = Math.abs(parseInt(left));
		console.log(left);
		$("#userBox").css("left",(left-125)+"px");

	});
});