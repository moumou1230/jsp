<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawChart);
	
	//ajax 호출
	let centerAry = [];
	centerAry.push(['시도명', '센터의갯수']);
	
	fetch('centerChart.do')
		.then(result => result.json())
		.then(result=>{
			
			for(let prop in result){
				console.log(prop);
				centerAry.push([prop, result[prop]]);
			}//객체(centerChart.java 에서 마지막에 gson.toJson(centerMap))
			
			//result.forEach(center => {
				//centerAry.push([center.sido, center.cnt]);
			//})//배열(centerChart.java 에서 마지막에 result 넣으면)
			//google.charts.setOnLoadCallback(drawChart);//비동기처리의 순서
		});
			
	
	function drawChart() {
		//[{},{},{}] = >[[],[],[]]
		console.log(centerAry.length);
		var data = google.visualization.arrayToDataTable(centerAry);

		var options = {
			title : '시도별 센터의 갯수'
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart_3d'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
	<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
</body>
</html>