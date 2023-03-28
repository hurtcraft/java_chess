
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class Tour extends Piece{
    public Tour(){
        this.nom="Tour";
    }
    public Tour(int x , int y , BufferedImage img){
        this();
        this.x=x;
        this.y=y;
        this.img=img;
    }
    
    ArrayList<Coord> get_solution_coord(Board board) {
        // TODO Auto-generated method stub
        ArrayList<Coord> solution_coord = new ArrayList<>();
        Coord potential_coord;
        int x1=1;
        int y1=1;
        int X;
        int Y=this.y;
       
        for (int i = 0; i <2; i++) {
            X=this.x+x1;
            potential_coord=new Coord(X,Y);
            while(coord_in_board(potential_coord)){
                
                if(x1==1 && piece_sur_chemin(board, X, this.y)){
                    solution_coord.add(potential_coord);
                    break;
                }
                if(x1==-1 && piece_sur_chemin(board, X, this.y))
                {
                    solution_coord.add(potential_coord);
                    break;   
                }
                solution_coord.add(potential_coord);
                X+=x1;
                potential_coord=new Coord(X,Y);
            }
            x1=x1*-1;

        }
        X=this.x;
        for (int i = 0; i <2; i++) {
            Y=this.y+y1;
            potential_coord=new Coord(this.x, Y);
            while(coord_in_board(potential_coord)){
                
                if( y1==1 && piece_sur_chemin(board, X, Y)){
                    solution_coord.add(potential_coord);
                    break;
                }
                if( y1==-1 && piece_sur_chemin(board, X, Y))
                {
                    solution_coord.add(potential_coord);
                    break;   
                }
                solution_coord.add(potential_coord);
                Y+=y1;
                potential_coord=new Coord(this.x,Y);
            }
            y1=y1*-1;
        }

        return solution_coord;
    }

}
