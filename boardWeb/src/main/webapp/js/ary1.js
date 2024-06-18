/**
 * ary1.jsp 
 * forEach, filter, map, reduce
 */

const numAry = [23, 17, 5, 41, 30, 12];
let result = 0;

let evenSum = function(elem, idx, ary){
	
	if(elem %2 == 0){
		result +=elem;
		}
	};

let oddSum = function(elem, idx, ary){
	console.log(elem,idx,ary);
	if(idx %2 == 0){
		result +=elem;
		}
	};
	
//35보다 작은 값들의 합을 저장
let less35 = function(elem, idx, ary){
		if(elem < 35){
			result += elem;
		}
}

numAry.forEach(evenSum);//매개값으로 함수가 들어옴
console.log('작수합은 ', result);

numAry.forEach(oddSum);//매개값으로 함수가 들어옴
console.log('홀수번째 값의 합은 ', result);

numAry.forEach(less35);//매개값으로 함수가 들어옴
console.log('35보다 작은 값들의 합 ', result);

const dupAry = [10, 27, 32, 55, 27, 10];
const ary = [];// indexㅒf 사용

//중복된 값은 제거하고 새로운 ary배열에 담기
dupAry.forEach(function(elem){
	if(ary.indexOf(elem) == -1){
		ary.push(elem);
	}
});
console.log(ary);


