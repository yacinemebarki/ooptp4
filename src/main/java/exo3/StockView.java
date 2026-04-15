package exo3;
import java.awt.*;
import javax.swing.*;

public class StockView extends JFrame{
    

    private JLabel nom=new JLabel("nom: ");
    private JTextField nom_text=new JTextField(15);
    private JLabel qnt=new JLabel("quantity: ");
    private JTextField qnt_text=new JTextField(15);
      
    private JButton ajouter=new JButton("ajouter");
    
    private JButton suprimer=new JButton("suprimer");
    private JButton affichier=new JButton("affichier");
    private JButton reis=new JButton("réinitialiser");

    public StockView(){
        super("stock mangment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildlabels();
        buildbuttons();

    }

    public void buildbuttons(){
        JPanel panelbtn=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        panelbtn.add(ajouter);
        panelbtn.add(suprimer);
        panelbtn.add(affichier);
        panelbtn.add(reis);
        setContentPane(panelbtn);
        pack();
        setLocationRelativeTo(null);
        
    }

    public void buildlabels(){
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(nom);
        panel.add(nom_text);
        panel.add(Box.createVerticalStrut(8));
        panel.add(qnt);
        panel.add(qnt_text);
        panel.add(Box.createVerticalStrut(8));

    }
    public JButton getajouter(){
        return ajouter;
    }
    public JButton getsuprimer(){
        return suprimer;
    }
    public JButton getaffichier(){
        return affichier;
    }
    public JButton getrein(){
        return reis;
    }
    

}
