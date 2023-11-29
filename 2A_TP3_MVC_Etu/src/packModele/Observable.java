/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packModele;

import packVue.Observateur;

/**
 *
 * @author chris
 */
public interface Observable {
    public void addObservateur(Observateur obs);
    public void removeObservateur(Observateur obs);
    public void notifyObservateur();
}
