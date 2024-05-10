package com.fsb.firstSpringBootApp.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.firstSpringBootApp.models.Categorie_pro;

@Repository

public interface categoriepro_rep extends JpaRepository<Categorie_pro, Long> {

}
