package com.github.kevinnowak.local_variable_type_inference;

class TypeInferenceAndInheritance {

    static MyClass getObj(int which) {
        return switch (which) {
            case 0 -> new MyClass();
            case 1 -> new FirstDerivedClass();
            default -> new SecondDerivedClass();
        };
    }

    public static void main(String[] args) {
        var myClass = getObj(0);
        var firstDerivedClass = getObj(1);
        var secondDerivedClass = getObj(2);

        System.out.println(
                myClass instanceof MyClass &&
                        firstDerivedClass instanceof MyClass &&
                        secondDerivedClass instanceof MyClass
        );

        System.out.println(myClass.getClass());
        System.out.println(firstDerivedClass.getClass());
        System.out.println(secondDerivedClass.getClass());

        // firstDerivedClass.x = 10; -> won't work
        // secondDerivedClass.y = 10; -> won't work
    }
}
