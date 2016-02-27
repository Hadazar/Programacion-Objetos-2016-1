/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecciones;

/**
 *
 * @author HéctorAugusto
 */
public class Elecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner Leer = new java.util.Scanner(System.in);
        boolean continuidad = true;
        System.out.println("Escrutinio");
        System.out.println("");
        
            //Solicitud numero de candidatos
        System.out.print("Número de candidatos (menor a 20): ");
        int numeroCandidatos = 21;
        while(numeroCandidatos > 20){
            numeroCandidatos = Leer.nextInt();
        }
        System.out.println("");
        
            //Solicitud numero de municipios
        System.out.print("Numero de municipios (menor a 20): ");
        int numeroMunicipios = 21;
        while(numeroMunicipios > 20){
            numeroMunicipios = Leer.nextInt();
        }
        System.out.println("");
        
        int[][] tabla = new int[numeroCandidatos][numeroMunicipios];
        String[] etiquetasCandidatos = new String[numeroCandidatos];
        String[] etiquetasMunicipios = new String[numeroMunicipios];
        
            //Se crean las etiquetas de candidatos(candidato A, candidato B...)
        char letra = 'A';
        for(int i = 0; i < numeroCandidatos; i++){
            etiquetasCandidatos[i] = "Candidato " + letra;
            letra++;
        }
        
            //Se crean las etiquetas de municipios(municipio 1, municipio 2...)
        char numero = '1';
        for(int i = 0; i < numeroMunicipios; i++){
            etiquetasMunicipios[i] = "Municipio " + numero;
            numero++;
        }
        
            //Llenado de la tabla
        for(int i = 0; i < numeroMunicipios; i++){
            System.out.println(etiquetasMunicipios[i] + ":");
            System.out.println("");
            for(int j = 0; j < numeroCandidatos; j++){
                System.out.print(etiquetasCandidatos[j] + ": ");
                tabla[i][j] = Leer.nextInt();
            }
            System.out.println("");
        }
        
        int totalVotos = totalVotos(tabla, numeroCandidatos, numeroMunicipios);
        while(continuidad == true){
        
        System.out.println("Elija una opcion:\n");
        System.out.println("1. Imprimir reporte de las votaciones.");
        System.out.println("2. Imprimir la cantidad de votos recibidos por candidato y su correspondiente porcentaje.");
        System.out.println("3. Visualizar el candidato más votado.");
        System.out.println("4. Generar una lista ordenada de candidatos desde el mas votado hasta el menos votado.");
        System.out.println("");
        System.out.print("Opcion: ");
        String opcion = Leer.next();
        
        switch(opcion){
            case "1":
                System.out.println("");
                imprimirTabla(tabla, etiquetasCandidatos, etiquetasMunicipios, numeroCandidatos, numeroMunicipios);
                break;
            case "2":
                int posicion = 0;
                while(posicion < numeroCandidatos){
                    //Votos por candidato
                    String candidato = etiquetasCandidatos[posicion];
                    System.out.println(etiquetasCandidatos[posicion] + "\n");
                    double[] votosRecibidos = votosRecibidos(candidato, etiquetasCandidatos, tabla, numeroCandidatos, numeroMunicipios, totalVotos);
                    System.out.println("Votos: " + votosRecibidos[0]);
                    System.out.println("Porcentaje: " + (votosRecibidos[1]) + "%");
                    System.out.println("");
                    posicion++;
                }
                break;
            case "3":
                //Candidato mas votado
                int[] votosPorCandidato = new int[numeroCandidatos];
                for(int i = 0; i < numeroCandidatos; i++){
                    votosPorCandidato[i] = (int)votosRecibidos(etiquetasCandidatos[i], etiquetasCandidatos, tabla, numeroCandidatos, numeroMunicipios, totalVotos)[0];
                }
                String[] candidatoMasVotado = candidatoMasVotado(votosPorCandidato, etiquetasCandidatos, numeroCandidatos, totalVotos);
                System.out.println("Candidato mas votado: " + candidatoMasVotado[0]);
                break;
            case "4":
                int[][] listaCandidatos = ordenarcandidatos(votosPorCandidato, numeroCandidatos);
                for(int i = 0; i < numeroCandidatos; i++){
                    System.out.println(etiquetasCandidatos[listaCandidatos[i][1]]);
                    System.out.println("Votos: " + listaCandidatos[i][0]);
                }
                break;
        }
        }
        
    }
    
    //Funciones:
    
    public static void imprimirTabla(int[][] tabla, String[] etiquetasCandidatos, String[] etiquetasMunicipios, int numeroCandidatos, int numeroMunicipios){
        
        System.out.print("            ");
        for(int i = 0; i < numeroCandidatos; i++){
            System.out.print(etiquetasCandidatos[i] + "  ");
        }
        System.out.println("");
        
        for(int i = 0; i < numeroMunicipios; i++){
            System.out.print(etiquetasMunicipios[i] + "  ");
            for(int j = 0; j < numeroCandidatos; j++){
                System.out.print("      " + tabla[i][j] + "      ");
            }
            System.out.println("");
        }
    }
    
    public static int totalVotos(int[][]tabla, int numeroCandidatos, int numeroMunicipios){
        
        int totalVotos = 0;
        for(int i = 0; i < numeroMunicipios; i++){
            for(int j = 0; j < numeroCandidatos; j++){
                totalVotos += tabla[i][j];
            }
        }
        return totalVotos;
    }
    
    //falta corregir esta funcion
    public static double[] votosRecibidos(String candidato, String[] etiquetasCandidatos, int[][]tabla, int numeroCandidatos, int numeroMunicipios, int totalVotos){
        
        int columnaCandidato = 0;
        while(!candidato.equals(etiquetasCandidatos[columnaCandidato])){
            columnaCandidato++;
            if(columnaCandidato > numeroCandidatos){break;}
        }
        
        int votosRecibidos = 0;
        for (int i = 0; i < numeroMunicipios; i++){
            votosRecibidos += tabla[i][columnaCandidato];
        }
        
        double porcentaje = (votosRecibidos / totalVotos)*100;
        
        double[] datos = {votosRecibidos, porcentaje};
        
        return datos;
    }
    
    public static String[] candidatoMasVotado(int[] votosPorCandidato, String[] etiquetasCandidatos, int numeroCandidatos, int totalVotos){
        
        int mayor = 0;
        for(int i = 0; i < numeroCandidatos; i++){
            if(votosPorCandidato[i] > mayor){mayor = votosPorCandidato[i];}
        }
        
        int posicion = 0;
        while(votosPorCandidato[posicion] != mayor){
            posicion++;
        }
        
        double porcentaje = (mayor / totalVotos)*100;
        boolean hayGanador = true;
        int posicion2 = 0;
        int posicion3 = 0;
        if(porcentaje < 50){
            int mayor2 = 0;
            for(int i = 0; i < numeroCandidatos; i++){
                if((votosPorCandidato[i] > mayor2) && (votosPorCandidato[i] != mayor)){mayor2 = votosPorCandidato[i];}
            }
        
            while(votosPorCandidato[posicion2] != mayor2){
                posicion2++;
            }
            hayGanador = false;
        }
        if(porcentaje == 50){
            
            while((votosPorCandidato[posicion3] != mayor)||(posicion == posicion3)){
                posicion++;
            }
            hayGanador = false;
        }
        
        String[] candidatoMasVotado = new String[2];
        String Ganador = etiquetasCandidatos[posicion];
        String Ganador2;
        if (porcentaje < 50){
            Ganador2 =etiquetasCandidatos[posicion2];
        }else if(porcentaje == 50){
            Ganador2 =etiquetasCandidatos[posicion3];
        }
        
        return candidatoMasVotado;
    }
    
    public static int[][] ordenarcandidatos(int[] votosPorCandidato, int numeroCandidatos){
        
        int[][] listaNumeros = new int[numeroCandidatos][2];
        int mayor = 0;
        for(int j = 0; j < numeroCandidatos; j++){
            int posicion = 0;
            for(int i = 0; i < numeroCandidatos; i++){
                if(votosPorCandidato[i] > mayor){
                    mayor = votosPorCandidato[i];
                    posicion = i;
                }
            }
            listaNumeros[j][0] = mayor; listaNumeros[j][1] = posicion;
            votosPorCandidato[posicion] = 0;
            mayor = 0;
        }
        return listaNumeros;
    }
}
