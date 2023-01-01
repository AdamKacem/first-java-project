
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame implements ActionListener{
    JButton button = new JButton();
    JTextField text1 = new JTextField();

    JTextField text2 = new JTextField();
    JTextField text3 = new JTextField();


    JLabel label = new JLabel();
    JLabel messageFinal= new JLabel();

    Frame() {
            //text lables:
            messageFinal.setBounds(100,250,1000,50);
            messageFinal.setVisible(false);

            label.setBounds(100,190,1000,50);
            label.setVisible(false);
            //button
            button.setBounds(150,350,600,50);
            button.addActionListener(this);
            button.setText("Generer un nombre entre 000 et 999");
            button.setFocusable(false);
            button.setFont(new Font("",Font.PLAIN,20));

            //changement de l'icone
            ImageIcon dice = new ImageIcon("dice.png");

            //les cases de text
            text1.setPreferredSize(new Dimension(60,60));
            text1.setBounds(50,50,100,100);
            text1.setFont(new Font("Consolas",Font.PLAIN,25));
            text1.setHorizontalAlignment(JTextField.CENTER);




            text2.setPreferredSize(new Dimension(60,60));
            text2.setBounds(400,50,100,100);
            text2.setFont(new Font("Consolas",Font.PLAIN,25));
            text2.setHorizontalAlignment(JTextField.CENTER);


            text3.setPreferredSize(new Dimension(60,60));
            text3.setBounds(750,50,100,100);
            text3.setFont(new Font("Consolas",Font.PLAIN,25));
            text3.setHorizontalAlignment(JTextField.CENTER);


            //configuration du Frame
            this.setLayout(null);
            this.setSize(920, 500);

            this.setTitle("projet java");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setIconImage(dice.getImage());
            this.getContentPane().setBackground(new Color(0x123456));
            this.setVisible(true);
            //l'ajout des labels , cases et buttons
            this.add(label);
            this.add(messageFinal);

            this.add(button);

            this.add(text1);
            this.add(text2);
            this.add(text3);
        }

    @Override
        public void actionPerformed(ActionEvent e) {
        int result=0;

        //creation du nombre d'après les cases de text
        String t1=text1.getText();
        String t2=text2.getText();
        String t3=text3.getText();

        //generation d'un nombre (random)
        Random random = new Random();
        int nombre = random.nextInt(1000);

        //Si la saisie n'est pas valide: (case vide ou pas un chiffre)
        //affichage spéciale
        if( (t1==""||t2==""||t3=="")||(!(t1.matches("[0-9]"))||!(t2.matches("[0-9]"))||!(t3.matches("[0-9]")))) {


            label.setFont(new Font("Consolas", Font.BOLD, 30));
            label.setForeground(new Color(255, 255, 255));
            label.setText("Saisie invalide!");
            label.setVisible(true);

            messageFinal.setFont(new Font("Consolas", Font.BOLD, 20));
            messageFinal.setForeground(new Color(255, 255, 255));
            messageFinal.setText("Ecrivez un chiffre entre 0 et 9 dans chaque case");
            messageFinal.setVisible(true);
        }

        //Sinon:
        //affichage normal
        else {
            result=Integer.parseInt(t1+t2+t3);
            messageFinal.setFont(new Font("Consolas", Font.BOLD, 30));

            //si le nombre crée est égale au nombre generé:
            if (result == nombre) {
                messageFinal.setForeground(new Color(0, 255, 0));
                messageFinal.setText("Vous avez gagné!");

            }
            //sinon
            else {
                messageFinal.setForeground(new Color(255, 0, 0));
                messageFinal.setText("Vous avez perdu! Essayer une autre fois.");
            }


            messageFinal.setVisible(true);
            label.setFont(new Font("Consolas", Font.BOLD, 30));
            label.setForeground(new Color(255, 255, 255));
            label.setText("Le nombre generé automatiquement est : " + nombre);
            label.setVisible(true);

        }
    }
}

