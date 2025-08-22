package id.co.syahid.testinovasi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductUpdateReq {
	
	@Schema(example = "1")
	private Long id;

	@Schema(example = "10001")
	//@JsonProperty("productID")
	private String productID;
	
	@Schema(example = "Test 1")
	private String productName;
}
