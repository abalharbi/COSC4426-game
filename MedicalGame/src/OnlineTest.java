import java.awt.*;  
import java.awt.event.*;  
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l,l1;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3,b4;
    JPanel p,p1,p2,p3;
    JLabel label = new JLabel(); 
    JLabel lt1,lt2,lt3,lt4;
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0,lifetime=3;  
    int m[]=new int[5];   
    
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  
    
    OnlineTest(String s)   
    {  
       
        
        super(s);  
        JFrame f=new JFrame();
        try
        {
        f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\x_d7m\\workspace\\MedicalGame\\background.jpg")))));
        l=new JLabel();
        l1=new JLabel();
        lt1=new JLabel();
        lt2=new JLabel();
        lt3=new JLabel();
        lt4=new JLabel();
        p=new JPanel();
        f.add(l);  
        f.add(l1);
        f.add(lt1);
        f.add(lt2);
        f.add(lt3);
        f.add(lt4);
        f.add(p);
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            f.add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
       b2=new JButton("Result"); 
       b3=new JButton("Try Again");
       b4=new JButton("Exit");
       b2.setEnabled(false);
       b3.setEnabled(false);
       
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        b3.addActionListener(this); 
        b4.addActionListener(this);  
        f.add(b1);f.add(b2); f.add(b3);f.add(b4); 
        set();
        l1.setBounds(160,20,450,40);
        l1.setText("QUIZ ON MEDICAL OBJECTS");
        l1.setFont(new Font("Serif", Font.BOLD, 24));
        
        l.setBounds(50,70,450,20);  
        ImageIcon icon = new ImageIcon("C:\\Users\\x_d7m\\workspace\\MedicalGame\\lifetime.png"); 
       lt4.setBounds(30,310,50,30);
        lt1.setBounds(90,300,50,50);
       
        lt2.setBounds(120,300,50,50);

        lt3.setBounds(150,300,50,50);
        lt4.setText("Your Life");
        lt1.setIcon(icon);
        lt2.setIcon(icon);
        lt3.setIcon(icon);
         
            
        f.add(lt1);
        f.add(lt2);
        f.add(lt3);
        p.setBounds(300,70,270,270);
        jb[0].setBounds(50,100,200,20);  
        jb[1].setBounds(50,130,200,20);  
        jb[2].setBounds(50,160,200,20);  
            jb[3].setBounds(50,190,200,20);  
        b1.setBounds(30,220,100,30);  
        b2.setBounds(150,220,100,30);  
        b3.setBounds(30,270,100,30);
       
        b4.setBounds(150,270,100,30);
     
             f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setSize(screenSize);
    f.setResizable(false);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        
        f.setLayout(null);  
        f.setLocation(100,100);  
        //setVisible(true);  

//f.setVisible(true); 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        f.pack();
        
   
    
        
    }
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;
            else
            {
                lifetime=lifetime-1;
            
            
            if(lifetime==2)
            {  lt1.setEnabled(false);
                    try{
                String soundName = "C:\\Users\\x_d7m\\workspace\\MedicalGame\\lose.wav";
            
AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
Clip clip = AudioSystem.getClip();
clip.open(audioInputStream);
clip.start();
            }
            catch (LineUnavailableException a) {
            }

        catch (UnsupportedAudioFileException | IOException b) {

        }
                JOptionPane.showMessageDialog(this,"you lost one life time !!!");}
            else if(lifetime==1)
            { lt2.setEnabled(false); 
            try{
                String soundName = "C:\\Users\\x_d7m\\workspace\\MedicalGame\\lose.wav";
            
AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
Clip clip = AudioSystem.getClip();
clip.open(audioInputStream);
clip.start();
            }
            catch (LineUnavailableException a) {
            }

        catch (UnsupportedAudioFileException | IOException b) {

        }
            JOptionPane.showMessageDialog(this,"you lost one more life time !!! ");}
            else if(lifetime==0)
            { lt3.setEnabled(false);  JOptionPane.showMessageDialog(this,"you lost all life times !!! GameOver! ");
            b1.setEnabled(false); 
                //b3.setEnabled(false);
            JOptionPane.showMessageDialog(this,"COUNT IS "+count+ " AND UR SCORE IS "+(count*10));
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setEnabled(true);
            jb[0].setVisible(false);  
            jb[1].setVisible(false);  
            jb[2].setVisible(false);  
            jb[3].setVisible(false);  
        l.setVisible(false);
         lt1.setVisible(false);
           lt2.setVisible(false);
           lt3.setVisible(false);
           lt4.setVisible(false);
        p.setVisible(false);
         p1.setVisible(false);
          p2.setVisible(false);
           p3.setVisible(false);
          
        
            
            }
            else
            {
                
                try{
                String soundName = "C:\\Users\\x_d7m\\workspace\\MedicalGame\\lose.wav";
            
AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
Clip clip = AudioSystem.getClip();
clip.open(audioInputStream);
clip.start();
            }
            catch (LineUnavailableException a) {
            }

        catch (UnsupportedAudioFileException | IOException b) {

        }
                //JOptionPane.showMessageDialog(this,"U lost all life times so game over");
                //JOptionPane.showMessageDialog(this,"COUNT IS "+count+ " AND UR SCORE IS "+(count*10));
        }    //System.exit(0);
        }
            current++;  
            set();    
            if(current==4)
            {  
                b1.setEnabled(false);  
                b2.setEnabled(true);
                b2.setText("Result");
                b3.setEnabled(true);
                b4.setEnabled(true);
                
            }  
        }  
       
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            if(count==5)
            { JOptionPane.showMessageDialog(this,"CONGRATS WELL DONE !!! ALL ARE CORRECT & COUNT IS "+count+ " AND YOUR SCORE IS "+(count*10)); 
           
                b1.setEnabled(false);  
                b2.setEnabled(false);
            
                b3.setEnabled(true);
                b4.setEnabled(true);}
            else 
              JOptionPane.showMessageDialog(this,"COUNT IS "+count+ " AND YOUR SCORE IS "+(count*10));   
            
        }  
        if(e.getActionCommand().equals("Exit"))
        {
             System.exit(0);  
        }
         if(e.getActionCommand().equals("Try Again"))
        {
             new MainScreen("Quiz on Medical Objects"); 
        }
    }  
    void set()  
    {  
        jb[4].setSelected(true);  

        if(current==0)  
        {  
            l.setText("Question 1: What is this?");  
            jb[0].setText("Blood Pressure Meter");jb[1].setText("Gluco Meter");jb[2].setText("Temperature Reading");jb[3].setText("None"); 
            ImageIcon icon = new ImageIcon("C:\\Users\\x_d7m\\workspace\\MedicalGame\\q1.jpg"); 
            label.setIcon(icon); 
            p.add(label); 
        }  
        if(current==1)  
        {  
            l.setText("Question 2: Choose the correct answer?");  
            jb[0].setText("Dropper");jb[1].setText("Pipet");jb[2].setText("Funnel");jb[3].setText("Stir Rod"); 
            ImageIcon icon = new ImageIcon("C:\\Users\\x_d7m\\workspace\\MedicalGame\\q2.jpg"); 
            label.setIcon(icon); 
            p.add(label); 
          
        }  
        if(current==2)  
        {  
            l.setText("Question 3: What is this?");  
            jb[0].setText("Fasting Blood Sugar meter");jb[1].setText("Blood Pressure meter");jb[2].setText("Gluco Meter");jb[3].setText("Blood Group Meter"); 
             // p.add(new JLabel(new ImageIcon ("D:\\q3.jpg")));
              ImageIcon icon = new ImageIcon("C:\\Users\\x_d7m\\workspace\\MedicalGame\\q3.jpg"); 
              label.setIcon(icon); 
              p.add(label); 
          
        }  
        if(current==3)  
        {  
            l.setText("Question 4: Choose the correct answer?");  
            jb[0].setText("Heart Rate Reading Meter");jb[1].setText("Pressure Reading Meter");jb[2].setText("Respriation Reading Meter");jb[3].setText("ECG Meter");  
              ImageIcon icon = new ImageIcon("C:\\Users\\x_d7m\\workspace\\MedicalGame\\q4.jpg"); 
              label.setIcon(icon); 
              p.add(label); 
          
        }  
        if(current==4)  
        {  
            l.setText("Question 5: What is this?");  
            jb[0].setText("Thermo Meter");jb[1].setText("Freezer Reading");jb[2].setText("Glucose Reading");jb[3].setText("None");  
            ImageIcon icon = new ImageIcon("C:\\Users\\x_d7m\\workspace\\MedicalGame\\q5.jpg"); 
            label.setIcon(icon); 
            p.add(label);           
        }  
        
        l.setBounds(50,70,450,20); 
        
        for(int i=0,j=0;i<=90;i+=30,j++)  
           
            jb[j].setBounds(50,100+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[1].isSelected());  
        if(current==3)  
            return(jb[3].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Quiz on Medical Objects");  
    }  
}  
