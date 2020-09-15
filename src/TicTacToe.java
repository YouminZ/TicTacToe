public class TicTacToe{
    public static void main(String[] args){
        TTTLogic_Observable observable = new TTTLogic_Observable();
        TTTLogic_Observer observer = new TTTLogic_Observer(observable);

        observable.addObserver(observer);
    }
}