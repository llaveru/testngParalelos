/*
en verdad es un runnable no hilo :D
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrecogercsv;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static testrecogercsv.HiloDescarga.casillaUserName;
import static testrecogercsv.TestDeLogin.driver;



/**
 *
 * @author hpasarin
 */
public class HiloDescarga implements Runnable{
    static UsuarioTKS u1;
    static WebDriver driver;
    static WebElement bannerError;
    static WebElement parrafoErrorUsuario;
    static WebElement casillaUserName, casillaFullName, casillaEmail, casillaPassword,enlaceBD,enlaceVR,inputFI,inputFF,botonMostrar,botonExportarCSV,enlaceGuardarCSV;
    static WebElement botonEnvioRegistro;
    static String mensajeError;
    static WebElement  botonLogearse;
    
    static final String urlLogin="http://verif-desarrollo.tks.local/login";
    String fechaInicio="";
    String fechaFin="";

    
    
    
    
    public static void hacerLogin() throws InterruptedException {
        casillaUserName.sendKeys(u1.getEmail());
        //casillaFullName.sendKeys(u1.getFullName());
        //casillaEmail.sendKeys(u1.getEmail());
        casillaPassword.sendKeys(u1.getPassword());
        Thread.sleep(300);

        botonLogearse.click();
        //driver.close();
        Thread.sleep(1000);
    }

    
    
    
    
    public HiloDescarga(String inicio, String fin,WebDriver driver) {
        
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.driver = driver;
        
           System.out.println("creado un nuevo hilo");
    }

    
    
    
    
    @Override
    public void run() {
        
        
        System.out.println("comienza a ejecutarse la tarea del nuevo hilo");
        
       // Random alea = new Random();
        //try {
         //   Thread.sleep(alea.nextInt(10000));
        //} catch (InterruptedException ex) {
          //  Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
       // }
        
       
        

        //creo un nuevo usuario que será el que registremos:
       u1 = new UsuarioTKS("jaime.serrano@grupotks.com","12345");

        try {
            //navego a la pagina en cuestion y compruebo que no da errores
            driver.navigate().to(urlLogin);
        } catch (Exception e) {
            JOptionPane dialogo = new JOptionPane();
            dialogo.showMessageDialog(null, "No se ha podido conectar a la web.");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }

        //entro en la pantalla de registro: para ello uso un css selector, aunque mejor usar un id o name por futuros cambios en la 
        //estructura de la web.
        //WebElement casillaUserLogin = driver.findElement(By.id("email"));
        //casillaUserLogin.click();
        //Thread.sleep(3000);

        //creo los elementos a los cuales pasarles los datos de registro:
        casillaUserName = driver.findElement(By.name("email"));
        //casillaFullName = driver.findElement(By.name("full_name"));
        //casillaEmail = driver.findElement(By.name("email"));
        casillaPassword = driver.findElement(By.name("pass"));
        botonLogearse = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/form/button"));

        try {
            //registro el usuario de los datos anteriores
            hacerLogin();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try {
            //espero un poco
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         enlaceBD = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
        enlaceVR   = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
        
         
         enlaceBD.click();
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }
         enlaceVR.click();
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }

         
                inputFI = driver.findElement(By.xpath("//*[@id=\"fechaInicio\"]"));
                inputFF= driver.findElement(By.xpath("//*[@id=\"fechaFin\"]"));
         
                
         
                inputFI.sendKeys(this.fechaInicio);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }
                inputFF.sendKeys(this.fechaFin);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                botonMostrar = driver.findElement(By.id("mostrarVerificaciones"));
                
     
                botonMostrar.click();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }

                    
                botonExportarCSV = driver.findElement(By.id("botonExportarCSV"));
                botonExportarCSV.click();
                
                //AL PULSAR EL BOTON DE Exportar a CSV, tarda un poco en prepararse la descarga
                // y luego aparece un enlace de descarga:
                //hago un while que espere a que esté lista la descarga:
                
                
                enlaceGuardarCSV = driver.findElement(By.xpath("//*[@id=\"enlace\"]"));
                    
                do {
            try {
                Thread.sleep(70);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (enlaceGuardarCSV.isDisplayed()==false);

                enlaceGuardarCSV.click();
                
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                driver.close();
                
        
        

        
           System.out.println("se acabó el hilo");
    }

   
        
        
        
    }
    
    
    
    
    
        

    
    

   

    




