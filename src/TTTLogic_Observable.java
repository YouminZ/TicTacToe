import java.util.Arrays;
import java.util.Observable;

public class TTTLogic_Observable extends Observable {

    private Boolean gameStarted = false;
    private String[] gameState = new String[9];
    private String currentTurn;
    private String winner = null;

    public void StartGame() {
        gameStarted = true;
        winner = null;
        GameProperties.turnLabel.setText("X's turn");
        setCurrentTurn("X's turn");

        for (int i = 0; i < gameState.length; i++) {
            setGameState(i, "-");
            GameProperties.tttButton[i].setLabel("-");
        }
    }

    public void tttButtonClick(String index) {
        if (gameStarted) {
            int i = Integer.parseInt(index);
            if (gameState[i].equals("-")) {
                if (currentTurn.equals("O's turn")) {
                    setCurrentTurn("X's turn");
                    setGameState(i, "O");
                } else {
                    setCurrentTurn("O's turn");
                    setGameState(i, "X");
                }
                checkForWinner();
                setChanged();
                notifyObservers();
            }
        }
    }

    public void checkForWinner() {

        if (!gameState[0].equals("-") && gameState[0].equals(gameState[1]) && gameState[1].equals(gameState[2])){
            endGame(0);
        }else if(!gameState[3].equals("-") && gameState[3].equals(gameState[4]) && gameState[4].equals(gameState[5])){
            endGame(3);
        }else if(!gameState[6].equals("-") && gameState[6].equals(gameState[7]) && gameState[7].equals(gameState[8])){
            endGame(6);
        }else if(!gameState[0].equals("-") && gameState[0].equals(gameState[3]) && gameState[3].equals(gameState[6])){
            endGame(0);
        }else if(!gameState[1].equals("-") && gameState[1].equals(gameState[4]) && gameState[4].equals(gameState[7])){
            endGame(1);
        }else if(!gameState[2].equals("-") && gameState[2].equals(gameState[5]) && gameState[5].equals(gameState[8])){
            endGame(2);
        }else if(!gameState[0].equals("-") && gameState[0].equals(gameState[4]) && gameState[4].equals(gameState[8])){
            endGame(0);
        }else if(!gameState[6].equals("-") && gameState[6].equals(gameState[4]) && gameState[4].equals(gameState[2])){
            endGame(6);
        }else if(!Arrays.asList(gameState).contains("-")){
            gameStarted = false;
            winner = "tie";
            setChanged();
            notifyObservers();
        }
    }

    private void endGame(int index){
        gameStarted = false;
        winner = gameState[index];
        setChanged();
        notifyObservers();
    }

    public String[] getGameState() {
        return gameState;
    }

    public void setGameState(int index, String val) {
        gameState[index] = val;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(String turn) {
        currentTurn = turn;
    }

    public String getWinner() {
        return winner;
    }
}
