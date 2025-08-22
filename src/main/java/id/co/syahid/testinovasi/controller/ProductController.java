package id.co.syahid.testinovasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.syahid.testinovasi.request.ProductSaveReq;
import id.co.syahid.testinovasi.request.ProductUpdateReq;
import id.co.syahid.testinovasi.response.ProductListRes;
import id.co.syahid.testinovasi.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/product/save")
	public ProductSaveReq save(@RequestBody ProductSaveReq request) {
		return productService.save(request);
	}

	@PostMapping("/product/update")
	public ProductUpdateReq update(@RequestBody ProductUpdateReq request) {
		return productService.update(request);
	}

	@GetMapping("/product/list")
	public ProductListRes list() {
		return productService.list();
	}
}
