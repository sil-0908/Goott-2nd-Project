
// 로그인을 빈칸으로 제출하는 것을 방지
$(function(){ 
    $(".login_submit").click(function(){
        var id=$("input[type=text]").val(); // 아이디 입력값
        var password=$("input[type=password]").val(); // 비밀번호 입력값
                   
        if(id==""){ //아이디 빈칸 방지 
            $('#id').html("아이디를 입력해주세요");
            $("input[type=text]").focus();
            return;
        }
                   
        if(password==""){ //비밀번호 빈칸 방지 
            $('#password').html("비밀번호를 입력해주세요");
            $("input[type=password]").focus();
            return;
        }
        
        document.form1.action="signin_check"; 
        document.form1.submit();
    });
});

