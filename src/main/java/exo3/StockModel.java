package exo3;
import java.util.*;

public class StockModel {
    List<produit> stock;
    private int capacity;
    public StockModel(int capcity){
        this.capacity=capcity;
        this.stock=new ArrayList<>();

    }
    public int getcap(){
        return capacity;
    }
    public void setcap(int cap){
        this.capacity=cap;
    }

    public String ajouter(produit p){
        for (produit pro:stock){
            if(pro.name==p.name){
                pro.qnt+=p.qnt;
                return "quantity ajouter";
            }
        }
        if (stock.size()==capacity-1){
            return "stock es plien";
                   
        }
        else {
            stock.add(p);
            return "produit ajouter";
        }
    }

    public String delete(produit p){
        for (produit pro:stock){
            if (pro.name==p.name){
                pro.qnt-=p.qnt;
                if(pro.qnt<=0){
                    return "produit suprimer";
                }
                else {
                    return "quantity diminuer";
                }
            }
        }
        if(stock.size()==0){
            return "aucun element a suprimer";
        }
        else {
            return "element non trouver";
        }
    }

    


}
