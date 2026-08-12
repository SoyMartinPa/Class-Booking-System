package Gui.Tutor;

import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Dias;
import Logica.Enumeraciones.Materias;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Tutor.OfertaMateria;
import Logica.Perfiles.Tutor.Tutor;
import Logica.Reservas.EstadoReserva;
import Logica.Reservas.Horario;
import Logica.Reservas.Reserva;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class TutorPerfilPanel extends javax.swing.JPanel {
    Sistema sistema = Sistema.getInstancia();
    Tutor tutor;
    
    public TutorPerfilPanel() {
        initComponents();
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    
    public void actualizarReservas() {                                                                                

    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

    modelo.setColumnIdentifiers(new Object[]{
        "ReservaID", "Fecha", "Estado"
    });
    modelo.setRowCount(0);

    for (Reserva reserva : sistema.verCalendarioTutor(tutor)){
        String id = reserva.getId();
        LocalDate horario = reserva.getHorario().getFecha();
        EstadoReserva estado = reserva.getEstado();

        Object[] lista = {id,horario,estado};
        modelo.addRow(lista);
    }
    
    nombreLabel.setText("Nombre: " + tutor.getNombre());
    emailLabel.setText("Email: " + tutor.getEmail());
    idLabel.setText("ID: " + tutor.getId());
    
    tabla.setModel(modelo);
    
    }
    public void actualizarMateria() {                                                                                

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        modelo.setColumnIdentifiers(new Object[]{
            "Materia", "Tarifa", "Cupos"
        });

        modelo.setRowCount(0);

        for (Materias materia : tutor.getOfertaTotal().keySet()){
            OfertaMateria oferta = tutor.getOferta(materia);
            int cupos = oferta.cuposMax();
            int tarifa = oferta.tarifa();
            Object[] lista = {materia,tarifa,cupos};
            modelo.addRow(lista);
        }
        nombreLabel.setText("Nombre: " + tutor.getNombre());
        emailLabel.setText("Email: " + tutor.getEmail());
        idLabel.setText("ID: " + tutor.getId());
        tabla.setModel(modelo);
    }
    public void actualizarDisponibilidad() {                                                                                

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

            modelo.setColumnIdentifiers(new Object[]{
                "Dia", "Bloque"
            });
        modelo.setRowCount(0);

        for (Dias dia : tutor.getDisponibilidad().keySet()){
            
            for (BloquesHorarios bloque : tutor.getDisponibilidad().get(dia) ){
                Object[] lista = {dia,bloque};
                modelo.addRow(lista);
            }
        }
        nombreLabel.setText("Nombre: " + tutor.getNombre());
        emailLabel.setText("Email: " + tutor.getEmail());
        idLabel.setText("ID: " + tutor.getId());
        tabla.setModel(modelo);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonEstudiantes = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        nombreLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        verReservas = new javax.swing.JButton();
        verMaterias = new javax.swing.JButton();
        verDisponible = new javax.swing.JButton();

        BotonEstudiantes.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        BotonEstudiantes.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes.setText("Estudiantes");
        BotonEstudiantes.setBorder(null);
        BotonEstudiantes.setBorderPainted(false);
        BotonEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes.addActionListener(this::BotonEstudiantesActionPerformed);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTextField1.setText("Buscador");

        setPreferredSize(new java.awt.Dimension(502, 340));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ReservaID", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setShowGrid(true);
        tabla.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tabla);

        nombreLabel.setText("Nombre:");

        idLabel.setText("ID: ");

        emailLabel.setText("Email: ");

        verReservas.setBackground(new java.awt.Color(0, 153, 255));
        verReservas.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        verReservas.setForeground(new java.awt.Color(255, 255, 255));
        verReservas.setText("Reservas");
        verReservas.setBorder(null);
        verReservas.setBorderPainted(false);
        verReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verReservas.addActionListener(this::verReservasActionPerformed);

        verMaterias.setBackground(new java.awt.Color(0, 153, 255));
        verMaterias.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        verMaterias.setForeground(new java.awt.Color(255, 255, 255));
        verMaterias.setText("Materias");
        verMaterias.setBorder(null);
        verMaterias.setBorderPainted(false);
        verMaterias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verMaterias.addActionListener(this::verMateriasActionPerformed);

        verDisponible.setBackground(new java.awt.Color(0, 153, 255));
        verDisponible.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        verDisponible.setForeground(new java.awt.Color(255, 255, 255));
        verDisponible.setText("Disponible");
        verDisponible.setBorder(null);
        verDisponible.setBorderPainted(false);
        verDisponible.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verDisponible.addActionListener(this::verDisponibleActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nombreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idLabel)
                        .addGap(176, 176, 176))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(idLabel))
                .addGap(18, 18, 18)
                .addComponent(emailLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
       
    }//GEN-LAST:event_BotonEstudiantesActionPerformed

    private void verReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verReservasActionPerformed
        actualizarReservas();
    }//GEN-LAST:event_verReservasActionPerformed

    private void verMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMateriasActionPerformed
        actualizarMateria();
    }//GEN-LAST:event_verMateriasActionPerformed

    private void verDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDisponibleActionPerformed
        actualizarDisponibilidad();
    }//GEN-LAST:event_verDisponibleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTable tabla;
    private javax.swing.JButton verDisponible;
    private javax.swing.JButton verMaterias;
    private javax.swing.JButton verReservas;
    // End of variables declaration//GEN-END:variables
}
