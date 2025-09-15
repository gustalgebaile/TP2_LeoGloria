package org.example.Exe1;

import net.jqwik.api.*;
import java.util.*;

class OrdenacaoSimples {

    List<Integer> ordenar(List<Integer> lista) {
        return lista.stream().sorted().toList();
    }

    @Property
    boolean listaSempreOrdenada(@ForAll List<Integer> lista) {
        List<Integer> ordenada = ordenar(lista);
        for (int i = 0; i < ordenada.size() - 1; i++) {
            if (ordenada.get(i) > ordenada.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}


