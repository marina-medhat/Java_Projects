/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Marina
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int sum=0;
         int n=Integer.parseInt(args[0]);
         
        /* if(args.length==1)
             sum=Integer.parseInt(args[0]);*/
        for(int i=0;i<(args.length);i++)
        {
            if(i==0)
               sum=Integer.parseInt(args[0]);
                
          
            
            else if(i%2==1)
        {
        n=Integer.parseInt(args[i+1]);
        
        
        
        switch(args[i])
        {
            case "+":
                sum+=n;
                break;
                
            case "-":
                sum-=n;
                break;
                
            case "/":
                sum/=n;
                break;
                
            case "x":
                sum*=n;
                break;
        }
        
        }
        
        
        
    
    }
        System.out.println("sum="+sum);
    }
}
