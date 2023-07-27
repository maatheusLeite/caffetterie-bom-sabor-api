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

import com.echodesign.caffetteriebomsabor.controllers.dtos.CashFlowEntryDto;
import com.echodesign.caffetteriebomsabor.models.CashFlowEntry;
import com.echodesign.caffetteriebomsabor.services.CashFlowService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/cashflow")
public class CashFlowController {

	private final CashFlowService service;
	
	public CashFlowController(CashFlowService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Page<CashFlowEntry>> findAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
		Optional<CashFlowEntry> cashFlowEntryOptional = service.findById(id);
		
		if (!cashFlowEntryOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(cashFlowEntryOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<CashFlowEntry> save(@RequestBody @Valid CashFlowEntryDto cashFlowEntryDto) {
		CashFlowEntry cashFlowEntry = new CashFlowEntry();
		BeanUtils.copyProperties(cashFlowEntryDto, cashFlowEntry);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cashFlowEntry));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
		Optional<CashFlowEntry> cashFlowEntry = service.findById(id);
		
		if (!cashFlowEntry.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found!");
		}
		
		service.delete(cashFlowEntry.get());
		return ResponseEntity.status(HttpStatus.OK).body("Entry deleted successfully");
	}
}
