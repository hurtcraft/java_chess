public class Coord{
    private int x;
    private int y;
    public Coord(int x , int y){
        this.x=x;
        this.y=y;
    }
    public int get_x(){
        return this.x;
    } 
    public int get_y(){
        return this.y;
    }
    public String toString(){
        return new String("( X : "+this.x+" Y : "+this.y+" )");
    }
}