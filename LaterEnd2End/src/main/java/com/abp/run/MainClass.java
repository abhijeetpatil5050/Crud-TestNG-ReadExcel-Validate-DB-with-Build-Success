package com.abp.run;

import java.util.List;
import java.util.Scanner;

import com.abp.entities.CandidateEntity;
import com.abp.service.CandidateService;
import com.abp.serviceimpl.CandidateServiceImpl;

public class MainClass {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		CandidateEntity ce = new CandidateEntity(1, "abhijeet", "abhi@1");
		CandidateService cs = new CandidateServiceImpl();
		
		System.out.println("Enter below choice to perform");
		System.out.println("1.To add candidate\n2.To delete candidate\n3.To update candidate\n4.To get all candidate\n5.To get single candidate ");
		int usersChoice = sc.nextInt();
		switch(usersChoice) {
		
		case 1:
			boolean isAdded = cs.addCandidate(ce);
			System.out.println("Is Candidate Addedd " + isAdded);
			break; 
		case 2:
			boolean isDeleted = cs.deleteCandidate(2);
			System.out.println("Is Candidate Deleted " + isDeleted);
			break; 
		case 3:
			boolean isUpdated= cs.updateCandidate(new CandidateEntity(3, "abhijeet3", "abhi@3"));
			System.out.println("Is Candidate Updated " + isUpdated);
			break; 
		case 4:
			List<CandidateEntity> listofEntites = cs.getAllCandidates();
			System.out.println("List Of DB Entities " + listofEntites);
			break; 
		case 5:
			CandidateEntity EntityFrmDb = cs.getCandidate(1);
			System.out.println("DBEntity -- " + EntityFrmDb);
			break; 
		
		}
		
		/*boolean isAdded = cs.addCandidate(ce);
		System.out.println("Is Candidate Addedd " + isAdded);
		
		boolean isDeleted = cs.deleteCandidate(2);
		System.out.println("Is Candidate Deleted " + isDeleted);
		
		boolean isUpdated= cs.updateCandidate(new CandidateEntity(3, "abhijeet3", "abhi@3"));
		System.out.println("Is Candidate Updated " + isUpdated);
		
		List<CandidateEntity> listofEntites = cs.getAllCandidates();
		System.out.println("List Of DB Entities " + listofEntites);
		
		CandidateEntity EntityFrmDb = cs.getCandidate(1);
		System.out.println("DBEntity -- " + EntityFrmDb);*/
		
		
	}

}
