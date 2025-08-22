package id.co.syahid.testinovasi.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import id.co.syahid.testinovasi.model.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TransactionViewRes {
	
	private List<TransData> data = new ArrayList<>();
	
	private List<StatusRes> status = new ArrayList<>();

	@Data
	@NoArgsConstructor
	public static class TransData {
	
		private Long id;
		
		//@JsonProperty("productID")
		private String productID;
		
		private String productName;
		
		private Long amount;
		
		private String customerName;
		
		private Integer status;
		
		private String transactionDate;
		
		private String createBy;
		
		private String createOn;
		
		public TransData(Transaction transaction) {
			this.id = transaction.getId();
			this.productID = transaction.getProductID();
			this.productName = transaction.getProductName();
			this.amount = transaction.getAmount();
			this.customerName = transaction.getCustomerName();
			this.status = transaction.getStatus();
			this.createBy = transaction.getCreateBy();
		}
	}
}
