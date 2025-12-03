package com.Delivey.pageObjects;

import org.openqa.selenium.By;

import com.Delivery.testCases.BaseClass;

public class WebTable_Handle extends BaseClass {

	public void webtable() {

		// 1) How many rows in table

		int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
		System.out.println("Total number of rows in a table:" + rows); // 5

		// 2) How many columns in a table

		int cols = driver.findElements(By.xpath("//table[@class='data-list']//thead/tr/th")).size();
		System.out.println("Total number of columns in a table:" + cols); // 6

		// 3) Retrieve the specific row/column data
		String value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
		System.out.println("The value is:" + value);

		// 4) Retrieve all the data from the table

		System.out.println("Data from the table.........");
		for (int r = 1; r <= rows; r++) // 1 2
		{
			for (int c = 1; c <= cols; c++) // 1 2 3 4 5 6..
			{
				String data = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[" + c + "]"))
						.getText();
				System.out.print(data + "     ");
			}
			System.out.println();
		}

	}

}
