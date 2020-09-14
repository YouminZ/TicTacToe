import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class TicTacToe{
    public static void main(String[] args){
        GameBoard newGame = new GameBoard();
        newGame.RenderGameBoard();
    }
}

