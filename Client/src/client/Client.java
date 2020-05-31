/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Marina
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Client();
    }
    
    public Client() throws IOException
    {
     
        try
        {
        
         mySocket=new Socket("127.0.0.1",5005);//keda ana 3raft el socket bta3 el client(mariam).. lazm yb2a m3aha el 3ewan w rakm el ka3a 
         
         dis=new  DataInputStream(mySocket.getInputStream()); //mariam btsm3
         
        ps=new PrintStream(mySocket.getOutputStream());
         ps.println("Test Test"); //htb3at 
        
         String replyMsg=dis.readLine(); //hatsm3 el reply 
         System.out.println(replyMsg); //a3red el reply 
        }
        catch(IOException ex)
        {
          ex.getStackTrace();
        }
        
        try
        {
          ps.close();
          dis.close();
          mySocket.close();
        }
        catch(Exception ex)
        {
         ex.printStackTrace();
        }
        
        
    }
    
}
