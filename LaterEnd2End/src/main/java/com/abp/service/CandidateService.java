package com.abp.service;

import java.util.List;

import com.abp.entities.CandidateEntity;

public interface CandidateService {

	public boolean addCandidate(CandidateEntity candidate);
	public boolean deleteCandidate(int candidateId);
	public CandidateEntity getCandidate(int candidateId);
	public boolean updateCandidate(CandidateEntity candidate);
	public List<CandidateEntity> getAllCandidates();
	//public List<CandidateEntity> searchEmp(HashMap<AppLevelConstants.EmpFields,String> searchCriteria);
	
	
}
