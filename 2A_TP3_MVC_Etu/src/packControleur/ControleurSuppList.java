/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packControleur;

import java.util.ArrayList;
import packModele.Promotion;

/**
 *
 * @author chris
 */
public class ControleurSuppList extends AbstractControleur {
    public ControleurSuppList(Promotion p){
        super(p);
    }
     @Override
    public void control(ArrayList<String> etudiants) {
        for (String etudiant : etudiants) {

            String[] parts = etudiant.split("-");
            if (parts.length > 0) {
                String id = parts[0].trim();
                if(promotion.getEtudiantParIdent(id)!=null){
                    promotion.supprimerEtudiantParIndex(id);

                }
            }
        }
    }
}
