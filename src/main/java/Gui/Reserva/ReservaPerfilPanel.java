package Gui.Reserva;

import Logica.Perfiles.Estudiante;
import Logica.Reservas.Reserva;
import javax.swing.table.DefaultTableModel;

public class ReservaPerfilPanel extends javax.swing.JPanel {
    Reserva reserva;
    
    public ReservaPerfilPanel() {
        initComponents();
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
    public void actualizar() {                                           


    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0);

    for (Estudiante estudiante : reserva.getListaEstudiantes()){
        String id = estudiante.getId();
        String email = estudiante.getEmail();
        String nombre = estudiante.getNombre();

        Object[] lista = {id,nombre,email};
        modelo.addRow(lista);
    }
    
    nombreLabel.setText("Nombre Tutor: " + reserva.getTutorAsociado().getNombre());
    idLabel.setText("ID: " + reserva.getId());
    materiaLabel.setText("Materia: " + reserva.getMateria().name());
    fechaLabel.setText(
            "Horario: " + reserva.getHorario().getFecha().toString() 
                    + " {" + reserva.getHorario().getBloqueHorario() + "}");
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
        fechaLabel = new javax.swing.JLabel();
        materiaLabel = new javax.swing.JLabel();

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
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setShowGrid(true);
        tabla.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 80, -1, 254));

        nombreLabel.setText("Nombre:");
        add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 6, -1, -1));

        idLabel.setText("ID: ");
        add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        fechaLabel.setText("Fecha:");
        add(fechaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 49, -1, -1));

        materiaLabel.setText("Materia");
        add(materiaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
       
    }//GEN-LAST:event_BotonEstudiantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel materiaLabel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
