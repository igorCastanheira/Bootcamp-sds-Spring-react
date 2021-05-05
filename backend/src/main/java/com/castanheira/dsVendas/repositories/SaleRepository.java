package com.castanheira.dsVendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.castanheira.dsVendas.dto.SaleSuccessDTO;
import com.castanheira.dsVendas.dto.SaleSumDTO;
import com.castanheira.dsVendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.castanheira.dsVendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount )) "
			+ "FROM Sale AS obj GROUP BY  obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new com.castanheira.dsVendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals )) "
			+ "FROM Sale AS obj GROUP BY  obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
