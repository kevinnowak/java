package com.github.kevinnowak;

public class MyClassIsMyCastle {

    private static int streetNo = 169;

    private static class FirstFloor {

        private static class DiningRoom {
            private static int size = 36;

            private static void myMessage() {
                System.out.println("I can access street number: " + streetNo);
            }
        }
    }

    private static class SecondFloor {

        private static class BathRoom {
            private static int size = 16;

            private static void myMess() {
                System.out.println("I can access the dining room size: " + FirstFloor.DiningRoom.size);
            }
        }
    }

    public static void main(String[] args) {
        FirstFloor.DiningRoom.myMessage();
        SecondFloor.BathRoom.myMess();
    }
}
