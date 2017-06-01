/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrecogercsv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static testrecogercsv.HiloDescarga.driver;

/**
 *
 * @author hpasarin
 */
public class Descargar {
    
    //los runnables
    static HiloDescarga r1,r2,r3;
    static WebDriver  driver1,driver2,driver3;
    
    public static void main(String[] args) throws InterruptedException {
     
        //indicamos la ruta del ejecutable Chromedriver.exe
        String exePath = "C:\\Users\\hpasarin\\Desktop\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", exePath);



        driver1 = new ChromeDriver();
        driver2= new ChromeDriver();
        driver3= new ChromeDriver();
        


        r1 = new HiloDescarga("14/02/2017","20/02/2017",driver1);
        r2 = new HiloDescarga("20/03/2017","20/04/2017",driver2);
        r3 = new HiloDescarga("30/04/2017","30/05/2017",driver3);
        
     Thread hilo1 = new Thread(r1);
     hilo1.start();
     
     
     Thread.sleep(50);
     
     Thread hilo2 = new Thread(r2);
     hilo2.start();
     Thread.sleep(100);
     
     Thread hilo3 = new Thread(r3);
     hilo3.start();
     Thread.sleep(100);
     
    }
    
    
    
    
}
