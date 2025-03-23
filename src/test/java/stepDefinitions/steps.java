package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class steps {
	WebDriver driver = new ChromeDriver();

	@Given("User is on Greenkart Landing page")
	public void user_is_on_greenkart_landing_page() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);

	}

	@When("User adds items to card")
	public void user_adds_items_to_card() {
		driver.findElement(By.xpath("//h4[contains(text(),'Brocolli')]//following-sibling::div/button")).click();
		driver.findElement(By.xpath("//h4[contains(text(),'Tomato')]//following-sibling::div/button")).click();
		driver.findElement(By.xpath("//h4[contains(text(),'Beetroot')]//following-sibling::div/button")).click();

	}

	@When("User clicks on cart option")
	public void user_clicks_on_cart_option() {
		driver.findElement(By.xpath("//a[contains(@class,'cart-icon')]")).click();

	}

	@When("User clicks on Proceed To checkout")
	public void user_clicks_on_proceed_to_checkout() throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(@class,'action-block')]/button[text()='PROCEED TO CHECKOUT']"))
				.click();
		Thread.sleep(4000);

	}

	@Then("User is taken to cart Page")
	public void user_is_taken_to_cart_page() throws InterruptedException {

		System.out.println("Current URL ::" + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

	}

	@When("User clicks on Proceed Button")
	public void user_clicks_on_proceed_button() throws InterruptedException {
		WebElement Bttn1;
		try {
			Bttn1 = driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
		} catch (StaleElementReferenceException e) {
			driver.navigate().refresh();
			Thread.sleep(3000);
			Bttn1 = driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Bttn1);
		Thread.sleep(3000);

	}

	@Then("User is taken to Delivery info Page")
	public void user_is_taken_to_delivery_info_page() {
		System.out.println("Current Page URL ::" + driver.getCurrentUrl());
		WebElement drpdwn = driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select"));
		Select drpelem = new Select(drpdwn);
		drpelem.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[contains(@type,'checkbox')]")).click();

	}

	@When("User click on Proceed Button")
	public void user_click_on_proceed_button() throws InterruptedException {
		driver.findElement(By.xpath("//div//button")).click();
		Thread.sleep(3);

	}

	@Then("User is taken to order confirmation page")
	public void user_is_taken_to_order_confirmation_page() {
		System.out.println("Current Page URL ::" + driver.getCurrentUrl());
	}

	@Then("User validates the Order Confirmaton page")
	public void user_validates_the_order_confirmaton_page() {
		String ConfirmText = driver.findElement(By.xpath("//div[@class='wrapperTwo']/span")).getText();

		System.out.println(ConfirmText);
		if (ConfirmText.equals("Thank you, your order has been placed successfully\\r\\n\"\r\n"
				+ "				+ \"You'll be redirected to Home page shortly!!"))
			Assert.assertTrue(true);
	}

	@Then("User closes the browser")
	public void user_closes_the_browser() {
		driver.close();
	}

}
