package com.github.kevinnowak;

import java.util.Comparator;

class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}
