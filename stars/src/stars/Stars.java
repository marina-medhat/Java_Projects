/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package stars;
import java.lang.Integer;

/**
 *
 * @author Marina
 */
public class Stars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(args.length<=0)
        {
        System.out.println("please enter a valid naumber:");
        }
        else
        {
          int size=Integer.parseInt(args[0]);
        
        
        Triang t=new Triang();
        t.setSize(size);
        t.draw1();
        System.out.println("______________________");
        t.draw2();
        }
    }
    
}
