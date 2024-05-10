package com.fsb.firstSpringBootApp.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.firstSpringBootApp.models.Stat; // Correct the import to State entity

@Repository
public interface State_rep extends JpaRepository<Stat, Long> {
    // You can add custom repository methods here if needed
}
