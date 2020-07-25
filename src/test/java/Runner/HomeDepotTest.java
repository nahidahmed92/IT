package Runner;

import java.util.Date;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.CreateDepotAccount;
import Pages.Homepage;
import Sites.PageObjectModelFramework.Base;

public class HomeDepotTest extends Base {
  @Test(priority = 1)
  public void verification() {
	  Homepage homepage = new Homepage(driver);
	  String myAccountText = homepage.myAccountTextVerification();
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertEquals(myAccountText, "My Account");
	  String youreShoppingText = homepage.youreShoppingTextVerification();
	  softAssert.assertEquals(youreShoppingText, "You're shopping Starrett City OPEN until 8 pm");
	  String storeFinderText = homepage.storeFinderTextVerification();
	  softAssert.assertEquals(storeFinderText, "Store Finder");
	  softAssert.assertAll();
  }
  @Test (priority = 2)
  public void createTheAccount() throws InterruptedException {
	  Homepage homepage = new Homepage(driver);
	  homepage.myAccountClick();
	  Thread.sleep(3000);
	  homepage.registerButton();
	  
	  CreateDepotAccount dt = new CreateDepotAccount(driver);
	  String createAccountText = dt.createAnAccountVerification();
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertEquals(createAccountText, "Create an Account");
	  boolean lk = dt.linkds();
	  softAssert.assertEquals(lk, true);
	 // boolean click = dt.createButtonClickable();
	 // softAssert.assertEquals(click, false);
	  Thread.sleep(3000);
	  homepage.Clicktocontinue();
	  Date di = new Date();
	  String ut = di.toString().replace(" ", "_").replace(":", "_");
	  dt.email(di+"home@homedepot.com");
	  dt.passwrd("testinghome258*");
	  dt.phoneNumber("7181234567");
	  dt.zipCode("11001");
	  dt.createButtonAccount();
	  softAssert.assertAll();
	  }
}
