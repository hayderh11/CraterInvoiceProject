package utilities;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtils {
	Actions action;
	WebDriverWait wait;
	Select letsSelect;

	// Waits for the element to be visible
	public void waitUntilElementVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Sendkeys with the actions class to the field that is not intractable
	public void actionsSendKeys(WebElement element, String text) {

		action = new Actions(Driver.getDriver());
		action.sendKeys(element, text).build().perform();
	}

	// select by visible text
	public void selectByVisibleText(WebElement selectelement, String tobeSelectedOptionText) {

		letsSelect = new Select(selectelement);
		letsSelect.selectByVisibleText(tobeSelectedOptionText);
	}
	
	// Return the selected option from the dropdown
	
	public String getSelectedOption(WebElement selectElement) {
		letsSelect = new Select(selectElement);
		String option = letsSelect.getFirstSelectedOption().getText();
		return option;
	}
	
	// Random Number
	public int randomNumber() {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 100) + 1) + 100;
		return randomNum;
	}

}
