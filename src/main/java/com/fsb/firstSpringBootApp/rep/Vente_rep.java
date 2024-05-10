package com.fsb.firstSpringBootApp.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 import com.fsb.firstSpringBootApp.models.Vente;
@Repository
public interface Vente_rep extends JpaRepository<Vente, Long>  {
	
	@Query("SELECT MONTH(v.date) as month, COUNT(v) as salesCount FROM Vente v GROUP BY MONTH(v.date)")
	List<Object[]> countSalesPerMonth();


    @Query("SELECT COUNT(v) FROM Vente v")
    int countSales();

}
