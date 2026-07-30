
package Gui.Reserva;

public class ReservaPanel extends javax.swing.JPanel {

    public ReservaPanel() {
        initComponents();
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
        jTable1 = new javax.swing.JTable();
        BotonEstudiantes1 = new javax.swing.JButton();
        BotonEstudiantes2 = new javax.swing.JButton();
        BotonEstudiantes3 = new javax.swing.JButton();
        Filtros = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        BotonEstudiantes4 = new javax.swing.JButton();

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tutor", "Materia", "Tarifa", "Cupos", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        BotonEstudiantes1.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes1.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        BotonEstudiantes1.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes1.setText("Modificar");
        BotonEstudiantes1.setBorder(null);
        BotonEstudiantes1.setBorderPainted(false);
        BotonEstudiantes1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes1.addActionListener(this::BotonEstudiantes1ActionPerformed);

        BotonEstudiantes2.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes2.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        BotonEstudiantes2.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes2.setText("Eliminar");
        BotonEstudiantes2.setBorder(null);
        BotonEstudiantes2.setBorderPainted(false);
        BotonEstudiantes2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes2.addActionListener(this::BotonEstudiantes2ActionPerformed);

        BotonEstudiantes3.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes3.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        BotonEstudiantes3.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes3.setText("Registrar");
        BotonEstudiantes3.setBorder(null);
        BotonEstudiantes3.setBorderPainted(false);
        BotonEstudiantes3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes3.addActionListener(this::BotonEstudiantes3ActionPerformed);

        Filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tutor", "Materia", "Tarifa", "Cupos", "Fecha" }));

        BotonEstudiantes4.setBackground(new java.awt.Color(0, 153, 255));
        BotonEstudiantes4.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        BotonEstudiantes4.setForeground(new java.awt.Color(255, 255, 255));
        BotonEstudiantes4.setText("Buscar");
        BotonEstudiantes4.setBorder(null);
        BotonEstudiantes4.setBorderPainted(false);
        BotonEstudiantes4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstudiantes4.addActionListener(this::BotonEstudiantes4ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonEstudiantes3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonEstudiantes2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonEstudiantes4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BotonEstudiantes4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonEstudiantes1)
                    .addComponent(BotonEstudiantes3)
                    .addComponent(BotonEstudiantes2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEstudiantesActionPerformed

    private void BotonEstudiantes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEstudiantes2ActionPerformed

    private void BotonEstudiantes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEstudiantes1ActionPerformed

    private void BotonEstudiantes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEstudiantes3ActionPerformed

    private void BotonEstudiantes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantes4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEstudiantes4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.JButton BotonEstudiantes1;
    private javax.swing.JButton BotonEstudiantes2;
    private javax.swing.JButton BotonEstudiantes3;
    private javax.swing.JButton BotonEstudiantes4;
    private javax.swing.JComboBox<String> Filtros;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
