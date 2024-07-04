package org.testngwithbaseclasspageobjectmodel;




import org.testng.annotations.Test;

import Pages.Loginpages;

public class AutomateWorktype extends Baseclass1{
	

	@Test()
	public void nonworktype() throws InterruptedException {
		Loginpages ll= new Loginpages(driver);
		ll.userName("bootcamp_2024@testleaf.com")
	     .password("Bootcamp@123")
		 .click()
		 .toggleName()
		 .viewall()
		 .servicesApp();
		
		
		

	}}
	
	
	


