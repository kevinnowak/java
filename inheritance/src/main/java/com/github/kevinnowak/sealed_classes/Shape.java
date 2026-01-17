package com.github.kevinnowak.sealed_classes;

public sealed class Shape permits Circle, Square, Triangle {
}

final class Circle extends Shape {}

final class Square extends Shape {}

final class Triangle extends Shape {}
