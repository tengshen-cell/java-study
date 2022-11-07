package com.yin.singlethreadedexcecution.a1_1;

public class UserThread {
    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    public void run() {
        System.out.println(myname + " BEGIN");
        while (true) {
            gate.pass(myname, myaddress);
        }
    }
}
