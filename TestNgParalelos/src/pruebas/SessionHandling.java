/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class SessionHandling {
public static void main(String...strings ){
    //First session of WebDriver
    //WebDriver driver = new FirefoxDriver();
    WebDriver driver = new ChromeDriver();
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\hpasarin\\Desktop\\chromedriver.exe");
    
    //Goto guru99 site
    driver.get("http://demo.guru99.com/V4/");
    
    //Second session of WebDriver
    WebDriver driver2 = new FirefoxDriver();
    //Goto guru99 site
    driver2.get("http://demo.guru99.com/V4/");
}
}