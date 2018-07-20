package com.abp.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.abp.entities.CandidateEntity;
import com.abp.service.CandidateService;
import com.abp.util.HibernateUtil;

public class CandidateServiceImpl implements CandidateService {

	static SessionFactory sessionFactory = null;

	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	public boolean addCandidate(CandidateEntity candidate) {
		Session session = null;
		Transaction transcation =null;
		try{
			session = sessionFactory.openSession();
			transcation = session.beginTransaction();	
			int id = (Integer)session.save(candidate); //
			HibernateUtil.flushNCommit(session, transcation);
			return id!=0;
		}catch(Exception e){
			transcation.rollback(); 
		}finally{
			HibernateUtil.closeSession(session); 
		}
		return false;
	}

	public boolean deleteCandidate(int candidateId) {
		Session session = null;
		Transaction transcation = null;

		try {
			session = sessionFactory.openSession();
			transcation = session.beginTransaction();
			CandidateEntity dbEntity = session.get(CandidateEntity.class, candidateId);
			if (dbEntity == null)
				return false;
			session.delete(dbEntity);//UPDATE
			HibernateUtil.flushNCommit(session, transcation);
			return true;

		} catch (Exception e) {
			transcation.rollback();
			
		}finally{
			HibernateUtil.closeSession(session);
		}
		return false;
	}

	public CandidateEntity getEmp(int candidateId) {
		Session session = null;
		Transaction transcation = null;
		try {
			session = sessionFactory.openSession();
			transcation = session.beginTransaction();
			return session.get(CandidateEntity.class,candidateId);
		} catch (Exception e) {
			transcation.rollback();
		}finally{
			HibernateUtil.closeSession(session);
		}
		return null;
	}

	public boolean updateCandidate(CandidateEntity candidate) {
		Session session = null;
		Transaction transcation =null;
		try{
			session = sessionFactory.openSession();
			transcation = session.beginTransaction();	
			CandidateEntity entity = (CandidateEntity) session.merge(candidate); //
			HibernateUtil.flushNCommit(session, transcation);
			return entity!=null;
		}catch(Exception e){
			transcation.rollback(); 
		}finally{
			HibernateUtil.closeSession(session); 
		}
		return false;
	}

	public List<CandidateEntity> getAllCandidates() {
		Session session = null;
		Transaction transcation = null;
		try {
			session = sessionFactory.openSession();
			transcation = session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<CandidateEntity> listOfEmpEnties = session.createQuery("from CandidateEntity").list();
			return listOfEmpEnties;
			
		} catch (Exception e) {
			transcation.rollback();
		}finally{
			HibernateUtil.closeSession(session);
		}
		return null;
	}

	public CandidateEntity getCandidate(int candidateId) {
		// TODO Auto-generated method stub
		return null;
	}

}
