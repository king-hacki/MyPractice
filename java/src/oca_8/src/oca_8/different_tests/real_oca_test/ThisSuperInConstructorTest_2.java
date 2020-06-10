package oca_8.different_tests.real_oca_test;

public class ThisSuperInConstructorTest_2 {
}

class Vehicle {
    String type = "3";
    int maxSpeed = 2;

    public Vehicle(String type, int maxSpeed) {
        this.type = type;
        this.maxSpeed = maxSpeed;
    }
}

class Car extends Vehicle {
    String trans;

//    public Car(String trans) {
//        this.trans = trans;
//    }
//
//    public Car(String type, int maxSpeed, String trans) {
//        super(type, maxSpeed);
//        this(trans);
//    }


    public Car(String type, int maxSpeed, String trans) {
        super(type, maxSpeed);
        this.trans = trans;
    }
}
