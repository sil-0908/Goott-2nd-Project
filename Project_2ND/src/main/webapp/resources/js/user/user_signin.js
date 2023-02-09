
// 로그인을 빈칸으로 제출하는 것을 방지
$(function(){ 
    $(".login_submit").click(function(){
        var id=$("input[type=text]").val(); 
        var password=$("input[type=password]").val();
                   
        if(id==""){
            $('#id').html("아이디를 입력해주세요");
            $("input[type=text]").focus();
            return;
        }
                   
        if(password==""){
            $('#password').html("비밀번호를 입력해주세요");
            $("input[type=password]").focus();
            return;
        }
        
        document.form1.action="signin_check"; 
        document.form1.submit();
    });
});

