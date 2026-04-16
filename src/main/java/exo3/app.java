package exo3;

import javax.swing.JOptionPane;

public class app{
    public static void main(String[] args){
        String max_text=JOptionPane.showInputDialog("entrer une nouvelle capacity maximal");
        int max=Integer.parseInt(max_text);
        StockModel model=new StockModel(max);
        StockView view=new StockView();
        StockController controller=new StockController(model, view);
    }
}