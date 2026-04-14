package exo2;
import javax.swing.*;
import java.awt.*;

public class app {
    static boolean new_client=false;
    static Achat achat=null;

    public static void ajouterProduit(JTextField nom,JTextField prix,JTextField quantity,JCheckBox box1,JComboBox<String> options){
        boolean fidele = box1.isSelected();
        String type=(String) options.getSelectedItem();

        boolean liver=type.equals("express");

        if (achat==null){
            achat=new Achat(fidele, liver);
        }
        String name=nom.getText();
        double price=Double.parseDouble(prix.getText());
        int qtn = Integer.parseInt(quantity.getText());
        

        produit p=new produit(name, price, qtn);
        achat.addarticle(p);
        nom.setText("");
        prix.setText("");
        quantity.setText("");
        box1.setSelected(false);
        options.setSelectedIndex(0);
    }

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
            
            JLabel result_lable=new JLabel("total prix");
            result_lable.setForeground(Color.BLUE);
            panel_label.add(result_lable);


            

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
                ajouterProduit(nom, prix, quantity, box1, options);
            });
            calculer.addActionListener(e->{

                if(achat==null){
                    ajouterProduit(nom, prix, quantity, box1, options);
                }

                double total_price=achat.claculer();
                result_lable.setText("prix total: "+total_price);

            });
            vider.addActionListener(e->{
                achat=null;
                new_client=false;
            });





        });
    }
}
