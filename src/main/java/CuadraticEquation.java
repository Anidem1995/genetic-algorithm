import java.util.Scanner;

public class CuadraticEquation {
    public void start(){}

    private void defineConstants() {
    }
    public int[] DefineConstante(){

            int [] constantes = new int[3];

            System.out.println ("Defina el valor de la constante a:");
            String entradaTeclado = "";

            Scanner entradaEscaner = new Scanner (System.in);
            entradaTeclado = entradaEscaner.nextLine ();
            Integer a = Integer.valueOf(entradaTeclado);
            constantes[0] = a;
            //  System.out.println("a valor dado es"+constantes[0]);



            System.out.println ("Defina el valor de la constante b:");
            entradaTeclado = entradaEscaner.nextLine ();
            Integer b = Integer.valueOf(entradaTeclado);
            constantes[1] = b;
            // System.out.println("b valor dado es"+constantes[1]);

            System.out.println ("Defina el valor de la constante c:");
            entradaTeclado = entradaEscaner.nextLine ();
            Integer c = Integer.valueOf(entradaTeclado);
            constantes[2] = c;


            return constantes;
        }
    public int[]  DefineRango(){
        int [] rangos = new int[100];

        for (int i = 0; i < 99; i++) {
            rangos[i] = i;
        }
        return rangos;
    }
    public void Maximo(int rangos[], int constantes[]){

        int max = 0;
        for (int i = 0; i<99; i++)
        {
            int rango = (int) Math.pow(rangos[i],2);
            int resultado = (constantes[0] * rango  +(constantes[1] * rangos[i]))+constantes[2];
            System.out.println("resultado "+resultado);

           if(max < resultado){
               max = resultado;
           }
        }
     System.out.println("el maximo es: "+max);
    }
    public void Minimo(int rangos[],int constantes[]){
        int min =0;
        for(int i = 0; i<99; i++)
        {
            int rango = (int) Math.pow(rangos[i],2);
            int resultado = (constantes[0] * rango  +(constantes[1] * rangos[i]))+constantes[2];
            System.out.println("resultado "+resultado);
            if(min > resultado){
                min = resultado;
            }
        }
        System.out.println("el minimo es: "+min);
    }






}
