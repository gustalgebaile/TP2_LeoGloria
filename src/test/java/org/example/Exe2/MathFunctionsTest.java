package org.example.Exe2;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

public class MathFunctionsTest {
    @Property
    boolean dobroMaiorOuIgual(@ForAll @IntRange(min = 0, max = 1073741823) int number) {
        int resultado = MathFunctions.multiplyByTwo(number);
        return resultado >= number;
    }
    @Property
    boolean dobroDeParEhPar(@ForAll int number) {
        if (number % 2 == 0) {
            return MathFunctions.multiplyByTwo(number) % 2 == 0;
        }
        return true;
    }
}

