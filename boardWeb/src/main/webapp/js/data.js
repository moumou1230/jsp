/**
 * data.js
 */
const myMembers = [
	{id: 'user01', name: '홍길동', phone: '010-1111-2222', point: 90},
	{id: 'user02', name: '박석민', phone: '010-5555-8888', point: 95},
	{id: 'user03', name: '감길동', phone: '010-7878-2224', point: 70}
];//new array()

const json = `[{"id":1,"first_name":"Fidelia","last_name":"Yerrill","email":"fyerrill0@canalblog.com","gender":"Female","salary":6212},
{"id":2,"first_name":"Faber","last_name":"Maureen","email":"fmaureen1@china.com.cn","gender":"Male","salary":3312},
{"id":3,"first_name":"Yehudit","last_name":"Andrivel","email":"yandrivel2@multiply.com","gender":"Male","salary":3121},
{"id":4,"first_name":"Myles","last_name":"Bottrill","email":"mbottrill3@accuweather.com","gender":"Male","salary":3641},
{"id":5,"first_name":"Ramsay","last_name":"Leverentz","email":"rleverentz4@tmall.com","gender":"Male","salary":7045},
{"id":6,"first_name":"Dorian","last_name":"Geroldini","email":"dgeroldini5@gov.uk","gender":"Male","salary":5456},
{"id":7,"first_name":"Nora","last_name":"Guisby","email":"nguisby6@google.it","gender":"Female","salary":5564},
{"id":8,"first_name":"Natal","last_name":"McCully","email":"nmccully7@chronoengine.com","gender":"Male","salary":5362},
{"id":9,"first_name":"Natale","last_name":"Tenman","email":"ntenman8@europa.eu","gender":"Male","salary":7560},
{"id":10,"first_name":"Rachael","last_name":"Geany","email":"rgeany9@weibo.com","gender":"Female","salary":5793},
{"id":11,"first_name":"Andrej","last_name":"Buckell","email":"abuckella@usa.gov","gender":"Male","salary":3085},
{"id":12,"first_name":"Pincus","last_name":"Kleinbaum","email":"pkleinbaumb@artisteer.com","gender":"Male","salary":3385},
{"id":13,"first_name":"Mitchel","last_name":"Humblestone","email":"mhumblestonec@facebook.com","gender":"Male","salary":4316},
{"id":14,"first_name":"Blake","last_name":"McNelis","email":"bmcnelisd@telegraph.co.uk","gender":"Female","salary":4164},
{"id":15,"first_name":"Morgana","last_name":"Norcop","email":"mnorcope@theatlantic.com","gender":"Female","salary":6467}]`;

const employees = JSON.parse(json);

