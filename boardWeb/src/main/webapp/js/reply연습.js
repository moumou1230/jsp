/**
 * reply.js
 */
//댓글 -> li 생성
let fields = ['replyNo', 'reply', 'replyer', 'replyDate'];
function makeRow(reply = {}) {
	let li = document.createElement('li');
	//li.setAttribute('id', reply.replyNo);
	fields.forEach(field => {
		let span = document.createElement('span');
		span.innerHTML = reply[field];
		if (field == 'reply') {
			width = '4';
		} else if (field == 'replyDate') {
			width = '3';
		} else {
			width = '2';
		}

		span.setAttribute('class', 'col-sm-' + width);
		li.appendChild(span);
	});
	return li;
}

function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
	console.dir(template);
	template.style.display = 'block';
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	template.querySelector('span:nth-of-type(5) > button').setAttribute('delId', reply.replyNo);

	return template;
}

//cloneRow();

//한건 삭제

function deleteRow(e) {
	let rno = e.target.getAttribute('delId');
	let li = e.target.parentNode.parentNode;
	//console.log(e.target.getAttribute('delId'));
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'removeReply.do?rno=' + rno);
	delAjax.send();
	delAjax.onload = function() {
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == "OK") {
			alert('삭제 되었습니다.');
			li.remove();
		}
	}
}

const listAjax = new XMLHttpRequest();
listAjax.open('get', 'replyListJson.do?bno=' + bno);
listAjax.send();
listAjax.onload = function() {
	let data = JSON.parse(listAjax.responseText);
	console.log(data);
	data.forEach(reply => {
		//document.querySelector('div.content>ul').appendChild(makeRow(reply));
		document.querySelector('div.content>ul').appendChild(cloneRow(reply));
	});
}