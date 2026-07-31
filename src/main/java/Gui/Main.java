package Gui;

import Gui.Estudiantes.EstudianteModificarPanel;
import Gui.Estudiantes.EstudiantePanel;
import Gui.Estudiantes.EstudianteRegistrarPanel;
import Gui.Reserva.ReservaModificarPanel;
import Gui.Reserva.ReservaPanel;
import Gui.Reserva.ReservaRegistrarPanel;
import Gui.Tutor.TutorModificarPanel;
import Gui.Tutor.TutorPanel;
import Gui.Tutor.TutorRegistrarPanel;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.CardLayout;

public class Main extends javax.swing.JFrame {
    
    public static CardLayout cardLayout;
    private static Main instance;
    
        private Main() { 
        initComponents();
        initPanelDinamico();
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public void cambiarPantalla(String nombre){
        cardLayout.show(PanelDinamico, nombre);
    }

    private void initPanelDinamico(){
    cardLayout = new CardLayout();
    PanelDinamico.setLayout(cardLayout);

    PanelDinamico.add(new EstudiantePanel(), "Estudiante");
    PanelDinamico.add(new TutorPanel(), "Tutor");
    PanelDinamico.add(new ReservaPanel(), "Reserva");
    PanelDinamico.add(new InformacionPanel(), "Informacion");

    PanelDinamico.add(new TutorRegistrarPanel(), "TutorRegistrar");
    PanelDinamico.add(new TutorModificarPanel(), "TutorModificar");
    PanelDinamico.add(new EstudianteRegistrarPanel(), "EstudianteRegistrar");
    PanelDinamico.add(new EstudianteModificarPanel(), "EstudianteModificar");
    PanelDinamico.add(new ReservaRegistrarPanel(), "ReservaRegistrar");
    PanelDinamico.add(new ReservaModificarPanel(), "ReservaModificar");



    cardLayout.show(PanelDinamico, "Informacion");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BotonEstudiantes = new javax.swing.JButton();
        BotonEstudiantes1 = new javax.swing.JButton();
        BotonEstudiantes2 = new javax.swing.JButton();
        BotonEstudiantes3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        PanelDinamico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(704, 450));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setForeground(new java.awt.Color(0, 102, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonEstudiantes.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 18)); // NOI18N
        BotonEstudiantes.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes.setText("Estudiantes");
        BotonEstudiantes.setBorder(null);
        BotonEstudiantes.setBorderPainted(false);
        BotonEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes.addActionListener(this::BotonEstudiantesActionPerformed);
        jPanel2.add(BotonEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 190, 90));

        BotonEstudiantes1.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes1.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 18)); // NOI18N
        BotonEstudiantes1.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes1.setText("Informacion");
        BotonEstudiantes1.setBorder(null);
        BotonEstudiantes1.setBorderPainted(false);
        BotonEstudiantes1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes1.addActionListener(this::BotonEstudiantes1ActionPerformed);
        jPanel2.add(BotonEstudiantes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 190, 80));

        BotonEstudiantes2.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes2.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 18)); // NOI18N
        BotonEstudiantes2.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes2.setText("Reservas");
        BotonEstudiantes2.setBorder(null);
        BotonEstudiantes2.setBorderPainted(false);
        BotonEstudiantes2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes2.addActionListener(this::BotonEstudiantes2ActionPerformed);
        jPanel2.add(BotonEstudiantes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 90));

        BotonEstudiantes3.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes3.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 18)); // NOI18N
        BotonEstudiantes3.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes3.setText("Tutores");
        BotonEstudiantes3.setBorder(null);
        BotonEstudiantes3.setBorderPainted(false);
        BotonEstudiantes3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes3.addActionListener(this::BotonEstudiantes3ActionPerformed);
        jPanel2.add(BotonEstudiantes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 90));

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        titulo.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Gestor De Reservas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout PanelDinamicoLayout = new javax.swing.GroupLayout(PanelDinamico);
        PanelDinamico.setLayout(PanelDinamicoLayout);
        PanelDinamicoLayout.setHorizontalGroup(
            PanelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );
        PanelDinamicoLayout.setVerticalGroup(
            PanelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelDinamico.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("BackGround");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
        cardLayout.show(PanelDinamico, "Estudiante");
    }//GEN-LAST:event_BotonEstudiantesActionPerformed

    private void BotonEstudiantes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantes1ActionPerformed
        cardLayout.show(PanelDinamico, "Informacion");
    }//GEN-LAST:event_BotonEstudiantes1ActionPerformed

    private void BotonEstudiantes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantes2ActionPerformed
        cardLayout.show(PanelDinamico, "Reserva");
    }//GEN-LAST:event_BotonEstudiantes2ActionPerformed

    private void BotonEstudiantes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantes3ActionPerformed
        cardLayout.show(PanelDinamico, "Tutor");
    }//GEN-LAST:event_BotonEstudiantes3ActionPerformed

    public static void main(String args[]) {
        try {
                FlatLightLaf.setup();
            } catch (Exception ex) {
                ex.printStackTrace();
                }
        java.awt.EventQueue.invokeLater(() -> new Main().getInstance().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.JButton BotonEstudiantes1;
    private javax.swing.JButton BotonEstudiantes2;
    private javax.swing.JButton BotonEstudiantes3;
    private javax.swing.JPanel PanelDinamico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
