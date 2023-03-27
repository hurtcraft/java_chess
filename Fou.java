
import java.util.ArrayList;

public class Fou extends Piece{
    public Fou(){
        this.nom="Fou";
    }
    public Fou(int x, int y){
        this();
        this.x=x;
        this.y=y;
    }

    
    public ArrayList<Coord> get_solution_coord(Board board) {
        // TODO Auto-generated method stub
        ArrayList<Coord> solution_coord = new ArrayList<>();
        Coord potential_coord;
        int x1=1;
        int y1=1;

        int X;
        int Y;

        for (int i = 0; i <2; i++) {
            x1=x1*-1;
            X=this.x+x1;
            Y=this.y+y1;
            potential_coord=new Coord(X,Y);
            while(this.coord_in_board(potential_coord)){
                // c dangereux ici 
                //System.out.println(X+" "+Y);
                if(x1==1 && y1==-1 && piece_sur_chemin(board, X, Y)){
                    solution_coord.add(potential_coord);

                    break;
                }
                else if(x1==-1 && y1==1 && piece_sur_chemin(board, X, Y)){
                    solution_coord.add(potential_coord);

                    break;
                }
                
                solution_coord.add(potential_coord);

                X+=x1;
                Y+=y1;
                potential_coord=new Coord(X,Y);                

            }
            y1=y1*-1;

        }


        for (int i = 0; i <2; i++) {
            
            X=this.x+x1;
            Y=this.y+y1;
            potential_coord=new Coord(X,Y);
            while(this.coord_in_board(potential_coord)){
                if(x1==-1 && y1==-1 && piece_sur_chemin(board, X, Y)){
                    solution_coord.add(potential_coord);

                    break;
                }
                else if(x1==1 && y1==1 && piece_sur_chemin(board, X, Y)){
                    solution_coord.add(potential_coord);

                    break;
                }
                solution_coord.add(potential_coord);
                X+=x1;
                Y+=y1;
                potential_coord=new Coord(X,Y);

            }
            x1=x1*-1;
            y1=y1*-1;

        }

        return solution_coord;

    }
     
}