package com.ltech.ltech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltech.ltech.Entity.FormsEntity;

@Repository
public interface FormsRepository extends JpaRepository<FormsEntity, Integer>{
    
}
