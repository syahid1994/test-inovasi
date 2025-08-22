package id.co.syahid.testinovasi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TransactionReq {
	
	@Schema(example = "TRX250800001")
	//@JsonProperty("transactionID")
	private String transactionID;

	@Schema(example = "10001")
	//@JsonProperty("productID")
	private String productID;
	
	@Schema(example = "1000")
	private Long amount;
	
	@Schema(example = "abc")
	private String customerName;
	
	@Schema(example = "0")
	private Integer status;
	
	@Schema(example = "2022-07-10 11:14:52")
	private String transactionDate;
	
	@Schema(example = "abc")
	private String createBy;
}
