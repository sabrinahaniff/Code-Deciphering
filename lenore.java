
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 1. The first code word is to be considered as word #0.
 * 2. For odd numbered code words, use only the third
 * and fifth characters in the word.
 * 3. For all other code words, use only the second
 * character in the word.
 * Write a program which will enter the code words into
 * an array in the order given. Have the program decode
 * the hidden message for Lenore.
 * 
 * 
 * 
 * 
 *
 * @author sabrinahaniff
 */
public class lenore
{

    public static void main(String[] args)
    {
       Scanner src = new Scanner(System.in);
       
      
       int numberCodeMessages = 0;
       
       System.out.println("Code Deciphering Application \n");
       
       //ask the user how many coded messages they would like to enter
       System.out.println("How many coded messages would you like to enter?");
       numberCodeMessages = src.nextInt();
       
       //create an array and input the number of coded messages the user wants to input in the array
       String[] codeMessages = new String[numberCodeMessages];
      
        
       System.out.println("Please enter in " + numberCodeMessages + " coded messages.");
       
       //loop the number of times to read in the coded messages
       for(int i = 0; i < numberCodeMessages; i++)
       {
           Scanner src2 = new Scanner(System.in);
           
           codeMessages[i] = src2.nextLine();  
           
       }
       
       //create a file writer to input the coded messages that were sent from Candar
       try
       {
         FileWriter obj = new FileWriter("secretCode.txt");
         
         obj.write("Message from Candar: " + "\n");
         
         for(int i = 0; i < numberCodeMessages; i++)
         {           
           obj.write(codeMessages[i] + "\n");  
         }
         obj.close();         
       }
       catch(IOException e)
       {
          System.out.println("Error during write" + e.getMessage()); 
       }
      
          
       
       
       //create a variable that will decipher the coded messages 
        String message = "";
      
        //used .length to find how many coded messages are entered
        for(int i = 0; i < codeMessages.length; i++)
        {
            //safety check to make sure the array is intialized correctly
            if(codeMessages[i] == null || codeMessages[i].length() < 2)
                continue;
            
            //if the coded message is even, take the second character of the message
            if( (i % 2) == 0)
            {
                message += codeMessages[i].substring(1, 2); 
            }
            //if the coded message is odd, then take the third and fifth character of the message
            else
            {
                message += codeMessages[i].substring(2, 3); 
                message += codeMessages[i].substring(4, 5); 
            }
            
        }
        
        //print the deciphered message
        System.out.println("The deciphered message is: " + message);
        
    }
    


    
}
