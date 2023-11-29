package packVue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import packModele.Etudiant;
import packModele.Promotion;


public class VueListe extends AbstractVue {

    private final JList<String> liste;
    private final JButton btSuppr = new JButton("Supprimer");
    private Promotion promotion;
    

    public VueListe(Promotion promotion) {
        // Initialisation de la promotion et chargement des étudiants depuis un CSV
        this.promotion = promotion; 
        // Configuration de la JList
        liste = new JList<>();
        liste.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(liste);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(scrollPane, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(btSuppr, gc);

        remplissageListe(promotion);
        this.pack();
        liste.setVisibleRowCount(this.getHeight()/8);
        this.pack();
    }

    public void remplissageListe(Promotion promotion) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Etudiant etudiant : promotion.getEtudiants()) {
            model.addElement(etudiant.getPrenom() + " " + etudiant.getNom());
        }
        liste.setModel(model);
    }   
    public void actualiserListe() {
    DefaultListModel<String> model = new DefaultListModel<>();
    for (Etudiant etudiant : promotion.getEtudiants()) {
        model.addElement(etudiant.getPrenom() + " " + etudiant.getNom());
    }
    liste.setModel(model);
}

}
