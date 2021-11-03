$(function() {
	$("#btnJoin").click(function() {
		//alert($("#pass_check").val()+":"+$("#pass").val());
		if ($("#username").val() == "") {
			alert("아이디를 입력하세요.");
			$("#username").focus();
			return false;
		}
		if ($("#userpw").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#userpw").focus();
			return false;
		}
		if ($("#pass_check").val() != $("#userpw").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#pass_check").focus();
			return false;
		}		
		if ($("#email").val() == "") {
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}
		var data = {
			"username": $("#username").val(),
			"password": $("#userpw").val(),
			"email":$("#email").val(),
			"admin":$(":radio[name='admin']:checked").val(),
		}
		$.ajax({
			type: "post",
			url: "join",
			contentType: "application/json;charset=utf-8",
			data: JSON.stringify(data)

		}).done(function(res) {
			if (res == "success") {
				alert("회원가입을 축하합니다.");
				location.href="/"
				
			} else if (res == "fail") {
				alert("아이디를 중복확인하세요");
				$("#username").val("")
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
		if ($("#findid").val() == "") {
			alert("아이디를 입력하세요")
			return
		}
		$.ajax({
			type: "post",
			url: "idCheck",
			data: { "username": $("#findid").val() },
			success: function(resp) {
				//alert(resp.trim().length);
				if (resp.trim() == "yes") {
					alert("사용 가능한 아이디입니다.");
					//opener.document.querySelector("#userID").value=$("#userid").val(); java문법
					$(opener.document).find("#username").val($("#findid").val());  //자바스크립트 문법
					//window.close();
					self.close();
				} else {
					alert("사용 불가능한 아이디입니다.");
					$("#findid").val("");
					$("#findid").focus();
				}
			},
			error: function(e) {
				alert("error: " + e);
			}

		})
	})

})
