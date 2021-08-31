import java.util.Scanner;

/**
 *
 * @author JUAN FELIPE ORTIZ FRANCO
 */
public class Triqui {
    
    // MÉTODO
    // modificadores tipoDato(int, double, float, void) nombreMétodo( ...párametros ){}
    
    public static void iniciarTablero(int tablero[][]){
        // Por cada dimensión usamos un ciclo FOR.
        // CICLO FOR
        // for(inicio; condición; incremento){}
        for(int filas=0; filas < 3; filas++){
            for(int columnas=0; columnas < 3; columnas++){
                tablero[filas][columnas] = -1;
            }
        }
    }
    
    public static void imprimirTablero(int tablero[][], String fichaJugadores[]){
        System.out.println("  |  A  |  B  |  C  |");
        for(int i=0; i<3; i++){
            System.out.println("--------------------");
            System.out.println("  |     |     |     |");
            for(int j=0; j<3; j++){
                if(j==0){
                    System.out.print((i+1) + " |");
                }
                String ficha = " ";
                ficha = tablero[i][j] == - 1 ? ficha : fichaJugadores[tablero[i][j]];
                System.out.print("  " + ficha + "  |");
            }
            System.out.println();
            System.out.println("  |     |     |     |");
        }
        System.out.println("--------------------");
    }
    
    
    public static boolean validarJugada(int tablero[][], String coordenada){
        boolean esValida = true;
        int fila = -1, columna = -1;
        // SWITCH ES UNA ESTRUCTURA PARA EVUALAR MULTIPLES VALORES DE UNA VARIABLE
        
        switch(coordenada){
            case "1a", "a1", "A1", "1A" -> {
               fila = 0;
               columna = 0;
            }
            
            case "2a", "a2", "A2", "2A" -> {
               fila = 1;
               columna = 0;
            }
            
            case "3a", "a3", "A3", "3A" -> {
               fila = 2;
               columna = 0;
            }
            
            case "1b", "b1", "B1", "1B" -> {
               fila = 0;
               columna = 1;
            }
            
            case "2b", "b2", "B2", "2B" -> {
               fila = 1;
               columna = 1;
            }
            
            case "3b", "b3", "B3", "3B" -> {
               fila = 2;
               columna = 1;
            }
            
            case "1c", "c1", "C1", "1C" -> {
               fila = 0;
               columna = 2;
            }
            
            case "2c", "c2", "C2", "2C" -> {
               fila = 1;
               columna = 2;
            }
            
            case "3c", "c3", "C3", "3C" -> {
               fila = 2;
               columna = 2;
            }
        }
        
        if(tablero[fila][columna] == -1){
            esValida = true;
        }
        else{
            esValida = false;
        }
        
        return esValida;
    }

    public static void asignarJugada(int tablero[][], int jugador, String coordenada){
        int fila = -1, columna = -1;
        // SWITCH ES UNA ESTRUCTURA PARA EVUALAR MULTIPLES VALORES DE UNA VARIABLE
        
        switch(coordenada){
            case "1a", "a1", "A1", "1A" -> {
               fila = 0;
               columna = 0;
            }
            
            case "2a", "a2", "A2", "2A" -> {
               fila = 1;
               columna = 0;
            }
            
            case "3a", "a3", "A3", "3A" -> {
               fila = 2;
               columna = 0;
            }
            
            case "1b", "b1", "B1", "1B" -> {
               fila = 0;
               columna = 1;
            }
            
            case "2b", "b2", "B2", "2B" -> {
               fila = 1;
               columna = 1;
            }
            
            case "3b", "b3", "B3", "3B" -> {
               fila = 2;
               columna = 1;
            }
            
            case "1c", "c1", "C1", "1C" -> {
               fila = 0;
               columna = 2;
            }
            
            case "2c", "c2", "C2", "2C" -> {
               fila = 1;
               columna = 2;
            }
            
            case "3c", "c3", "C3", "3C" -> {
               fila = 2;
               columna = 2;
            }
        }
        
        tablero[fila][columna] = jugador;
    }
    
    public static int validarGanador(int tablero[][], int jugador){
        int ganador = -1;
        if(
            validarFilas(tablero,jugador) == 1 || 
            validarColumnas(tablero,jugador) == 1 ||
            validarDiagonalPrincipal(tablero, jugador) == 1 ||
            validarDiagonalSecundaria(tablero, jugador) == 1
        ){
            ganador = jugador;
        }
        return ganador;
    }
    
    public static int validarFilas(int tablero[][], int jugador){
        int esGanador = 0;
        for(int filas = 0; filas < 3; filas++){
            int coincidencias = 0;
            for(int columnas = 0; columnas < 3; columnas ++){
                if(tablero[filas][columnas] == jugador){
                    coincidencias ++;
                }
                else{
                    break;
                }
            }
            if(coincidencias == 3){
                esGanador = 1;
                break;
            }
        }
        return esGanador;
    }
    
    public static int validarColumnas(int tablero[][], int jugador){
        int esGanador = 0;
        for(int filas = 0; filas < 3; filas++){
            int coincidencias = 0;
            for(int columnas = 0; columnas < 3; columnas ++){
                if(tablero[columnas][filas] == jugador){
                    coincidencias ++;
                }
                else{
                    break;
                }
            }
            if(coincidencias == 3){
                esGanador = 1;
                break;
            }
        }
        return esGanador;
    }
    
    public static int validarDiagonalPrincipal(int tablero[][], int jugador){
        int esGanador = 0;
        
        int coincidencias = 0;
        for(int filas = 0; filas < 3; filas++){
            if(tablero[filas][filas] == jugador){
                coincidencias++;
            }
            else{
                break;
            }
        }
        
        if(coincidencias == 3){
            esGanador = 1;
        }
        
        return esGanador;
    }
    
    public static int validarDiagonalSecundaria(int tablero[][], int jugador){
        int esGanador = 0;
        
        int coincidencias = 0;
        for(int filas = 0; filas < 3; filas++){
            if(tablero[filas][3-(filas+1)] == jugador){
                coincidencias++;
            }
            else{
                break;
            }
        }
        
        if(coincidencias == 3){
            esGanador = 1;
        }
        
        return esGanador;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // ARRAY-2D -> MATRIZ
        // tipoDatos - nombreVariable [][][]...[] = new tipoDato[n][m][l]...[..n]
        int tablero[][] = new int[3][3];
        String jugadores[] = new String[2];
        String fichaJugadores[] = new String[]{"X", "O"};
        int turno = 0;
        int turnos = 0;
        int ganador = -1;
        
        // TODA VARIABLE QUE REPRESENTA UNA CLASE -> Objeto
        // nombreClase nombreVariable = new nombreClase(...pármetros?);
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Digite el nombre del Jugador 1: ");
        jugadores[0] = lector.nextLine();
        
        System.out.println("Digite el nombre del Jugador 2: ");
        jugadores[1] = lector.nextLine();
        
        iniciarTablero(tablero);
        
        do{
            // OPERADOR TERNARIO 
            // (condición) ? CondiciónVerdadera : CondiciónFalsa;
            
            turno = turnos % 2 == 0 ? 0 : 1;
            imprimirTablero(tablero, fichaJugadores);
            System.out.println("Turno del Jugador: " + jugadores[turno]);
            boolean esValida = false;
            String coordenada;
            do{
                System.out.println("Digite la coordenada");
                coordenada = lector.nextLine();
                esValida = validarJugada(tablero, coordenada);
            }while(!esValida);
            
            asignarJugada(tablero, turno, coordenada);
            ganador = validarGanador(tablero, turno);
            
            if(ganador != -1){
                imprimirTablero(tablero, fichaJugadores);
                System.out.println("El ganador es: " + jugadores[ganador]);
            }
            
            turnos++;
        }while(turnos < 9 && ganador == -1);
        
        if(turnos == 9 && ganador == -1){
            System.out.println("Empate");
        }
    }
    
}
