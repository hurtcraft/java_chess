import javax.swing.JFrame;
import javax.swing.JPanel;
class Chess{

    public static void main(String arv[]){
        Board board = new Board();
        //board.init();
        
        
        Pion p=new Pion(3,3,true);
        Pion p1=new Pion(4,4,false);
        //Pion p2=new Pion(4,2);
        //Chess_window f=new Chess_window();
        
        board.set_piece(p, p.get_coord());
        board.set_piece(p1, p1.get_coord());
        //board.set_piece(p2, p2.get_coord());
        System.out.println(board);
        System.out.println("solution p : ");
        p.get_solution_coord(board);
        System.out.println("solution p1 : ");
        p1.get_solution_coord(board);
    
        //System.out.println(p.get_solution_coord(board));
        //p1.get_solution_coord(board);

    }

}