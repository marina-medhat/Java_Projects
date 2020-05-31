/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marina
 */

public class ChatServer {

    /**
     * @param args the command line arguments
     */
    ServerSocket serverSocket;
    
    public ChatServer() 
    {
        try {
            serverSocket=new ServerSocket(5015);
             while(true)
      {
      
        Socket s=serverSocket.accept();
        new ChatHandler(s);
      }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new ChatServer();
    }
    
}


class ChatHandler extends Thread
{
   DataInputStream dis;
   PrintStream ps;
   static Vector <ChatHandler> clientsVector= new Vector<ChatHandler>();
   
   //hna ay socket haygeli hadefo(mariam, mostafa ..)
   public ChatHandler(Socket cs) 
   {
       try {
           dis=new DataInputStream(cs.getInputStream()); //bysm3
                ps=new PrintStream(cs.getOutputStream()); //bytklm
     clientsVector.add(this);  //7tholi fel vector el feh el clients
     start();
       } catch (IOException ex) {
           Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
       }

   }
   
   public void run()
   {
   
     while(true)
     {
         try {
             String str=dis.readLine();
             sendMessageToAll(str);
         } catch (IOException ex) {
             Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
   
   }
   
   void sendMessageToAll(String msg)
   {
   
   for(ChatHandler ch : clientsVector)
   {
   ch.ps.println(msg);
   }
   }

   



}
