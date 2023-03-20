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
    
    
    abstract ArrayList<Coord> get_solution_coord();// met dans this.solution_coord la liste des solutions possible
    
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
    public String toString(){
        return this.nom;
    }

}

class Cavalier extends Piece{
    public Cavalier(){
        this.nom="Cavalier";
    }
    public Cavalier(int x ,int y){
        this();
        this.x=x;
        this.y=y;
    }

    ArrayList<Coord> get_solution_coord(){
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

class Fou extends Piece{
    public Fou(){
        this.nom="Fou";
    }
    public Fou(int x, int y){
        this();
        this.x=x;
        this.y=y;
    }

    
    public ArrayList<Coord> get_solution_coord() {
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
                X+=x1;
                Y+=y1;
                solution_coord.add(potential_coord);
                potential_coord=new Coord(X,Y);

            }
            y1=y1*-1;

        }


        for (int i = 0; i <2; i++) {
            
            X=this.x+x1;
            Y=this.y+y1;
            potential_coord=new Coord(X,Y);
            while(this.coord_in_board(potential_coord)){

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
class Tour extends Piece{
    public Tour(){
        this.nom="Tour";
    }
    public Tour(int x , int y){
        this();
        this.x=x;
        this.y=y;
    }
    
    ArrayList<Coord> get_solution_coord() {
        // TODO Auto-generated method stub
        ArrayList<Coord> solution_coord = new ArrayList<>();
        Coord potential_coord;
        int x1=1;
        int y1=1;
        int X;
        int Y;
       
        for (int i = 0; i <2; i++) {
            X=this.x+x1;
            potential_coord=new Coord(X, this.y);
            while(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
                X+=x1;
                potential_coord=new Coord(X,this.y);
                
            }
            x1=x1*-1;

        }
        for (int i = 0; i <2; i++) {
            Y=this.y+y1;
            potential_coord=new Coord(this.x, Y);
            while(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
                Y+=y1;
                potential_coord=new Coord(this.x,Y);
                
            }
            y1=y1*-1;

        }
        for (Coord coord : solution_coord) {
            System.out.println(coord);
        }
        return solution_coord;
    }

}

class Renne extends Piece{

    public Renne(){
        this.nom="Renne";
    }
    public Renne(int x,int y){
        this();
        this.x=x;
        this.y=y;
    }
    ArrayList<Coord> get_solution_ligne(){
        ArrayList<Coord> solution_coord = new ArrayList<>();
        Coord potential_coord;
        int x1=1;
        int y1=1;
        int X;
        int Y;
        
        for (int i = 0; i <2; i++) {
            X=this.x+x1;
            potential_coord=new Coord(X, this.y);
            while(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
                X+=x1;
                potential_coord=new Coord(X,this.y);
                
            }
            x1=x1*-1;

        }
        for (int i = 0; i <2; i++) {
            Y=this.y+y1;
            potential_coord=new Coord(this.x, Y);
            while(coord_in_board(potential_coord)){
                solution_coord.add(potential_coord);
                Y+=y1;
                potential_coord=new Coord(this.x,Y);
                
            }
            y1=y1*-1;

        }
        return solution_coord;
    }

    ArrayList<Coord> get_solution_diag(){
        
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
                    X+=x1;
                    Y+=y1;
                    solution_coord.add(potential_coord);
                    potential_coord=new Coord(X,Y);

                }
                y1=y1*-1;

            }


            for (int i = 0; i <2; i++) {
                
                X=this.x+x1;
                Y=this.y+y1;
                potential_coord=new Coord(X,Y);
                while(this.coord_in_board(potential_coord)){

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
    
    ArrayList<Coord> get_solution_coord() {

        ArrayList<Coord> solution_coord=new ArrayList<>(this.get_solution_ligne());
        solution_coord.addAll(this.get_solution_diag());
        for (Coord coord : solution_coord) {
            System.out.println(coord);
        }
        return solution_coord;
    
    }
}

class Pion extends Piece{
    public Pion(){
        this.nom="Pion";
    }
    public Pion(int x , int y){
        this();
        this.x=x;
        this.y=y;
    }
    @Override
    ArrayList<Coord> get_solution_coord() {
        // TODO Auto-generated method stub
        ArrayList<Coord> solution_coord=new ArrayList<>();
        Coord potential_coord=new Coord(this.x, this.y+1);
        if(coord_in_board(potential_coord)){
            solution_coord.add(potential_coord);
        }
        potential_coord=new Coord(this.x+1, this.y+1);
        if(coord_in_board(potential_coord)){
            solution_coord.add(potential_coord);
        }
        potential_coord=new Coord(this.x-1, this.y+1);
        if(coord_in_board(potential_coord)){
            solution_coord.add(potential_coord);
        }
        for (Coord coord : solution_coord) {
            System.out.println(coord);
        }
        return solution_coord;
    }
    
}

class Roi extends Piece{
    public Roi(){
        this.nom="Roi";

    }
    public Roi(int x,int y){
        this();
        this.x=x;
        this.y=y;
    }
    @Override
    ArrayList<Coord> get_solution_coord() {
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
