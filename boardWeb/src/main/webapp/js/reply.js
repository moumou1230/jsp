/*
 *reply.jsp 
 */
svc.replyList(bno, replyListFnc);

//댓글 등록 이벤트
document.querySelector('#addReply').addEventListener('click', addReplyFnc);

function addReplyFnc(){
	if(!replyers){
		alert('로그인하세요');
		return;
	}
	let reply = document.getElementById('reply').value;
	if(!reply){
		alert('댓글을 등록하세요');
		return;
	}
	svc.addReply({replyer: replyers, reply, bno},addReplyCallback);	
}
function addReplyCallback(){
	let result = JSON.parse(this.responseText);
	if(result.retCode == 'OK'){
		alert('등록성공');
		let li = cloneRow(result.retVal);
		document.querySelector('div.content>ul').appendChild(li);
		document.getElementById('reply').value = '';
	}else{
		alert('실패 =>' + result.retVal);
	}
	
}

//replyList의 매개값으로 사용될 함수
function replyListFnc() {
	let data = JSON.parse(this.responseText);	//this는 replyService.js에있는 xhtp
	console.log(data);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
}

//댓글정보, li생성
function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
	//console.dir(template);
	template.style.display = 'block';
	template.setAttribute('id', reply.replyNo);
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;

	return template;
}

//한건삭제
function deleteRow(e) {
	let li = e.target.parentElement.parentElement;
	let rno = li.getAttribute('id');

	svc.removeReply(rno, deleteReplyFnc);
	// removeReply메소드의 매개값으로 전달될 함수, 화면에서 한건 지우기
	function deleteReplyFnc() {
		let result = JSON.parse(this.responseText);
		if(result.retCode == 'OK'){
			alert(result.retMsg);
			document.getElementById(rno).remove();
		}else{
			alert('ERROR =>' + result.retMsg);
		}
	}

}
