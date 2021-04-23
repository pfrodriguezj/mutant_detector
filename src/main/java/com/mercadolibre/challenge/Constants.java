package com.mercadolibre.challenge;

import java.util.regex.Pattern;

public final class Constants {

    public static String MUTANT_DNA_PATTERN = "([A-Z])\\1{3}";
    public static Pattern COMPILED_MUTANT_PATTERN = Pattern.compile(MUTANT_DNA_PATTERN, Pattern.CASE_INSENSITIVE);
    public static Long MIN_COMPLIANT_SEQUENCES = 2L;
}
