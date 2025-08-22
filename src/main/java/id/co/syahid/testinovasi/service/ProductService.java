package id.co.syahid.testinovasi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.syahid.testinovasi.constant.ResponseCodeConstant;
import id.co.syahid.testinovasi.exception.ResponseCodeException;
import id.co.syahid.testinovasi.model.Product;
import id.co.syahid.testinovasi.repository.ProductRepository;
import id.co.syahid.testinovasi.request.ProductSaveReq;
import id.co.syahid.testinovasi.request.ProductUpdateReq;
import id.co.syahid.testinovasi.response.ProductListRes;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public ProductSaveReq save(ProductSaveReq request) {
		try {
			if (productRepository.findByProductID(request.getProductID()).isPresent()) {
				throw new ResponseCodeException(ResponseCodeConstant.DATA_EXIST_MSG, ResponseCodeConstant.DATA_EXIST_RC);
			}
			Product product = new Product();
			product.setProductID(request.getProductID());
			product.setProductName(request.getProductName());
			productRepository.save(product);
			return request;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public ProductUpdateReq update(ProductUpdateReq request) {
		try {
			Optional<Product> productOpt = productRepository.findById(request.getId());
			if (productOpt.isEmpty()) {
				throw new ResponseCodeException(ResponseCodeConstant.DATA_NOTFOUND_MSG, ResponseCodeConstant.DATA_NOTFOUND_RC);
			}
			Product product = productOpt.get();
			if (request.getProductID() != null && !product.getProductID().equals(request.getProductID())) {
				if (productRepository.findByProductID(request.getProductID()).isPresent()) {
					throw new ResponseCodeException(ResponseCodeConstant.DATA_EXIST_MSG, ResponseCodeConstant.DATA_EXIST_RC);
				}
			}
			product.setProductID(request.getProductID() != null ? request.getProductID() : product.getProductID());
			product.setProductName(request.getProductName());
			productRepository.save(product);
			return request;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public ProductListRes list() {
		List<Product> listProduct = productRepository.findAll();
		return new ProductListRes(listProduct);
	}
}
