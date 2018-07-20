package com.abp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CandidateEntity {
	
	@Id
	private int candidateId;
	private String candidateUserName;
	private String candidatePassword;
	
	
	public CandidateEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CandidateEntity(int candidateId, String candidateUserName, String candidatePassword) {
		super();
		this.candidateId = candidateId;
		this.candidateUserName = candidateUserName;
		this.candidatePassword = candidatePassword;
	}


	public int getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}


	public String getCandidateUserName() {
		return candidateUserName;
	}


	public void setCandidateUserName(String candidateUserName) {
		this.candidateUserName = candidateUserName;
	}


	public String getCandidatePassword() {
		return candidatePassword;
	}


	public void setCandidatePassword(String candidatePassword) {
		this.candidatePassword = candidatePassword;
	}


	@Override
	public String toString() {
		return "CandidateEntity [candidateId=" + candidateId + ", candidateUserName=" + candidateUserName
				+ ", candidatePassword=" + candidatePassword + "]";
	}
	
	
	
	

}
