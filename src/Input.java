import javax.swing.*;
public class Input {
   static double loan;
   static double annual_rate;
   static double monthly_rate;
   static int months;


   public static void insert() {
      try {
      
         loan = Double.parseDouble(JOptionPane.showInputDialog("Write the loan amount in euros: "));
         annual_rate = Double.parseDouble(JOptionPane.showInputDialog("Write the annual interest rate: "));
         months = Integer.parseInt(JOptionPane.showInputDialog("Write the number of months: "));
         monthly_rate=annual_rate/1200;
      
      
         if(loan<0 || annual_rate<0||months<0) {
            JOptionPane.showMessageDialog(null, "The following values should not be negative!");
            insert();}
      	
      }
        catch(NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Please write a valid numerical value!");
         insert();    
         }
      catch(NullPointerException e) {
    	  System.exit(0);
      } 	
   }  
}
