
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
        import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class MainScreen extends JFrame implements ActionListener  
{
   JLabel l;  
   JButton b1;
   JButton b2;
  
            MainScreen(String s)   
    {  
       
        
        super(s);  
        JFrame f=new JFrame();
        try
        {
        f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\x_d7m\\workspace\\MedicalGame\\background.jpg")))));
        l=new JLabel();
        
       
        f.add(l);  
      
       
       
        b1=new JButton("Start Game");  
       b2=new JButton("Help");  
       
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        f.add(b1);f.add(b2);  
       ;
        l.setBounds(160,20,450,40);
        l.setText("QUIZ ON MEDICAL OBJECTS");
        l.setFont(new Font("Serif", Font.BOLD, 24));
        
         
        b1.setBounds(250,120,100,30);  
        b2.setBounds(250,220,100,30);  
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setLayout(null);  
        f.setLocation(100,100);  
        //setVisible(true);  
        f.setSize(600,800);  
    }
        catch (IOException e) {
            e.printStackTrace();
        }
        f.pack();
        f.setVisible(true);
    }
             public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            String name = JOptionPane.showInputDialog(null,"Enter your name:","Get Details",JOptionPane.INFORMATION_MESSAGE);
             JOptionPane.showMessageDialog(null,"WELCOME "+name.toUpperCase()+" TO PLAY GAME !!!");

      try{
                String soundName = "C:\\Users\\x_d7m\\workspace\\MedicalGame\\click.wav";
            
AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
Clip clip = AudioSystem.getClip();
clip.open(audioInputStream);
clip.start();
            }
            catch (LineUnavailableException a) {
            }

        catch (UnsupportedAudioFileException | IOException b) {

        }
             
             
            new OnlineTest("Quiz on Medical Objects");
            
        }  
        if(e.getSource()==b2)
        {
            try{
                String soundName = "C:\\Users\\x_d7m\\workspace\\MedicalGame\\help.wav";
            
AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
Clip clip = AudioSystem.getClip();
clip.open(audioInputStream);
clip.start();
            }
            catch (LineUnavailableException a) {
            }

        catch (UnsupportedAudioFileException | IOException b) {

        }
            JOptionPane.showMessageDialog(this,"This Quiz is based on medical objects which has 5 questions \n and if you answer correctly then you will get 10 point or else you will lose life time. \n The total life is 3 if all three life time got over then game will get over automatically. \n if Answered all questions then you will final result with score");  
        }
    
}
public static void main(String s[])  
    {  
        new MainScreen("Quiz on Medical Objects");  
    } }



