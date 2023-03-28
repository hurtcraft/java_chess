
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Cavalier extends Piece{
    public Cavalier(){
        this.nom="Cavalier";
    }
    public Cavalier(int x ,int y, BufferedImage img){
        this();
        this.x=x;
        this.y=y;
        this.img=img;
    }

    ArrayList<Coord> get_solution_coord(Board board){
        ArrayList<Coord> solution_coord = new ArrayList<>();
        Coord potential_coord;
        int x1=2;
        int y1=1;
        for (int i = 0; i < 2; i++) {

            potential_coord=new Coord(this.x+x1, this.y+y1);
            //System.out.println(potential_coord);
            System.out.println(coord_in_board(potential_coord));
            if(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
            }
            y1=y1*-1;
            potential_coord=new Coord(this.x+x1, this.y+y1);

            if(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
            }
            x1=x1*-1;
            
        }
        x1=1;
        y1=2; // a revoir
        for (int i = 0; i < 2; i++) {

            potential_coord=new Coord(this.x+x1, this.y+y1);
            if(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
            }
            y1=y1*-1;
            potential_coord=new Coord(this.x+x1, this.y+y1);

            if(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
            }
            x1=x1*-1;
            
        }
        
        return solution_coord;
    }
    
}
