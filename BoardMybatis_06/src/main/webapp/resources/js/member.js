$(function() {
	$("#btnJoin").click(function() {
		//alert($("#pass_check").val()+":"+$("#pass").val());
		if ($("#id").val() == "") {
			alert("아이디를 입력하세요7.");
			$("#id").focus();
			return false;
		}
		if ($("#pass").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#pass").focus();
			return false;
		}
		if ($("#pass_check").val() != $("#pass").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#pass_check").focus();
			return false;
		}
		if ($("#name").val() == "") {
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}
		if ($("#addr").val() == "") {
			alert("주소를 입력하세요.");
			$("#addr").focus();
			return false;
		}
		var data = {
			"id": $("#id").val(),
			"name": $("#name").val(),
			"pass": $("#pass").val(),
			"addr": $("#addr").val()
		}
		$.ajax({
			type: "post",
			url: "/myapp06/member/join",
			contentType: "application/json;charset=utf-8",
			data: JSON.stringify(data)

		}).done(function(res) {
			if (res == "success") {
				alert("회원가입을 축하합니다.");
			} else if (res == "fail") {
				alert("아이디를 중복확인하세요");
				$("#id").val("")
			}
		})
			.fail(function(e) {
				alert("회원가입실패");
			})
	}) //btnJoin
	
	$("#btnIdCheck").click(function(){
		window.open("idCheck","","width=600 height=300")
	})
	
	//아이디 중복확인
	$("#useBtn").click(function() {
		if ($("#userid").val() == "") {
			alert("아이디를 입력하세요")
			return
		}
		$.ajax({
			type: "post",
			url: "idCheck",
			data: { "id": $("#userid").val() },
			success: function(resp) {
				//alert(resp.trim().length);
				if (resp.trim() == "yes") {
					alert("사용 가능한 아이디입니다.");
					//opener.document.querySelector("#userID").value=$("#userid").val(); java문법
					$(opener.document).find("#id").val($("#userid").val());  //자바스크립트 문법
					//window.close();
					self.close();
				} else {
					alert("사용 불가능한 아이디입니다.");
					$("#userid").val("");
					$("#userid").focus();
				}
			},
			error: function(e) {
				alert("error: " + e);
			}

		})
	})

})
