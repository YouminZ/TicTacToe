import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tttActionListener implements ActionListener {

    TTTLogic_Observable game;

    public tttActionListener(TTTLogic_Observable game){
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.tttButtonClick(e.getActionCommand());
    }
}
