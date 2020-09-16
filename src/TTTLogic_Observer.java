import java.util.Observable;
import java.util.Observer;

public class TTTLogic_Observer implements Observer {

    private TTTLogic_Observable ov;
    public TTTLogic_Observer(TTTLogic_Observable ov){
        this.ov = ov;
        GameBoard newGame = new GameBoard(ov);
        newGame.RenderGameBoard();
    }

    @Override
    public void update(Observable o, Object arg) {
        GameProperties.turnLabel.setText(ov.getCurrentTurn());

        for(int i = 0; i < GameProperties.tttButton.length; i++){
            GameProperties.tttButton[i].setLabel(ov.getGameState()[i]);
        }

        if(ov.getWinner() != null && (ov.getWinner().equals("O") || ov.getWinner().equals("X"))){
            GameProperties.turnLabel.setText("The winner is player: " + ov.getWinner());
        }else if(ov.getWinner() != null && ov.getWinner().equals("tie")){
            GameProperties.turnLabel.setText("Tie Game!");
        }
    }
}
