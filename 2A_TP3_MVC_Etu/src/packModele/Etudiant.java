/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packModele;

/**
 *
 * @author chris
 */
public class Etudiant {
    private final String ident;
    private final String prenom;
    private final String nom;
    private final String departement;
    private final String filliere;

    public Etudiant(String ident, String prenom, String nom, String departement, String filliere) {
        this.ident = ident;
        this.prenom = prenom;
        this.nom = nom;
        this.departement = departement;
        this.filliere = filliere;
    }

    public String getIdent() {
        return ident;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getDepartement() {
        return departement;
    }

    public String getFilliere() {
        return filliere;
    }


}
