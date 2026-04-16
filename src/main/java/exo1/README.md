# Exercice 1 — Interface graphique seule (Swing)

---

## Structure du projet

```bash
exo1/
└── Inscription.java  
```
---
# Travail réalisé
---
### 1. Création de la fenêtre principale
La classe Inscription crée une fenêtre Swing avec :
- une taille définie ;
- une fermeture correcte de l’application ;
- un centrage automatique de la fenêtre à l’écran.
```java
JFrame frame=new JFrame("Inscription"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            frame.setSize(500,500);
```
---
### 2. Organisation générale de l’interface
- BoxLayout pour organiser les éléments verticalement ;
- un panel intermédiaire pour structurer le formulaire.
```java
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
```
---
### 3. Champs du formulaire
Le formulaire contient les champs suivants :

- Nom
- Prénom
- Email
- Niveau
- Spécialité
```java
panel.add(new JLabel("Nom:"));
JTextField nom=new JTextField(20);
fixSize(nom);
panel.add(nom);
panel.add(new JLabel("Prenom:"));
JTextField prenom=new JTextField(20);
fixSize(prenom);
panel.add(prenom);
panel.add(new JLabel("Email:"));
JTextField email=new JTextField(20);
fixSize(email);
panel.add(email);
panel.add(new JLabel("Specialite:"));
JTextField spec=new JTextField(20);
fixSize(spec);
panel.add(spec);
```
---
### 4. Zone “Modules souhaités”:
Une section permet de choisir plusieurs modules via des cases à cocher :
- Analyse
- POO
- ISE
```java
panel.add(new JCheckBox("Analyse"));
panel.add(new JCheckBox("POO"));
panel.add(new JCheckBox("ISE"));
```
---
### 5. Zone commentaire (multiligne):
Une zone de texte multiligne est ajoutée pour les commentaires.
Elle est placée dans un JScrollPane pour permettre le défilement.
```java
panel.add(new JLabel("Commentaire:"));
JTextArea comment = new JTextArea(5, 20);
panel.add(new JScrollPane(comment));
```
---
### 6. Boutons d’action
Deux boutons sont ajoutés en bas de l’interface :

- Enregistrer
- Annuler
```java
JButton inscrire = new JButton("Enregistrer");
panel.add(inscrire);

JButton annuler = new JButton("Annuler");
panel.add(annuler);
```
---
# Contraintes respectées

- ✔ Utilisation de plusieurs layouts (BoxLayout)
- ✔ Interface organisée et lisible
- ✔ Présence de composants Swing variés (labels, text fields, checkboxes, textarea, buttons)
- ✔ Fenêtre centrée à l’écran
- ✔ Aucun traitement d’événement (conforme à l’énoncé)

# Résultat attendu

Une interface graphique propre représentant une fiche d’inscription universitaire, entièrement fonctionnelle visuellement, mais sans logique métier.


