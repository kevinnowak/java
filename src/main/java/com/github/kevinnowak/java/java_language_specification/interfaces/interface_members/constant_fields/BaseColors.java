package com.github.kevinnowak.java.java_language_specification.interfaces.interface_members.constant_fields;

interface BaseColors {
    // Implicitly public, final, and static
    public final static int RED = 1, GREEN = 2, BLUE = 4;
}

interface RainbowColors extends BaseColors {
    int YELLOW = 3, ORANGE = 5, INDIGO = 6, VIOLET = 7;
}

interface PrintColors extends BaseColors {
    int YELLOW = 8, CYAN = 16, MAGENTA = 32;
}

interface LotsOfColors extends RainbowColors, PrintColors {
    int FUCHSIA = 17, VERMILION = PrintColors.YELLOW + 43, CHARTREUSE = RED + 90;
}
