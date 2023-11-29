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
public abstract class AbstractControleur {
    protected Promotion promotion;
    
    public AbstractControleur(Promotion promotion) {
        this.promotion = promotion;
    }
    
    public abstract void control(ArrayList<String> data);
    
}