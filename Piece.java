import java.util.ArrayList;


abstract class Piece {

    protected int x;
    protected int y;
    protected String nom;
    protected ArrayList<Coord> solution_coord= new ArrayList<>();
    protected int max_solution;
    
    
    
    abstract ArrayList<Coord> get_solution_coord(Board board);// met dans this.solution_coord la liste des solutions possible
    
    protected void move(int x , int y){
        this.x=x;
        this.y=y;
    }

    protected Coord get_coord(){
        return new Coord(this.x,this.y);
    }

    protected boolean coord_in_board(Coord my_coord){
        int x = my_coord.get_x();
        int y = my_coord.get_y();
        final int board_size=8;// a revoir
        if(x>=board_size || y>=board_size || x<0 || y <0){
            return false;
        }
        return true;
    }
    protected boolean piece_sur_chemin(Board board,int x ,int y){
        if(board.get_piece(x, y)!=null){
            return true;
        }
        return false;
    }
    public String toString(){
        return this.nom;
    }


}





