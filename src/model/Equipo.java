package model;

public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;

    protected String nombreEquipo;

    public Equipo(String nombreEquipo2, String jugadores2) {
        //TODO Auto-generated constructor stub
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void setJugadores(JugadorHockey[] jugadores) {
        this.jugadores = jugadores;
    }

    private JugadorHockey[] jugadores = new JugadorHockey[CANTIDAD_JUGADORES];

    public void agregarJugador(JugadorHockey jugador, int posicion) {
        if (posicion >= 0 && posicion < jugadores.length) {
            jugadores[posicion] = jugador;
        }
    }

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }
}