package com.bewise.challenges.util;

import com.bewise.challenges.sorting.Jugador;

import java.util.Comparator;

public class ComparatorJugadorPorPuntosPerdidasYNombre implements Comparator<Jugador> {

    @Override
    public int compare(Jugador jugador1, Jugador jugador2) {
        if (esMismaPuntuacion(jugador1, jugador2)) {
            if (esMismaCantidadDePerdidas(jugador1, jugador2)) {
                return jugador1.getNombre().compareTo(jugador2.getNombre());
            }
            return jugador1.getPerdidas() > jugador2.getPerdidas() ? 1 : -1;
        }
        return jugador1.getPuntuacion() > jugador2.getPuntuacion() ? -1 : 1;
    }

    private static boolean esMismaCantidadDePerdidas(Jugador jugador1, Jugador jugador2) {
        return jugador1.getPerdidas() == jugador2.getPerdidas();
    }

    private static boolean esMismaPuntuacion(Jugador jugador1, Jugador jugador2) {
        return jugador1.getPuntuacion() == jugador2.getPuntuacion();
    }

}
