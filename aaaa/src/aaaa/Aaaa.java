/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Aaaa extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel guessLabel;
    private JTextField guessTextField;
    private JButton guessButton;
    private JLabel resultLabel;
    private int maxTentativas = 20;
    private int aleatorio;
    private int numeroDeTentativas;

    public Aaaa() {
        setTitle("Guess the Number Game");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        guessLabel = new JLabel("Guess a number between 1 and 1000:");
        panel.add(guessLabel);

        guessTextField = new JTextField();
        panel.add(guessTextField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        panel.add(guessButton);

        resultLabel = new JLabel("You have " + maxTentativas + " attempts remaining.");
        panel.add(resultLabel);

        setContentPane(panel);

        aleatorio = new Random().nextInt(1000) + 1;
        numeroDeTentativas = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (numeroDeTentativas >= maxTentativas) {
            JOptionPane.showMessageDialog(this, "You have used all your attempts. The number was " + aleatorio + ".", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        int resposta = Integer.parseInt(guessTextField.getText());
        numeroDeTentativas++;

        if (resposta < aleatorio) {
            resultLabel.setText("Your guess was too low. You have " + (maxTentativas - numeroDeTentativas) + " attempts remaining.");
        } else if (resposta > aleatorio) {
            resultLabel.setText("Your guess was too high. You have " + (maxTentativas - numeroDeTentativas) + " attempts remaining.");
        } else {
            JOptionPane.showMessageDialog(this, "Congratulations! You guessed the number in " + numeroDeTentativas + " attempts.", "You Win!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        guessTextField.setText("");
        guessTextField.requestFocus();
    }

    public static void main(String[] args) {
        Aaaa game = new Aaaa();
        game.setVisible(true);
    }
}
