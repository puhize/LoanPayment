import java.text.*;

public class LoanCalculator {

   static DecimalFormat formatter = new DecimalFormat("#.##");

  static double monthly_payment=0.0;
  static double annual_payment=0.0;
  static double total_payment = 0.0;
   public static double monthlyLoan(double i, double l, int m ) {   
      monthly_payment = (Math.pow(1+i,m)*l*i)/(Math.pow(1+i,m)-1);
      double monthlypay = Double.parseDouble(formatter.format(monthly_payment));
      annual_payment = Double.parseDouble(formatter.format(monthly_payment*12));
      total_payment = Double.parseDouble(formatter.format(monthly_payment*m));
      return monthlypay;
   
   }
   

}


