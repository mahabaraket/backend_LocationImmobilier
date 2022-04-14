package com.loca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loca.modal.BienImmobilier;

public interface BienImmobilierDao extends JpaRepository<BienImmobilier, Long> {

}
