import javax.swing.JFrame;
import java.awt.*;
public class Chess_window extends JFrame{
    private JFrame fenetre;
    public Chess_window(Chess_panel panel){
        fenetre=new JFrame("Chess");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1000,800);
        fenetre.setLocationRelativeTo(null);
        fenetre.add(panel);
        fenetre.setResizable(false);
        fenetre.setVisible(true);
        
    }

}
