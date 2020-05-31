/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stars;

/**
 *
 * @author Marina
 */
public class Triang {
    private int size;
    
    public Triang()
    {
     size=0;
    }
    public int getsize()
    {
        return size;
    
    }
    
    public void setSize(int x)
    {
     size=x;
    }
    
    public void draw1()
    {
      for(int i=0;i<size;i++)
      {
        for(int j=0;j<i+1;j++)
        {
           System.out.print("*");
        }
        System.out.println();
      }
    }
    
    
    public void draw2()
    {
    
     for(int i=0;i<size;i++)
     {
       for(int j=0;j<size-i;j++)
       {
         System.out.print(" ");
       }
       
       for(int k=size-i;k<size;k++)
       {
         System.out.print("*");
         System.out.print(" ");
       }
       System.out.println();
       
     }
    }
    
    
}
