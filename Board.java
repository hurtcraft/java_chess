import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board{
    private Piece board_tab[][];
    private final int size;
    private Map<String,Piece> pieces_blanc;
    private Map<String,Piece> pieces_noir;
    private boolean init_done;

    private Chess_window window;
    private Chess_panel panel;
    
    public Board(){
        this.size=8;
        this.board_tab=new Piece[size][size];
        this.pieces_blanc=new HashMap<>();
        this.pieces_noir=new HashMap<>();
        this.init_done=false;
        
        
        this.panel=new Chess_panel(this);
        this.window=new Chess_window(this.panel);
        this.init();
        System.out.println(this);
    }
    
    public Piece get_piece(int x , int y){
        
        return board_tab[x][y];
    }
    public void set_piece(Piece p, Coord c){
        board_tab[c.get_x()][c.get_y()]=p;
    }
    public void init(){
        init_pion();
        init_tour();
        init_cavalier();
        init_fou();
        init_renne();
        init_roi();
        Coord coord;

        for (Piece piece_blanc: this.pieces_blanc.values()) {
            coord=piece_blanc.get_coord();
            this.board_tab[coord.get_x()][coord.get_y()]=piece_blanc;
        }
        for (Piece piece_noir : this.pieces_noir.values()){
            coord=piece_noir.get_coord();
            this.board_tab[coord.get_x()][coord.get_y()]=piece_noir;
        }

        this.init_done=true;

    }

    private void init_tour(){
        Tour tour;

        //le haut du plateau sont les blancs
        int x=0;
        int y1=0;
        int y2=this.size-1;
        int t=4;
        tour=new Tour(x,y1,this.panel.get_img(false, t));
        this.pieces_blanc.put("T1", tour);
        tour=new Tour(x,y2,this.panel.get_img(false,t));
        this.pieces_blanc.put("T2", tour);

        x=this.size-1;
        //le bas du plateau sont les noirs
        tour=new Tour(x,y1,this.panel.get_img(true, t));
        this.pieces_noir.put("T1", tour);
        tour=new Tour(x,y2,this.panel.get_img(true, t));
        this.pieces_noir.put("T2", tour);

    }
    private void init_pion(){

        int x1=1;
        int x2=this.size-2;
        int i_pion=5;
        for (int i = 0; i < board_tab.length; i++) {
            this.pieces_blanc.put(new String("P"+i), new Pion(x1,i,false,this.panel.get_img(false, i_pion)));

            this.pieces_noir.put(new String("P"+i), new Pion(x2,i,true,this.panel.get_img(true, i_pion)));
        }
    }
    private void init_fou(){
        Fou fou;
        int x=0;
        int y1=2;
        int y2=this.size-3;
        int i_fou=2;
        fou=new Fou(x,y1,this.panel.get_img(false, i_fou));
        this.pieces_blanc.put("F1", fou);
        fou=new Fou(x,y2,this.panel.get_img(false, i_fou));
        this.pieces_blanc.put("F2", fou);

        x=this.size-1;
        //le bas du plateau sont les noirs
        fou=new Fou(x,y1,this.panel.get_img(true, i_fou));
        this.pieces_noir.put("F1", fou);
        fou=new Fou(x,y2,this.panel.get_img(true, i_fou));
        this.pieces_noir.put("F2", fou);
    }
    private void init_cavalier(){
        Cavalier cavalier;
        int x=0;
        int y1=1;
        int y2=this.size-2;
        int i_cavalier=3;
        cavalier=new Cavalier(x,y1,this.panel.get_img(false, i_cavalier));
        this.pieces_blanc.put("C1", cavalier);
        cavalier=new Cavalier(x,y2,this.panel.get_img(false, i_cavalier));
        this.pieces_blanc.put("C2", cavalier);

        x=this.size-1;

        cavalier=new Cavalier(x,y1,this.panel.get_img(true, i_cavalier));
        this.pieces_noir.put("C1",cavalier);
        cavalier=new Cavalier(x,y2,this.panel.get_img(true, i_cavalier));
        this.pieces_noir.put("C2",cavalier);

    }
    private void init_roi(){
        Roi roi;
        int y=4;
        int i_roi=0;
        roi=new Roi(0,y,this.panel.get_img(false, i_roi));
        this.pieces_blanc.put("Roi", roi);
        roi=new Roi(this.size-1,y,this.panel.get_img(true, i_roi));
        this.pieces_noir.put("Roi", roi);
        
    }
    private void init_renne(){
        Renne renne;
        int y=3;
        int i_renne=1;
        renne=new Renne(0,y,this.panel.get_img(false, i_renne));
        this.pieces_blanc.put("Renne", renne);
        renne=new Renne(this.size-1,y,this.panel.get_img(true,i_renne));
        this.pieces_noir.put("Renne", renne);
    }
    
    
    public void affichage(JFrame fenetre){
        
    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i <this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if(this.board_tab[i][j]==null){
                    sb.append(String.format("[%16s]",""));
                }
                else{
                    //sb.append("["+this.board_tab[i][j]+"]");
                    sb.append(String.format("[%10s %5s]", this.board_tab[i][j],""));
                }
            }
            //sb.append("\n-------------------------------------------------------------------------------------------------------------------------------------------------\n");
            sb.append("\n");
        }


        return sb.toString();
    }
    
}