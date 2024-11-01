package model;

import java.util.Random;

import javax.swing.text.Position;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;
    private int numArbitros;


    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    public void preloadInformation() {
        arbitros[0] = new ArbitroPrincipal("Arbitro Principal", "40");
        arbitros[1] = new JuezDeLinea("Juez de Linea 1", "35");
        arbitros[2] = new JuezDeLinea("Juez de Linea 2", "30");
        arbitros[3] = new JuezDeLinea("Juez de Linea 3", "32");
    }

        
        //for (int i = 0; i < CANTIDAD_EQUIPOS; i++) {
          //  Equipo equipo = new Equipo();
            //for (int j = 0; j < 6; j++) {
              //  Posicion posicion = (j == 5) ? Posicion.PORTERO : Posicion.values()[j % 5];
                //JugadorHockey jugador = new JugadorHockey("Jugador " + (j + 1), 25 + j, posicion);
                //equipo.agregarJugador(jugador, j);
            //}
            //equipos[i] = equipo;
        //}
    //}

    public void simularJugadaGol() {
        Random random = new Random();
        Equipo equipo = equipos[random.nextInt(CANTIDAD_EQUIPOS)];
        JugadorHockey[] jugadores = equipo.getJugadores();

        boolean[] jugadoresPasando = new boolean[6]; 
        int pases = 0;
        int jugadorGol = random.nextInt(6);

        for (int i = 0; i < 5; i++) {
            int jugadorPasador;
            do {
                jugadorPasador = random.nextInt(6);
            } while (jugadoresPasando[jugadorPasador] || jugadorPasador == jugadorGol);


            System.out.println(jugadores[jugadorPasador].getNombre() + " se la pasa a " + jugadores[(jugadorPasador + 1) % 6].getNombre());
            System.out.println(arbitros[random.nextInt(CANTIDAD_ARBITROS)].getNombre() + " se desplaza sobre el hielo");

            jugadoresPasando[jugadorPasador] = true;
            pases++;
        }

        System.out.println(jugadores[jugadorGol].getNombre() + " entra el disco en la red. ¡Gol!");
    }

    
}
