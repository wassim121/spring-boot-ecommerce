package com.fsb.firstSpringBootApp.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.firstSpringBootApp.models.Profil;

 @Repository
public interface Profil_rep extends JpaRepository<Profil, Long> {

	 Profil findByiduser(Long id);
}
