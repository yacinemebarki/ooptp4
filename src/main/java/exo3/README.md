# Exercice 3 – Interface graphique + événements + MVC (Gestion de stock)

---

## Architecture imposée (MVC)

L’application suit strictement le modèle **MVC (Model – View – Controller)** :

```bash
exo3/
├── StockModel.java        # logique métier (stock)
├── StockView.java         # interface graphique Swing
├── StockController.java   # gestion des événements
└── app.java               # point d’entrée
```
---
#Travail réalisé
---
## 1. Model – StockModel
Le modèle représente la logique métier du stock.

Responsabilités :
- stocker le stock actuel ;
- stocker la capacité maximale ;
- ajouter une quantité ;
- retirer une quantité ;
- réinitialiser le stock ;
- appliquer les règles métier.
---
### État du modèle
```java
private int max_cap;
private int curr_cap;
```
---
### Initialisation
```java
public StockModel(int max_cap) {
    this.max_cap = max_cap;
    this.curr_cap = 0;
}
```
---
### Ajout de stock
```java
public String ajouter(int qnt) {
    if (curr_cap + qnt > max_cap) {
        return "stock insuffisant";
    } else {
        curr_cap += qnt;
        return "élément ajouté";
    }
}
```
---
### Retrait de stock
```java
public String suprimer(int qnt) {
    if (curr_cap == 0) {
        return "stock vide";
    } else {
        curr_cap -= qnt;
        if (curr_cap < 0) curr_cap = 0;
        return "élément supprimé";
    }
}
```
---
### Réinitialisation
```java
public void reis(int max_cap) {
    this.curr_cap = 0;
    this.max_cap = max_cap;
}
```
---
###Rôle du Model

- ✔ Aucune dépendance Swing
- ✔ Contient uniquement la logique métier
- ✔ Garantit les règles de stock
---
## 2. View – StockView
La vue construit l’interface graphique de l’application.
---
### Responsabilités :
- afficher les composants Swing ;
- fournir des getters au contrôleur ;
- organiser l’interface ;
- afficher les informations utilisateur.
---
### Fenêtre principale
```java
public class StockView extends JFrame {
    public StockView() {
        super("stock management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```
---
### Composants principaux
```java
private JLabel qnt = new JLabel("quantity: ");
private JTextField qnt_text = new JTextField(15);

private JButton ajouter = new JButton("ajouter");
private JButton suprimer = new JButton("supprimer");
private JButton affichier = new JButton("afficher");
private JButton reis = new JButton("réinitialiser");
```
---
### Organisation de l’interface

La vue utilise plusieurs panneaux :

- BoxLayout pour l’organisation verticale ;
- FlowLayout pour les boutons.
---
### Construction de l’interface
```java
buildlabels();
buildbuttons();
setContentPane(mainPanel);
pack();
setLocationRelativeTo(null);
setVisible(true);
```
---
### Accès aux composants (MVC)

La vue expose ses composants au contrôleur :
```java
public JButton getajouter() { return ajouter; }
public JButton getsuprimer() { return suprimer; }
public JButton getaffichier() { return affichier; }
public JButton getrein() { return reis; }
public JTextField getqnt() { return qnt_text; }
```
---
## 3. Controller – StockController

Le contrôleur gère toute la logique événementielle.
---
Responsabilités :
- écouter les boutons ;
- lire les saisies utilisateur ;
- appeler le modèle ;
- afficher les messages ;
- gérer les erreurs.
---
## 4. Bouton Ajouter
```java
this.view.getajouter().addActionListener(e -> {
    String qnt_text = qnt_field.getText();

    if (qnt_text.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Champ obligatoire");
        return;
    }

    try {
        int qnt = Integer.parseInt(qnt_text);

        if (qnt <= 0) {
            JOptionPane.showMessageDialog(null, "Quantité invalide");
            return;
        }

        String msg = model.ajouter(qnt);
        JOptionPane.showMessageDialog(null, msg);

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Valeur invalide");
    }
});
```
---
## 5. Bouton Supprimer
```java
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
```
---
## 6. Bouton Réinitialiser
affichier JOptionPane.showInputDialog pour entrer une valeur maximal pour se nouvelle stock
```java
this.view.getrein().addActionListener(e -> {
    String input = JOptionPane.showInputDialog("Nouvelle capacité maximale");

    try {
        int value = Integer.parseInt(input);
        model.reis(value);
        JOptionPane.showMessageDialog(null, "Stock réinitialisé");

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Valeur invalide");
    }
});
```
---
## 7. Bouton Afficher
```java
this.view.getaffichier().addActionListener(e -> {
    JOptionPane.showMessageDialog(null,
        "Stock actuel: " + model.getcurrent());
});
```
---
## 8. Classe de lancement
```java
public class app {
    public static void main(String[] args) {
        String max_text = JOptionPane.showInputDialog("capacité maximale");
        int max = Integer.parseInt(max_text);

        StockModel model = new StockModel(max);
        StockView view = new StockView();
        new StockController(model, view);
    }
}
```
---
# Contraintes respectées

- ✔ Architecture MVC obligatoire
- ✔ Séparation stricte des responsabilités
- ✔ Swing utilisé uniquement dans la View
- ✔ Gestion des événements dans le Controller
- ✔ Validation des entrées utilisateur
- ✔ Gestion des erreurs avec JOptionPane
- ✔ Application robuste (pas de crash)
---






