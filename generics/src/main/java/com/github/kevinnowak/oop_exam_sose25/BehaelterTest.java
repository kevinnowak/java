package com.github.kevinnowak.oop_exam_sose25;

class BehaelterTest {

    public static void main(String[] args) {
        Behaelter<?> a = new Behaelter<Gegenstand>();
//        Behaelter<Gegenstand> b = new Behaelter<Buch>();
        Behaelter<? extends Buch> c = new Behaelter<Buch>();
//        c.legeHinein(new Buch());
    }
}
