package mvc;

import javax.swing.SwingUtilities;
import static javax.swing.SwingUtilities.updateComponentTreeUI;
import javax.swing.UIManager;
import packModele.Etudiant;
import packModele.Promotion;
import packVue.MainWindow;

/**
 * @authors brice.effantin & Eric Duchene
 * @modifed by L Buathier & A. Peytavie
 */
public class Mvc {


    public static void main(String[] args) {
        // TODO code application logic here
        // Création de l'instance de la promotion
        // Création de l'instance de la promotion
        Promotion promotion = new Promotion();
        promotion.chargerDepuisCsv();

        // Créer MainWindow avec la promotion chargée
        MainWindow fen = new MainWindow(promotion);

        // Affichage des étudiants chargés pour tester
        for (Etudiant etudiant : promotion.getEtudiants()) {
            System.out.println("ID: " + etudiant.getIdent() + ", Prenom: " + etudiant.getPrenom() + ", Nom: " + etudiant.getNom() + ", Departement: " + etudiant.getDepartement() + ", Filliere: " + etudiant.getFilliere());
        }
           
        fen.setVisible(true);
/*       try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(fen);
            updateComponentTreeUI(fen);
        } catch (Exception ex) {
                       System.out.println(ex.getMessage());
        } 
  */    
        
        
    }
    
}
