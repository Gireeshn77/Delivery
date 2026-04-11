package com.Delivey.pageObjects;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks {
	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = null;

		driver.get("http://www.deadlinkcity.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		int brokenLinks = 0;

		for (WebElement element : links) {
			String url = element.getDomAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}

			URL link = new URL(url);

			try {
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();
				if (httpconn.getResponseCode() >= 400) {
					System.out.println(httpconn.getResponseCode() + url + " is " + " Broken link");
					brokenLinks++;
				} else {
					System.out.println(httpconn.getResponseCode() + url + " is " + " Valid Link");
				}

			} catch (Exception e) {

			}	

		}

		System.out.println("Number of broken links:" + brokenLinks);
		driver.quit();

	}

}
