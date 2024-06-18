/**
 * ary2.jsp
 * 
 */
//console.log(employees);

let result = [23, 54, 22, 39, 10, 56].filter(function(item, idx, ary) {
	if (item % 2 == 0) {
		return false;//이렇게 하면 홀수만 반환
	}
	return true;
});
console.log(result);

//employees.forEach(console.log);

//급여가 5000이 넘는 여자만 필터링.
let over5000 = [];
let over5000Sum = 0;
let filterFnc = emp => emp.gender == 'Female' && emp.salary > 5000
over5000 = employees.filter(filterFnc);//1번방법

filterFnc = function(emp) {
	return emp.gender == 'Female' && emp.salary > 5000;//2번방법
}
over5000 = employees.filter(emp => emp.gender == 'Female' && emp.salary > 5000);//3번방법

//[A,A,A] -> [A,A]
employees.filter(filterFnc).forEach(function(emp) {
	over5000Sum += emp.salary;
});

console.log(over5000);
console.log('조건만족 사람들의 급여 합: ',over5000Sum);


//[A,A,A] -> [A',A',A']
employees.map(function(elem, idx, ary){
	const obj = {};
	obj.name = elem.first_name + '-' + elem.last_name;
	obj.no = elem.id;
	obj.salary = elem.salary;
	return obj;
	
}).forEach(console.log);


