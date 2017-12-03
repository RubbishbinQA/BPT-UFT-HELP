package com.hp.leanft.examples.testng;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.web.*;
import com.hp.lft.unittesting.OutputParameters;
import org.testng.annotations.*;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;

public class AdvantageShoppingBp extends UnitTestClassBase {

	private static final String SiteUrl = "http://www.advantageonlineshopping.com";
	private Browser browser;
    
	@BeforeClass
	public void beforeClass() throws Exception {
	}

	@AfterClass
	public void afterClass() throws Exception {
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
	}

	@AfterMethod
	public void afterMethod() throws Exception {
}

	//Output variablespublic String CartProductCount;
	public String CartTotalValue;

	// Component code to login to Advantage Shopping website and select product.
	@Test(dataProvider="ALM")
	@Parameters({"BrowserType", "Username", "Password", "Category", "Product"})
	@OutputParameters({"CartProductCount"})
	public void loginAndSelectProduct(String browserType, String username, String password, String category, String product) throws ReportException, GeneralLeanFtException, InterruptedException {
		String reportMessage = String.format("browserType='%s', username='%s', password='%s', category='%s', product='%s'", browserType, username, password, category, product);
		Reporter.reportEvent("Input Values: " + reportMessage, reportMessage);

		openAdvantageShoppingSite(browserType);
		login(username, password);
		verifyLoggedUser(username);
		selectProduct(category, product);
		CartProductCount = getCartProductCount();
		reportMessage = String.format("Products in cart: %s", CartProductCount);
		Reporter.reportEvent(reportMessage, reportMessage);
	}

	// Component code to login to Advantage Shopping website and select product.
	@Test(dataProvider="ALM")
	@Parameters({"BrowserType", "Username", "Password", "ProductCount"})
	@OutputParameters({"CartTotalValue"})
	public void loginAndCheckout(String browserType, String username, String password, String productCount) throws ReportException, GeneralLeanFtException, InterruptedException {
		String reportMessage = String.format("browserType='%s', username='%s', password='%s', productCount='%s'", browserType, username, password, productCount);
		Reporter.reportEvent("Input Values: " + reportMessage, reportMessage);

		openAdvantageShoppingSite(browserType);
		login(username, password);
		verifyLoggedUser(username);
		verifyCartProductCount(productCount);

		CartTotalValue = checkout();
		reportMessage = String.format("Total value for checkout is %s", CartTotalValue);
		Reporter.reportEvent(reportMessage, reportMessage);
	}

	private void openAdvantageShoppingSite(String browserType) throws GeneralLeanFtException {
		//Launch the browser.
		browser = BrowserFactory.launch(getBrowserType(browserType));

		//Navigate to the Advantage Shopping website. 
		browser.navigate(SiteUrl);
	}

	private void login(String username, String password) throws GeneralLeanFtException {
		WebElement userPict = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("A")
			.innerText(new RegExpProperty(".*My account.*")).build());
		userPict.click();

		//Enter username and password in the modal dialog
		WebElement usernameDiv = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("DIV")
			.innerText("Username").build());
		EditField userNameField = usernameDiv.describe(EditField.class, new EditFieldDescription.Builder().type("text").build());

		WebElement passwordDiv = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("DIV")
			.innerText("Password").build());
		EditField passwordField = passwordDiv.describe(EditField.class, new EditFieldDescription.Builder().type("password").build());

		userNameField.setValue(username);
		passwordField.setSecure(password);

		WebElement signInLink = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("A")
			.innerText("SIGN IN").build());
		signInLink.click();
	}

	private void verifyLoggedUser(String username) throws GeneralLeanFtException {
		// Verify correct username appears in the header
		WebElement loggedUserField = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("SPAN")
			.className("hi-user containMiniTitle ng-binding").build());
		String loggedUsername = loggedUserField.getInnerText().trim();
		String descr = String.format("Expected username '%s', actual '%s'", username, loggedUsername);
		Verify.areEqual(username.trim(), loggedUsername, "Verify logged user name", descr);
	}

	private void selectProduct(String category, String product) throws GeneralLeanFtException {
		WebElement categoryElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("SPAN")
			.innerText(category)
			.className("shop_now roboto-bold ng-binding").build());
		categoryElement.click();

		WebElement productElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("A")
			.innerText(product).build());
		productElement.click();

		Button addToCartButton = browser.describe(Button.class, new ButtonDescription.Builder()
			.tagName("BUTTON")
			.name("ADD TO CART")
			.buttonType("submit").build());
		addToCartButton.click();
	}

	private String getCartProductCount() throws InterruptedException, GeneralLeanFtException {
		Thread.sleep(1000);
		//Verify the correct products count in the cart
		WebElement cartProductCountElement = browser.describe(WebElement.class, new XPathDescription("//HEADER[1]/NAV[1]/UL[1]/LI[1]/A[1]/SPAN[1]"));
		String actualCartProductsCount = cartProductCountElement.getInnerText();
		return actualCartProductsCount;
	}

	private void verifyCartProductCount(String expectedCartProductsCount) throws InterruptedException, GeneralLeanFtException {
		String actualCartProductsCount = getCartProductCount();
		String descr = String.format("Expecting %s products in the cart, actual count is %s", expectedCartProductsCount, actualCartProductsCount);
		Verify.areEqual(expectedCartProductsCount, actualCartProductsCount, "Verify products count in the cart", descr);
	}

	private String checkout() throws GeneralLeanFtException, ReportException {
		Link cartLink = browser.describe(Link.class, new LinkDescription.Builder()
			.tagName("A")
			.className("img").build());
		cartLink.click();

		Button checkoutButton = browser.describe(Button.class, new ButtonDescription.Builder()
			.tagName("BUTTON")
			.buttonType("submit")
			.name(new RegExpProperty("^CHECKOUT.*"))
			.index(1).build());
		checkoutButton.click();

		WebElement totalValueSpan = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("SPAN")
			.className("roboto-medium totalValue ng-binding").build());
		totalValueSpan.highlight();
		return totalValueSpan.getInnerText();
	}
    
	private BrowserType getBrowserType(String browserTypeParam) {
		if (browserTypeParam.toLowerCase().equals("chrome"))
			return BrowserType.CHROME;
		if (browserTypeParam.toLowerCase().equals("internetexplorer"))
			return BrowserType.INTERNET_EXPLORER;
		if (browserTypeParam.toLowerCase().equals("ie"))
			return BrowserType.INTERNET_EXPLORER;
		if (browserTypeParam.toLowerCase().equals("edge"))
			return BrowserType.EDGE;
		if (browserTypeParam.toLowerCase().equals("firefox"))
			return BrowserType.FIREFOX;
		if (browserTypeParam.toLowerCase().equals("safari"))
			return BrowserType.SAFARI;
		return BrowserType.CHROME;
	}

}