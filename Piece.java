import java.util.ArrayList;


enum Piece_nom{
    Roi(0),Renne(1),Tour(2),Cavalier(3),Fou(4),Pion(5);
    private int num;
    Piece_nom (int num){
        this.num=num;
    }
    public int get_num(){
        return this.num;
    }

}
abstract class Piece {

    protected int x;
    protected int y;
    protected String nom;
    protected ArrayList<Coord> solution_coord= new ArrayList<>();
    protected int max_solution;
    
    abstract void move(int x , int y);// fait bouger une piece
    abstract ArrayList<Coord> get_solution_coord();// met dans this.solution_coord la liste des solutions possible
    
    protected Coord get_coord(){
        return new Coord(this.x,this.y);
    }
    protected boolean coord_in_board(Coord my_coord){
        int x = my_coord.get_x();
        int y = my_coord.get_y();
        final int board_size=8;// a revoir
        if(x>board_size || y>board_size || x<0 || y <0){
            return false;
        }
        return true;
    }

}

class Cavalier extends Piece{
    public Cavalier(){
        this.nom="Cavalier";
    }
    public Cavalier(int x ,int y){
        this.x=x;
        this.y=y;
        this.max_solution=8;// un cavalier ne peut au maximum que 4 cases sur lequel il peu se déplacé
    }
    public void move(int x , int y){
        this.x=x;
        this.y=y;
    }
    public ArrayList<Coord> get_solution_coord(){
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
