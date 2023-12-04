package packVue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import packControleur.ControleurSuppList;
import packModele.Etudiant;
import packModele.Promotion;


public class VueListe extends AbstractVue implements Observateur {

    private final JList<String> liste;
    private final JButton btSuppr = new JButton("Supprimer");
    private Promotion promotion;
    

    public VueListe(final Promotion promotion) {
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
        liste.setPreferredSize(new Dimension (150,500));
        
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(btSuppr, gc);

        remplissageListe(promotion);
        this.pack();
        liste.setVisibleRowCount(this.getHeight()/8);
        this.pack();
        
        btSuppr.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                String selectedStudent = liste.getSelectedValue();
        
                if (selectedStudent != null) {
                    String[] parts = selectedStudent.split("-");
                    if (parts.length > 0) {
                        String studentId = parts[0].trim();
                        ControleurSuppList controleur = new ControleurSuppList(promotion);
                        ArrayList<String> studentsToDelete = new ArrayList<>();
                        studentsToDelete.add(studentId);
                        controleur.control(studentsToDelete);
                        update();
                    }
                }
    
            }
        });
    }

    private void remplissageListe(Promotion promotion) {
        ArrayList<Etudiant> etudiants = promotion.getEtudiants();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant.getPrenom()+ " " + etudiant.getNom());
            model.addElement(etudiant.getIdent()+"-" +etudiant.getPrenom() + " " + etudiant.getNom());
        }
        liste.setModel(model);
    }
    private void remplissageListe2(ArrayList<Etudiant> etudiants) {
    DefaultListModel<String> model = new DefaultListModel<>();
    for (Etudiant etudiant : etudiants) {
        System.out.println(etudiant.getPrenom() + " " + etudiant.getNom());
        model.addElement(etudiant.getIdent() + "-" + etudiant.getPrenom() + " " + etudiant.getNom());
    }
    liste.setModel(model);
}

    public void update() {
       if (promotion != null) {
            ArrayList<Etudiant> newPromotion = promotion.getEtudiants();
            remplissageListe2 (newPromotion);
        }   
    }
    
    
    
    

}
