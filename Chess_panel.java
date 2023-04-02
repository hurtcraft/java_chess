import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.Map;

import javax.swing.JPanel;

public class Chess_panel extends JPanel{
    private MouseInput mouse_input;
    private Color green;
    private Color white;

    
    private Map<String,Piece> pieces_blanc;
    private Map<String,Piece> pieces_noir;
    
    private static final int largeur_case=80;
    private static final int longueur_case=80;

    private  int x_board;
    private  int y_board;
    private static final int NB_CASE=8;

    private Board board;
    public Chess_panel(Board board ,Map<String,Piece> pieces_blanc,Map<String,Piece>pieces_noir){
        this.mouse_input=new MouseInput(this,board);
        this.x_board=largeur_case;
        this.y_board=longueur_case/2;
        this.green=new Color(127,166,80);
        this.white=new Color(235,236,208);
        addMouseMotionListener(mouse_input);
        addMouseListener(mouse_input);
        this.pieces_blanc=pieces_blanc;
        this.pieces_noir=pieces_noir;
        this.board=board;

        //this.board.init();

    }
    public Board get_board(){
        return this.board;
    }
    public int get_largeur_case(){
        return Chess_panel.largeur_case;
    }
    public Map<String,Piece> get_map_pieces_blanc()
    {
        return this.pieces_blanc;
    }
    public Map<String,Piece> get_map_pieces_noir()
    {
        return this.pieces_noir;
    }
    public int get_board_x(){
        return this.x_board;
    }
    public int get_board_y(){
        return this.y_board;
    }
    public int get_nb_case(){
        return Chess_panel.NB_CASE;
    }
    public void paintComponent(Graphics g){

        
        //g.drawImage(this.img,x, y, (int)this.img.getWidth()/2,(int)this.img.getHeight()/2,null);
        draw_board(g, Chess_panel.NB_CASE, Chess_panel.largeur_case, Chess_panel.longueur_case);
        //g.drawImage(this.white_piece_img[5], x, y/2, green, getFocusCycleRootAncestor());
        
        draw_cadre(g, Chess_panel.NB_CASE, Chess_panel.largeur_case, Chess_panel.longueur_case);
        draw_piece(g,this.x_board, this.y_board);
        draw_dot(g, 10, 10);
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
    public void draw_piece(Graphics g ,int x , int y){
        Piece p_tmp;
        int X;
        int Y;
        for (String nom_piece : this.pieces_blanc.keySet()) {
            p_tmp=this.pieces_blanc.get(nom_piece);
            X=p_tmp.get_coord().get_y()*x+x;
            Y=p_tmp.get_coord().get_x()*y+y;
            if(nom_piece.charAt(0)=='P'){
                Y+=y;
            }
            g.drawImage(p_tmp.get_img(),X,Y, getFocusCycleRootAncestor());

            p_tmp=this.pieces_noir.get(nom_piece);
            X=(p_tmp.get_coord().get_y()*x+x);
            Y=(p_tmp.get_coord().get_x()*y+y/2)*2;
            g.drawImage(p_tmp.get_img(),X,Y, getFocusCycleRootAncestor());
        }
    }
    public void draw_dot(Graphics g,int x , int y ){
        
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 10, 10);
    }

}

