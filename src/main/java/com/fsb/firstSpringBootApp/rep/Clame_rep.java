package com.fsb.firstSpringBootApp.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 import com.fsb.firstSpringBootApp.models.Clame;
@Repository
public interface Clame_rep extends JpaRepository<Clame, Long>  {

}
