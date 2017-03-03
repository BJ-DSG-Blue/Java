$(function () {
    $(".content .con_right .left").click(function (e) {
        $(this).css({ "color": "#333333", "border-bottom": "2px solid #2e558e" });
        $(".content .con_right .right").css({ "color": "#999999", "border-bottom": "2px solid #dedede" });
        $(".content .con_right ul .con_r_left").css("display", "block");
        $(".content .con_right ul .con_r_right").css("display", "none");
    });
    $(".content .con_right .right").click(function (e) {
        $(this).css({ "color": "#333333", "border-bottom": "2px solid #2e558e" });
        $(".content .con_right .left").css({ "color": "#999999", "border-bottom": "2px solid #dedede" });
        $(".content .con_right ul .con_r_right").css("display", "block");
        $(".content .con_right ul .con_r_left").css("display", "none");
    });

    $('#btn_Login').click(function () {
        if ($.trim($('#userid').val()) == '') {
            alert('请输入您的用户名');
            return false;
        } else if ($.trim($('#pwd').val()) == '') {
            alert('请输入密码');
            return false;
        } else {
        	loginCheck();
        }
    });
    
    function loginCheck(id)  {
        $("#div_edit").hide();
    	//ajax提交表单url,data,callback,returnType
		$.post("login/loginCheck.do", {
			userName : $.trim($('#userid').val()),
			userPwd : $.trim($('#pwd').val()) 
		}, function(data) {
			if(data){
				window.location.href="user/loginToIndex.do";
				return;
			}
			window.location.href="login/backToLogin.do";
		}, "json");// 这里返回的类型有：json,html,xml,text
    }

})