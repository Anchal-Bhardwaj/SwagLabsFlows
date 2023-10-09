package org.example;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;


public class  LoginExcel {
    public static void main(String[] args) throws IOException, InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        String excelFilePath = System.getProperty("user.dir")+"\\Files\\Creds.xlsx";

        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Login");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(sheet.getRow(0).getCell(0));

//        Valid Username and Password
        String validUsername = String.valueOf(sheet.getRow(0).getCell(0));
        System.out.println(sheet.getRow(0).getCell(0));
        String validPassword = String.valueOf(sheet.getRow(0).getCell(1));
        System.out.println(sheet.getRow(0).getCell(1));

//        Locked Username and Password
        String invalidUsername = String.valueOf(sheet.getRow(1).getCell(0));
        System.out.println(sheet.getRow(1).getCell(0));
        String invalidPassword = String.valueOf(sheet.getRow(1).getCell(1));
        System.out.println(sheet.getRow(1).getCell(1));

//        Problem User
        String ProblemUsername = String.valueOf(sheet.getRow(2).getCell(0));
        System.out.println(sheet.getRow(2).getCell(0));
        String ProblemPassword = String.valueOf(sheet.getRow(2).getCell(1));
        System.out.println(sheet.getRow(2).getCell(1));


        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("react-burger-cross-btn")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();


        //Checkout
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Anchal");
        driver.findElement(By.id("last-name")).sendKeys("Bhardwaj");
        driver.findElement(By.id("postal-code")).sendKeys("302017");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();


    }
}