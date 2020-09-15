import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard{
    TTTLogic_Observable game;
    private JPanel topPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private Button startButton = new Button();

    public GameBoard(TTTLogic_Observable game){
        this.game = game;
    }

    public void RenderGameBoard(){
        JFrame frame = new JFrame();
        frame.setSize(300,470);

        JLayeredPane layerPane = new JLayeredPane();

        frame.add(layerPane, FlowLayout.LEFT);
        layerPane.setBounds(0,0,300, 470);

        // Add top panel and its components
        topPanel.setPreferredSize(new Dimension(300, 90));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setBounds(0,0,300, 90);
        topPanel.add(GameProperties.turnLabel);
        GameProperties.turnLabel.setText("Game is not started yet!!!");
        topPanel.setBackground(Color.green);

        // Add Center Board
        boardPanel.setPreferredSize(new Dimension(300, 250));
        boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        boardPanel.setBounds(0, 90, 300, 250);

        ActionListener listener = new tttActionListener(game);

        for(int i = 0; i < 9; i++) {
            GameProperties.tttButton[i] = new Button("-");
            GameProperties.tttButton[i].setPreferredSize(new Dimension(70,70));
            GameProperties.tttButton[i].setActionCommand(Integer.toString(i));
            GameProperties.tttButton[i].addActionListener(listener);
            boardPanel.add(GameProperties.tttButton[i]);
        }

        boardPanel.setBackground(Color.blue);

        //Add bottom Layout
        bottomPanel.setPreferredSize(new Dimension(300, 90));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setBounds(0, 340, 300, 90);
        startButton.setLabel("Start Game");
        startButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.StartGame();
            }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        });
        bottomPanel.add(startButton);
        bottomPanel.setBackground(Color.yellow);

        layerPane.add(topPanel);
        layerPane.add(boardPanel);
        layerPane.add(bottomPanel);

        frame.setVisible(true);
    }
}
