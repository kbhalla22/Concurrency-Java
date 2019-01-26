package karan_final;

import java.time.*;

public class Persons implements Runnable {

    private String name;
    private long start;
    private boolean life;
  
        public void run() {
        while(life) {
            long times = System.currentTimeMillis();
            long abcd = (times - start) / 1000;
            if(abcd >= 1) {
                life = false;}}}
        public Persons(String name) {
            this.name = name;
            this.start = System.currentTimeMillis();
            this.life = true;}
    public boolean namealive() {
        return this.life;}
    public String getName() {
        return this.name;}
    public String outputnew(String newperson) {
        return newperson + " received intro message from " + name + " [" + System.currentTimeMillis() +"]";
    }
    public void newTime(long time) {
        this.start = time;}
    public String sendback(String friend) {
        return friend + " received reply message from "+ name +" ["+System.currentTimeMillis()+"]";
    }}
