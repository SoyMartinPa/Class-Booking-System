package Gui.Reserva;

import Excepciones.TimeException;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Materias;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Tutor.Tutor;
import Logica.Reservas.Horario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ReservaRegistrarPanel extends javax.swing.JPanel {
    
    Sistema sistema = Sistema.getInstancia();
    
    
    public ReservaRegistrarPanel() {
        initComponents();
        materiaCombo.setModel(new DefaultComboBoxModel(Materias.values()) );
        bloqueCombo.setModel(new DefaultComboBoxModel(BloquesHorarios.values()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonEstudiantes = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        materiaCombo = new javax.swing.JComboBox<>();
        bloqueCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        fechaField = new javax.swing.JFormattedTextField();
        registrarEstudianteLabel = new javax.swing.JLabel();

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

        registrar.setBackground(new java.awt.Color(0, 153, 255));
        registrar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("Registrar");
        registrar.setBorder(null);
        registrar.setBorderPainted(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.addActionListener(this::registrarActionPerformed);

        jLabel2.setText("Nombre Tutor:");

        jLabel3.setText("Fecha: ");

        nombreField.addActionListener(this::nombreFieldActionPerformed);

        jLabel4.setText("Materia: ");

        materiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bloqueCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Bloque: ");

        try {
            fechaField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechaField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaField.addActionListener(this::fechaFieldActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(materiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(bloqueCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(fechaField)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bloqueCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        registrarEstudianteLabel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        registrarEstudianteLabel.setForeground(new java.awt.Color(51, 51, 51));
        registrarEstudianteLabel.setText("Registrar Reserva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEstudiantesActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nombre = nombreField.getText();
        BloquesHorarios bloque = (BloquesHorarios) bloqueCombo.getSelectedItem();
        Materias materia = (Materias) materiaCombo.getSelectedItem();
        
        try{ 
            Tutor tutor = sistema.buscarTutorPorNombre(nombre);
            LocalDate fecha = LocalDate.parse(fechaField.getText().trim(), formato);
            Horario horario = new Horario(bloque,fecha);
            if (!horario.horarioVigente()){throw new TimeException("El horario ya pasó");}
            
            sistema.getGestorReservas().registrarReserva(tutor,materia,horario);
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

    private void fechaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.JComboBox<String> bloqueCombo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField fechaField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> materiaCombo;
    private javax.swing.JTextField nombreField;
    private javax.swing.JButton registrar;
    private javax.swing.JLabel registrarEstudianteLabel;
    // End of variables declaration//GEN-END:variables

}
