package com.Delivey.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetriveAllLinks {

	public static void main(String[] args) {

		WebDriver driver = null;

		driver.findElement(By.linkText("Today's Deals")).click();
		driver.findElement(By.partialLinkText("Deals")).click();

		// How to capture all the links

		List<WebElement> links = driver.findElements(By.tagName("a"));
		// System.out.println("Number of links present:" + links.size());

		// Normal for loop

		/*
		 * for(int i=0; i<=links.size(); i++) {
		 * System.out.println(links.get(i).getText());
		 * System.out.println(links.get(i).getAttribute("href")); }
		 */

		for (WebElement link : links) {
			System.out.println(link.getText());

			// In selenium ver 4 we use getDomeAttribute , here href is the attribure and retrive its value i.e link
		//	System.out.println(link.getAttribute("href"));  // deprecated
			System.out.println(link.getDomAttribute("href"));

		}

	}

}
