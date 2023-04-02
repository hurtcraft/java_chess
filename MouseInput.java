import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Map;

public class MouseInput implements MouseMotionListener , MouseListener{
    private Chess_panel chess_panel;
    private Board board;
    public MouseInput(Chess_panel chess_panel,Board board){
        this.chess_panel=chess_panel;
        this.board=board;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("true");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println((e.getX())/7+" "+(e.getY())7);
        int nb_case=this.chess_panel.get_nb_case();
        int x_board=this.chess_panel.get_board_x();
        int y_board=this.chess_panel.get_board_y();
        int x;
        int y;
        //System.out.println(e.getX()+" "+x_board + " " +x_board*nb_case);
        if ((e.getX()>=x_board && e.getX()<=x_board*nb_case+x_board) && (e.getY()>=y_board && e.getY()<=y_board*nb_case*2+y_board)){// me demandez pas pk ca marche mais ca marche 
            x=e.getX()-x_board;
            y=e.getY()-y_board;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Map<String , Piece> pieces_blanc= this.chess_panel.get_map_pieces_blanc();
        Map<String , Piece> pieces_noir=this.chess_panel.get_map_pieces_noir();
        int nb_case=this.chess_panel.get_nb_case();
        int x_board=this.chess_panel.get_board_x();
        int y_board=this.chess_panel.get_board_y();
        int x;
        int y;
        Piece piece_tmp;
        //System.out.println(e.getX()+" "+x_board + " " +x_board*nb_case);
        if ((e.getX()>=x_board && e.getX()<=x_board*nb_case+x_board) && (e.getY()>=y_board && e.getY()<=y_board*nb_case*2+y_board)){// me demandez pas pk ca marche mais ca marche 
            x=e.getX()-x_board;
            y=e.getY()-y_board;
            //System.out.println(x/80+" "+y/80);
            piece_tmp=this.board.get_piece( y/this.chess_panel.get_largeur_case(),x/this.chess_panel.get_largeur_case());
            System.out.print(y/80+" "+x/80);
            piece_tmp.get_solution_coord(board);
        }
        
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}
