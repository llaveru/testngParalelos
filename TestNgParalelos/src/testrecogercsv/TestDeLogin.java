/*

con esto obtenemos datos entre dos fechas que le digamos, sin concurrencia.



 * Login:

http://verif-desarrollo.tks.local/login

Email: jaime.serrano@grupotks.com
Clave: 12345

Repetir X veces:

A la izquierda pinchar:
Base de datos > Verificaciones por rango

Meter fechas >> mostrar y pulsar CSV


Un saludo,
Rubén


 */
package testrecogercsv;

import com.steadystate.css.parser.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author hpasarin
 */
public class TestDeLogin {

    static String fechaI,fechaF;
    static UsuarioTKS u1;
    static WebDriver driver;
    static WebElement bannerError;
    static WebElement parrafoErrorUsuario;
    static WebElement casillaUserName, casillaFullName, casillaEmail, casillaPassword,enlaceBD,enlaceVR,inputFI,inputFF,botonMostrar,botonExportarCSV,enlaceGuardarCSV;
    static WebElement botonEnvioRegistro;
    static String mensajeError;
    static WebElement  botonLogearse;
      static   Date fechaDateI = null;
      static  Date fechaDateF = null;
        static SimpleDateFormat formato;
        static Fechas fecha;
        
        
    static final String urlLogin="http://verif-desarrollo.tks.local/intranet-edp/informes/rango";
    //static final String urlLogin="http://verif-desarrollo.tks.local/login";
    /**
     * @param args the command line arguments
     */
    public static ArrayList<Fechas> arrayFechas=null;
    
    
    public static void main(String[] args) throws InterruptedException, java.text.ParseException {
        
        //inicializo con algunos datos el arrayList de fechas.
        inicializarArrayFechas(5);
        
        //indicamos la ruta del ejecutable Chromedriver.exe
        String exePath = "C:\\Users\\hpasarin\\Desktop\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        driver = new ChromeDriver();

        //creo un nuevo usuario que será el que registremos:
       u1 = new UsuarioTKS("jaime.serrano@grupotks.com","12345");

        try {
            //navego a taiga.io y compruebo que no da errores
            driver.navigate().to(urlLogin);
        } catch (Exception e) {
            JOptionPane dialogo = new JOptionPane();
            dialogo.showMessageDialog(null, "No se ha podido conectar a la web.");
        }
        Thread.sleep(3000);

        //entro en la pantalla de registro: para ello uso un css selector, aunque mejor usar un id o name por futuros cambios en la 
        //estructura de la web.
        //WebElement casillaUserLogin = driver.findElement(By.id("email"));
        //casillaUserLogin.click();
        //Thread.sleep(3000);


        //creo los elementos a los cuales pasarles los datos de registro:

        //casillaUserName = driver.findElement(By.name("email"));
        

//casillaFullName = driver.findElement(By.name("full_name"));
        //casillaEmail = driver.findElement(By.name("email"));
//        casillaPassword = driver.findElement(By.name("pass"));
  //      botonLogearse = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/form/button"));

        //registro el usuario de los datos anteriores
    //    hacerLogin();

        
        //espero un poco
        Thread.sleep(1000);
        
       
        
         
         
             
         
         
                System.out.println("_______________________________________________________");
                for (int i = 0; i < arrayFechas.size(); i++) {
                    //abrir link en ventana nueva
         
                    System.out.println("Test numero: "+i+" entre fechas: "+arrayFechas.get(i).fi+" - "+arrayFechas.get(i).ff);
//                      enlaceBD = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
  //                   enlaceVR   = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
                    
                     
                     
    //                 enlaceBD.click();
                    Thread.sleep(200);
                    //para abrir en nueva tab
      //              String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
                    
        //            enlaceVR.sendKeys(selectLinkOpeninNewTab);
                    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                    driver.switchTo().window(tabs2.get(tabs2.size()-1));
                    
                    //enlaceVR.click();
                    Thread.sleep(200);
                    
                inputFI = driver.findElement(By.xpath("//*[@id=\"fechaInicio\"]"));
                inputFF= driver.findElement(By.xpath("//*[@id=\"fechaFin\"]"));
         
                inputFI.sendKeys(arrayFechas.get(i).fi);
                Thread.sleep(200);
                inputFF.sendKeys(arrayFechas.get(i).ff);
                Thread.sleep(200);
                
                botonMostrar = driver.findElement(By.id("mostrarVerificaciones"));
                
     
                botonMostrar.click();
                                Thread.sleep(200);

                botonExportarCSV = driver.findElement(By.id("botonExportarCSV"));
                botonExportarCSV.click();
        
                Thread.sleep(200);
                }
                
         
                
                                
                                
               /*                 
               botonExportarCSV = driver.findElement(By.id("botonExportarCSV"));
               botonExportarCSV.click();
                
                //AL PULSAR EL BOTON DE Exportar a CSV, tarda un poco en prepararse la descarga
                // y luego aparece un enlace de descarga:
                //hago un while que espere a que esté lista la descarga:
                
                
               enlaceGuardarCSV = driver.findElement(By.xpath("//*[@id=\"enlace\"]"));
                    
                do {
            Thread.sleep(70);
        } while (enlaceGuardarCSV.isDisplayed()==false);

                enlaceGuardarCSV.click();
                
                Thread.sleep(5000);
                
                */
                //driver.close();
                
        
        

        
        
    }

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

    public static void gestionarError() {
        //segun el texto del error hace una cosa u otra:
        if (mensajeError.contains("username")) {
            System.out.println("Error con el nombre de usuario");
        }

        String usuarioNuevo = JOptionPane.showInputDialog(null, "Escriba un nombre nuevo");
        casillaUserName.clear();
        casillaUserName.sendKeys(usuarioNuevo);
        //y guardo en u1 el nuevo nombre
        u1.setEmail(usuarioNuevo);
        //y vuelvo a hacer click en el boton de registro
        botonEnvioRegistro.click();
    }

    public static void inicializarArrayFechas(int numeroIntervalos) throws java.text.ParseException {
        
        arrayFechas= new ArrayList<>();
        
        
        //genero dos fechas aleatorias, si la segunda es mas nueva que la primera, daría error
        //así que cambio la segunda por la primera:
        
        //puedo acceder al metodo de la clase RT por ser publico y estatico
    
        
        for (int i = 0; i < numeroIntervalos; i++) {
        do {
             fechaI= RandomTime.CrearFechaAleatoria();
             fechaF = RandomTime.CrearFechaAleatoria();
        
        
         formato = new SimpleDateFormat("dd/MM/yyyy");
        
        fechaDateI = formato.parse(fechaI);
        fechaDateF = formato.parse(fechaF);
        
        } while (fechaDateI.after(fechaDateF));
        
         fecha = new Fechas(fechaI,fechaF);     
        
        arrayFechas.add(fecha);            
        }

   
    }

    public static class Fechas {

       public String fi ="";
        public String ff="";

        public Fechas(String fi,String ff) {
       this.ff=ff;
       this.fi=fi;
        }

        public String getFi() {
            return fi;
        }

        public void setFi(String fi) {
            this.fi = fi;
        }

        public String getFf() {
            return ff;
        }

        public void setFf(String ff) {
            this.ff = ff;
        }

       
        
        
        
        
    }

    
    
}
