package com.bewise.challenges.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     * Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     * Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     *
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {
        char[] arrayCaracteres = obtenerCadenaSinEspaciosEnBlanco(cadena).toCharArray();
        Map<Character, Integer> mapCaracteresRepetidos = obtenerCaracteresRepetidos(arrayCaracteres);
        Set<Integer> setCaracteresRepetidos = new HashSet<>(mapCaracteresRepetidos.values());

        return setCaracteresRepetidos.size() == 1 || setCaracteresRepetidos.size() == 2;
    }

    private String obtenerCadenaSinEspaciosEnBlanco(String cadena) {
        return cadena.replace(" ", "");
    }

    private Map<Character, Integer> obtenerCaracteresRepetidos(char[] arrayCaracteres) {
        char caracter;
        int contadorCaracterRepetido = 0;
        Map<Character, Integer> mapCaracteresRepetidos = new HashMap<>();

        for (int i = 0; i < arrayCaracteres.length; i++) {
            caracter = arrayCaracteres[i];
            for (int j = 0; j < arrayCaracteres.length; j++) {
                if (arrayCaracteres[j] == caracter) {
                    contadorCaracterRepetido++;
                    mapCaracteresRepetidos.put(caracter, contadorCaracterRepetido);
                }
            }
            contadorCaracterRepetido = 0;
        }
        return mapCaracteresRepetidos;
    }
}



