//login admin---> click on restaurant---> click on edit category---> pick restaurant --->edit retraurant category---> save 
package AutomationTestCases;

import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;

import ObjectRepository.RestaurantPage;
import ObjectRepository.TabNames;

public class AutomationTestCase4EditcategoryfromAdminporatl_Test extends BaseClass{
	@Test
	public void testCase4Test() {
		String admurl = fileUtility.getDataFromPropertyFile("admurl");
		String adnusername = fileUtility.getDataFromPropertyFile("adnusername");
		String adnpassword = fileUtility.getDataFromPropertyFile("adnpassword");
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, admurl);
		loginPage.adminLogInAction(adnusername, adnpassword);
		commonPage.clickRequiredTab(TabNames.Restaurant, webDriverUtility);
		RestaurantPage restaurant = new RestaurantPage(driver);
		restaurant.adminClickOnRAddCategory();
		String categoryName= "African";
		commonPage.editCategoryName(categoryName, webDriverUtility);
		commonPage.pickcategoryName();
		String updatedCategoryName= "African";
		commonPage.updateCategoryName(updatedCategoryName);
		System.out.println("Category updated successfully");
		logoutpage.logOutAction();
}
}