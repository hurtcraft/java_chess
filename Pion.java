
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Pion extends Piece{
    private Boolean couleur;
    public Pion(Boolean couleur){
        this.nom="Pion";
        this.couleur=couleur;// false pour blanc et true pour noir
    }
    //pour inversé les pion ajouté un facteur 7
    
    public Pion(int x , int y,Boolean couleur,BufferedImage img){
        this(couleur);
        this.x=x;
        this.y=y;
        this.img=img;
    }
    @Override
    ArrayList<Coord> get_solution_coord(Board board) {
        // TODO Auto-generated method stub
        ArrayList<Coord> solution_coord=new ArrayList<>();
        int X;
        int Y;
        if(this.couleur==true){
            X=1;
            Y=1;
        }
        else{
            X=-1;
            Y=-1;
        }
        Coord potential_coord=new Coord(this.x+X, this.y+Y);
        
        if(coord_in_board(potential_coord) && piece_sur_chemin(board,potential_coord.get_x(), potential_coord.get_y())){
            solution_coord.add(potential_coord);
        }
        potential_coord=new Coord(this.x+X, this.y+(Y*-1));
        if(coord_in_board(potential_coord) && piece_sur_chemin(board,potential_coord.get_x(), potential_coord.get_y())){
            solution_coord.add(potential_coord);
        }
        potential_coord=new Coord(this.x+X, this.y);
        if(coord_in_board(potential_coord)){
            solution_coord.add(potential_coord);
        }
        for (Coord coord : solution_coord) {
            System.out.println(coord);
        }
        return solution_coord;
    }


    
}
