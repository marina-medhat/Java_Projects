/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Marina
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Server();
    }
    
    public Server() throws IOException
    {
       try
       {
         myServerSocket=new ServerSocket(5005);
         s=myServerSocket.accept();//listen ana mstany mariam ted5ol
         dis=new DataInputStream(s.getInputStream());//marcelle btsm3
         ps=new PrintStream(s.getOutputStream()); //marcelle btsm3 
         String msg=dis.readLine(); //hta5od el data el gaylha mn el socket el client 
         System.out.println(msg); //ttba3ha
         ps.println("Data Recieved"); //tmam yasta glk el klam 
       }
       catch(IOException ex)
       {
       
        ex.printStackTrace();
       
       }
       
       
       try
       {
         ps.close();
         dis.close();
         s.close();
         myServerSocket.close();
       }
       
      catch(Exception ex)
      {
        ex.printStackTrace();
      }
    
    }
    
}
