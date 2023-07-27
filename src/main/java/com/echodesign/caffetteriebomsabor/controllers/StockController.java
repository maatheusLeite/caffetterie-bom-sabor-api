package com.echodesign.caffetteriebomsabor.controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echodesign.caffetteriebomsabor.controllers.dtos.StockEntryDto;
import com.echodesign.caffetteriebomsabor.models.StockEntry;
import com.echodesign.caffetteriebomsabor.services.StockService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/stock")
public class StockController {

	private final StockService service;
	
	public StockController(StockService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Page<StockEntry>> findAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
		Optional<StockEntry> stockEntryOptional = service.findById(id);
		
		if (!stockEntryOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(stockEntryOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<StockEntry> save(@RequestBody @Valid StockEntryDto stockEntryDto) {
		StockEntry stockEntry = new StockEntry();
		BeanUtils.copyProperties(stockEntryDto, stockEntry);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(stockEntry));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
		Optional<StockEntry> stockEntry = service.findById(id);
		
		if (!stockEntry.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found!");
		}
		
		service.delete(stockEntry.get());
		return ResponseEntity.status(HttpStatus.OK).body("Entry deleted successfully");
	}
}
