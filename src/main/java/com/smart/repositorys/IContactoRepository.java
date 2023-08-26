package com.smart.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.entities.Contacto;
@Repository
public interface IContactoRepository extends JpaRepository<Contacto, Integer>{

}
