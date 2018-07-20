package com.abp.util;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.abp.controller.CandidateController;

public class PerfomAuthenticationTest {

	
	@DataProvider
	public Object[][] getTestData(){
		return ReadDataFromExcelUtil.readTestData();
	}
	
	
	@Test(dataProvider="getTestData")
	public void perfomLogin(String uname,String pwd,String emsg){
		System.out.println(uname +"----" +pwd +" ---" +emsg);
		
		CandidateController candcotrlr = new CandidateController();
		String actualMsg = candcotrlr.validateUserCredentails(uname, pwd);
		Assert.assertEquals(actualMsg, emsg);
	}
	
	
}
