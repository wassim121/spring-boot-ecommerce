package com.fsb.firstSpringBootApp.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 import com.fsb.firstSpringBootApp.models.User;

 @Repository
public interface User_rep extends JpaRepository<User, Long>  {

	    List<User> findByname(String name);

}
