package com.castanheira.dsVendas.controlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castanheira.dsVendas.dto.SaleDTO;
import com.castanheira.dsVendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleControler {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(org.springframework.data.domain.Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);

	}

}
