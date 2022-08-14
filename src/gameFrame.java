import javax.swing.*;
import java.awt.*;

public class gameFrame extends JFrame {
     static JButton done;
     static JButton clear;
     static  JTextField tf;
    gameFrame(){
        done=new JButton();
        done.setFont(new Font("Ink Free" ,Font.BOLD ,30));
        done.setText("Done");
        done.setBounds(640,30,120,50);
        done.setFocusable(false);
        done.setBackground(Color.green);
        done.setForeground(Color.blue);


        clear=new JButton();
        clear.setFont(new Font("Ink Free" ,Font.BOLD ,30));
        clear.setText("Clear");
        clear.setBounds(640,120,120,50);
        clear.setFocusable(false);
        clear.setBackground(Color.green);
        clear.setForeground(Color.blue);



        tf= new JTextField();
        tf.setFont(new Font(null,Font.BOLD,20));
        tf.setForeground(Color.red);
        tf.setText("Enter between 0-9");
        tf.setBounds(20,623,603,50);
        tf.setBackground(Color.lightGray);
        tf.setVisible(false);


        sudokuPanel spanel= new sudokuPanel();


        this.setSize(800,700);
        this.setTitle("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(spanel);
        this.add(done);
        this.add(clear);
        this.add(tf);
    }
}
