package com.fsb.firstSpringBootApp.rep;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fsb.firstSpringBootApp.models.Produit;

@Repository
public interface Produit_rep extends JpaRepository<Produit, Long> {
    List<Produit> findBynumpro(String img);
}