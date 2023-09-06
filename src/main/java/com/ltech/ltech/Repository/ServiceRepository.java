package com.ltech.ltech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltech.ltech.Entity.ServiceEntity;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer>{
    
}
