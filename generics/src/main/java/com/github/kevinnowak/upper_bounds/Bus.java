package com.github.kevinnowak.upper_bounds;

class Bus<T extends SchoolPerson> {

    private T rider;

    Bus(T rider) {
        this.rider = rider;
    }

    T getRider() {
        return rider;
    }

    void setRider(T rider) {
        this.rider = rider;
    }

    void printRider() {
        System.out.println(rider.toString());
    }
}
