package karan_final;
import java.util.ArrayList;
public class Interactions implements Runnable {
    private ArrayList<Message> calls;
    private ArrayList<Persons> friends;
    private boolean AliveThread;
    private long start;
    public Interactions(ArrayList<Message> calls) {
        this.calls = calls;
        this.friends = new ArrayList<Persons>();
        this.Friendthreads();
        AliveThread = true;
        start = System.currentTimeMillis();
    }
    public void run() {
        showThread();
        while(AliveThread) {
            if(!calls.isEmpty()) {
                renameProcess(calls.get(0));
                calls.remove(0);
            }
            for(Persons friend: friends) {
                if(!friend.namealive()) {
                    System.out.println("Process "+ friend.getName() +" has received no calls for 1 second, ending...");
                    friends.remove(friend);
                    break;}}
            long exitthread = System.currentTimeMillis();
            long sub = exitthread - start;
            if(sub >= 1500) {
                System.out.println("Master has received no replies for 1.5 seconds, ending...");
                AliveThread = false;}}}
    private void renameProcess(Message call) {
        ArrayList<String> list = call.getFriends();
        int check = getIndex(call.getCaller());
        if (check >= 0) {
            for (String tempo : list) {
                String result = friends.get(check).outputnew(tempo);
                System.out.println(result);
                int index = getIndex(tempo);
                friends.get(index).newTime(System.currentTimeMillis());
                start = System.currentTimeMillis();}
            for (String tempo : list) {
                check = getIndex(tempo);
                if (check >= 0) {
                    String result = friends.get(check).sendback(call.getCaller());
                    System.out.println(result);
                    friends.get(check).newTime(System.currentTimeMillis());
                    start = System.currentTimeMillis();
                }}}}

    private int getIndex(String friend) {
        for(int i=0; i<friends.size(); i++) {
            if(friends.get(i).getName().equalsIgnoreCase(friend))
            {
                return i;
            }}
        return -1;
    }
   
    private void showThread() {
        System.out.println("** Calls to be made **");
        for(Message call: calls) {
            System.out.println(call);
        }
    }
    private void Friendthreads() {
        for(Message call: calls) {
            Persons friend = new Persons(call.getCaller());
            this.friends.add(friend);
            Thread thread = new Thread(friend);
            thread.start();}}}
