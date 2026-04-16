# Exercice 2 – Interface graphique + événements (Mini simulateur de commande)

---


## Structure du projet

```bash
exo2/
├── app.java       # Interface graphique + logique + événements
├── produit.java   # Classe Produit
└── Achat.java     # Classe gestion de commande
```

---
# Travail réalisé
---
### Classes du projet
---
#### Classe Produit:
Représente un article de commande.
```java
public class produit {
    String name;
    double price;
    int qnt;

    public produit(String name, double price, int qnt) {
        this.name = name;
        this.price = price;
        this.qnt = qnt;
    }
}
```
---
#### Classe Achat:
Gère la liste des produits et le calcul final.

Fonctionnalités :
- stockage des produits (ArrayList)
- gestion client fidèle
- gestion livraison
- calcul du total
---
### 1. Structure générale de l’interface
L’interface est construite avec :

- JFrame comme fenêtre principale ;
- BorderLayout pour organiser la fenêtre ;
- un panneau central pour les champs ;
- un panneau bas pour les boutons.
```java
JFrame frame = new JFrame("achats");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 300);
frame.setLayout(new BorderLayout());
```
---
### 2. Champs de saisie
L’utilisateur peut entrer :

- Nom du produit
- Prix unitaire
- Quantité
```java
JTextField nom = new JTextField(15);
JTextField prix = new JTextField(15);
JTextField quantity = new JTextField(15);
```
---
### 3. Options supplémentaires
L’application propose :

- une case à cocher Client fidèle
- une liste déroulante Livraison (standard / express)

```java
JCheckBox box1 = new JCheckBox("fidel");

String[] option = {"standard", "express"};
JComboBox<String> options = new JComboBox<>(option);
```
---
### 4. Affichage du résultat
Le résultat est affiché dynamiquement dans un JLabel.
```java
JLabel result_label = new JLabel("total prix");
result_label.setForeground(Color.BLUE);
```
---
### 5. Bouton Ajouter (ActionListener)
Ce bouton :

- récupère les données saisies ;
- valide les entrées ;
```java
try {
    price = Double.parseDouble(priceText);
    qtn = Integer.parseInt(qtnText);

    if (price <= 0 || qtn <= 0) {
        JOptionPane.showMessageDialog(null, "Prix et quantité doivent être positifs !");
        return;
    }

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Prix ou quantité invalide !");
    return;
}
```
- ajoute un produit à la commande ;
- gère les erreurs (champs vides, valeurs invalides, etc.).
```java
ajouter.addActionListener(e -> {
    ajouterProduit(nom, prix, quantity, box1, options);
});
```
---
### 6. Bouton Calculer
Ce bouton :

- calcule le total de la commande ;
- applique les réductions et frais ;
```java
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
```
- affiche le résultat.
```java
result_lable.setText("prix total: "+total_price);
```

```java
calculer.addActionListener(e -> {
    if (achat == null) {
        ajouterProduit(nom, prix, quantity, box1, options);
    }

    double total_price = achat.claculer();
    result_label.setText("prix total: " + total_price);
});
```
---
### 7. Bouton Vider
Ce bouton :

- réinitialise la commande ;
- vide les données internes.
```java
vider.addActionListener(e -> {
    achat = null;
});
```
---
# Contraintes respectées

- ✔ Interface complète en Swing
- ✔ Utilisation de ActionListener (lambda)
- ✔ Gestion des erreurs avec JOptionPane
- ✔ Validation des entrées utilisateur
- ✔ Séparation en plusieurs classes
- ✔ Calcul dynamique du total
---


