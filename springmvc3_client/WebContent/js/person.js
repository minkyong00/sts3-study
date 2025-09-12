const person = {
	
	listPerson: () => {
		axios.get('http://localhost:8888/person/')
			.then(function(response) {
				person.renderList(response.data.personList);
		});
	},

	renderList: personList => {
		let listHtml;
		for(let i=0; i<personList.length; i++){
			listHtml += "<tr>";
			listHtml += "<td>" + personList[i].pid + "</td>";
			listHtml += "<td><a href='/html/getPerson.html?pid="+ personList[i].pid
				 + "' >" + personList[i].name + "</a></td>";
			listHtml += "<td>" + personList[i].age + "</td>";
			listHtml += "</tr>";
		}
		$("tbody").html(listHtml);
	},
	
	insertPerson: () => {
		axios.post(
			'http://localhost:8888/person/', 
		{
			pid: $("input[name='pid']").val(),
			name: $("input[name='name']").val(),
			age: $("input[name='age']").val()
		},
		{
			header: {
				'Content-Type': 'application/json'
			}
		}
		).then(function(){
			location.href='/html/listPerson.html';
		})
	},
	
	getPerson: pid => {
		axios.get('http://localhost:8888/person/' + pid)
			.then(function(response) {
				const person = response.data;
				$("#pid").text(person.pid);
				$("#name").text(person.name);
				$("#age").text(person.age);
		});
	},
	
	updatePerson: () => {
		location.href='/html/insertPersonForm.html?&isEdit=Y&pid='+ $('#pid').text();
	},
	
	setInsertPersonForm: pid => {
		$("#insertSpan").text('수정');
		$("#insertBtn").val('수정');
		axios.get('http://localhost:8888/person/' + pid)
		.then(function(response) {
			const person = response.data;
			$('#pidTd').text(person.pid);
			$('input[name="name"]').attr("value", person.name);
			$('input[name="age"]').attr("value", person.age);
			$("#insertBtn").attr("onclick", "person.updatePersonProc("+ person.pid +")");
		});
	},
	
	updatePersonProc: pid => {
		axios.put(
			'http://localhost:8888/person/',
		{
			pid: pid,
			name: $("input[name='name']").val(),
			age: $("input[name='age']").val()
		},
		{
			header: {
				'Content-Type': 'application/json'
			}
		}).then(function(){
			location.href='/html/listPerson.html';
		})
	},
	
	deletePerson: () => {
		axios.delete('http://localhost:8888/person/' + $('#pid').text())
			.then(function(response) {
				location.href='/html/listPerson.html';
		});
	}
	
}



