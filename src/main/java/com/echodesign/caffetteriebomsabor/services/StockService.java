package com.echodesign.caffetteriebomsabor.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.echodesign.caffetteriebomsabor.models.StockEntry;
import com.echodesign.caffetteriebomsabor.repositories.StockRepository;

import jakarta.transaction.Transactional;

@Service
public class StockService {

	private final StockRepository repository;
	
	public StockService(StockRepository repository) {
		this.repository = repository;
	}
	
	public Page<StockEntry> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Optional<StockEntry> findById(Integer id) {
		return repository.findById(id);
	}
	
	@Transactional
	public StockEntry save(StockEntry Product) {
		return repository.save(Product);
	}
	
	@Transactional
	public void delete(StockEntry Product) {
		repository.delete(Product);
	}
}
