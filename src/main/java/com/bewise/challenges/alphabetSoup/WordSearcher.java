package com.bewise.challenges.alphabetSoup;

import java.util.ArrayList;
import java.util.List;

public class WordSearcher {

    private char soup[][];

    public WordSearcher(char soup[][]) {
        this.soup = soup;
    }

    public boolean isPresent(String word) {
        char[] letras = word.toCharArray();
        int ultimaFila = this.soup.length;
        int ultimaColumna = this.soup[0].length;
        int indiceLetra = 0;
        List<String> recorrido = new ArrayList<>();

        for (int fila = 0; fila < ultimaFila; fila++) {
            for (int columna = 0; columna < ultimaColumna; columna++) {
                boolean existePalabra = existePalabra(letras, indiceLetra, fila, columna, recorrido);
                if (existePalabra) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existePalabra(char[] letras, int indiceLetra, int fila, int columna, List<String> recorrido) {
        boolean palabraEncontrada = false;

        if (letras[indiceLetra] == this.soup[fila][columna]) {
            recorrido.add(fila + "-" + columna);

            if (indiceLetra == letras.length - 1) {
                return true;
            }
            indiceLetra++;

            int filaMas = fila + 1;
            int filaMenos = fila - 1;
            int columnaMas = columna + 1;
            int columnaMenos = columna - 1;
            int ultimaFila = this.soup.length - 1;
            int ultimaColumna = this.soup[0].length - 1;

            if (filaMas <= ultimaFila && !recorrido.contains(filaMas + "-" + columna)) {
                palabraEncontrada = existePalabra(letras, indiceLetra, filaMas, columna, recorrido);
            }
            if (filaMenos >= 0 && !palabraEncontrada && !recorrido.contains(filaMenos + "-" + columna)) {
                palabraEncontrada = existePalabra(letras, indiceLetra, fila - 1, columna, recorrido);
            }
            if (columnaMas <= ultimaColumna && !palabraEncontrada && !recorrido.contains(fila + "-" + columnaMas)) {
                palabraEncontrada = existePalabra(letras, indiceLetra, fila, columnaMas, recorrido);
            }
            if (columnaMenos >= 0 && !palabraEncontrada && !recorrido.contains(fila + "-" + columnaMenos)) {
                palabraEncontrada = existePalabra(letras, indiceLetra, fila, columnaMenos, recorrido);
            }
            if (filaMas <= ultimaFila && columnaMas <= ultimaColumna && !palabraEncontrada && !recorrido.contains(filaMas + "-" + columnaMas)) {
                palabraEncontrada = existePalabra(letras, indiceLetra, filaMas, columnaMas, recorrido);
            }
            if (filaMenos >= 0 && columnaMenos >= 0 && !palabraEncontrada && !recorrido.contains(filaMenos + "-" + columnaMenos)) {
                palabraEncontrada = existePalabra(letras, indiceLetra, filaMenos, columnaMenos, recorrido);
            }
            if (filaMenos >= 0 && columnaMas <= ultimaColumna && !palabraEncontrada && !recorrido.contains(filaMenos + "-" + columnaMas)) {
                palabraEncontrada = existePalabra(letras, indiceLetra, filaMenos, columnaMas, recorrido);
            }
            if (filaMas <= ultimaFila && columnaMenos >= 0 && !palabraEncontrada && !recorrido.contains(filaMas + "-" + columnaMenos)) {
                palabraEncontrada = existePalabra(letras, indiceLetra, filaMas, columnaMenos, recorrido);
            }
        }
        return palabraEncontrada;
    }
}