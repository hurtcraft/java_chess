import java.util.ArrayList;

public class Board{
    private Piece board_tab[][];
    private final int size;
    public Board(){
        this.size=8;
        this.board_tab=new Piece[size][size];

    }
    
    public Piece get_piece(int x , int y){
        return board_tab[x][y];
    }
    public void set_piece(Piece p, Coord c){

    }
    public void init(){
        Pion pion;
        Cavalier cavalier;
        Roi roi;
        Fou fou;
        Tour tour;


        for (int i = 0; i<3; i++) {
            tour=new Tour(i,i);
            board_tab[i][i]=tour;
            
        }
    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i <this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                sb.append(this.board_tab[i][j]);
            }
            sb.append("---------------------------");
            sb.append("\n");
        }


        return sb.toString();
    }
    
}