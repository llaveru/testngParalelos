/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import static testrecogercsv.TestDeLogin.arrayFechas;

public class IndependentTest 
{
    
    
    //importante poner timeout alto
    @Test(threadPoolSize = 25, invocationCount = 5, timeOut = 34000)
    public void testMethod() throws InterruptedException 
    {
        Long id = Thread.currentThread().getId();
        System.out.println("Test method executing on thread with id: " + id);
        
        
         System.setProperty("webdriver.chrome.driver","chromedriver.exe");
     WebDriver driver = new ChromeDriver();
            
            
            // We could use any driver for our tests...
//DesiredCapabilities capabilities = new DesiredCapabilities();

// ... but only if it supports javascript
//capabilities.setJavascriptEnabled(true);


// Get a handle to the driver. This will throw an exception
// if a matching driver cannot be located
 //WebDriver driver = new RemoteWebDriver(capabilities);
            
            //Goto guru99 site
 //  driver.get("http://demo.guru99.com/V4/");
            //find user name text box and fill it
   //         driver.findElement(By.name("uid")).sendKeys("Driver 1");
   
   
   
   ///////////////////////////////////
   
   driver.get("http://verif-desarrollo.tks.local/intranet-edp/informes/rango");
             
                    Thread.sleep(200);
                    
                    //enlaceVR.click();
                    Thread.sleep(200);
                    
             WebElement   inputFI = driver.findElement(By.xpath("//*[@id=\"fechaInicio\"]"));
             WebElement   inputFF= driver.findElement(By.xpath("//*[@id=\"fechaFin\"]"));
         
                inputFI.sendKeys(RandomTime.CrearFechaAleatoria());
                Thread.sleep(200);
                inputFF.sendKeys("31/05/2017");
                Thread.sleep(200);
                
                WebElement botonMostrar = driver.findElement(By.id("mostrarVerificaciones"));
                
     
                botonMostrar.click();
                                Thread.sleep(200);

                WebElement botonExportarCSV = driver.findElement(By.id("botonExportarCSV"));
                botonExportarCSV.click();
        
                Thread.sleep(200);
                }
                
         
   /////////////////////
        
    }
