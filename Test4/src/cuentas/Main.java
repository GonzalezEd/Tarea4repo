package cuentas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *

 */
public class Main {
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	/*
    	 * METODO MAIN
    	 */
        CCuenta.operativa_cuenta(10);
    }




	public static void operativa_cuenta(CCuenta miCuenta, float cantidad,int opcion){
		/*
		 * METODO OPERATIVA CUENTA CEDIDO POR LOS APUNTES Y QUE NO SE PUEDE MOVER
		 */
        if(opcion==2){
            try 
            {
                miCuenta.retirar(cantidad);
            } catch (Exception e)
            {
                System.out.print("Fallo al retirar");
            }
        }else if(opcion==1){
            try
            {
                System.out.println("Ingreso en cuenta");
                miCuenta.ingresar(cantidad);
            } catch (Exception e)
            {
                System.out.print("Fallo al ingresar");
            }
        }
    }
}

