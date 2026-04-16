package exo3;

public class StockModel {
    private int max_cap;
    private int curr_cap;
    public StockModel(int max_cap){
        this.max_cap=max_cap;
        this.curr_cap=0;
    }
    public int getcurrent(){
        return curr_cap;
    }
    public String ajouter(int qnt){
        if(curr_cap+curr_cap>=max_cap){
            return "stock inssufisant";
        }
        else{
            
            curr_cap+=qnt;
            return "element ajout";
        }

    }
    public String suprimer(int qnt){
        if(curr_cap==0){
            return "stock vide";

        }
        else {
            curr_cap-=qnt;
            return "element suprimer";
        }
    }

    public void reis(int max_cap){
        this.curr_cap=0;
        this.max_cap=max_cap;
        
    }

}
