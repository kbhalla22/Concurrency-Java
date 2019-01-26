package karan_final;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Exchange {
    private static final String myfile = "C:\\Users\\karan\\tutorials\\karan_final\\src\\karan_final\\calls.txt";
private static ArrayList<Message> threadcall() {
        ArrayList<Message> chats = new ArrayList<Message>();
        try {
  File file = new File(myfile);
   Scanner s = new Scanner(file);
   while(s.hasNextLine()) {
  String mydata = s.nextLine().trim();
  mydata = mydata.substring(1, mydata.length()-2);
 String sender = mydata.substring(0, mydata.indexOf(","));
 String receiver = mydata.substring(mydata.indexOf("[")+1, mydata.indexOf("]"));
 String mynumber [] = receiver.split(",");
 Message inputCall = new Message();
  inputCall.myCaller(sender.trim());
   for(int i=0; i<mynumber.length; i++) {
  inputCall.newThread(mynumber[i].trim());}
   chats.add(inputCall);} 
   s.close();
        } catch (Exception e) {
   e.printStackTrace();}    
        return chats;}
    public static void main(String [] args) {
        ArrayList<Message> myarraylist = threadcall();
        Interactions xyz = new Interactions(myarraylist);
        Thread mythread = new Thread(xyz);
        mythread.start();}}
