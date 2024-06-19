/**
 * ajax.js
 * 비동기 처리
 */

 setTimeout(function(){
	console.log("1번");
 }, 1000) //마지막에 지연시간 1초있다가 하겠다
 
  setTimeout(function(){
	console.log("2번");
 }, 1000)
 
  setTimeout(function(){
	console.log("3번");
 }, 1000)
 
 console.log("end");