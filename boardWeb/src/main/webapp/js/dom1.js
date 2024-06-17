/**
 * dom1.js
 */
document.getElementById('fruit').style.display = 'none';

document.querySelector('table.table tr:nth-of-type(5)').setAttribute('align', 'center');//버튼 가운데 정렬

//페이지 로딩하면서 회원3명 출력
console.log(myMembers)

for(let memb of myMembers){	
	document.getElementById('memberList').appendChild(addRow(memb));
}

//수정버튼
document.getElementById('modBtn').addEventListener('click', modMemberFunc);

function modMemberFunc(){
	let list = document.querySelectorAll('#memberList tr');
	let mid = document.getElementById('mid').value;
	let mname = document.getElementById('mname').value;
	let mphone = document.getElementById('mphone').value;
	let mpoint = document.getElementById('mpoint').value;
	
	//입력화면의 회원아이디 값을 가져와서 mid변수저장
	for(let lists of list){
		//console.log(lists.children);
		if(lists.children[0].innerHTML == mid){
			lists.children[1].innerHTML = mname;
			lists.children[2].innerHTML = mphone;
			lists.children[3].innerHTML = mpoint;
		}
	}
}//end of modMemberFunc()

//추가버튼 클릭이벤트 등록
document.getElementById('addBtn').addEventListener('click', addMemberFunc);

function addMemberFunc() {
	const id = document.getElementById('mid').value;
	const name = document.getElementById('mname').value;
	const phone = document.getElementById('mphone').value;
	const point = document.getElementById('mpoint').value;

	if (!id || !name || !phone || !point) {
		alert('입력값을 확인하세요');
		return;
	}

	document.getElementById('memberList').appendChild(addRow({ id, name, phone, point }));

	document.getElementById('mid').value = "";
	document.getElementById('mname').value = "";
	document.getElementById('mphone').value = "";
	document.getElementById('mpoint').value = "";
} //end of addMemberFunc()

function addRow(member = { id, name, phone, point }) {
	//tr -> td * 4
	const tr = document.createElement('tr');
	tr.addEventListener('click', showDetailFnc);
	
	for (let prop in member) {
		const td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td);
	}
	
	//삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	
	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	
	btn.addEventListener('click', removeTrElement); 
	function  removeTrElement(e){
		console.log('btn',e);
		e.stopPropagation();//상위요소로 이벤트 전파차단
		this.parentElement.parentElement.remove();
		//td.parentElement.remove();
	}
	
	
	//체크박스 생성
	td = document.createElement('td');
	let checkbox = document.createElement('input');
	checkbox.setAttribute('type', 'checkbox');
	td.appendChild(checkbox);
	tr.appendChild(td);
	
	
	return tr;
}//end of addRow()

//선택 삭제
document.getElementById('delBtn').addEventListener('click', removeMemberFunc);

function removeMemberFunc(){
	let list = document.querySelectorAll('#memberList tr');
	for(let lists of list){
		console.log(lists.children[5].children[0].checked);
		if(lists.children[5].children[0].checked == true){
			lists.remove();
		}
		
	}
}

//체크박스 전체 선택
//this - > 1.이벤트(이벤트대상) 2.함수(window), 3.객체(객체자신)
let chec = document.querySelector('thead input[type ="checkbox"]').addEventListener('change',allCheckFnc);
function allCheckFnc(){
	let checkval = this.checked;
	let lists = document.querySelectorAll('#memberList tr')
				.forEach(item => item.children[5].children[0].checked = this.checked);//화살표 함수, this.는 이벤트 대상
				
	
//.forEach(function(item){item.children[5].children[0].checked = checkval});//this => window객체
				
}

function showDetailFnc(e){
	console.log(e);
	console.dir(this.children[1].innerText);
	document.getElementById('mid').value = this.children[0].innerText;
	document.getElementById('mname').value = this.children[1].innerText;
	document.getElementById('mphone').value = this.children[2].innerText;
	document.getElementById('mpoint').value = this.children[3].innerText;
	
}//end of showDetailFnc()


