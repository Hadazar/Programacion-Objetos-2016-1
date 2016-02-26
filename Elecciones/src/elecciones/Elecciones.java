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
        
        
        System.out.print("Candidato a consultar: ");
        String candidato = Leer.next();
        int totalVotos = totalVotos(candidato, tabla, numeroCandidatos, numeroMunicipios);
        double[] votosRecibidos = votosRecibidos(candidato, etiquetasCandidatos, tabla, numeroCandidatos, numeroMunicipios, totalVotos);
        System.out.println("Votos: " + votosRecibidos[0]);
        System.out.println("Porcentaje: " + votosRecibidos[1]);
        
        System.out.println("");
        imprimirTabla(tabla, etiquetasCandidatos, etiquetasMunicipios, numeroCandidatos, numeroMunicipios);
    }
    
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
    
    public static int totalVotos(String candidato, int[][]tabla, int numeroCandidatos, int numeroMunicipios){
        
        int totalVotos = 0;
        for(int i = 0; i < numeroMunicipios; i++){
            for(int j = 0; j < numeroCandidatos; j++){
                totalVotos =+ tabla[i][j];
            }
        }
        return totalVotos;
    }
    
    public static double[] votosRecibidos(String candidato, String[] etiquetasCandidatos, int[][]tabla, int numeroCandidatos, int numeroMunicipios, int totalVotos){
        
        int columnaCandidato = 0;
        while(candidato.equals(etiquetasCandidatos[columnaCandidato])){
            columnaCandidato++;
        }
        
        int votosRecibidos = 0;
        for (int i = 0; i < numeroMunicipios; i++){
            votosRecibidos =+ tabla[i][columnaCandidato];
        }
        
        double porcentaje = votosRecibidos / totalVotos;
        
        double[] datos = {votosRecibidos, porcentaje};
        
        return datos;
    }
    
}
