package com.echodesign.caffetteriebomsabor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echodesign.caffetteriebomsabor.models.StockEntry;

public interface StockRepository extends JpaRepository<StockEntry, Integer> {

}
