package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.MonsterCard;
import com.revature.utility.HibernateSessionFactory;

/*
 * Repository is a Spring stereotype that denotes that we want Spring to add
 * a bean of this type to our IOC container.
 */
@Repository(value = "monsterCardRepository2")
public class MonsterCardRepositoryImpl implements MonsterCardRepository {

	// Of course we still use the DAO design pattern! We're just using
	// Hibernate to implement the methods now!
	@Override
	public void insert(MonsterCard monsterCard) {
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			//This method persists the MonsterCard; creates a new record
			//in the table.
			s.save(monsterCard);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

	@Override
	public List<MonsterCard> findAllMonsterCards() {
		List<MonsterCard> cards = new ArrayList<>();

		// All of our work is done within the context of a Hibernate session.
		Session s = null;
		// This interface gives you control over your transactions. You can use
		// it to rollback changes, commit changes, and start transactions!
		Transaction tx = null;

		try {
			// Get a Hibernate Session.
			s = HibernateSessionFactory.getSession();
			// Begin Transaction
			tx = s.beginTransaction();
			// Hibernate has its own query language called "HQL - Hibernate Query
			// Language" which allows us to emphasize our Java models rather than the
			// entities in the database. It gives us a more object-oriented approach to
			// data persistence.
			cards = s.createQuery("FROM MonsterCard", MonsterCard.class).getResultList();
			// Commit our transaction.
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// If something goes wrong, rollback the changes you've made during
			// this transaction.
			tx.rollback();
		} finally {
			s.close();
		}

		return cards;
	}

	@Override
	public void update(MonsterCard monsterCard) {
		
	}

	@Override
	public void delete(MonsterCard monsterCard) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(monsterCard);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}

	}

	@Override
	public MonsterCard findMonsterCardByName(String name) {
		
		Session s = null;
		Transaction tx = null;
		MonsterCard card = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<MonsterCard> cq = cb.createQuery(MonsterCard.class);
			Root<MonsterCard> root = cq.from(MonsterCard.class);
			cq.select(root).where(cb.equal(root.get("name"), name));
			Query<MonsterCard> q = s.createQuery(cq);
			//What you choose to do with the Query is entirely dependent
			//upon your schema. Some of the methods absolutely require that
			//you use them only under certain circumstances. For instance, 
			//you shouldn't call getSingleResult() if more than one record
			//will be returned!
			card = q.getSingleResult();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return card;
	}

}
