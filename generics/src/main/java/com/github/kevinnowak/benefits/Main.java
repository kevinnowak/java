package com.github.kevinnowak.benefits;

class Main {

    public static void main(String[] args) {
        Box box = new Box<>("My String"); // Raw type box -> variable not of type Box<String>
        String s2 = (String) box.getData(); // No incompatible type error
//        String s1 = box.getData(); // Incompatible type error

        Box<String> box1 = new Box<>("Hello");
        Box box2 = box1;

        box2.setData("New String");
    }
}
