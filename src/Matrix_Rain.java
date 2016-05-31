
/*In this project, I am trying to create a screen that has the binary numbers are falling from the
top of the screen.*/
import java.awt.*;
import java.util.*;
import javax.swing.*;//library has JFRAME
//BEGIN:CLASS:MATRIX_RAIN
public class Matrix_Rain extends JFrame{//to create a JFrame for the project we need to extend it from the library
	//we have statistic type to keep the variable constant 
	private static final int Font_SIZE=30;//The size of the failing words
	private static final int NUMBER_OF_REPEATS=80;//the speed of the rain
	private static final String TEXT= new String("01010101010101011010101101010101010001");// The text I am using
	private static JPanel panel= new JPanel(null);
	private static Random random= new Random( );
	private static JLabel[] label= new JLabel[NUMBER_OF_REPEATS];
//......................................................................
//BEGIN:CONSTRUCTOR	
	public Matrix_Rain()
	{
		   this.add(panel);
		    panel.setBackground(Color.BLACK);
	}
//END:CONSTRUCTOR	
//........................................................................
//BEGIN:METHOD:DISPLAY	
public void display() 
{
			
     for (int i = 0; i < NUMBER_OF_REPEATS; i++) 
          {
		        int initial = random.nextInt(TEXT.length());
		        int random_x = random.nextInt(panel.getWidth() / Font_SIZE) - 1;
		        int CC= 255;// the level the elements reach on the screen
		        label[i] = new JLabel(""+TEXT.charAt(initial));
		        panel.add(label[i]);
		        //set up the font/size/ and the colors of the falling words
		        label[i].setForeground(new Color(0, 20, 0));
		        label[i].setFont(new Font("monospaced", Font.PLAIN, Font_SIZE));
		       
		        //Here we are going to make the move of the elements
		        for (int alpha = 0; alpha < (panel.getHeight() / Font_SIZE)*2; alpha++) 
		        {
		            int character = random.nextInt(TEXT.length());
		            label[i].setBounds(random_x*Font_SIZE, alpha*(Font_SIZE / 2), Font_SIZE, Font_SIZE);
		            label[i].setText(""+TEXT.charAt(character));

		            //if foreground CC < 255 catch exception
		            try {
		                //when text reaches a certain CC remove it
		                label[i].setForeground(new Color(0, 255-(alpha*5), 0));
		                CC = 255-(alpha*5);
		                if (CC <= 100) {
		                    panel.remove(label[i]);
		                    repaint();
		                    CC = 255;
		                    alpha = (panel.getHeight() / Font_SIZE)*2;
		                }
		            } catch (Exception e) {}

		            //pause between each character, thrown exception
		            try {
		                Thread.sleep(15);
		            } catch (Exception e) {}
		        }//End of "for loop".

		        //create an infinite loop
		        if (i == NUMBER_OF_REPEATS - 1) 
		        {
		            i = 0;
		        }
		        
     }//End of the "for statement".
    
}
//END:METHOD:DISPLAY		
//..............................................................................................		
//METHOD::MAIN
	public static void main(String[] args) {
		//DEFAULT WITH JFRAM CLASS
	    Matrix_Rain frame = new Matrix_Rain();
	    frame.setVisible(true);//check if the screen is display or not.
	    frame.setSize(500, 300);//set the size of the screen
	    frame.setResizable(false);//set the size of the screen is not resizable.
	    frame.setMinimumSize(new Dimension(200, 100));
	    frame.setLocationRelativeTo(null);
	    frame.setTitle("Matrix_Rain");//Set the title of the window
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.display();//run the method where the movements are coded
	}
//END:METHOD	
	
}//END:CLASS:MATRIX_RAIN.