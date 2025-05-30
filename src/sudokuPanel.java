import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class sudokuPanel extends JPanel implements ActionListener {
    static final int WIDTH = 603;
    static final int HEIGHT = 603;
    static final int BOX = WIDTH / 9;
    static int[][] grid = new int[9][9];

    Random random;
    static Font font;

    JPanel[] sudokuBox;
    static JTextField[][] textField = new JTextField[9][9];

    sudokuPanel() {
        gameFrame.done.addActionListener(this);
        gameFrame.clear.addActionListener(this);
        random = new Random();

        font = new Font(null, Font.BOLD, 30);
        sudokuBox = new JPanel[81];

        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBounds(20, 20, WIDTH, HEIGHT);
        // this.setLayout(new GridLayout(3,3));
        this.setLayout(null);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textField[i][j] = new JTextField("0");
                textField[i][j].setBounds(j * BOX, i * BOX, BOX, BOX);
                textField[i][j].setBackground(Color.cyan);
                textField[i][j].setFont(font);
                this.add(textField[i][j]);
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    private void draw(Graphics g) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                g.setColor(Color.black);
                g.drawLine(j * BOX, i * BOX, j * BOX, HEIGHT);
                g.drawLine(i * BOX, j * BOX, WIDTH, j * BOX);
            }
        }
        for (int i = 0; i <= 9; i += 3) {
            for (int j = 0; j <= 9; j += 3) {
                g.setColor(Color.red);
                g.drawLine(j * BOX, i * BOX, j * BOX, HEIGHT);
                g.drawLine(i * BOX, j * BOX, WIDTH, j * BOX);

            }
        }

    }

    public void getValues() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(textField[i][j].getText() + " ");
            }
            System.out.println(" ");
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(textField[i][j].getText());
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(" ");
        }
        new solve(grid);
    }

    public static void setValues(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textField[i][j].setText(String.valueOf(grid[i][j]));
            }

        }
    }

    public static boolean isPossible() {
        boolean returns = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (Integer.parseInt(textField[i][j].getText()) > 9
                        && Integer.parseInt(textField[i][j].getText()) < 1) {
                    returns = false;

                    gameFrame.tf.setVisible(true);
                    break;
                } else {
                    returns = true;
                }
            }

        }
        return returns;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Integer.parseInt(textField[i][j].getText()) != 0) {
                    textField[i][j].setForeground(Color.blue);
                }
            }

        }

        if (e.getSource() == gameFrame.done) {
            if (isPossible()) {
                System.out.println("in");
                getValues();
            }

        }
        if (e.getSource() == gameFrame.clear) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    textField[i][j].setForeground(Color.black);
                    textField[i][j].setText("0");
                }

            }
        }
    }

}
