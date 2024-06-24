/**
 * 
 */

let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=w79N0ah8SaHaN%2FxNB%2BrUBYBQifwe5KVCk23JZ0s4Vhv3P4ba7xBK3dOSsq4dxc4iIkxbpmwMj3SCfENQ33529A%3D%3D';

//센터정보 생성
document.getElementById('centerDB').addEventListener('click', createCenterInfo);

function createCenterInfo(){
	// 1.open API 호출.
	// 2.컨트롤 호출 DB입력.
	fetch(url)
		.then(result => result.json())//json문자열 => 자바객체
		.then(result =>{
			console.log(result);
			let centers = result.data; //[{},{},{}] => [{"id":"hong"}]
			return fetch('centerInfo.do', {
				method: 'post', //전달되는 값이 body영역에 저장.
				headers: {'Content-type': "application/json"},//키=값&키=값
				body: JSON.stringify(centers)// 객체 => json문자열(서버로 보낼때는 문자열로 바꿔서 보내줘야됨)
			})
		})
		.then(result => result.json())//{"txnCnt": 3}
		.then(result =>  {
			if(result.txnCnt > 0){
				alert(result.txnCnt + '건 처리 성공');
			}else{
				alert('실패');
			}
		})
		.catch(err => console.log(err));
}

const target = document.querySelector('#centerList');
const selc = document.querySelector('#searchList');

let allData;
let sidoData = [];
fetch(url)
    .then(result => result.json())
    .then(result => {
		allData = result.data;
		console.log(result);
        result.data.forEach((center)=>{
            target.appendChild(makeRow(center));

         	if(sidoData.indexOf(center.sido)==-1){
				sidoData.push(center.sido);
			}  	
        });

        let opt1 = document.createElement('option');
        opt1.innerHTML = '전체선택';
        selc.appendChild(opt1);

        sidoData.forEach(e=>{
            let opt = document.createElement('option');
            opt.innerHTML = e;
            selc.appendChild(opt);
        });
    });
//선택한 시도에 맞게 출력

let selBtn = document.querySelector('#searchList')
selBtn.addEventListener('change',selectFnc)
function selectFnc(e = {}){
    let mySel = selBtn.value;
	//console.log(mySel);
    target.innerHTML = '';
    allData.forEach(sido => {
        if(sido.sido.includes(mySel)){
            //console.log(sido);
            //opt1.value = allData;
            target.appendChild(makeRow(sido));
        }else if(mySel == '전체선택'){
			target.appendChild(makeRow(sido));
		}
    })
}

//검색어 조회

document.querySelector('#findBtn').addEventListener('click', searchFnc);

function searchFnc(e){
	let mySearch = document.querySelector('#search').value;
	let mySel = selBtn.value;
    target.innerHTML = '';
    if(!mySearch){
        alert('검색어를 입력해주세요');
    }

    allData.forEach(function(e){
        if(e.address.includes(mySearch) && e.sido.includes(mySel)){
            target.appendChild(makeRow(e));
        }else if(mySel == '전체선택' && e.address.includes(mySearch)){
			target.appendChild(makeRow(e));
		}
    });
}

 //리스트 조회 

let fields = ['id', 'centerName', 'phoneNumber', 'address'];
function makeRow(center = {}){
	let mySearch = document.querySelector('#search');
    let tr = document.createElement('tr');
    tr.addEventListener('click', function(){
		//let name = center.centerName.substr(6);
		location.href = "map.do?x="+center.lat+"&y="+center.lng+"&name="+center.centerName.replace("코로나19","");
	});
    mySearch.value = '';

    fields.forEach(field =>{
        let td = document.createElement('td');
        td.innerHTML = center[field];
        tr.appendChild(td);
    });

    return tr;
}




