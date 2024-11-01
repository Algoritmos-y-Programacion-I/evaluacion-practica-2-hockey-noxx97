package model;


public abstract class Arbitro extends Persona implements IDesplazarseEnPistaSinPalo {
    
    
    public Arbitro(String nombre, String edad) {
        super(nombre, edad);
    }
    @Override
    public String desplazarse() {
        return nombre + " se desplaza en la pista como árbitro.";
    }
}

