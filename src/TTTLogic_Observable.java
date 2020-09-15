import java.awt.*;
import java.util.Observable;

public class TTTLogic_Observable extends Observable{

    public static Button[] tttButton = new Button[9];

    public void StartGame(Label turnLabel){
        turnLabel.setText("X's turn");

        System.out.println("game started");
    }

    public void tttButtonClick(String index){
//        tttButton[Integer.parseInt(index)].setLabel("x");
        setChanged();
        notifyObservers(tttButton[Integer.parseInt(index)]);
    }

}
