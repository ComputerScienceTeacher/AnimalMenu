import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.InputStream;
import javax.sound.sampled.*;


public class primate
{
    AnimalMenu am1;
    private Clip currentSound;
    /**
     * Constructor for objects of class primate
     */
    public primate(AnimalMenu am1, String animal, Image iconImage, String soundFile)
    {
        updateMenuContents(animal, iconImage, soundFile);
  
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void updateMenuContents(String animal, Image iconImage, String soundFile)
    {
          am1.getLabel().setText(animal);
          am1.getFrame().getContentPane().removeAll();
          am1.getFrame().repaint();
          am1.getFrame().add(am1.getLabel());
          
          InputStream path = getClass().getResourceAsStream(soundFile);
          
              try{
                currentSound = AudioSystem.getClip();
                currentSound.open(AudioSystem.getAudioInputStream(path));
            
              }catch(Exception fail){}
              
          ImageIcon icon= new ImageIcon(iconImage);
          am1.setImageLabel(new JLabel(icon)); 
          am1.getButton1().setVisible(true);
          am1.getFrame().add(am1.getButton1());
          am1.getFrame().revalidate();

    }
}
