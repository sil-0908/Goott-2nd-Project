package com.test.test1.common;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class PayMentController {

	private IamportClient api;
	
	public PayMentController(){		
    	//REST API , REST API secret KEY
		//생성자를 통한 토큰 발급
		this.api = new IamportClient("1003071753880806","US46uhT0JGWE7fGoxqtb3tVOEF1UCelTe5xD210RuLLOaUxWBtWmUHmdM1VcTM6lMgpaBr08R4wRBdLH");
	}
		
	@ResponseBody
	@RequestMapping(value="/verifyiamport/{imp_uid}", method=RequestMethod.POST)
	public IamportResponse<Payment> paymentByImpUid(Model model, Locale locale, HttpSession session
			, @PathVariable(value= "imp_uid") String imp_uid) throws IamportResponseException, IOException{	
		
			return api.paymentByImpUid(imp_uid);
	}
	
}

