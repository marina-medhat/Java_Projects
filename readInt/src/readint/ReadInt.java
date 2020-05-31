/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Marina
 */
public class ReadInt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        File xofile = new File("xoData.txt");

        FileWriter wr = new FileWriter(xofile);
        for (int i = 0; i < 10; i++) {
            wr.write(new Integer(44).toString());
            wr.write("\n");
        }
        wr.close();

        /* Scanner scanner=new Scanner(new File("xoData.txt"));
        int [] tall=new int[100];
        int i=0;
        while(scanner.hasNextLong())
        {
        tall[i++]=scanner.nextInt();
        System.out.println(tall[i]);
        }*/
        FileReader file = new FileReader(xofile);
        BufferedReader bf = new BufferedReader(file);
        String st = bf.readLine();

        while ((st = bf.readLine()) != null) {
            StringTokenizer stn = new StringTokenizer(st);
            int num = Integer.parseInt(stn.nextToken());
            System.out.println(num);

        }

        if (xofile.delete()) {
            System.out.println("File Deleted Successfully");
        } else {
            System.out.println("Failed to delete the file");
        }

    }

}
