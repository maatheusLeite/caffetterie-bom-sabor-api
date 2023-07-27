package com.echodesign.caffetteriebomsabor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echodesign.caffetteriebomsabor.models.CashFlowEntry;

public interface CashFlowRepository extends JpaRepository<CashFlowEntry, Integer> {

}
