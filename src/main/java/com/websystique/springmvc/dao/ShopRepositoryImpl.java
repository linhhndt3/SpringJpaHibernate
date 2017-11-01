package com.websystique.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Shop;

@EnableTransactionManagement
public class ShopRepositoryImpl implements ShopDao {

	Logger log = Logger.getLogger(ShopRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insertShop(Shop shop) {
		try {
			System.out.println("insert shoop nnnnnnnnnnn");
			
//			String iQ = "INSERT INTO shops (name, emplNumber) VALUES ('testshop', 123)";
//			int rs = entityManager.createQuery(iQ).executeUpdate();
//			System.out.println("--->>> rs: " +rs);
			
			String insertQuery = "INSERT INTO shops (name, employees_number) VALUES (:name, :emplNumber)";
			Query query = entityManager.createNativeQuery(insertQuery);
			query.setParameter("name", "avx");
			query.setParameter("emplNumber", 1);
			query.executeUpdate();
			
		} catch(Exception ex) {
			System.out.println("exception");
			log.info( ex.getMessage(), ex);
		}
	}


}
