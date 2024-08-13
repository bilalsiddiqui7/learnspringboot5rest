package com.example.learnspringboot5rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learnspringboot5rest.model.Alien;

@Repository
public interface AlienRepo extends JpaRepository<Alien,Integer>{

}
