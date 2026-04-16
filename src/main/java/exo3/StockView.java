package exo3;
import java.awt.*;
import javax.swing.*;

public class StockView extends JFrame{
    

    private JLabel qnt=new JLabel("quantity: ");
    private JTextField qnt_text=new JTextField(15);
      
    private JButton ajouter=new JButton("ajouter");
    
    private JButton suprimer=new JButton("suprimer");
    private JButton affichier=new JButton("affichier");
    private JButton reis=new JButton("réinitialiser");
    private JPanel mainPanel = new JPanel();

    public StockView(){
        super("stock mangment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        buildlabels();
        buildbuttons();
        setContentPane(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

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
        mainPanel.add(panelbtn);
        
    }

    public void buildlabels(){
        JPanel panel=new JPanel();
        
        panel.add(qnt);
        panel.add(qnt_text);
        mainPanel.add(panel);
        

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
    public JTextField getqnt(){
        return qnt_text;
    }
    

}
