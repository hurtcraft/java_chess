import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Chess_panel extends JPanel{
    public Chess_panel(){

    }
    public void paintComponent(Graphics g){
        int x=80;//largeur d'une case;
        int y=80;//longueur d'une case;
        int nb_case=8;// nb de case dans une largeur
        g.setColor(Color.black);
        g.drawRect(x,y, x*nb_case, y*nb_case);

        for (int i = 0; i < x*nb_case/2; i++) {

            for (int j = 0; j < y*nb_case/2; j++) {
                if(j%2!=0 && i%2!=0){
                    g.setColor(Color.black);

                }
                else{
                    g.setColor(Color.gray);
                }
                g.fillRect(x*i,y*j, x, y);



            }

        }
        }
}
