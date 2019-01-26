package karan_final;
import java.util.ArrayList;
public class Message {
    private String senderss;
    private ArrayList<String> peoples;
  public Message() {
        this.senderss = "";
        this.peoples = new ArrayList<String>();}
 public void myCaller(String caller) {
        this.senderss = caller;}
    public String getCaller() {
        return this.senderss;} 
    public void newThread(String friend) {
        this.peoples.add(friend);}  
    public ArrayList<String> getFriends() {
        return this.peoples;} 
    public String toString() {
        String output = senderss + ": [";
        output += peoples.get(0);
        for(int i=1; i<peoples.size(); i++) {
            output += ", " + peoples.get(i);}
        output += "]";
        return output;}}