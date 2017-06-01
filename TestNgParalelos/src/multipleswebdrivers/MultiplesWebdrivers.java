/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleswebdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author hpasarin
 */
public class MultiplesWebdrivers {

//tendremos que usar hilos que correran runnables
    static Thread hilo1, hilo2, hilo3, hilo4, hilo5;
    static ProcesoParalelo p1, p2, p3, p4, p5;
    static WebDriver d1, d2, d3, d4, d5;

    public static void main(String[] args) {
        arrancarHilos();
    }

    public static void arrancarHilos() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\hpasarin\\Desktop\\chromedriver.exe");

         System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        
        d1 = new ChromeDriver();
        d2 = new ChromeDriver();
        d3 = new ChromeDriver();
        d4 = new ChromeDriver();
        d5 = new ChromeDriver();

        p1 = new ProcesoParalelo(d1);
        hilo1 = new Thread(p1);

        p2 = new ProcesoParalelo(d2);
        hilo2 = new Thread(p2);

        p3 = new ProcesoParalelo(d3);
        hilo3 = new Thread(p3);

        p4 = new ProcesoParalelo(d4);
        hilo4 = new Thread(p4);

        p5 = new ProcesoParalelo(d5);
        hilo5 = new Thread(p5);
        
        hilo1.start();System.out.println("comienza hilo1 ");
        hilo2.start();System.out.println("comienza hilo2 ");
        hilo3.start();System.out.println("comienza hilo3 ");
        hilo4.start();System.out.println("comienza hilo4 ");
        hilo5.start();System.out.println("comienza hilo5 ");

    }

}
