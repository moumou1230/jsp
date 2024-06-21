/*
 *reply.jsp 
 */

//댓글 출력하기
let page = 1;
svc.replyList({ bno, page }, replyListFnc);

//댓글 등록 이벤트
document.querySelector('#addReply').addEventListener('click', addReplyFnc);

//페이징 a태그를 클릭하면 목록보여주기

function addReplyFnc() {
	if (!replyers) {
		alert('로그인하세요');
		return;
	}
	let reply = document.getElementById('reply').value;
	if (!reply) {
		alert('댓글을 등록하세요');
		return;
	}
	svc.addReply({ replyer: replyers, reply, bno }, addReplyCallback);
}// end of addReplyFnc()

// 댓글 건수를 활용해서 페이징계산하고 목록출력
function makePagingFnc(){
	svc.replyTotalCnt(bno, createPagingList);
}
let pagination = document.querySelector('div.pagination');
function createPagingList(){
	let totalCnt = this.responseText; //댓글 건수
	console.log(totalCnt);
	let startPage, endPage;
	let prev, next;
	let realEnd = Math.ceil(totalCnt / 5);
	
	endPage = Math.ceil(page / 10) * 10; // 1페이지일 경우 현재 10페이지까지 보여주겠다 ceil이 올림이라서
	startPage = endPage - 9;
	endPage = endPage > realEnd ? realEnd : endPage;
	
	prev = startPage > 1;
	next = endPage < realEnd;
	
	//startPage, endPage, prev,next =>a태그 생성
	pagination.innerHTML = '';
	if(prev){
		let aTag = document.createElement('a'); //<a data-page = startpage-1 href = '#'>
		aTag.setAttribute('data-page', startPage-1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&laquo";
		pagination.appendChild(aTag);

	}
	
	for(let p = startPage; p <= endPage; p++){
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', p);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = p;
		if(page == p){
			aTag.className = 'active';
		}
		pagination.appendChild(aTag);
	}
	if(next){
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', endPage+1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&raquo";
		pagination.appendChild(aTag);

	}
	document.querySelectorAll('div.pagination a').forEach(item => {//item은 a태그
	item.addEventListener('click', function(e){
		e.preventDefault();// a태그의 href#은 페이지 맨위로 이동하는데 그거 차단하기위해서
		page = item.dataset.page;
		svc.replyList({ bno, page }, replyListFnc);
	})
});
}//end of createPagingList()

//등록 실행함수
function addReplyCallback() {
	let result = JSON.parse(this.responseText);
	if (result.retCode == 'OK') {
		alert('등록성공');
		let li = cloneRow(result.retVal);
		document.querySelector('div.content>ul').appendChild(li);
		document.getElementById('reply').value = '';
		
		//댓글 등록 후 최근 작성 댓글로 돌아가기.
		page = 1;
		svc.replyList({bno, page}, replyListFnc);
		
	} else {
		alert('실패 =>' + result.retVal);
	}

}
//replyList의 매개값으로 사용될 함수
function replyListFnc() {
	
	//5개의 댓글을 지워주고 출력
	document.querySelectorAll('div.content>ul>li').forEach((item, idx)=> {
		if(idx > 2){
			item.remove();
		}
	});
	
	let data = JSON.parse(this.responseText);	//this는 replyService.js에있는 xhtp
	//console.log(data);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
	makePagingFnc();
}//end of replyListFnc()

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
		if (result.retCode == 'OK') {
			alert(result.retMsg);
			document.getElementById(rno).remove();
			
			//댓글 삭제 후 제일 최근작성 댓글로 돌아가기
		
			svc.replyList({bno, page}, replyListFnc);
		} else {
			alert('ERROR =>' + result.retMsg);
		}
	}

}
