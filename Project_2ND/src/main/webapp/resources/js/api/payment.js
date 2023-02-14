function iamport(){	
	var IMP = window.IMP;
	IMP.init('imp22771671');
	IMP.request_pay({		
		pg : 'kakaopay.TC0ONETIME',
		pay_method : 'card',
		merchant_uid : 'merchant_' + new Date().getTime(), //주문번호
		name : 'GOOTTFLEX',        //상품명
		amount : '1',           //가격
		//customer_uid : buyer_name + new Date().getTime(), //해당 파라미터값이 있어야 빌링 키 발급 시도
		buyer_email : 'email',       //구매자 이메일
		buyer_name : 'buyer_name',   //구매자 이름
		buyer_tel : 'hp',            //전화번호
		buyer_addr : 'addr',	     //주소
		buyer_postcode : '123-456'   //우편번호 
	},function(data){
		console.log("data");
		console.log(data);
		//결제 검증 -> imp_uid(결제 고유번호)
		$.ajax({
			type : 'post',
			url : "/verifyiamport/" + data.imp_uid
		}),done(function(data2){
				console.log("data2 = " + data2);
				//서버 검증
				if(data.paid_amount == data2.response.amount){
					alert("결제 완료");
				} else {
					alert("결제 실패")
				}			
		});
	});
}