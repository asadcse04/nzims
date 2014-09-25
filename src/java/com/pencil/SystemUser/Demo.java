/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SystemUser;

/**
 *
 * @author apple
 */
public class Demo {
    
    public static void main(String[] args)
    {
        //System.out.println(tst("0ss"));
        
        String s1=new String("qaz");
        
        String s2=new String("qaz");
        
        System.out.println(s1==s2);//
        
        int i = 3;

        System.out.println(++i);
        
        
        int j = 3;

        System.out.println(j++);
    }
    
    public static boolean tst(String i)
    {
        try
        {
            Integer.parseInt(i);
            
            System.out.println(i);
            
            return true;
        }
        catch(NumberFormatException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            System.out.println("Hello world");
        }
        
        return false;
    }
    
}
