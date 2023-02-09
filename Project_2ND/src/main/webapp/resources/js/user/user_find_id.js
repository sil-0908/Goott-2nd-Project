
$(function(){ 
    $(".login_submit_id").click(function(){
        var email_id=$("#email_id").val();

        if(email_id==""){
            $('#email_text1').html("이메일를 입력해주세요");
            $("#email_id").focus();
            return;
        }
        else{
            $('#email_text1').html("");
        }
        
        if(!email_id.match("@")){
            $('#email_text1').html("올바른 이메일을 입력해주세요");
            $("#email_id").focus();
            return;
        }
        else{
            $('#email_text1').html("");
        }

         
        document.form1.action=""; 
        document.form1.submit();
    });
});



$(function(){ 
    $(".login_submit_pw").click(function(){
        var email_pw=$("#email_pw").val();  
        var id=$("input[type=text]").val();

        if(id==""){
            $('#id').html("아이디를 입력해주세요");
            $("input[type=text]").focus();
            return;
        }
        else{
            $('#id').html("");
        }

        if(email_pw==""){
            $('#email_text2').html("이메일을 입력해주세요");
            $("#email_pw").focus();
            return;
        }
        else{
            $('#email_text2').html("");
        }
        
        if(!email_pw.match("@")){
            $('#email_text2').html("올바른 이메일을 입력해주세요");
            $("#email_pw").focus();
            return;
        }
        else{
            $('#email_text2').html("");
        }

        document.form1.action=""; 
        document.form1.submit();
    });
});