package Gui.Tutor;
import Excepciones.IncompatibilityException;
import Excepciones.NoRepeatException;
import Excepciones.NotFoundException;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Dias;
import Logica.Enumeraciones.Materias;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Tutor.Tutor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TutorModificarPanel extends javax.swing.JPanel {
    
    Sistema sistema = Sistema.getInstancia();
    
    public TutorModificarPanel() {
        initComponents();
        
        materiaCombo.setModel(crearModeloCombo(Materias.values()) );
        diaCombo.setModel(crearModeloCombo(Dias.values() ) );
        bloqueCombo.setModel(crearModeloCombo(BloquesHorarios.values()) );
    }
    
    private <T> DefaultComboBoxModel<T> crearModeloCombo(T[] valores) {
    T[] opciones = java.util.Arrays.copyOf(valores, valores.length + 1);
    System.arraycopy(opciones, 0, opciones, 1, valores.length);
    opciones[0] = null;

    return new DefaultComboBoxModel<>(opciones);
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNombreField() {
        return nombreField;
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
        registrar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        modificarBoton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        materiaLabel = new javax.swing.JLabel();
        tarifaLabel = new javax.swing.JLabel();
        materiaCombo = new javax.swing.JComboBox<>();
        Agregar1 = new javax.swing.JButton();
        Quitar1 = new javax.swing.JButton();
        Agregar2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        diaCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        bloqueCombo = new javax.swing.JComboBox<>();
        Quitar2 = new javax.swing.JButton();
        tarifaSpiner = new javax.swing.JSpinner();
        cuposLabel = new javax.swing.JLabel();
        cuposSpiner = new javax.swing.JSpinner();
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

        registrar.setBackground(new java.awt.Color(0, 153, 255));
        registrar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("Registrar");
        registrar.setBorder(null);
        registrar.setBorderPainted(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.addActionListener(this::registrarActionPerformed);

        registrar1.setBackground(new java.awt.Color(0, 153, 255));
        registrar1.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        registrar1.setForeground(new java.awt.Color(255, 255, 255));
        registrar1.setText("Registrar");
        registrar1.setBorder(null);
        registrar1.setBorderPainted(false);
        registrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar1.addActionListener(this::registrar1ActionPerformed);

        setPreferredSize(new java.awt.Dimension(502, 340));

        jLabel2.setText("Nombre:");

        emailField.addActionListener(this::emailFieldActionPerformed);

        jLabel3.setText("Email: ");

        nombreField.addActionListener(this::nombreFieldActionPerformed);

        idField.addActionListener(this::idFieldActionPerformed);

        idLabel.setText("ID: ");

        modificarBoton.setBackground(new java.awt.Color(0, 153, 255));
        modificarBoton.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        modificarBoton.setForeground(new java.awt.Color(255, 255, 255));
        modificarBoton.setText("Modificar");
        modificarBoton.setBorder(null);
        modificarBoton.setBorderPainted(false);
        modificarBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificarBoton.addActionListener(this::modificarBotonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(idLabel)
                            .addComponent(modificarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        materiaLabel.setText("Materia");
        jPanel2.add(materiaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, -1));

        tarifaLabel.setText("Tarifa");
        jPanel2.add(tarifaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, -1, -1));

        materiaCombo.addActionListener(this::materiaComboActionPerformed);
        jPanel2.add(materiaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 6, -1, -1));

        Agregar1.setText("Agregar");
        Agregar1.addActionListener(this::Agregar1ActionPerformed);
        jPanel2.add(Agregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        Quitar1.setText("Quitar");
        Quitar1.addActionListener(this::Quitar1ActionPerformed);
        jPanel2.add(Quitar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 78, -1));

        Agregar2.setText("Agregar");
        Agregar2.addActionListener(this::Agregar2ActionPerformed);
        jPanel2.add(Agregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 138, -1, -1));

        jLabel6.setText("Dia");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 141, -1, -1));

        jPanel2.add(diaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 138, 75, -1));

        jLabel7.setText("Bloque");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 177, -1, -1));

        bloqueCombo.addActionListener(this::bloqueComboActionPerformed);
        jPanel2.add(bloqueCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 174, -1, -1));

        Quitar2.setText("Quitar");
        Quitar2.addActionListener(this::Quitar2ActionPerformed);
        jPanel2.add(Quitar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 174, 76, -1));

        tarifaSpiner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 50));
        jPanel2.add(tarifaSpiner, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 42, 75, -1));

        cuposLabel.setText("Cupos");
        jPanel2.add(cuposLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 81, -1, -1));

        cuposSpiner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel2.add(cuposSpiner, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 78, 75, -1));

        registrarEstudianteLabel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        registrarEstudianteLabel.setForeground(new java.awt.Color(51, 51, 51));
        registrarEstudianteLabel.setText("Modificar Tutor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(registrarEstudianteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 312, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(registrarEstudianteLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addGap(46, 46, 46))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEstudiantesActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed

    }//GEN-LAST:event_emailFieldActionPerformed

    private void nombreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFieldActionPerformed

    private void bloqueComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloqueComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloqueComboActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        //Borrable
    }//GEN-LAST:event_registrarActionPerformed

    private void registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar1ActionPerformed
        //borrable
    }//GEN-LAST:event_registrar1ActionPerformed

    private void Agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar1ActionPerformed
        Materias materia = (Materias)materiaCombo.getSelectedItem();
        int tarifa = (int) tarifaSpiner.getValue();
        int cupos  = (int) cuposSpiner.getValue();
        String id = idField.getText();
        int opcion;
        
        try{
            Tutor tutor = sistema.buscarTutorPorId(id);
            if (materia == null){throw new IncompatibilityException("Seleccione una materia valida");}
            
            if (!tutor.dictaMateria(materia)) {
                tutor.ofrecerMateria(materia,tarifa,cupos);
                tarifaSpiner.setValue(0);
                cuposSpiner.setValue(0);
                materiaCombo.setSelectedIndex(0);
            }
            else {
                
                opcion = JOptionPane.showConfirmDialog(
                        this,
                        "¿Desea sobreescribir la configuracion de esta materia?",
                        "Sobreescribir materia",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                
                if (opcion == JOptionPane.YES_OPTION){
                    tutor.ofrecerMateria(materia,tarifa,cupos); 
                    tarifaSpiner.setValue(0);
                    cuposSpiner.setValue(0);
                }
            
            }
            
   
            
        } catch(Exception e){
                JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                e.getClass().getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
        }; 
        
    }//GEN-LAST:event_Agregar1ActionPerformed

    private void modificarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBotonActionPerformed
        String email = emailField.getText();
        String nombre = nombreField.getText();
        String id = idField.getText();
        
        try{ 
            
            Tutor tutor = sistema.buscarTutorPorId(id);
            
            if (!tutor.getNombre().equals(nombre) && !tutor.getEmail().equals(email)){
                
            sistema.getGestorTutores().cambiarNombre(tutor, nombre);
            nombreField.setText("");
            emailField.setText("");;
            idField.setText("");}
            
            else if (!tutor.getNombre().equals(nombre)){
                 sistema.getGestorTutores().cambiarNombre(tutor, nombre);
                 nombreField.setText("");}
            else if (!tutor.getEmail().equals(email)){
                 sistema.getGestorTutores().cambiarEmail(tutor, email);
                 emailField.setText("");}

            
        } catch(Exception e){ 
            JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            e.getClass().getSimpleName(),
            JOptionPane.ERROR_MESSAGE
            );
        }   
    }//GEN-LAST:event_modificarBotonActionPerformed

    private void materiaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materiaComboActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void Quitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quitar1ActionPerformed
        Materias materia = (Materias)materiaCombo.getSelectedItem();
        String id = idField.getText();
        int opcion;
        
        try{
            Tutor tutor = sistema.buscarTutorPorId(id);
            if (materia == null){throw new IncompatibilityException("Seleccione una materia valida");}
            if (tutor.dictaMateria(materia)) {
                opcion = JOptionPane.showConfirmDialog(
                        this,
                        "¿Desea que el tutor no imparta esta materia?",
                        "Eliminar materia",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                
                if (opcion == JOptionPane.YES_OPTION){
                    tutor.dejarDeOfrecer(materia); 
                    tarifaSpiner.setValue(0);
                    cuposSpiner.setValue(0);
                    materiaCombo.setSelectedIndex(0);
                     }
            }
            else {
                    throw new NotFoundException("El tutor no imparte esa materia");
                }

        } catch(Exception e){
                JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                e.getClass().getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
        }; 
    }//GEN-LAST:event_Quitar1ActionPerformed

    private void Agregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar2ActionPerformed
        Dias dia = (Dias) diaCombo.getSelectedItem();
        BloquesHorarios bloque = (BloquesHorarios) bloqueCombo.getSelectedItem();
        String id = idField.getText();

        
        try{
            if (dia == null){throw new IncompatibilityException("Seleccione un dia valido");}
            if (bloque == null){throw new IncompatibilityException("Seleccione un bloque valido");}
            
            Tutor tutor = sistema.buscarTutorPorId(id);
            if (!tutor.estaDisponible(dia,bloque)) {
                tutor.agregarDisponibilidad(dia,bloque);
                diaCombo.setSelectedIndex(0);
                bloqueCombo.setSelectedIndex(0);
            }
            else {
                throw new NoRepeatException("El horario ya ha sido ocupado");
            }
            
        } catch(Exception e){
                JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                e.getClass().getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
        }; 
    }//GEN-LAST:event_Agregar2ActionPerformed

    private void Quitar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quitar2ActionPerformed
        Dias dia = (Dias) diaCombo.getSelectedItem();
        BloquesHorarios bloque = (BloquesHorarios) bloqueCombo.getSelectedItem();
        String id = idField.getText();
        int opcion;
        
        try{
            Tutor tutor = sistema.buscarTutorPorId(id);
            if (tutor.estaDisponible(dia,bloque)) {
                
                opcion = JOptionPane.showConfirmDialog(
                        this,
                        "¿Desea que el tutor no imparta en este horario?",
                        "Eliminar horario",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                
                if (opcion == JOptionPane.YES_OPTION){
                    tutor.quitarDisponibilidad(dia,bloque); 
                    diaCombo.setSelectedIndex(0);
                    bloqueCombo.setSelectedIndex(0);
                     }
            }
            else {
                throw new NoRepeatException("El profesor no está ocupando ese horario");
            }
            
        } catch(Exception e){
                JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                e.getClass().getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
        }; 
    }//GEN-LAST:event_Quitar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar1;
    private javax.swing.JButton Agregar2;
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.JButton Quitar1;
    private javax.swing.JButton Quitar2;
    private javax.swing.JComboBox<BloquesHorarios> bloqueCombo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cuposLabel;
    private javax.swing.JSpinner cuposSpiner;
    private javax.swing.JComboBox<Dias> diaCombo;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<Materias> materiaCombo;
    private javax.swing.JLabel materiaLabel;
    private javax.swing.JButton modificarBoton;
    private javax.swing.JTextField nombreField;
    private javax.swing.JButton registrar;
    private javax.swing.JButton registrar1;
    private javax.swing.JLabel registrarEstudianteLabel;
    private javax.swing.JLabel tarifaLabel;
    private javax.swing.JSpinner tarifaSpiner;
    // End of variables declaration//GEN-END:variables
}
