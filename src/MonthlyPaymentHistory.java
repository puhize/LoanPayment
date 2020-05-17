import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.Map;

public class MonthlyPaymentHistory extends JPanel{
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   static Input input;
   LoanCalculator calc;
   DecimalFormat formatter = new DecimalFormat();
   JFrame frame;
   
	/**
	 * Launch the application.
	 */
   public void newScreen() {
      EventQueue.invokeLater(
         new Runnable() {
            public void run() {
               try {
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
         });
   }
	

	/**
	 * Create the application.
	 */
   public MonthlyPaymentHistory() {
      initialize();
   }
   /**
 *  Initialize the contents of the frame.
 */
   private void initialize() {
   
      JScrollPane scrollPane = new JScrollPane(this);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
      this.setPreferredSize(new Dimension(15*Input.months,850));
      frame = new JFrame("Monthly Payment History");
      frame.setSize(900,850);
      frame.getContentPane().add(scrollPane);
      frame.setVisible(true);
      scrollPane.setViewportView(this);
   }

   public void paintComponent(Graphics g) {
      Map<?, ?> desktopHints = (Map<?,?>)
            Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints");
      Graphics2D g2d = (Graphics2D) g;
      if(desktopHints != null) {
         g2d.setRenderingHints(desktopHints);
      }
      setBackground(new Color(191, 205, 219));
      super.paintComponent(g);
      int x = 20;
      int y = 30;
      g.setFont(new Font("SansSerif", Font.PLAIN,18)); 
      double loan = Input.loan;
      for(int counter = 0; counter <=Input.months;counter++) {
         double left = ((1+Input.monthly_rate)*loan)-LoanCalculator.monthly_payment;
         if(y>800) {x=x+360; y=30;}	
         g.drawString("Month "+ (counter) +" : "+formatter.format(loan)+" € left to pay", x, y);
         y=y+30;
         loan=left;
      }
   }
   		
}


