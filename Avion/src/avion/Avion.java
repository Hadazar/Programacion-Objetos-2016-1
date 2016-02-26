/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avion;

/**
 *
 * @author HéctorAugusto
 */
public class Avion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner Leer = new java.util.Scanner(System.in);
        
        boolean[][] sillasEjecutivas = new boolean[2][4];
        boolean[][] sillasEconomicas = new boolean[7][6];
        String[] nombres = new String[50];
        int[] cedulas = new int[50];
        int[][] puestos = new int[50][3]; //(primera columna: coordenada x, segunda columna: coordenada y; tercera columna: clase)
        boolean continuidad = true;
        
        while(continuidad == true){
            
        System.out.println("Esquema del avion\n");
        dibujarAvion(sillasEjecutivas, sillasEconomicas);
        System.out.println("");
            
            //Menu de opciones
        System.out.println("Elija una opción:\n");
        System.out.println("1. Asignación de sillas a pasajeros.");
        System.out.println("2. Contar sillas ejecutivas ocupadas.");
        System.out.println("3. Localizar la silla en la que se encuentra un pasajero.");
        System.out.println("4. Localizar una silla enconómica disponible.");
        System.out.println("5. Asignar un pasajero a una silla economica.");
        System.out.println("6. Anular una reserva.");
        System.out.println("7. Contar el numero de puestos disponibles en ventana en la clase económica.");
        System.out.println("8. Identificar si dos personas tienen nombres iguales.");
        System.out.println("");
        
        System.out.print("Opcion: ");
        int opcion = Leer.nextInt();
            System.out.println("");
     
            
        switch(opcion){
            case 1:
                
                    //Datos del pasajero
                int posicion = 0;
                System.out.println("Ingrese los datos del pasajero:\n");
                System.out.print("Nombre: ");
                nombres[posicion] = Leer.next();
                System.out.println("");
                System.out.print("Cedula: ");
                cedulas[posicion] = Leer.nextInt();
                System.out.println("");
        
                    //Preferencias del pasajero:
                System.out.println("Ingrese las preferencias del psajero:\n");
                System.out.print("Clase: ");
                String clase = Leer.next();
                System.out.println("");
                System.out.print("Ubicacion: ");
                String ubicacion = Leer.next();
                System.out.println("");
        
                    //Asignacion de silla
                if(ubicacion.equals("Ventana") || ubicacion.equals("Pasillo") || ubicacion.equals("Centro")){
                    int estaLlena = 0;
                    int[] vectorDatos = new int[3];
                    if(clase.equals("Economica")){
                        vectorDatos = asignacionDeSillas(sillasEconomicas, clase, ubicacion);
                        if(vectorDatos[0] == 0){
                            puestos[posicion][0] = vectorDatos[1];
                            puestos[posicion][1] = vectorDatos[2];
                            puestos[posicion][2] = 0;
                        }
                    }else if(clase.equals("Ejecutiva")){
                        vectorDatos = asignacionDeSillas(sillasEjecutivas, clase, ubicacion);
                        if(vectorDatos[0] == 0){
                            puestos[posicion][0] = vectorDatos[1];
                            puestos[posicion][1] = vectorDatos[2];
                            puestos[posicion][2] = 1;
                        }
                    }else{System.out.println("Esa clase no existe");}
                    if(estaLlena == 1){System.out.println("La silla esta ocupada");}
                    else{posicion++;}
                }else{System.out.println("Esa ubicacion no existe");}
                
                break;
                
            case 2:
                
                System.out.print("Cantidad de sillas ejecutivas ocupadas: " + sillasOcupadas(sillasEjecutivas));
                System.out.println("");
                break;
                
            case 3:
                
                System.out.print("Cedula del pasajero: ");
                int cedula = Leer.nextInt();
                System.out.println("");
                int[] silla = localizarSilla(cedula, cedulas, puestos);
                System.out.print("El pasajero se encuentra en la fila " + (silla[0]+1) + " y en la columna " + (silla[1]+1));
                if(silla[2] == 1){System.out.println(" de la clase ejecutiva.");}
                else{System.out.println(" de la clase economica");}
                System.out.println("");
                break;
                
            case 4:
                
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
        }
        } 
      
    }
    
    //Funciones:
    
    public static void dibujarAvion(boolean[][] sillasEjecutivas, boolean[][] sillasEconomicas){
        
        for(int i = 0; i < 2; i++){
            System.out.print("   ");
            for(int j = 0; j < 4; j++){
                if(sillasEjecutivas[i][j] == true){
                    System.out.print("X");
                }else{System.out.print("▄");}
                if(j == 1){
                System.out.print("    ");
                }else{System.out.print("  ");}
            }
            System.out.println("");
        }
        System.out.println("");
        
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                if(sillasEconomicas[i][j] == true){
                    System.out.print("X");
                }else{System.out.print("▓");}
                if(j == 2){
                System.out.print("    ");
                }else{System.out.print("  ");}
            }
            System.out.println("");
        }
    }
    
    public static int[] asignacionDeSillas(boolean[][] sillas, String clase, String ubicacion){
        
        int[] datos = {0,0,0}; //(primera columna: ocupacion de silla, segunda columna: coordenada x; tercera columna: y)
        if (clase.equals("Ejecutiva")){
            if(ubicacion.equals("Ventana")){
                int posicionx = 0;
                int posiciony = 0;
                int repeticiones = 0;
                while(repeticiones < 4){
                    if(sillas[posicionx][posiciony] == false){sillas[posicionx][posiciony] = true; datos[0] = 1; datos[1] = posicionx;  datos[2] = posiciony; break;}
                    if(repeticiones % 2 == 0){posiciony += 3;}
                    else{posiciony -= 3; posicionx = 1;}
                }
            }else if(ubicacion.equals("Pasillo")){
                int posicionx = 0;
                int posiciony = 1;
                int repeticiones = 0;
                while(repeticiones < 4){
                    if(sillas[posicionx][posiciony] == false){sillas[posicionx][posiciony] = true;  datos[1] = posicionx;  datos[2] = posiciony;; break;}
                    if(repeticiones % 2 == 0){posiciony += 1;}
                    else{posiciony -= 1; posicionx = 1;}
                    
                }
            }
        }else if(clase.equals("Economica")){
            if(ubicacion.equals("Ventana")){
                int posicionx = 0;
                int posiciony = 0;
                int repeticiones = 0;
                while(repeticiones < 4){
                    if(sillas[posicionx][posiciony] == false){sillas[posicionx][posiciony] = true;  datos[1] = posicionx;  datos[2] = posiciony;; break;}
                    if(repeticiones % 2 == 0){posiciony += 5;}
                    else{posiciony -= 5; posicionx += 1;}
                }
            }else if(ubicacion.equals("Pasillo")){
                int posicionx = 0;
                int posiciony = 2;
                int repeticiones = 0;
                while(repeticiones < 4){
                    if(sillas[posicionx][posiciony] == false){sillas[posicionx][posiciony] = true;  datos[1] = posicionx;  datos[2] = posiciony;; break;}
                    if(repeticiones % 2 == 0){posiciony += 1;}
                    else{posiciony += 1; posicionx += 1;}
                }
            }else if(ubicacion.equals("Centro")){
                int posicionx = 0;
                int posiciony = 1;
                int repeticiones = 0;
                while(repeticiones < 4){
                    if(sillas[posicionx][posiciony] == false){sillas[posicionx][posiciony] = true;  datos[1] = posicionx;  datos[2] = posiciony;; break;}
                    if(repeticiones % 2 == 0){posiciony += 3;}
                    else{posiciony -= 3; posicionx = 1;}
                }
            }
        }
        return datos;
    }
    
    public static int sillasOcupadas(boolean[][] sillasEjecutivas){
        int sillasOcupadas = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; i++){
                if(sillasEjecutivas[i][j] == true){sillasOcupadas++;}
            }
        }
        return sillasOcupadas;
    }
    
    public static int[] localizarSilla(int cedula, int[] cedulas, int[][] posiciones){
        int posicion = 0;
        while(posicion < 50){
            if(cedula == cedulas[posicion]){break;}
            posicion++;
        }
        int[] silla = new int[3];
        silla[0] = posiciones[posicion][0];
        silla[1] = posiciones[posicion][1];
        silla[1] = posiciones[posicion][2];
        return silla;
    }
}

