package Ex2_Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PollThread extends Thread {
    public Chat client;
    public int nbMess;
    
    public PollThread(Chat clientRef) {
        this.nbMess = 0;
        this.client = clientRef;
    }
    
    public void run(){
        try {
            int nbMessRecep;
            String message;
        while (true) {
            nbMessRecep = client.recupNBmessages(); // on recup le nb de message pour être sur qu'il change pas pendant notre boucle
            if(nbMessRecep>this.nbMess) {
                for(int i = this.nbMess;i<nbMessRecep;i++) {
                    message = client.recepMessage(i);
                    System.out.println(message);
                }
                this.nbMess = nbMessRecep;
            }
            Thread.sleep(100);
        }
        }catch (IOException | InterruptedException e) {};
    }
    
    
}
