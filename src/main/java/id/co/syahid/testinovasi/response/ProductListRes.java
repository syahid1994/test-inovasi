package id.co.syahid.testinovasi.response;

import java.util.List;

import id.co.syahid.testinovasi.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductListRes {

	private List<Product> data;
}
