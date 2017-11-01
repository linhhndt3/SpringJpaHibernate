package com.websystique.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ShopDao {
	
}
