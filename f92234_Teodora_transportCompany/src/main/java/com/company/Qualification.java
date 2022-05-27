package com.company;

public enum Qualification {

    MORETHAN12PERSON(1), SPECIALLOAD(2), INFLAMMABLE(3);
    private int num;

    Qualification(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
