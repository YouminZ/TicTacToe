import java.util.Observable;

public class TTTLogic_Observable extends Observable{

    Boolean gameStarted = false; //TODO set to false when ready
    String[] gameState = new String[9];
    String currentTurn;

    public void StartGame(){
        GameProperties.turnLabel.setText("X's turn");
        gameStarted = true;

        for(int i = 0; i < gameState.length; i++){
            setGameState(i, null);
            GameProperties.tttButton[i].setLabel("-");
        }
    }

    public void tttButtonClick(String index){
        if(gameStarted == true){
            int i = Integer.parseInt(index);

            if(gameState[i] == null){
                if(currentTurn == "O's turn"){
                    setCurrentTurn("X's turn");
                    setGameState(i, "O");
                }else{
                    setCurrentTurn("O's turn");
                    setGameState(i, "X");
                }

                setChanged();
                notifyObservers();
            }
        }
    }

    public String[] getGameState(){
        return gameState;
    }

    public void setGameState(int index, String val){
        gameState[index] = val;
    }

    public String getCurrentTurn(){
        return currentTurn;
    }

    public void setCurrentTurn(String turn){
        currentTurn = turn;
    }
}
