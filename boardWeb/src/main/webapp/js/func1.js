/**
 * func1.jsp
 *  함수정의문
 */

function sum(a = 0, b = 0) {
	//if(b == undefined){
	//return a;
	//}
	return a + b;
}//end of sum()

//함수표현식
sum = function sum(a = 0, b = 0) {
	return a + b;
}

console.log('결과2: ', sum(30, 40));
let result = sum(10, 20);
result = sum(10);
console.log('결과1: ', result);


let name = "홍길동";
let age = 20;
const obj = {
	name,
	age
}

function showObj(obj = { name: '홍길순', age: 25 }) {
	return obj.name + ' - ' + obj.age;
}//end of showObj

console.log(showObj(obj));


function showItem(item) {
	let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];

	days.forEach(function(val) {
		let span = document.createElement('span');
		span.innerHTML = val + ' ';
		item.appendChild(span);
	});

	function sumAry(ary = []) {
		let sum = 0;
		for (let i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum;
	}
	result = sumAry([1, 2, 3, 4, 5]);
	console.log("결과4: ", result);
}//end of showItem()

showItem(document.getElementById('show'));

console.log(window);
