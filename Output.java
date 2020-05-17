import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Output extends JPanel {
/**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   static Input input;
   LoanCalculator calc;
   double monthly_payment = LoanCalculator.monthlyLoan(Input.monthly_rate, Input.loan, Input.months); 
   private final Action action = new SwingAction();
   private final Action action_1 = new SwingAction_1();
   JFrame frame;

 
   public Output(){
      frame = new JFrame("Loan Calculator");
      frame.setVisible(true);
      frame.setBackground(new Color(191, 205, 219));
      frame.setSize(600,600); 
      frame.getContentPane().add(this);
      setLayout(null);
   
      JButton btnNewButton = new JButton("Show payment history");
      btnNewButton.setAction(action);
      btnNewButton.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               MonthlyPaymentHistory mp = new MonthlyPaymentHistory();
               mp.newScreen();
            
            }
         });
      btnNewButton.setBounds(306, 491, 166, 26);
      add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("Reset");
      btnNewButton_1.setAction(action_1);
      btnNewButton_1.setBounds(113, 491, 98, 26);
      add(btnNewButton_1);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void paintComponent(Graphics g) {
      g.setFont(new Font("SansSerif", Font.PLAIN,20));
      g.drawString("Loan ammount: ",20,40);
      g.drawString("Annual interest rate: ", 20, 100);
      g.drawString("Loan payment duration in months: ", 20, 160);
      g.drawString("Monthly payment: ", 20, 220);
      g.drawString("Annual payment: ", 20, 280);
      g.drawString("Total payment: ",20, 340);
      g.setFont(new Font("HelvaticaNeue",Font.ITALIC,18));
      g.drawRect(350,20,160,30);
      g.drawString(Input.loan+" €", 380, 40);
      g.drawRect(350,80,160,30);
      g.drawString(Input.annual_rate+" %", 415, 100);
      g.drawRect(350, 140, 160, 30);
      g.drawString(Input.months+" ", 415, 160);
      g.drawRect(350, 200,160, 30);
      g.drawString(monthly_payment+" €",400,220);
      g.drawRect(350,260,160,30);
      g.drawString(LoanCalculator.annual_payment +" €", 380, 280);
      g.drawRect(350,320,160, 30);
      g.drawString(LoanCalculator.total_payment+" €", 380, 340);
   }
   /**
 * @param args
 */
   public static void main(String[] args) {
      Input.insert();
      new Output();
   
   }

   private class SwingAction extends AbstractAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
    * 
    */
      public SwingAction() {
         putValue(NAME, "Show payment history");
         putValue(SHORT_DESCRIPTION, "Some short description");
      }
      public void actionPerformed(ActionEvent e) {
      }
   }
   private class SwingAction_1 extends AbstractAction {
   	/**
   	 * 
   	 */
      private static final long serialVersionUID = 1L;
      public SwingAction_1() {
         putValue(NAME, "Reset");
         putValue(SHORT_DESCRIPTION, "Some short description");
      }
      public void actionPerformed(ActionEvent e) {
         frame.setVisible(false);
         Input.insert();
         new Output();
      	
      }
   }
}

