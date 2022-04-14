package com.loca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loca.modal.DemandeLocation;


public interface DemandeLocationDao extends JpaRepository<DemandeLocation, Long> {

}
