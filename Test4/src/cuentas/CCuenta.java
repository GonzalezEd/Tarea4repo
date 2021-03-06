package cuentas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase realiza el comportamiento de una cuenta bancaria, ingreso de dinero, retirada y consulta de saldo
 * 
 * @author Eduardo
 * @version 1.0
 * @since 03/03/2020
 * @see <a href = https://docs.oracle.com/javase/7/docs/api/java/io/IOException.html> Clase IOException de java </a>
 * 
 */

public class CCuenta {

	/**
	 * @return
	 * ATRIBUTOS DE LA CLASE CCUENTA ENCAPSULADOS CON 
	 * VISUALIZACION PRIVADA Y CON GET Y SETS GENERADOS
	 * 
	 */
  
    protected String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInter�s;

    
    public CCuenta ()    
    {
    	/**
    	 * @return
    	 * CONSTRUCTOR DE LA CLASE CCUENTA POR DEFECTO
    	 * 
    	 */
    }
    
    public CCuenta (String nom, String cue, double sal, double tipo) 
    {
    	/**
    	 * CONSTRUCTOR DE LA CLASE CCUENTA CON PARAMETROS
    	 * @return
    	 */
        nombre =nom;
        cuenta=cue;
        saldo=sal;
        tipoInter�s=tipo;
    }
   
    public void asignarNombre(String nom)
    {
        nombre=nom;
    }
    
    public String obtenerNombre()
    {
        return nombre;
    }

    
     public double estado ()
    {
        return saldo;
    }

    
    public void ingresar(double cantidad) throws Exception  
    {
    	 /**
         * METODO INGRESAR, COMPRUEBA QUE LA CANTIDAD A INGRESAR NO ES MENOR QUE 0
         * @return
         */
        if (cantidad<0){
            throw new Exception("No se puede ingresar una cantidad negativa");}
        setSaldo(saldo + cantidad);
    }



    
    public void retirar (double cantidad) throws Exception
    {
    	/**
    	 * METODO RETIRAR, COMPRUEBA QUE LA CANTIDAD A RETIRAR NO SEA MENOR QUE 0 Y QUE LA CUENTA
    	 * DISPONGA DE LA CANTIDAD
    	 * @return
    	 */
        if (cantidad < 0){
            throw new Exception ("No se puede retirar una cantidad negativa");}
        if (estado()< cantidad){
            throw new Exception ("No se hay suficiente saldo");}
        setSaldo(saldo - cantidad);
    }
    
    public String obtenerCuenta ()
    {
        return cuenta;
    }

  
  public void setCuenta(String cuenta) {
    this.cuenta = cuenta;
  }

  
  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  
  public double getTipoInter�s() {
    return tipoInter�s;
  }

 
  public void setTipoInter�s(double tipoInter�s) {
    this.tipoInter�s = tipoInter�s;
  }

static void operativa_cuenta(float cantidad) {
	/**
	 * METODO OPERATIVA CUENTA GENERADO A PARTIR DE LA CLASE MAIN
	 * @return
	 */
		CCuenta cuenta1;
        double saldoActual;
        int opcion=0;
        cuenta1 = new CCuenta("Juan López","1000-2365-85-123456789",2500,0);
        do{
            try {
                System.out.println("MENÚ DE OPERACIONES");
                System.out.println("-------------------");
                System.out.println("1 - Ingresar");
                System.out.println("2 - Retirar");
                System.out.println("3 - Finalizar");
                opcion=Integer.parseInt(Main.dato.readLine());
                if(opcion==1){
                    System.out.println("¿Cuánto desea ingresar?: ");
                    float ingresar=Integer.parseInt(Main.dato.readLine());
                    Main.operativa_cuenta(cuenta1,ingresar,opcion);
                }else if(opcion==2){
                    System.out.println("¿Cuátno desea retirar?: ");
                    float retirar=Integer.parseInt(Main.dato.readLine());
                    Main.operativa_cuenta(cuenta1,retirar,opcion);
                }else if(opcion==3){
                    System.out.println("Finalizamos la ejecución");
                }else{
                    System.err.println("Opción errónea");
                }
/*                switch(opcion){
                    case 1:
                        System.out.println("¿Cuánto desea ingresar?: ");
                        float ingresar=Integer.parseInt(dato.readLine());
                        operativa_cuenta(miCuenta,ingresar,opcion);
                        break;
                    case 2:
                        System.out.println("¿Cuátno desea retirar?: ");
                        float retirar=Integer.parseInt(dato.readLine());
                        operativa_cuenta(miCuenta,retirar,opcion);
                        break;
                    case 3:
                        System.out.println("Finalizamos la ejecución");
                }
*/            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while (opcion!=3);
        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es"+ saldoActual );
	}
}