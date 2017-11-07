/**
 * 
 */
/**
 * 
 */
(function (window) {
	'use strict';
	/*
	$(document).ready(function(){

	});
	*/
	function findMap() {
		var todo = $("#naver_map_address").val();
		var todoData = {};
		todoData["address"] = todo
		
		if(todo == ""){
			alert("공백 입니다!!");
		} else {
			
			$.ajax({
		        type: "GET"
		        ,url: "/map"
		        ,data: JSON.stringify(todoData)
		        ,contentType : "application/json"
		        ,success: function(data){
		        	console.log(data);
		        	$(".new-todo").val("");
		            addTodoHTML(data);      	
		        }
		        ,error : function(data, status, err) {
		        	console.log(err);
		        }
			});
			
		}
	}
	
	
})(window);
