package Gui.Reserva;

import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Materias;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;
import Logica.Reservas.Horario;
import Logica.Reservas.Reserva;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReservaModificarPanel extends javax.swing.JPanel {
    
    Sistema sistema = Sistema.getInstancia();
    
    
    public ReservaModificarPanel() {
        initComponents();
        materiaCombo.setModel(new DefaultComboBoxModel(Materias.values()) );
        bloqueCombo.setModel(new DefaultComboBoxModel(BloquesHorarios.values()));
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNombreField() {
        return nombreField;
    }

    public JFormattedTextField getFechaField() {
        return fechaField;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonEstudiantes = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        materiaCombo = new javax.swing.JComboBox<>();
        fechaField = new javax.swing.JFormattedTextField();
        bloqueCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        registrarEstudianteLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        estudianteField = new javax.swing.JTextField();
        agregarEstudianteBoton = new javax.swing.JButton();
        quitarEstudianteBoton = new javax.swing.JButton();

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

        jLabel2.setText("Nombre Tutor:");

        jLabel3.setText("Fecha: ");

        nombreField.addActionListener(this::nombreFieldActionPerformed);

        jLabel4.setText("Materia: ");

        materiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fechaField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        fechaField.addActionListener(this::fechaFieldActionPerformed);

        bloqueCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Bloque: ");

        jLabel6.setText("ID Reserva:");

        idField.addActionListener(this::idFieldActionPerformed);

        registrar.setBackground(new java.awt.Color(0, 153, 255));
        registrar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("Modificar");
        registrar.setBorder(null);
        registrar.setBorderPainted(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.addActionListener(this::registrarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
            .addComponent(fechaField)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bloqueCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(materiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(idField)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bloqueCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        registrarEstudianteLabel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        registrarEstudianteLabel.setForeground(new java.awt.Color(51, 51, 51));
        registrarEstudianteLabel.setText("Registrar Modificar");

        jLabel1.setText("Estudiante nombre:");

        estudianteField.addActionListener(this::estudianteFieldActionPerformed);

        agregarEstudianteBoton.setText("Agregar");
        agregarEstudianteBoton.addActionListener(this::agregarEstudianteBotonActionPerformed);

        quitarEstudianteBoton.setText("Quitar");
        quitarEstudianteBoton.addActionListener(this::quitarEstudianteBotonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(estudianteField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agregarEstudianteBoton)
                        .addGap(18, 18, 18)
                        .addComponent(quitarEstudianteBoton)))
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(registrarEstudianteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(registrarEstudianteLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estudianteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarEstudianteBoton)
                            .addComponent(quitarEstudianteBoton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEstudiantesActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String id = idField.getText();
        String nombre = nombreField.getText();
        BloquesHorarios bloque = (BloquesHorarios) bloqueCombo.getSelectedItem();
        Materias materia = (Materias) materiaCombo.getSelectedItem();
        
        try{ 
            LocalDate fecha = LocalDate.parse(fechaField.getText(), formato);
            Horario horario = new Horario(bloque,fecha);
            Tutor tutor = sistema.buscarTutorPorNombre(nombre);
            Reserva reserva = sistema.buscarReservaPorId(id);
            sistema.getGestorReservas().modificarReserva(reserva,tutor,materia,horario);
            idField.setText("");
            nombreField.setText("");
            fechaField.setText("");
            bloqueCombo.setSelectedIndex(0);
            materiaCombo.setSelectedIndex(0);
            
        } 
        catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                "Fecha inválida.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        
        }catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            e.getClass().getSimpleName(),
            JOptionPane.ERROR_MESSAGE
        );
        
        
       }                                         
    }//GEN-LAST:event_registrarActionPerformed

    private void nombreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFieldActionPerformed

    }//GEN-LAST:event_nombreFieldActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void estudianteFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudianteFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estudianteFieldActionPerformed

    private void agregarEstudianteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEstudianteBotonActionPerformed
        String nombre = estudianteField.getText();
        try{
            String id = idField.getText();
            Reserva reserva = sistema.buscarReservaPorId(id);
            Estudiante estudiante = sistema.buscarEstudiantePorNombre(nombre);
            sistema.getGestorReservas().agregarEstudiantesReserva(reserva, estudiante);
            estudianteField.setText("");
        } catch (Exception e){
            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                e.getClass().getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_agregarEstudianteBotonActionPerformed

    private void quitarEstudianteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarEstudianteBotonActionPerformed
                String nombre = estudianteField.getText();
        try{
            String id = idField.getText();
            Reserva reserva = sistema.buscarReservaPorId(id);
            Estudiante estudiante = sistema.buscarEstudiantePorNombre(nombre);
            sistema.getGestorReservas().quitarEstudianteReserva(reserva, estudiante);
            estudianteField.setText("");
        } catch (Exception e){
            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                e.getClass().getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_quitarEstudianteBotonActionPerformed

    private void fechaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.JButton agregarEstudianteBoton;
    private javax.swing.JComboBox<String> bloqueCombo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField estudianteField;
    private javax.swing.JFormattedTextField fechaField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> materiaCombo;
    private javax.swing.JTextField nombreField;
    private javax.swing.JButton quitarEstudianteBoton;
    private javax.swing.JButton registrar;
    private javax.swing.JLabel registrarEstudianteLabel;
    // End of variables declaration//GEN-END:variables

}
