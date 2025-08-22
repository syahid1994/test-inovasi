package id.co.syahid.testinovasi.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.syahid.testinovasi.constant.ResponseCodeConstant;
import id.co.syahid.testinovasi.constant.TransactionStatus;
import id.co.syahid.testinovasi.exception.ResponseCodeException;
import id.co.syahid.testinovasi.model.Product;
import id.co.syahid.testinovasi.model.Transaction;
import id.co.syahid.testinovasi.repository.ProductRepository;
import id.co.syahid.testinovasi.repository.TransactionRepository;
import id.co.syahid.testinovasi.request.TransactionReq;
import id.co.syahid.testinovasi.response.TransactionViewRes;
import id.co.syahid.testinovasi.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionService {
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	TransactionRepository transactionRepository;
	
	public TransactionReq save(TransactionReq request) {
		try {
			Optional<Product> productOpt = productRepository.findByProductID(request.getProductID());
			if (productOpt.isEmpty()) {
				throw new ResponseCodeException(ResponseCodeConstant.PRODUCT_NOTFOUND_MSG, ResponseCodeConstant.PRODUCT_NOTFOUND_RC);
			}
			if (transactionRepository.findByTransactionID(request.getTransactionID()).isPresent()) {
				throw new ResponseCodeException(ResponseCodeConstant.DATA_EXIST_MSG, ResponseCodeConstant.DATA_EXIST_RC);
			}
			Transaction transaction = new Transaction();
			transaction.setTransactionID(request.getTransactionID());
			transaction.setProductID(request.getProductID());
			transaction.setProductName(productOpt.get().getProductName());
			transaction.setAmount(request.getAmount());
			transaction.setCustomerName(request.getCustomerName());
			transaction.setStatus(request.getStatus());
			try {
				transaction.setTransactionDate(DateUtil.fullDate(request.getTransactionDate()));
			} catch (ParseException e) {
				throw new ResponseCodeException(ResponseCodeConstant.INVALID_DATE_MSG, ResponseCodeConstant.INVALID_DATE_RC);
			}
			transaction.setCreateBy(request.getCreateBy());
			transaction.setCreateOn(new Date());
			transactionRepository.save(transaction);
			return request;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public TransactionViewRes viewdata() {
		try {
			TransactionViewRes response = new TransactionViewRes();
			List<Transaction> listTransaction = transactionRepository.findAll();
			for (Transaction transaction: listTransaction) {
				TransactionViewRes.TransData transData = new TransactionViewRes.TransData(transaction);
				transData.setTransactionDate(DateUtil.fullDate(transaction.getTransactionDate()));
				transData.setCreateOn(DateUtil.fullDate(transaction.getCreateOn()));
				response.getData().add(transData);
			}
			response.setStatus(TransactionStatus.toList());
			return response;
		} catch (RuntimeException e) {
			throw e;
		} catch (ParseException e) {
			throw new ResponseCodeException(e.getMessage(), "99");
		}
	}
}
