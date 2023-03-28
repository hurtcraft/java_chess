
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class Roi extends Piece{
    public Roi(){
        this.nom="Roi";

    }
    public Roi(int x,int y,BufferedImage img){
        this();
        this.x=x;
        this.y=y;
        this.img=img;
    }
    @Override
    ArrayList<Coord> get_solution_coord(Board board) {
        ArrayList<Coord> solution_coord= new ArrayList<>();
        int x1=1;
        int y1=1;
        Coord potential_coord;

        for (int i = 0; i < 2; i++) {

            potential_coord=new Coord(this.x, this.y+y1);
            if(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
            }
            potential_coord=new Coord(this.x+x1, this.y);
            if(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
            }
            x1*=-1;
            y1*=-1;
            potential_coord=new Coord(this.x+x1, this.y+y1);
            if(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
            }
            potential_coord=new Coord(this.x-x1, this.y+y1);
            if(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
            }
            
        }
        for (Coord coord : solution_coord) {
            System.out.println(coord);
        }
        return solution_coord;


    }
}
