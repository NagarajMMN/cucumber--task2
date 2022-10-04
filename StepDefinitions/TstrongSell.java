package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Objects;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TstrongSell {
	
	WebDriver driver=null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Browser is open");
		System.setProperty("webdriver.chrome.driver", "C:/Users/nagar/eclipse-workspace/cucumberr/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@And("user is on the Trading_view application")
	public void user_is_on_the_trading_view_application() {
		driver.navigate().to("https://in.tradingview.com/");
	}

	@When("user goes to Stocks page")
	public void user_goes_to_stocks_page() {
		driver.findElement(By.xpath("//DIV[@role='button'][text()='Markets']")).click();
		 driver.findElement(By.xpath("//SPAN[@class='menuItemHeader-ml2L5a_a'][text()='Stocks']")).click();
	}

	@When("click on the Quotes tab")
	public void click_on_the_quotes_tab() throws InterruptedException {
		driver.findElement(By.xpath("//A[@href='/markets/stocks-india/market-movers-all-stocks/']")).click();
		 driver.findElement(By.xpath("//button[text()='Load More']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[text()='Load More']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[text()='Load More']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[text()='Load More']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[text()='Load More']")).click();
	}

	@When("get the list of Strong_buy, Strong_sell from the table")
	public void get_the_list_of_strong_buy_strong_sell_from_the_table() {
		 System.out.println("Strong Buy ===================");
		 List<WebElement> buy = driver.findElements(By.xpath("//DIV[@class='container-epNUk8Mp strong_buy-epNUk8Mp']//preceding::sup[1]"));
		 	List<WebElement> sell = driver.findElements(By.xpath("//DIV[text()='Strong Sell']//preceding::sup[1]"));
		 for (WebElement e : buy) {
			 System.out.println(e.getText());
		}
		 System.out.println();
		 System.out.println("Strong Sell==================");
		   for(WebElement sell1 : sell) {
		  		 System.out.println(sell1.getText());			
			 			    
		}System.out.println(Objects.equal(buy, sell));
	}

	@And("compare the list")
	public void compare_the_list() {
		System.out.println();
	}

	@Then("print the result")
	public void print_the_result() {
		System.out.println("matching=======");
	}

}
