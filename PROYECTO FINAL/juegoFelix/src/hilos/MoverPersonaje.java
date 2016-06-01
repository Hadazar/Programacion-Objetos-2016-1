/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import dto.Personaje;
import java.util.Random;
import javax.swing.JOptionPane;
import juegofelix.JuegoFelix;
import juegofelix.PuntajeRegistro;
import vista.Tablero;

/**
 *
 *
 */
public class MoverPersonaje extends Thread {

    public Personaje personaje;
    public Tablero tablero;
    public Boolean start;
    public Random aleatoreo;
    public int dificultad;
    public boolean multijugador;
    public Boolean mensaje;
    public JuegoFelix juego;
    public PuntajeRegistro puntajeRegistro;
    public String nombreJugador;

    public MoverPersonaje(Personaje pPersonaje, Tablero pTablero, int pDificultad, boolean pMultijugador, String pNombreJugador) {
        nombreJugador = pNombreJugador;
        mensaje = false;
        personaje = pPersonaje;
        tablero = pTablero;
        start = true;
        aleatoreo = new Random();
        dificultad = pDificultad;
        multijugador = pMultijugador;
    }

    @Override
    public void run() {
        while (start) {
            enviarDatosServidor("no");
            verificarJuego();
            control();
            actualizarPuntaje();

            if ((verificarJuego() || validarVictoria()) && (!tablero.panelControl.getFelix().isActivo() && !tablero.panelControl.getSonic().isActivo())) {
                break;
            }
        }
        System.out.println(start + "-" + mensaje + "-" + personaje.getNombrePersonaje());
        if (!start && mensaje) {
            try {
                if (personaje.getNombrePersonaje().equalsIgnoreCase("Felix") && multijugador && !tablero.panelControl.getFelix().isActivo()) {
                    vegetaVictorioso();
                    acabarJuegoIniciar("Perdiste tu puntaje fue " + tablero.panelControl.getFelix().getPuntaje());
                } else if (personaje.getNombrePersonaje().equalsIgnoreCase("Sonic") && !tablero.panelControl.getSonic().isActivo()) {
                    vegetaVictorioso();
                    acabarJuegoIniciar("Perdiste tu puntaje fue " + tablero.panelControl.getSonic().getPuntaje());
                }
            } catch (Throwable ex) {
                System.err.println("Error al terminar los hilos, destruyalos de manera manual " + ex.getMessage());
            }
        }
    }

    public void enviarDatosServidor(String pReinicio) {
        if (multijugador) {
            tablero.enviarDatos("felix" + "-"
                    + tablero.panelControl.getFelix().getPosicionX() + "-" + tablero.panelControl.getFelix().getPosicionY() + "-" + tablero.panelControl.getFelix().getIndiceImagenActual()
                    + "-" + tablero.panelControl.getBomba().getPosicionX() + "-" + tablero.panelControl.getBomba().getPosicionY() + "-" + tablero.panelControl.getBomba().getIndiceImagenActual()
                    + "-" + tablero.panelControl.getVegeta().getPosicionX() + "-" + tablero.panelControl.getVegeta().getPosicionY() + "-" + tablero.panelControl.getVegeta().getIndiceImagenActual()
                    + "-" + tablero.panelControl.getFelix().getPuntaje() + "-" + pReinicio);
        } else {
            tablero.enviarDatos("sonic" + "-"
                    + tablero.panelControl.getSonic().getPosicionX() + "-" + tablero.panelControl.getSonic().getPosicionY() + "-" + tablero.panelControl.getSonic().getIndiceImagenActual()
                    + "-" + tablero.panelControl.getBomba().getPosicionX() + "-" + tablero.panelControl.getBomba().getPosicionY() + "-" + tablero.panelControl.getBomba().getIndiceImagenActual()
                    + "-" + tablero.panelControl.getVegeta().getPosicionX() + "-" + tablero.panelControl.getVegeta().getPosicionY() + "-" + tablero.panelControl.getVegeta().getIndiceImagenActual()
                    + "-" + tablero.panelControl.getSonic().getPuntaje() + "-" + pReinicio);
        }
    }

    /**
     * Movimientos del personaje
     */
    public void control() {
        if (!personaje.getNombrePersonaje().equalsIgnoreCase("vegeta") && !personaje.getNombrePersonaje().equalsIgnoreCase("bomba")) {
            switch (personaje.getControlTecla()) {
                case 37:
                    saltar();
                    personaje.setControlTecla(0);
                    break;
                case 38:
                    hacerCaminarArribaPersonaje();
                    personaje.setControlTecla(0);
                    break;
                case 39:
                    caminar();
                    personaje.setControlTecla(0);
                    break;
                case 40:
                    hacerCaminarAbajoPersonaje();
                    personaje.setControlTecla(0);
                    break;
                case 98:
                    hacerCaminarAbajoPersonaje();
                    personaje.setControlTecla(0);
                    break;
                case 100:
                    saltar();
                    personaje.setControlTecla(0);
                    break;
                case 102:
                    caminar();
                    personaje.setControlTecla(0);
                    break;
                case 104:
                    hacerCaminarArribaPersonaje();
                    personaje.setControlTecla(0);
                    break;
                default:
                    break;
            }
        } else if (personaje.getNombrePersonaje().equalsIgnoreCase("vegeta")) {
            vegetaCargando();
        } else {
            bomba();
        }
    }

    public void saltar() {
        personaje.setIndiceImagenActual(personaje.getCantidadDeMovimientos() - 2);
        for (int i = 0; i < 15; i++) {
            esperarXsegundos(1);
            personaje.setPosicionY(personaje.getPosicionY() - i);
            tablero.repaint();
        }
        for (int i = 0; i < 15; i++) {
            esperarXsegundos(1);
            personaje.setPosicionY(personaje.getPosicionY() + i);
            tablero.repaint();
        }
        personaje.setIndiceImagenActual(0);
    }

    public void hacerCaminarArribaPersonaje() {
        for (int i = 1; i < personaje.getCantidadDeMovimientos() - 2; i++) {
            esperarXsegundos(1);
            personaje.setIndiceImagenActual(i);
            if (validarLimitesPersonajes()) {
                personaje.setPosicionY(personaje.getPosicionY() - 1);
            }
            tablero.repaint();
        }
    }

    public void hacerCaminarAbajoPersonaje() {
        for (int i = 1; i < personaje.getCantidadDeMovimientos() - 2; i++) {
            esperarXsegundos(1);
            personaje.setIndiceImagenActual(i);
            if (validarLimitesPersonajes()) {
                personaje.setPosicionY(personaje.getPosicionY() + 1);
            }
            tablero.repaint();
        }
    }

    public void caminar() {
        for (int i = 1; i < personaje.getCantidadDeMovimientos() - 2; i++) {
            esperarXsegundos(1);
            personaje.setIndiceImagenActual(i);
            personaje.setPosicionX(personaje.getPosicionX() + 2);
            tablero.repaint();
        }
    }

    public void vegetaCargando() {
        for (int i = 0; i < tablero.panelControl.getVegeta().getCantidadDeMovimientos() - 2; i++) {
            esperarXsegundos(2);
            if ((tablero.panelControl.getFelix().isActivo() || tablero.panelControl.getSonic().isActivo()) && tablero.panelControl.getVegeta().isActivo()) {
                tablero.panelControl.getVegeta().setIndiceImagenActual(i);
                tablero.repaint();
            }
        }
    }

    public void vegetaDerrotado() {
        tablero.panelControl.getVegeta().setActivo(false);
        tablero.panelControl.getVegeta().setIndiceImagenActual(tablero.panelControl.getVegeta().getCantidadDeMovimientos() - 1);
        tablero.panelControl.getVegeta().setPosicionX(300);
        tablero.panelControl.getBomba().setIndiceImagenActual(tablero.panelControl.getBomba().getCantidadDeMovimientos() - 1);
        tablero.repaint();
    }

    public void vegetaVictorioso() {
        tablero.panelControl.getVegeta().setActivo(false);
        tablero.panelControl.getVegeta().setIndiceImagenActual(tablero.panelControl.getVegeta().getCantidadDeMovimientos() - 2);
        tablero.panelControl.getVegeta().setPosicionX(300);
        tablero.panelControl.getBomba().setIndiceImagenActual(tablero.panelControl.getBomba().getCantidadDeMovimientos() - 1);
        tablero.repaint();
    }

    public void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 30);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     *
     * @param segundos
     */
    public void esperarXsegundosBomba(int segundos) {
        try {
            Thread.sleep(segundos * dificultad);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    /*
     * Dificultad
     */

    public void bomba() {
        esperarXsegundosBomba(1);
        personaje.setActivo(validarLimitesBomba());

        if (personaje.isActivo()) {
            tablero.panelControl.getBomba().setPosicionX(personaje.getPosicionX() - 1);
        }
        tablero.repaint();
    }

    /**
     * Cotroles generales del juego
     */
    public void adicionarPuntaje() {
        if (multijugador && start) {
            if (tablero.panelControl.getFelix().isActivo()) {
                tablero.panelControl.getFelix().setPuntaje(tablero.panelControl.getFelix().getPuntaje() + tablero.panelControl.getFelix().getPosicionX());
            }
        } else if (tablero.panelControl.getSonic().isActivo() && start) {
            tablero.panelControl.getSonic().setPuntaje(tablero.panelControl.getSonic().getPuntaje() + tablero.panelControl.getSonic().getPosicionX());
        }
    }

    public void actualizarPuntaje() {
        if (tablero.panelControl.getFelix().isActivo() && multijugador) {
            tablero.puntaje.setText("FELIX: " + tablero.panelControl.getFelix().getPuntaje().intValue());
        } else if (tablero.panelControl.getSonic().isActivo() && !multijugador) {
            tablero.puntaje.setText(" SONIC: " + tablero.panelControl.getSonic().getPuntaje().intValue());
        }
    }

    public void acabarJuegoIniciar(String mensaje) {
        String aGuardar = "";
        String estado = "Gano";
        int eleccion = 0;
        if (mensaje.contains("Perdiste")) {
            estado = "Perdio";
        }
        if (!tablero.panelControl.getFelix().isActivo() && multijugador) {
            aGuardar = nombreJugador + " jugo con FELIX: " + tablero.panelControl.getFelix().getPuntaje().intValue();
            puntajeRegistro = new PuntajeRegistro();
            puntajeRegistro.escrituraArchivo(aGuardar + " - " + estado);
            eleccion = JOptionPane.showConfirmDialog(null, mensaje + ", quieres volver a intentarlo ?");
            decisionJuego(eleccion);
        } else if (!tablero.panelControl.getSonic().isActivo() && !multijugador) {
            aGuardar = nombreJugador + " jugo con SONIC: " + tablero.panelControl.getSonic().getPuntaje().intValue();
            puntajeRegistro = new PuntajeRegistro();
            puntajeRegistro.escrituraArchivo(aGuardar + " - " + estado);
            eleccion = JOptionPane.showConfirmDialog(null, mensaje + ", quieres volver a intentarlo ?");
            decisionJuego(eleccion);
        }


    }

    public void decisionJuego(int eleccion) {
        if (eleccion == JOptionPane.YES_OPTION) {
            enviarDatosServidor("si");
            tablero.panelControl.getFelix().setActivo(false);
            tablero.panelControl.getSonic().setActivo(false);
            tablero.panelControl.getBomba().setActivo(false);
            tablero.panelControl.getVegeta().setActivo(false);
            mensaje = false;
            tablero.setVisible(false);
            juego = new JuegoFelix();
            juego.nuevoJuego();
        } else if (eleccion == JOptionPane.NO_OPTION) {
            mensaje = false;
            tablero.setVisible(false);
            enviarDatosServidor("siC");
            tablero.cerrarConexion();
            System.exit(0);
        }
    }

    /**
     * Validaciones
     */
    public boolean validarLimitesPersonajes() {
        if (personaje.getPosicionY() >= 308 && personaje.getPosicionY() <= 370) {
            return true;
        } else {
            if (personaje.getPosicionY() < 308) {
                personaje.setPosicionY(308);
            } else {
                personaje.setPosicionY(370);
            }
            return false;
        }
    }

    public boolean validarLimitesBomba() {
        Double aleatoreoNumero;
        if (personaje.getPosicionX() >= 0) {
            return true;
        } else if (personaje.getPosicionX() < 0) {
            tablero.panelControl.getBomba().setPosicionX(405);
            aleatoreoNumero = aleatoreo.nextDouble() * 70;
            tablero.panelControl.getBomba().setPosicionY(375 - aleatoreoNumero.intValue());
            adicionarPuntaje();
            return false;
        } else {
            return false;
        }
    }

    public boolean verificarJuego() {
        if (validarRangoBombaY() && validarRangoBombaX()) {
            personaje.setActivo(false);
            if (personaje.getNombrePersonaje().equalsIgnoreCase("felix")) {
                tablero.panelControl.getFelix().setIndiceImagenActual(personaje.getCantidadDeMovimientos() - 1);
            } else if (personaje.getNombrePersonaje().equalsIgnoreCase("sonic")) {
                tablero.panelControl.getSonic().setIndiceImagenActual(personaje.getCantidadDeMovimientos() - 1);
            }
            return true;
        }

        if (multijugador) {
            if (!tablero.panelControl.getFelix().isActivo()) {
                start = false;
                mensaje = true;
                return true;
            }
        } else if (!tablero.panelControl.getSonic().isActivo()) {
            start = false;
            mensaje = true;
            return true;
        }
        return false;
    }

    public boolean validarRangoBombaY() {
        if (personaje.getPosicionY() >= tablero.panelControl.getBomba().getPosicionY() - 25 && personaje.getPosicionY() < tablero.panelControl.getBomba().getPosicionY() + 25) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarRangoBombaX() {
        if (personaje.getPosicionX() >= tablero.panelControl.getBomba().getPosicionX() && personaje.getPosicionX() < tablero.panelControl.getBomba().getPosicionX() + 20) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarVictoria() {
        if (multijugador) {
            if (tablero.panelControl.getFelix().getPosicionX() > 450 && personaje.getNombrePersonaje().equalsIgnoreCase("Felix")) {
                tablero.panelControl.getFelix().setActivo(false);
                vegetaDerrotado();
                acabarJuegoIniciar("Ganaste tu puntaje fue " + tablero.panelControl.getFelix().getPuntaje());
                return true;
            }
        } else {
            if (tablero.panelControl.getSonic().getPosicionX() > 450 && personaje.getNombrePersonaje().equalsIgnoreCase("Sonic")) {
                tablero.panelControl.getSonic().setActivo(false);
                vegetaDerrotado();
                acabarJuegoIniciar("Ganaste tu puntaje fue " + tablero.panelControl.getSonic().getPuntaje());
                return true;
            }
        }
        return false;
    }
}
