package exo2;
import javax.swing.*;
import java.awt.*;

public class app {
    static boolean new_client=false;
    static Achat achat=null;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame frame=new JFrame("achats");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());
            
            JPanel panel_label=new JPanel();
            panel_label.setLayout(new BoxLayout(panel_label, BoxLayout.Y_AXIS));
            JTextField nom=new JTextField(15);
            panel_label.add(new JLabel("nom de produit: "));
            panel_label.add(nom);
            panel_label.add(Box.createVerticalStrut(8));
            JTextField prix=new JTextField(15);
            
            panel_label.add(new JLabel("prix: "));
            panel_label.add(prix);
            panel_label.add(Box.createVerticalStrut(8));
            JTextField quantity=new JTextField(15);
            panel_label.add(new JLabel("quantity: "));
            panel_label.add(quantity);
            panel_label.add(Box.createVerticalStrut(8));
            JCheckBox box1=new JCheckBox("fidel");
            panel_label.add(box1);

            String[] option={"standard","express"};
            JComboBox<String> options=new JComboBox<>(option);
            panel_label.add(options);

            JPanel panel_button=new JPanel();
            panel_button.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
            JButton ajouter=new JButton("ajouter");
            panel_button.add(ajouter);
            JButton calculer=new JButton("calculer");
            panel_button.add(calculer);
            JButton vider=new JButton("vider");
            panel_button.add(vider);
            
            frame.add(panel_label,BorderLayout.CENTER);
            frame.add(panel_button,BorderLayout.SOUTH);
            frame.setVisible(true);
            
            ajouter.addActionListener(e->{
                boolean fidele=box1.isSelected();
                String type=(String) options.getSelectedItem();
                boolean liver=false;
                if(type=="express"){
                    liver=true;
                }
                else if(type=="standard"){
                    liver=false;
                }
                if (new_client==false){
                    new_client=true;
                    Achat achat=new Achat(fidele,liver);

                }
                String name=nom.getText();
                String price_text=prix.getText();
                String qnt=quantity.getText();
                double price=Double.parseDouble(price_text);
                int qtn=Integer.parseInt(qnt);
                produit p=new produit(name, price, qtn);
                achat.addarticle(p);

            });
            calculer.addActionListener(e->{
                double total_price=achat.claculer();

            });
            vider.addActionListener(e->{
                achat=null;
                new_client=false;
            });





        });
    }
}
