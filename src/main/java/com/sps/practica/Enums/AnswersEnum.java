package com.sps.practica.Enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum AnswersEnum {
    SI,NO,PROBABLEMENTE,INTENTA_PREGUNTANDO_DE_NUEVO;

    private static final List<AnswersEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static AnswersEnum randomAnswer() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    } 
}
