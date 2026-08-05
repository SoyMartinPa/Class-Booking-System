package Gui;

import Gui.Estudiantes.EstudianteModificarPanel;
import Gui.Estudiantes.EstudiantePanel;
import Gui.Estudiantes.EstudiantePerfilPanel;
import Gui.Estudiantes.EstudianteRegistrarPanel;
import Gui.Reserva.ReservaModificarPanel;
import Gui.Reserva.ReservaPanel;
import Gui.Reserva.ReservaPerfilPanel;
import Gui.Reserva.ReservaRegistrarPanel;
import Gui.Tutor.TutorRegistrarPanel;
import Gui.Tutor.TutorPanel;
import Gui.Tutor.TutorModificarPanel;
import Gui.Tutor.TutorPerfilPanel;
import java.awt.CardLayout;

public class Main extends javax.swing.JFrame {
    
    public static CardLayout cardLayout;

    private static Main instance;
    private final EstudiantePanel estudiantePanel = new EstudiantePanel();
    private final TutorPanel tutorPanel = new TutorPanel();
    private final ReservaPanel reservaPanel = new ReservaPanel();
    private final InformacionPanel informacionPanel = new InformacionPanel();
    
    private final TutorModificarPanel tutorModificarPanel= new TutorModificarPanel();
    private final TutorRegistrarPanel tutorRegistrarPanel = new TutorRegistrarPanel();
    private final EstudianteRegistrarPanel estudianteRegistrarPanel = new EstudianteRegistrarPanel();
    private final EstudianteModificarPanel estudianteModificarPanel = new EstudianteModificarPanel();
    private final ReservaRegistrarPanel reservaRegistrarPanel = new ReservaRegistrarPanel();
    private final ReservaModificarPanel reservaModificarPanel = new ReservaModificarPanel();
    
    private final EstudiantePerfilPanel estudiantePerfilPanel = new EstudiantePerfilPanel();
    private final TutorPerfilPanel tutorPerfilPanel = new TutorPerfilPanel();
    private final ReservaPerfilPanel reservaPerfilPanel = new ReservaPerfilPanel();
    

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

    PanelDinamico.add(estudiantePanel, "Estudiante");
    PanelDinamico.add(tutorPanel, "Tutor");
    PanelDinamico.add(reservaPanel, "Reserva");
    PanelDinamico.add(informacionPanel, "Informacion");
    PanelDinamico.add(tutorRegistrarPanel, "TutorRegistrar");
    PanelDinamico.add(tutorModificarPanel, "TutorModificar");
    PanelDinamico.add(estudianteRegistrarPanel, "EstudianteRegistrar");
    PanelDinamico.add(estudianteModificarPanel, "EstudianteModificar");
    PanelDinamico.add(reservaRegistrarPanel, "ReservaRegistrar");
    PanelDinamico.add(reservaModificarPanel, "ReservaModificar");
    PanelDinamico.add(estudiantePerfilPanel, "EstudiantePerfil");
    PanelDinamico.add(tutorPerfilPanel, "TutorPerfil");
    PanelDinamico.add(reservaPerfilPanel, "ReservaPerfil");

    cardLayout.show(PanelDinamico, "Informacion");
    }

    public ReservaPerfilPanel getReservaPerfilPanel() {
        return reservaPerfilPanel;
    }

    public TutorPerfilPanel getTutorPerfilPanel() {
        return tutorPerfilPanel;
    }
    
    public EstudiantePerfilPanel getEstudiantePerfilPanel() {
        return estudiantePerfilPanel;
    }

    public TutorModificarPanel getTutorModificarPanel() {
        return tutorModificarPanel;
    }

    public EstudianteModificarPanel getEstudianteModificarPanel() {
        return estudianteModificarPanel;
    }

    public ReservaModificarPanel getReservaModificarPanel() {
        return reservaModificarPanel;
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTotal = new javax.swing.JPanel();
        jPanelIzquierdo = new javax.swing.JPanel();
        estudianteBoton = new javax.swing.JButton();
        tutoresBoton = new javax.swing.JButton();
        reservasBoton = new javax.swing.JButton();
        informacionBoton = new javax.swing.JButton();
        jPanelTitulo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        PanelDinamico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelTotal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTotal.setPreferredSize(new java.awt.Dimension(704, 450));

        jPanelIzquierdo.setBackground(new java.awt.Color(0, 102, 204));
        jPanelIzquierdo.setForeground(new java.awt.Color(0, 102, 204));
        jPanelIzquierdo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        estudianteBoton.setBackground(new java.awt.Color(0, 153, 255));
        estudianteBoton.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 18)); // NOI18N
        estudianteBoton.setForeground(new java.awt.Color(255, 255, 255));
        estudianteBoton.setText("Estudiantes");
        estudianteBoton.setBorder(null);
        estudianteBoton.setBorderPainted(false);
        estudianteBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        estudianteBoton.addActionListener(this::estudianteBotonActionPerformed);
        jPanelIzquierdo.add(estudianteBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 190, 90));

        tutoresBoton.setBackground(new java.awt.Color(0, 153, 255));
        tutoresBoton.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 18)); // NOI18N
        tutoresBoton.setForeground(new java.awt.Color(255, 255, 255));
        tutoresBoton.setText("Información");
        tutoresBoton.setBorder(null);
        tutoresBoton.setBorderPainted(false);
        tutoresBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tutoresBoton.addActionListener(this::tutoresBotonActionPerformed);
        jPanelIzquierdo.add(tutoresBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 190, 80));

        reservasBoton.setBackground(new java.awt.Color(0, 153, 255));
        reservasBoton.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 18)); // NOI18N
        reservasBoton.setForeground(new java.awt.Color(255, 255, 255));
        reservasBoton.setText("Reservas");
        reservasBoton.setBorder(null);
        reservasBoton.setBorderPainted(false);
        reservasBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservasBoton.addActionListener(this::reservasBotonActionPerformed);
        jPanelIzquierdo.add(reservasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 90));

        informacionBoton.setBackground(new java.awt.Color(0, 153, 255));
        informacionBoton.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 18)); // NOI18N
        informacionBoton.setForeground(new java.awt.Color(255, 255, 255));
        informacionBoton.setText("Tutores");
        informacionBoton.setBorder(null);
        informacionBoton.setBorderPainted(false);
        informacionBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        informacionBoton.addActionListener(this::informacionBotonActionPerformed);
        jPanelIzquierdo.add(informacionBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 90));

        jPanelTitulo.setBackground(new java.awt.Color(0, 153, 204));

        titulo.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Gestor De Reservas");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
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

        javax.swing.GroupLayout jPanelTotalLayout = new javax.swing.GroupLayout(jPanelTotal);
        jPanelTotal.setLayout(jPanelTotalLayout);
        jPanelTotalLayout.setHorizontalGroup(
            jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalLayout.createSequentialGroup()
                .addComponent(jPanelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTotalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelTotalLayout.setVerticalGroup(
            jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalLayout.createSequentialGroup()
                .addComponent(jPanelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelTotalLayout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelDinamico.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelTotal.getAccessibleContext().setAccessibleName("BackGround");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estudianteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudianteBotonActionPerformed
        estudiantePanel.actualizar();
        cambiarPantalla("Estudiante");
        
    }//GEN-LAST:event_estudianteBotonActionPerformed

    private void tutoresBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutoresBotonActionPerformed
        cambiarPantalla("Informacion");
    }//GEN-LAST:event_tutoresBotonActionPerformed

    private void reservasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasBotonActionPerformed
        cambiarPantalla("Reserva");
        reservaPanel.actualizar();
    }//GEN-LAST:event_reservasBotonActionPerformed

    private void informacionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacionBotonActionPerformed
        tutorPanel.actualizar();
        cambiarPantalla("Tutor");
    }//GEN-LAST:event_informacionBotonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDinamico;
    private javax.swing.JButton estudianteBoton;
    private javax.swing.JButton informacionBoton;
    private javax.swing.JPanel jPanelIzquierdo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JPanel jPanelTotal;
    private javax.swing.JButton reservasBoton;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton tutoresBoton;
    // End of variables declaration//GEN-END:variables
}
