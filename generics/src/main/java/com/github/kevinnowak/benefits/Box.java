package com.github.kevinnowak.benefits;

class Box<T> {

    private T data;

    Box(T data) {
        this.data = data;
    }

    T getData() {
        return this.data;
    }

    void setData(T data) {
        this.data = data;
    }
}
