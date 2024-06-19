/**
 * ajax3.jsp
 */


//목록 가져오기
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'memberAjax.do');
xhtp.send();
xhtp.onload = function() {
	console.log(xhtp);
	let data = JSON.parse(xhtp.responseText);
	data.forEach(user => {
		document.querySelector('#list').appendChild(makeRow(user));
	});
}

//json문자열의 필드이름 활용
const fields = ['userId', 'userName', 'userPw', 'responsibility'];
function makeRow(obj = {}) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', obj.userId);
	tr.addEventListener('dblclick', function(e){
		document.getElementById('myModal').style.display = 'block';
		//선택된 사용자의 이름, 비밀번호를 모달에 출력
		console.log(e, this);
		document.querySelector('#modify_name').value = tr.children[1].innerHTML;
		document.querySelector('#modify_pass').value = this.children[2].innerHTML;
		document.querySelector('#modify_id').value = this.children[0].innerHTML;
	
	})
	
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
	});
	let td = document.createElement('td');
	let btn = document.createElement('button');
	
	btn.setAttribute('class','btn btn-warning')
	
	
	btn.innerHTML = '삭제';
	
	
	btn.style.fontSize = '16px';
	
	btn.setAttribute('date-delId', obj.userId);
	btn.addEventListener('click', removeMemberFnc);
	btn.style.padding = '1px 5px';
	td.appendChild(btn);

	tr.appendChild(td);
	return tr;
}//end of makeRow()

//삭제버튼 작동
function removeMemberFnc(e){
	let did = this.getAttribute('date-delId');
	console.log(did);
	let tr = document.getElementById(did);
	console.log(tr);
	
	const delAjax = new XMLHttpRequest();	
	delAjax.open('get', 'delMemberAjax2.do?id='+ did);
	delAjax.send();
	delAjax.onload = function(){
		let result = JSON.parse(delAjax.responseText);
		
		if(result.retCode == 'delete'){	
			alert('삭제가 완료되었습니다.')
			tr.remove();
		}
	}
}
//수정버튼
document.querySelector('#modBtn').addEventListener('click', function(){
	let id = document.querySelector('#modify_id').value;
	let name = document.querySelector('#modify_name').value;
	let pw = document.querySelector('#modify_pass').value;
	
	//ajax생성
	//정상적으로 정보가 업데이트 되면 화면수정
	//수정이 안됐으면 화면수정 x
	const updateAjax = new XMLHttpRequest();
	updateAjax.open('get','updateMemberAjax.do?id='+id+'&name='+name+'&pw='+pw);
	updateAjax.send();
	updateAjax.onload = function(){
		
	}
	
	
	let targetTr = document.getElementById(id);
	targetTr.children[1].innerHTML = name;
	targetTr.children[2].innerHTML = pw;
	
	//모달창 닫기
	document.querySelector('#myModal').style.display = 'none';
});

//등록 버튼
document.querySelector('#addBtn').addEventListener('click', function() {
	let id = document.querySelector('#uid').value;
	let pw = document.querySelector('#upw').value;
	let name = document.querySelector('#uname').value;
	let auth = document.querySelector('#auth').value;

	const addAjax = new XMLHttpRequest();
	let url = 'addAjax.do?id=' + id + '&pw=' + pw + '&name=' + name + '&auth=' + auth;
	addAjax.open('get', url);
	addAjax.send();
	addAjax.onload = function() {
		let result = JSON.parse(addAjax.responseText);
		if (result.retCode == 'OK') {
			let newMem = { userId: id, userName: name, userPw: pw, responsibility: auth };
			alert(result.retMsg);
			document.querySelector('#list').appendChild(makeRow(newMem));
		} else {
			alert('실패');
		}
	}
});

//id 체크 이벤트
document.querySelector('#uid').addEventListener('change', function() {
	let checkId = this.value;

	const checkAjax = new XMLHttpRequest();
	checkAjax.open('get', 'checkIdAjax.do?id=' + checkId);
	checkAjax.send();
	checkAjax.onload = function() {
		let result = JSON.parse(checkAjax.responseText);
		if (result.retCode == 'Exist') {
			alert('이미 존재하는 아이디입니다.');
			//document.querySelector('#addBtn').disabled = true;
		} else {
			alert('등록가능한 아이디 입니다.');
			//document.querySelector('#addBtn').disabled = false;
		}
	}
});
//id 삭제
document.querySelector('#delBtn').addEventListener('click', function(){
	let id = document.querySelector('#uid').value;
	let pw = document.querySelector('#upw').value;
	
	const delIdAjax = new XMLHttpRequest();
	delIdAjax.open('get', 'delMemberAjax.do?id='+id+'&pw='+pw);
	delIdAjax.send();
	delIdAjax.onload = function(){
		let result = JSON.parse(delIdAjax.responseText);
		
		if(result.retCode == 'delete'){	
			alert('삭제가 완료되었습니다.')
			document.querySelectorAll('#list > tr').forEach(function(ele){
				if(ele.childNodes[0].innerText == id){
					ele.remove();
				}
			})	
		}else{
			alert('삭제가 실패되었습니다.')
		}
	}
})