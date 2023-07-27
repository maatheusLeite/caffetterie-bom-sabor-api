package com.echodesign.caffetteriebomsabor.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.echodesign.caffetteriebomsabor.models.CashFlowEntry;
import com.echodesign.caffetteriebomsabor.repositories.CashFlowRepository;

import jakarta.transaction.Transactional;

@Service
public class CashFlowService {

	private final CashFlowRepository repository;
	
	public CashFlowService(CashFlowRepository repository) {
		this.repository = repository;
	}
	
	public Page<CashFlowEntry> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Optional<CashFlowEntry> findById(Integer id) {
		return repository.findById(id);
	}
	
	@Transactional
	public CashFlowEntry save(CashFlowEntry cashFlowEntry) {
		return repository.save(cashFlowEntry);
	}
	
	@Transactional
	public void delete(CashFlowEntry cashFlowEntry) {
		repository.delete(cashFlowEntry);
	}
}
