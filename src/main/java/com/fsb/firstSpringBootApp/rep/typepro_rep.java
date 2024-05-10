package com.fsb.firstSpringBootApp.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 import com.fsb.firstSpringBootApp.models.Type_pro;
@Repository
public interface typepro_rep extends JpaRepository<Type_pro, Long>  {

}
