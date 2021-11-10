import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.InputStream;
import javax.sound.sampled.*;
 
/**
 * This is a class that builds a menu for animal sounds
 * @extends JFrame
 * @implements ActionListener
 * 
 * This change was made to my project.
 */
public class AnimalMenu extends JFrame implements ActionListener  
{  
    private JMenu menu1, menu2, menu3, submenu1, submenu2;  
    private JMenuItem i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11;  
    private JLabel mainLabel, label, imageLabel;
    private JTextField textField;
    private JPanel panel;
    private JMenuBar mb;
    private JButton button1,button2;
    private JFrame f;
    private Image icon;
    private Clip currentSound;
    
    
    public JLabel getLabel(){
        return label;
    }
    
    public JFrame getFrame(){
        return f;
    }
    
    public JLabel getImageLabel(){
        return imageLabel;
    }
    
    public JButton getButton1(){
        return button1;
    }
    
    public void setImageLabel(JLabel icon){
        imageLabel = icon;
    }
    
    AnimalMenu(){  
      f= new JFrame("How do animals sound?");  
      mb=new JMenuBar();
      label = new JLabel(" ");
      mainLabel = new JLabel("Please select a menu option");
      ImageIcon icon = new ImageIcon("Chad_Whiteley.jpg");
      Image iconImage = icon.getImage();
      Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
      icon = new ImageIcon(newImage);
      imageLabel = new JLabel(icon);

      //first menu bar
      menu1=new JMenu("Marsupials");    
      i1=new JMenuItem("Kangaroo");  
      i2=new JMenuItem("Opossum");  
      i3=new JMenuItem("Koala");  
      i4=new JMenuItem("Wallaby");  
      i5=new JMenuItem("Wombat");  
      menu1.add(i1); menu1.add(i2); menu1.add(i3); menu1.add(i4); menu1.add(i5);
      //submenu1.add(i4); submenu1.add(i5);  
      //menu1.add(submenu1);  
      mb.add(menu1);  
      
      //second menu bar
      menu2 = new JMenu ("Snakes");
      submenu1 = new JMenu("Poinous Snakes");      
      submenu2 = new JMenu("Non-poisonous Snakes");
      i6=new JMenuItem("Cobra");  
      i7=new JMenuItem("Water Moccasin");  
      i8=new JMenuItem("Copperhead");  
      i9=new JMenuItem("Rattlesnake");
      submenu1.add(i6); submenu1.add(i7); submenu1.add(i8); submenu1.add(i9);  
      menu2.add(submenu1); menu2.add(submenu2);      
      mb.add(menu2);
      
      //third menu bar
      menu3=new JMenu("Primate");     
      i10=new JMenuItem("Gorilla");
      i10.addActionListener(this);
      i11=new JMenuItem("Human");
      i11.addActionListener(this);
      menu3.add(i10); menu3.add(i11);  
      mb.add(menu3); 

      
      f.setJMenuBar(mb);  
      f.setSize(400,400);  
      f.setLayout(new FlowLayout());
      label.setText("Please select an option above.");
      f.add(label);
      f.add(imageLabel);
      f.setVisible(true);
      button1=new JButton ("Sounds Like");
      button1.addActionListener(this);
      button1.setVisible(false);
      f.add(button1);
    }
    
    /**
     * This is the method that sets up the animal GUI
     * 
     * @param   animal - the name of the animal that is being set up
     * @param   iconImage - the picture of the animal
     * @param   soundFile - the sound that the animal makes
     */
    public void animalGUI(String animal, Image iconImage, String soundFile){
          
    }
    
    /**
     * This tests to see if a String can be a number.
     * 
     * @param s - the String being tested
     */
    public boolean isNumeric(String s) {  
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
    } 
    
    
    /**
     * This is the actionPerformed class that accepts
     * action events from the menu and JFrame buttons. 
     */
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource()==i10){    
            ImageIcon icon = new ImageIcon("gorilla.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            new primate(this,"Gorilla", newImage, "gorilla.wav");
        }
        if(e.getSource()==i11){
            ImageIcon icon = new ImageIcon("human.jfif");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Human",newImage, "human.wav");
        }
        if (e.getSource()==button1){
            currentSound.start();
        }
    }     
    
    /**
     * This is the main method whereby everything else runs
     * 
     * @param   args - the array of Strings that help run the program.
     */
    
    public static void main(String [] args)  
    {  
      new AnimalMenu();  
    }
}  
