package com.smart.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entities.Contacto;

public interface IContactoRepository extends JpaRepository<Contacto, Integer>{

}
