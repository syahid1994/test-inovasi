package id.co.syahid.testinovasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.syahid.testinovasi.request.TransactionReq;
import id.co.syahid.testinovasi.response.TransactionViewRes;
import id.co.syahid.testinovasi.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transaction/save")
	public TransactionReq save(@RequestBody TransactionReq request) {
		return transactionService.save(request);
	}
	
	@GetMapping("/transaction/viewdata")
	public TransactionViewRes viewdata() {
		return transactionService.viewdata();
	}
	
}
