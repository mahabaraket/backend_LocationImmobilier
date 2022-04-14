package com.loca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loca.modal.Reclamation;

public interface ReclamationDao extends JpaRepository<Reclamation, Long> {

}
