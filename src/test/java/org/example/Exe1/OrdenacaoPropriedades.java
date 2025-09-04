package org.example.Exe1;

import net.jqwik.api.*;
import java.util.*;

public class OrdenacaoPropriedades {

    // Função que queremos testar
    List<Integer> ordenar(List<Integer> lista) {
        return lista.stream().sorted().toList();
    }

    // Propriedade 1: a lista de saída deve estar ordenada
    @Property
    boolean listaOrdenada(@ForAll List<Integer> lista) {
        List<Integer> ordenada = ordenar(lista);
        for (int i = 0; i < ordenada.size() - 1; i++) {
            if (ordenada.get(i) > ordenada.get(i + 1)) {
                return false; // quebrou a ordem
            }
        }
        return true;
    }

    // Propriedade 2: tamanho da lista deve ser o mesmo
    @Property
    boolean mesmoTamanho(@ForAll List<Integer> lista) {
        return ordenar(lista).size() == lista.size();
    }

    // Propriedade 3: a lista ordenada deve conter os mesmos elementos
    @Property
    boolean mesmosElementos(@ForAll List<Integer> lista) {
        List<Integer> ordenada = ordenar(lista);
        Collections.sort(lista); // ordena a original
        return ordenada.equals(lista); // compara com a saída
    }
}

