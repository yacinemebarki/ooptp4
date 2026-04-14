package exo2;
import java.util.*;

public class Achat {
    List<produit> achats;
    private boolean fidele;
    public boolean livraison;
    
    public Achat(boolean fidele,boolean livraison){
        this.fidele=fidele;
        this.livraison=livraison;
        achats=new ArrayList<>();
        
    }
    public boolean getfidele(){
        return fidele;
    }
    public void setfidele(boolean fidele){
        this.fidele=fidele;
    }
    public void addarticle(produit article){
        for (produit p:achats){
            if (p.name==article.name){
                p.qnt=+1;
                return;
            }

        }
        achats.add(article);

    }
    public void deletearticle(produit article,int qnt){
        for(produit p:achats){
            if (p.name==article.name){
                if (qnt>=p.qnt){
                    achats.remove(p);
                    System.out.println("the element was deleted");
                    return;

                }
                else {
                    p.qnt=p.qnt-qnt;
                    System.out.println("the qunatity was reduced");
                    return;
                }
            }
        }
        System.out.println("element not found");
    }
    public double claculer(){
        double total_price=0;
        for (produit p:achats){
            total_price+=p.price*p.qnt;
        }
        if(fidele){
            total_price=total_price*0.1;
        }
        if(livraison==true){
            total_price+=300;
        }
        return total_price;
    }


}
