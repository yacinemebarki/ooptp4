package exo1;
import javax.swing.*;
import java.awt.*;

public class Inscription {
    private static void fixSize(JComponent c){
        c.setMaximumSize(new Dimension(Integer.MAX_VALUE,c.getPreferredSize().height));
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{ 
            JFrame frame=new JFrame("Inscription"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            frame.setSize(500,500);
            JPanel panel=new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(new JLabel("Nom:"));
            JTextField nom=new JTextField(20);
            fixSize(nom);
            panel.add(nom);

            panel.add(new JLabel("Prenom:"));
            JTextField prenom=new JTextField(20);
            fixSize(prenom);
            panel.add(prenom);

            panel.add(new JLabel("Email:"));
            JTextField email=new JTextField(20);
            fixSize(email);
            panel.add(email);

            panel.add(new JLabel("Specialite:"));
            JTextField spec=new JTextField(20);
            fixSize(spec);
            panel.add(spec);

            panel.add(new JLabel("Commentaire:"));
            panel.add(new JScrollPane(new JTextArea(5,20)));

            panel.add(new JCheckBox("Analyse"));
            panel.add(new JCheckBox("POO"));
            panel.add(new JCheckBox("ISE"));

            JButton inscrire=new JButton("Inscrire");
            fixSize(inscrire);
            panel.add(inscrire);

            JButton annuler=new JButton("Annuler");
            fixSize(annuler);
            panel.add(annuler);
            frame.setContentPane(panel); 
            frame.pack(); frame.setLocationRelativeTo(null); 
            frame.setVisible(true);
        });
        
    }
    
}
