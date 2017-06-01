package pruebas;    
/**
 * Genera fechas aleatorias
 * @author hector pasarin
 */
import testrecogercsv.*;
import java.util.Date;
import java.util.Random;
//import org.jfree.data.time.TimeSeries;
    
    public  class RandomTime {
    	
        /**
        @class genera fecha aleatoria
        @return devuelve una fecha aleatoria en formato dd/MM/yyyy
        */
        static int dia;
        static int mes;
        static int ano;
        static String cadenaDia;
        static String cadenaMes;
        static String cadenaAno;
        /**
        @author hector pasarin
        @return devuelve una fecha
        * 
        * <span style="text-decoration:underline;">underlined text</span>
                */
    	public static String CrearFechaAleatoria(){
    	
            Random genAlea = new Random();
               
               
                mes = genAlea.nextInt(4)+2;
            
               
                
                
                switch (mes) {
                    //por si acaso sale 0, ponemos dia 15
                    case (0):
                    dia= 15;
                    break;
                    
                    
                    case (1):
                    dia= genAlea.nextInt(15)+13;
                    break;
                    case (3):
                    dia= genAlea.nextInt(30)+1;
                    break;
                    case (5):
                    dia= genAlea.nextInt(30)+1;
                    break;
                    case (7):
                    dia= genAlea.nextInt(30)+1;
                    break;
                    case (9):
                    dia= genAlea.nextInt(30)+1;
                    break;
                    case (11):
                    dia= genAlea.nextInt(30)+1;
                    break;
                    
                    
                    //mes de 28 dias
                    case (2):   //FEBRERO
                    dia= genAlea.nextInt(28-13)+13;
                    break;
                    
                    
                    case (4):
                    dia= genAlea.nextInt(29)+1;
                    break;
                    case (6):
                    dia= genAlea.nextInt(29)+1;
                    break;
                    case (8):
                    dia= genAlea.nextInt(29)+1;
                    break;
                    case (10):
                    dia= genAlea.nextInt(29)+1;
                    break;
                    case (12):
                    dia= genAlea.nextInt(29)+1;
                    break;
                default:
                        dia=15;
            }
                
                
                
                cadenaAno="2017";
                
                if (dia<10) {
                 cadenaDia = "0"+(String.valueOf(dia));
            }else cadenaDia = String.valueOf(dia);
                
                if (mes<10) {
                 cadenaMes = "0"+(String.valueOf(mes));
            }else cadenaMes = String.valueOf(mes);
                
                String fecha = cadenaDia+"/"+cadenaMes+"/"+cadenaAno;
                System.out.println(fecha);
                
                return fecha;
                
                   		
    	}
    	
    	
    } 