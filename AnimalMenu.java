import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.InputStream;
import javax.sound.sampled.*;

/**
 * This is a class that builds a menu for animal sounds
 * @extends JFrame
 * @implements ActionListener
 */
public class AnimalMenu extends JFrame implements ActionListener
{
    private JMenu menu1, menu2, menu3,menu4, submenu1, submenu2;
    private JMenuItem i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, j1, j2, j3, j4, j5, j6, polarBear, pandaBear, brownBear, blackBear, sunBear;
    private JLabel mainLabel, label, imageLabel;
    private JTextField textField;
    private JPanel panel;
    private JButton button1,button2;
    private JFrame f;
    private Image icon;
    private Clip currentSound;

    AnimalMenu(){
      f= new JFrame("How do animals sound?");
      JMenuBar mb=new JMenuBar();
      label = new JLabel(" ");
      mainLabel = new JLabel("Please select a menu option");
      ImageIcon icon = new ImageIcon("Chad_Whiteley.jpg");
      Image iconImage = icon.getImage();
      Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
      icon = new ImageIcon(newImage);
      JLabel imageLabel = new JLabel(icon);

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

      //fourth menu bar
      menu4 = new JMenu ("Cryptozoology");
      j1=new JMenuItem("Hyppogriff");
      j1.addActionListener(this);
      j2=new JMenuItem("Phoenix");
      j2.addActionListener(this);
      j3=new JMenuItem("Goblins");
      j3.addActionListener(this);
      j4=new JMenuItem("Ogre");
      j4.addActionListener(this);
      j5=new JMenuItem("Fairy");
      j5.addActionListener(this);
      j6=new JMenuItem("Basilisk");
      j6.addActionListener(this);
      menu4.add(j1);menu4.add(j2);menu4.add(j3);menu4.add(j4);menu4.add(j5);menu4.add(j6);
      mb.add(menu4);
      
      bearMenu = new JMenu("Bears");
      polarBear = new JMenuItem("Polar Bear");
      polarBear.addActionListener(this);
      pandaBear = new JMenuItem("Panda Bear");
      pandaBear.addActionListener(this);
      brownBear = new JMenuItem("Brown Bear");
      brownBear.addActionListener(this);
      blackBear = new JMenuItem("Black Bear");
      blackBear.addActionListener(this);
      sunBear = new JMenuItem("Sun Bear");
      sunBear.addActionListener(this);
      
      bearMenu.add(polarBear); bearMenu.add(pandaBear); bearMenu.add(brownBear);
      bearMenu.add(blackBear); bearMenu.add(sunBear);
      mb.add(bearMenu);


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
          label.setText(animal);
          f.getContentPane().removeAll();
          f.repaint();
          f.add(label);

          InputStream path = getClass().getResourceAsStream(soundFile);

              try{
                currentSound = AudioSystem.getClip();
                currentSound.open(AudioSystem.getAudioInputStream(path));

              }catch(Exception fail){}

          ImageIcon icon= new ImageIcon(iconImage);
          imageLabel = new JLabel(icon);
          button1.setVisible(true);
          f.add(imageLabel);
          f.add(button1);
          f.revalidate();

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
        if(e.getSource()==j1){
            ImageIcon icon = new ImageIcon("hippogriff.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Hippogriff", newImage, "hippogriff.wav");
        }
        if(e.getSource()==j2){
            ImageIcon icon = new ImageIcon("phoenix.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Phoenix",newImage, "phoenix.wav");
        }
        if(e.getSource()==j3){
            ImageIcon icon = new ImageIcon("goblins.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Goblins", newImage, "goblins.wav");
        }
        if(e.getSource()==j4){
            ImageIcon icon = new ImageIcon("ogre.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Ogre", newImage, "ogre.wav");
        }
        if(e.getSource()==j5){
            ImageIcon icon = new ImageIcon("fairy.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Gorilla", newImage, "gorilla.wav");
        }
        if(e.getSource()==j6){
            ImageIcon icon = new ImageIcon("basilisk.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Basilisk", newImage, "basilisk.wav");
        if(e.getSource()==polarBear){
            ImageIcon icon = new ImageIcon("Polar_Bear.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Polar Bear",newImage, "polarbear.wav");
        }
        if(e.getSource()==pandaBear){
            ImageIcon icon = new ImageIcon("Panda-Bear.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Panda Bear",newImage, "panda.wav");
        }
        if(e.getSource()==brownBear){
            ImageIcon icon = new ImageIcon("Brown_Bear.jpeg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Brown Bear",newImage, "Grizzly.wav");
        }
        if(e.getSource()==blackBear){
            ImageIcon icon = new ImageIcon("Black_Bear.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Black Bear",newImage, "black.wav");
        }
        if(e.getSource()==sunBear){
            ImageIcon icon = new ImageIcon("Sun_Bear.jpg");
            Image iconImage = icon.getImage();
            Image newImage = iconImage.getScaledInstance(120,120, java.awt.Image.SCALE_SMOOTH);
            animalGUI("Sun Bear",newImage, "sun.wav");

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
      new MenuExample();
    }
}
