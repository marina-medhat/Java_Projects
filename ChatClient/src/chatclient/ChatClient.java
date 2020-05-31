/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Marina
 */
public class ChatClient extends JFrame {

    /**
     * @param args the command line arguments
     */
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public ChatClient() {

        try {

            mySocket = new Socket("10.145.5.250", 4000);//keda ana 3raft el socket bta3 el client(mariam).. lazm yb2a m3aha el 3ewan w rakm el ka3a 

            dis = new DataInputStream(mySocket.getInputStream()); //mariam btsm3

            ps = new PrintStream(mySocket.getOutputStream());
            this.setLayout(new FlowLayout());
            JTextArea ta = new JTextArea(10, 30);
            JScrollPane scroll = new JScrollPane(ta);
            scroll.setViewportView(ta);
            JTextField tf = new JTextField(30);
            JButton okButton = new JButton("Send");

            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    ps.println(tf.getText());
                    tf.setText("");
                }
            });

            add(scroll);
            add(tf);
            add(okButton);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String replyMsg = null;
                        try {
                            replyMsg = dis.readLine();
                            
                        } catch (IOException ex) {
                            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      ta.append(replyMsg);
                    }
                }
            }).start();
//        try {
//
//            mySocket = new Socket("127.0.0.1", 5005);//keda ana 3raft el socket bta3 el client(mariam).. lazm yb2a m3aha el 3ewan w rakm el ka3a 
//
//            dis = new DataInputStream(mySocket.getInputStream()); //mariam btsm3
//
//            ps = new PrintStream(mySocket.getOutputStream());
//            ps.println("Test Test"); //htb3at 
            /* String replyMsg = dis.readLine(); //hatsm3 el reply 
            System.out.println(replyMsg); //a3red el reply */

            Thread th;
            th = new Thread(new Runnable() {
                public void run() {

                    while (true) {
                        String replyMsg = null;
                        try {
                            replyMsg = dis.readLine();
                        } catch (IOException ex) {
                            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(replyMsg);
                    }

                }
            });
        } catch (IOException ex) {
            ex.getStackTrace();
        }

//        try {
//            ps.close();
//            dis.close();
//            mySocket.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ChatClient chC = new ChatClient();
        chC.setSize(300, 400);
        chC.setVisible(true);
    }

}
