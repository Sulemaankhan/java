package com.test.shopping.shoppingapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.test.shopping.shoppingapp.dto.ProductResponseDTO;
import com.test.shopping.shoppingapp.service.ProductService;

@RestController
@RequestMapping("products")
@Validated
public class ProductController {

	@Autowired
	private ProductService productSearchService;

	@GetMapping
	@Valid
	public ResponseEntity<List<ProductResponseDTO>> search(@RequestParam String productName,
			@RequestParam String categoryName) {
		List<ProductResponseDTO> productResponseDTO = productSearchService.searchProduct(productName, categoryName);

		return new ResponseEntity<List<ProductResponseDTO>>(productResponseDTO, HttpStatus.OK);
	}

//	@PostMapping("search")
//	public ResponseEntity<ProductCategoryResponseDTO> search(
//			@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
//		ProductCategoryResponseDTO productResponseDTO = productSearchService
//				.search(categoryRequestDTO.getCategoryName(), categoryRequestDTO.getProductName());
//
//		return new ResponseEntity<ProductCategoryResponseDTO>(productResponseDTO, HttpStatus.OK);
//
//	}

}
