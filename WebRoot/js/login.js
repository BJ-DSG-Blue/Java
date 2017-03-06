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
	        $("#div_edit").hide();
	    	$.ajax({
				type:"post",
				url:"login/loginCheck.do",
				contentType:"application/json;charset=utf-8",
				data:'{"userName":"'+$.trim($('#userid').val())+'","userPwd":"'+$.trim($('#pwd').val())+'"}',
				success:function(data){
					if(data){
						window.location.href="user/loginToIndex.do";
					}else{
						alert("账号或密码错误！");
					}
				}
			});
			//如果是表单form的话  也会先执行form提交。
			//提交之后 就已经不在当前页面了。所以 window.location.href无效，需要加上后面这句
			window.event.returnValue=false;
	    }
    });

})