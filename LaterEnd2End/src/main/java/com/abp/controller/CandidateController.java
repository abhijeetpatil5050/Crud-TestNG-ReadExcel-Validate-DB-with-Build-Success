package com.abp.controller;

import java.util.List;

import com.abp.constants.AppLevelConstants;
import com.abp.entities.CandidateEntity;
import com.abp.service.CandidateService;
import com.abp.serviceimpl.CandidateServiceImpl;

public class CandidateController {
	

	
	
	public String validateUserCredentails(String username, String password){
		String dbUserName =null;
		String dbPassword = null;
		try{
			CandidateService service = new CandidateServiceImpl();
			List<CandidateEntity> candidates = service.getAllCandidates(); //make sure one record is there-- for now consider this as an assumption
			for (CandidateEntity ce : candidates) {
				dbUserName= ce.getCandidateUserName();
				dbPassword = ce.getCandidatePassword();
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(dbUserName==null){
				dbUserName="";
			}
			if(dbPassword==null){
				dbPassword="";
			}
		}
		if(username==null&&password==null)
			return AppLevelConstants.INVALID_USERNAME_PASSWORD;

		if(username==null){
			return AppLevelConstants.USERNAME_CANNOT_BE_EMPTY;
		}else if(password==null){
			return AppLevelConstants.PASSWORD_CANNOT_BE_EMPTY;
		}else if(dbUserName.equals(username) && dbPassword.equals(password)){
			return AppLevelConstants.LOGIN_SUCCESS;
		}
		return AppLevelConstants.INVALID_USERNAME_PASSWORD;
		
	}

}
