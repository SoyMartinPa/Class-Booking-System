package Gui.Tutor;

import Excepciones.IncompatibilityException;
import Gui.Main;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Tutor.Tutor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TutorPanel extends javax.swing.JPanel {
    
    Sistema sistema = Sistema.getInstancia();
    
    public TutorPanel() {
        initComponents();
        modelo  = (DefaultTableModel) tabla.getModel();
    }
    
    public void actualizar() {                                           

            if (sistema.getGestorTutores().getLista() != null){
                modelo.setRowCount(0);

                for (Tutor tutor : sistema.getGestorTutores().getLista()){
                    String id = tutor.getId();
                    String nombre = tutor.getNombre();
                    String email = tutor.getEmail();
                    int ofertaCantidad = tutor.getOfertaTotal().size();
                    int disponibilidadCantidad = tutor.getDisponibilidad().size();

                    Object[] lista = {id,nombre,email,ofertaCantidad,disponibilidadCantidad};
                    modelo.addRow(lista);
                }
            }
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
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        Filtros = new javax.swing.JComboBox<>();
        BuscarField = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        ver = new javax.swing.JButton();

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
                "ID", "Nombre", "Email", "N°Materias", "N°Disponible"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setShowGrid(true);
        tabla.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tabla);

        modificar.setBackground(new java.awt.Color(0, 153, 255));
        modificar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setText("Modificar");
        modificar.setBorder(null);
        modificar.setBorderPainted(false);
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar.addActionListener(this::modificarActionPerformed);

        eliminar.setBackground(new java.awt.Color(0, 153, 255));
        eliminar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("Eliminar");
        eliminar.setBorder(null);
        eliminar.setBorderPainted(false);
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.addActionListener(this::eliminarActionPerformed);

        registrar.setBackground(new java.awt.Color(0, 153, 255));
        registrar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("Registrar");
        registrar.setBorder(null);
        registrar.setBorderPainted(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.addActionListener(this::registrarActionPerformed);

        Filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Email" }));
        Filtros.addActionListener(this::FiltrosActionPerformed);

        BuscarField.addActionListener(this::BuscarFieldActionPerformed);

        buscar.setBackground(new java.awt.Color(0, 153, 255));
        buscar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar");
        buscar.setBorder(null);
        buscar.setBorderPainted(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addActionListener(this::buscarActionPerformed);

        ver.setBackground(new java.awt.Color(0, 153, 255));
        ver.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        ver.setForeground(new java.awt.Color(255, 255, 255));
        ver.setText("Ver");
        ver.setBorder(null);
        ver.setBorderPainted(false);
        ver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ver.addActionListener(this::verActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(ver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
        
    }//GEN-LAST:event_BotonEstudiantesActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int fila = tabla.getSelectedRow();
        String id = "";
        String nombre = "";
        String email = "";
        
        if (fila != -1) {
            id = tabla.getValueAt(fila, 0).toString();
            nombre = tabla.getValueAt(fila, 1).toString();
            email = tabla.getValueAt(fila, 2).toString();
        }
        Main.getInstance().getTutorModificarPanel().getIdField().setText(id);
        Main.getInstance().getTutorModificarPanel().getEmailField().setText(email);
        Main.getInstance().getTutorModificarPanel().getNombreField().setText(nombre);
        
        Main.getInstance().cambiarPantalla("TutorModificar");
        
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            String id = tabla.getValueAt(fila, 0).toString();
            try {
                
                Tutor tutor = sistema.buscarTutorPorId(id);
                
                int opcion = JOptionPane.showConfirmDialog(
                        this,
                        "¿Seguro que deseas eliminar este tutor?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                    );
                if (opcion == JOptionPane.YES_OPTION) {
                     sistema.eliminarTutor(tutor);
                     actualizar();
                    }
            } catch(Exception e) {
                JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                e.getClass().getSimpleName(),
                JOptionPane.ERROR_MESSAGE
            );
            };
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        Main.getInstance().cambiarPantalla("TutorRegistrar");
    }//GEN-LAST:event_registrarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
       
       String filtro = Filtros.getSelectedItem().toString();
       String texto = BuscarField.getText();
       Tutor tutor;
       String id;
       String nombre;
       String email;
       try{
           
        tutor = switch (filtro) {
            case "ID" -> sistema.buscarTutorPorId(texto);

            case "Nombre" -> sistema.buscarTutorPorNombre(texto);

            case "Email" -> sistema.buscarTutorPorEmail(texto);
                
            default -> throw new IncompatibilityException("Error de filtrado desconocido");
        };

        modelo.setRowCount(0);
        id = tutor.getId();
        nombre = tutor.getNombre();
        email = tutor.getEmail();
        int ofertaCantidad = tutor.getOfertaTotal().size();
        int disponibilidadCantidad = tutor.getDisponibilidad().size();
        
        Object[]lista = {id,nombre,email,ofertaCantidad,disponibilidadCantidad};
        modelo.addRow(lista);
        
       } catch (Exception e){
                JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                e.getClass().getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
                actualizar();
        };
    }//GEN-LAST:event_buscarActionPerformed

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
           int fila = tabla.getSelectedRow();
           if (fila != -1) {
            String id = tabla.getValueAt(fila, 0).toString();
            Tutor tutor = sistema.buscarTutorPorId(id);
            
            Main.getInstance().cambiarPantalla("TutorPerfil");
            Main.getInstance().getTutorPerfilPanel().setTutor(tutor);
            Main.getInstance().getTutorPerfilPanel().actualizar();
           } 
        }//GEN-LAST:event_verActionPerformed

    private void BuscarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarFieldActionPerformed

    private void FiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltrosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.JTextField BuscarField;
    private javax.swing.JComboBox<String> Filtros;
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton eliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton registrar;
    private javax.swing.JTable tabla;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel modelo;
}
