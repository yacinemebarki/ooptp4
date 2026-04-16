package exo3;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StockController {
    StockModel model;
    StockView view;
    public StockController(StockModel model,StockView view){
        this.model=model;
        this.view=view;
        JTextField qnt_field=view.getqnt();
        this.view.getajouter().addActionListener(e->{
            String qnt_text=qnt_field.getText();
            int qnt;
            if(qnt_text.isEmpty()){
                JOptionPane.showMessageDialog(null,"Tous les champs sont obligatoires");
                return;
            }
            try{
                qnt=Integer.parseInt(qnt_text);
                if(qnt<=0){
                    JOptionPane.showMessageDialog(null,"la quanity doit etre plus grand que 0");
                    return;
                }
                String mes=model.ajouter(qnt);
                JOptionPane.showMessageDialog(null, mes);
            }catch(NumberFormatException a){
                JOptionPane.showMessageDialog(null, "quantity invalid");
                return;
            }
            
        });
        this.view.getsuprimer().addActionListener(e->{
            String qnt_text=qnt_field.getText();
            int qnt;
            if(qnt_text.isEmpty()){
                JOptionPane.showMessageDialog(null,"Tous les champs sont obligatoires");
                return;
            }
            try{
                qnt=Integer.parseInt(qnt_text);
                if(qnt<=0){
                    JOptionPane.showMessageDialog(null,"la quanity doit etre plus grand que 0");
                    return;
                }
                String mes=model.suprimer(qnt);
                JOptionPane.showMessageDialog(null, mes);
            }catch(NumberFormatException a){
                JOptionPane.showMessageDialog(null, "quantity invalid");
                return;
            }
            
        });
        this.view.getrein().addActionListener(e->{
            String qnt=JOptionPane.showInputDialog("entrer une nouvelle capacity maximal");
            if(qnt == null) return;

            try{
                int value=Integer.parseInt(qnt);

                if(value<=0){
                    JOptionPane.showMessageDialog(null,"Valeur invalide");
                    return;
                }

                model.reis(value);

                JOptionPane.showMessageDialog(null,"Stock réinitialisé");

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Nombre invalide");
            }
            
        });
        this.view.getaffichier().addActionListener(e->{
            JOptionPane.showMessageDialog(null, "the current capacity: "+model.getcurrent());
        });
    }
}
