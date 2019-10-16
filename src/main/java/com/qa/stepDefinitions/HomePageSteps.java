package com.qa.stepDefinitions;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.Testbase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomePageSteps extends Testbase {

	LoginPage loginpage;
	HomePage homepage;

	@Given("^user opens browser$")
	public void user_opens_browser() {
		Testbase.initialization();
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() {
		loginpage = new LoginPage();
		String title = loginpage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}

	@Then("^user logs into app$")
	public void user_enters_username_and_password() throws InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^validate home page title$")
	public void validate_home_page_title() {
		String homeTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homeTitle);
	}

	@Then("^close the broser$")
	public void close_the_browser() {
		driver.quit();
	}
}
