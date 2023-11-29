/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packModele;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import packVue.Observateur;

/**
 *
 * @author chris
 */
    public class Promotion implements Serializable, Observable{
    private final ArrayList<Etudiant> etudiants;
    private ArrayList<Observateur> listObservateur;

    public Promotion() {
        etudiants = new ArrayList<>();
        listObservateur = new ArrayList<Observateur>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    // Méthode pour obtenir un étudiant par son identifiant
    public Etudiant getEtudiantParIdent(int ident) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getIdent() == ident) {
                return etudiant;
            }
        }
        return null; // ou lever une exception si préféré
    }
    public void supprimerEtudiantParIndex(int index) {
    if (index >= 0 && index < etudiants.size()) {
        etudiants.remove(index);
    }
}


    // Méthode pour obtenir la liste des étudiants d'une certaine filière
    public List<Etudiant> getEtudiantsParFilliere(String filliere) {
        List<Etudiant> resultats = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getFilliere() == filliere) {
                resultats.add(etudiant);
            }
        }
        return resultats;
    }
    
    public void chargerDepuisCsv() {
        // Récupération du répertoire de travail actuel
        String repertoireActuel = System.getProperty("user.dir");

        // Configuration de JFileChooser pour s'ouvrir dans le répertoire actuel
        JFileChooser fileChooser = new JFileChooser(repertoireActuel);
        int resultat = fileChooser.showOpenDialog(null);

        if (resultat == JFileChooser.APPROVE_OPTION) {
            String cheminFichier = fileChooser.getSelectedFile().getAbsolutePath();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cheminFichier), "UTF-8"))) {
                String ligne;
                while ((ligne = br.readLine()) != null) {
                    String[] valeurs = ligne.split(";");
                    if (valeurs.length == 5) {
                        try {
                            int ident = Integer.parseInt(valeurs[0].trim());
                            String prenom = valeurs[1].trim();
                            String nom = valeurs[2].trim();
                            int departement = Integer.parseInt(valeurs[3].trim());
                            String filliere = valeurs[4].trim();

                            Etudiant etudiant = new Etudiant(ident, prenom, nom, departement, filliere);
                            ajouterEtudiant(etudiant);
                        } catch (NumberFormatException e) {
                            System.err.println("Erreur de format dans le fichier CSV : " + e.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
        }
    }

    @Override
    public void addObservateur(Observateur obs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeObservateur(Observateur obs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyObservateur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
