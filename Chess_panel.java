import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Chess_panel extends JPanel{
    private MouseInput mouse_input;
    private Color green;
    private Color white;

    
    private BufferedImage img;
    private BufferedImage white_piece_img[];
    private BufferedImage black_piece_img[]; 
    private Board board;
    
    public Chess_panel(Board board ){
        this.mouse_input=new MouseInput(this);
        this.green=new Color(127,166,80);
        this.white=new Color(235,236,208);
        //addMouseMotionListener(mouse_input);
        //addMouseListener(mouse_input);
        this.import_img();
        this.load_piece_img();   
        this.board=board;
        //this.board.init();
        
        
    }
    
    private void load_piece_img() {
        int nb_piece=6;
        int width=this.img.getWidth()/nb_piece;
        int height=this.img.getHeight()/2;
        this.white_piece_img=new BufferedImage[nb_piece];
        this.white_piece_img=new BufferedImage[nb_piece];
        for (int i = 0; i <nb_piece; i++) {
            this.white_piece_img[i]=this.img.getSubimage(i*width, 0, width, height);
            this.white_piece_img[i]=this.img.getSubimage(i*width, height, width, height);
        }
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        //merci stackoverflow
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    }  

    public void import_img(){
        InputStream is=getClass().getResourceAsStream("Pieces.png");

        try {
            this.img=ImageIO.read(is);
            int width=(int)((int)this.img.getWidth()/1.7);
            int height=(int) ((int) this.img.getHeight()/1.7);
            this.img=resize(this.img,width,height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g){
        int x=80;//largeur d'une case;
        int y=80;//longueur d'une case;
        int nb_case=8;// nb de case dans une largeur
        
        //g.drawImage(this.img,x, y, (int)this.img.getWidth()/2,(int)this.img.getHeight()/2,null);
        draw_board(g, nb_case, x, y);
        g.drawImage(this.white_piece_img[5], x, y/2, green, getFocusCycleRootAncestor());
        draw_piece(g);
        draw_cadre(g, nb_case, x, y);
        repaint();
    }
    public void draw_board(Graphics g ,int nb_case, int x,int y){
        for (int i = 0; i < nb_case; i++) {
            for (int j = 0; j <nb_case; j++) {
                if(i%2!=0){
                    if(j%2!=0){
                        g.setColor(this.green);           
                    }
                    else{
                        g.setColor(this.white);
                    }
                }
                else{
                    if(j%2!=0){
                        g.setColor(this.white);           
                    }
                    else{
                        g.setColor(this.green);
                    }
                }

                g.fillRect(x+(j*x), (y/2)+i*y, x, y);
            }
        }

    }
    public void draw_cadre(Graphics g,int nb_case,int x,int y){
        g.setColor(Color.black);

        g.drawRect(x,y/2, x*nb_case, y*nb_case);
        g.drawRect(x+1,y/2, x*nb_case, y*nb_case);
    }
    public void draw_piece(Graphics g ){
        
    }
    public BufferedImage get_img(boolean couleur,int index){
        if(!couleur){
            return this.white_piece_img[index];
        }
        return this.black_piece_img[index];
    }
}

