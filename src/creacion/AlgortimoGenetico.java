package creacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

/**Declaracion de la clase AlgoritmoGenetico.
 * @author Harold Pedraza
 * @version 16/09/2017
 */

public class AlgortimoGenetico {

	 static int maximo =0;//variables globales estaticas que dependiendo la cantidad n encuentra el motif mas repetido
	 static String mottifwinner= null;
	 static int lineas;
	
	 /**metodo para crear el archivo.
	 *En este metodo se crea el archivo y con cuantas lines queremos que contenga
	 */    
	    public AlgortimoGenetico() throws IOException {
	        BufferedWriter bw = new BufferedWriter(new FileWriter("sequences.umd")); //colocames writer con ruta del archivo hacer con exe
	        for (int i = 0; i < lineas; i++) {
	            bw.write(createExperimentalRad());//para crear un archivo con 1000 secuencias
	        }
	        bw.flush();//manda informacion al archivo
	    }

	    /**Metodo en el que crea la secuencia del read.
	     * En este metodo se crea los numeros aleatoriamente y la secuencia de palabras con tamañño aleatroio.
	     * @return retorna el read nuevamente.
	     */
	    public String createExperimentalRad(){
	        String read = "";
	        Random rd = new Random();
	        int number1 = Math.abs(rd.nextInt());//con valor absoluto para postivo siempre
	        int length = 5 + rd.nextInt(26);//minimo 5 maximo 30
	        read = number1 +","+(number1 + length)+ ","+ secuencia(length)+"\n";//el legth con numero maximo 30 hace que se imprima sin necesidad de colocar un numero 
	        return read;
	    }
	    
	    /**metodo de secuencia.
	     * Este metodo es el que crea los aleatorios y la secuencia aleatorio de las letras
	     * @param length, este parametro length es el tamaño que esta en la secuencia
	     * @return  retorna nuevamente la secuencia
	     */
	    public String secuencia (int length){
	        String secuencia= "";
	        Random rd = new Random();//generador de aleatorios
	        for(int i = 0; i < length;i++ ){
	            switch(rd.nextInt(4)){//tiene 0, 1 2 3
	                case 0:{secuencia += "A";}break;
	                case 1:{secuencia += "C";}break;
	                case 2:{secuencia += "G";}break;
	                case 3:{secuencia += "T";}break;  
	            }
	        }
	      return secuencia;  
	    }
	    
	    /**Metodo en el cual creo el constructor y imprimo las clases creadas anteriormente.
	     */
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        bw.write("                      Bienvenido...!");
	        bw.flush();
	        System.out.println("\nIngrese la cantidad de reads que desea en el archivo de txt:");
	        lineas = Integer.parseInt(br.readLine());
	        AlgortimoGenetico cf = new AlgortimoGenetico();
	        System.out.println("* Imprimiendo el read: "+cf.createExperimentalRad());//imprime el codigo del metodo
	        System.out.println("Que patron desea encontrar? ");
	        String patron = br.readLine();
	        System.out.println("\n* Segun el patron= " +(cf.numberResols(patron))+" veces encontradas");
	        System.out.println();
	        System.out.println("\nIngrese cantidad n para buscar el motif mas repetido");
	        int tamaño_n= Integer.parseInt(br.readLine());
	        generatePatterns("",tamaño_n);//motif vacio y tamaño
	        bw.write("\n* El motif mas reptido es "+mottifwinner+" y se repitio "+maximo+" veces\n");
	        bw.flush();
	        System.out.println(" ");
	    }
	  
	    /**metodo en el cual obtengo del archivo el patron con mas contains.
	     * @param motif, este parametro es el motif o patron que queremos buscar en la secuencia aleatoria.
	     * @return retorna de cero las lineas patron.
	     */
	    public int numberResols(String motif) throws IOException{
	      BufferedReader br = new BufferedReader(new FileReader("sequences.umd"));//para leer el archivo creado
	      int lines = 0;//contar las lineas
	      int linesmotif = 0;
	      String read = br.readLine();
	      while(read != null){ //mientras allan codigos, null esta en blanco termina el ciclo
	          //formato de archivo inicio, fin, cadena, se compara con la cadena
	          //funcion de strings contains retorna 1
	          if (read.split(",")[2].contains(motif)){//parte donde esten las comas y trae la segunda posicion cadena
	              //contains si retorna lo hace verdadero y si no lo contienes false, la cadena se compara con el motif que es la subcadena
	              linesmotif += 1;   
	          }
	          lines +=1;//cuenta la cantidad de lineas que tenga el archivo, sin importar el while 
	          read = br.readLine();
	      }
	      return linesmotif; 
	    }
	    
	    /**Este metodo es donde busco por medio de una cantidad la subcadena que mas se repita.
	     * @return retorna a de cero la cantidad de opciones encontradas.
	     */
	    public static void generatePatterns(String motif, int length) throws IOException{
	        if (length == 1) {
	            System.out.println(motif + "A");
	            System.out.println(motif + "C");
	            System.out.println(motif + "T");
	            System.out.println(motif + "G");
	            //Para imprimir en consola las combinacionales lossibles dependiendo de los paramentros del main
			
	            int temp;
	            AlgortimoGenetico cf = new AlgortimoGenetico();
	            temp = cf.numberResols(motif + "A");
	            if(temp>maximo){
	                mottifwinner = motif +"A";
	                maximo = temp;
	            }if(temp>maximo){
	                mottifwinner = motif +"A";
	                maximo = temp;
	            }
	            if(temp>maximo){
	                mottifwinner = motif +"C";
	                maximo = temp;
	            }
	            if(temp>maximo){
	                mottifwinner = motif +"C";
	                maximo = temp;
	            }
	            if(temp>maximo){
	                mottifwinner = motif +"T";
	                maximo = temp;
	            }
	            if(temp>maximo){
	                mottifwinner = motif +"T";
	                maximo = temp;
	            }
	            if(temp>maximo){
	                mottifwinner = motif +"G";
	                maximo = temp;
	            }
	            if(temp>maximo){
	                mottifwinner = motif +"G";
	                maximo = temp;
	            }
	        } 
	        else {
	            generatePatterns(motif + "A", length - 1);
	            generatePatterns(motif + "C", length - 1);
	            generatePatterns(motif + "T", length - 1);
	            generatePatterns(motif + "G", length - 1);
	        }
	    }
}

