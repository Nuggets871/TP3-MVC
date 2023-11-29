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
    private int ident;
    private String prenom;
    private String nom;
    private int departement;
    private String filliere;

    public Etudiant(int ident, String prenom, String nom, int departement, String filliere) {
        this.ident = ident;
        this.prenom = prenom;
        this.nom = nom;
        this.departement = departement;
        this.filliere = filliere;
    }

    public int getIdent() {
        return ident;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getDepartement() {
        return departement;
    }

    public String getFilliere() {
        return filliere;
    }


}
