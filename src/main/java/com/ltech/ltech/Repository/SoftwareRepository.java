package com.ltech.ltech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltech.ltech.Entity.SoftwareEntity;

@Repository
public interface SoftwareRepository extends JpaRepository<SoftwareEntity, Integer>{
    
}
