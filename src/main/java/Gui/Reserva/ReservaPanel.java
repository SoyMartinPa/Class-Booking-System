package Gui.Reserva;

import Gui.Main;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Materias;
import Logica.Filtros.FiltroBloque;
import Logica.Filtros.FiltroCompuesto;
import Logica.Filtros.FiltroCuposMax;
import Logica.Filtros.FiltroFecha;
import Logica.Filtros.FiltroMateria;
import Logica.Filtros.FiltroTarifaMax;
import Logica.Gestores.Sistema;
import Logica.Reservas.Reserva;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReservaPanel extends javax.swing.JPanel {
    
    Sistema sistema = Sistema.getInstancia();
    
    public ReservaPanel() {
        initComponents();
        materiaCombo.setModel(crearModeloCombo(Materias.values()));
        bloqueCombo.setModel(crearModeloCombo(BloquesHorarios.values()));
        
    }
    
    private <T extends Enum<T>> DefaultComboBoxModel<T> crearModeloCombo(T[] valores) {
        T[] opciones = java.util.Arrays.copyOf(valores, valores.length + 1);
        System.arraycopy(opciones, 0, opciones, 1, valores.length);
        opciones[0] = null;

        return new DefaultComboBoxModel<>(opciones);
    }

    public void actualizar() {                                           
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0);
    List<Reserva> lista = sistema.getGestorReservas().getListaReservas();
    
    for (Reserva reserva : lista){
        String id = reserva.getId();
        String nombre = reserva.getTutorAsociado().getNombre();
        Materias materia = reserva.getMateria();
        int tarifa = reserva.getTarifa();
        int cupos = reserva.getCuposMax() - reserva.getListaEstudiantes().size();
        LocalDate fecha = reserva.getHorario().getFecha();
        BloquesHorarios bloque = reserva.getHorario().getBloqueHorario();
        String estado = reserva.getEstado().toString();

        Object[] list = {id,nombre,materia,tarifa,cupos,fecha,bloque,estado};
        modelo.addRow(list);
            }
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        ver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cuposSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        materiaCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tarifaSpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        bloqueCombo = new javax.swing.JComboBox<>();
        fechaField = new javax.swing.JFormattedTextField();

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

        jLabel1.setText("jLabel1");

        setPreferredSize(new java.awt.Dimension(502, 340));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tutor", "Materia", "Tarifa", "Cupos", "Fecha", "Bloque", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setShowGrid(true);
        tabla.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 68, -1, 230));

        modificar.setBackground(new java.awt.Color(0, 153, 255));
        modificar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setText("Modificar");
        modificar.setBorder(null);
        modificar.setBorderPainted(false);
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar.addActionListener(this::modificarActionPerformed);
        add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 304, 90, 30));

        eliminar.setBackground(new java.awt.Color(0, 153, 255));
        eliminar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("Eliminar");
        eliminar.setBorder(null);
        eliminar.setBorderPainted(false);
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.addActionListener(this::eliminarActionPerformed);
        add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 304, 90, 30));

        registrar.setBackground(new java.awt.Color(0, 153, 255));
        registrar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("Registrar");
        registrar.setBorder(null);
        registrar.setBorderPainted(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.addActionListener(this::registrarActionPerformed);
        add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 304, 90, 30));

        buscar.setBackground(new java.awt.Color(0, 153, 255));
        buscar.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Filtrar");
        buscar.setBorder(null);
        buscar.setBorderPainted(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addActionListener(this::buscarActionPerformed);
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 70, 50));

        ver.setBackground(new java.awt.Color(0, 153, 255));
        ver.setFont(new java.awt.Font("Noto Serif CJK SC SemiBold", 0, 14)); // NOI18N
        ver.setForeground(new java.awt.Color(255, 255, 255));
        ver.setText("Ver");
        ver.setBorder(null);
        ver.setBorderPainted(false);
        ver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ver.addActionListener(this::verActionPerformed);
        add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 304, 90, 30));

        jLabel2.setText("Fecha");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        cuposSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        add(cuposSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel3.setText("Bloque");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        materiaCombo.addActionListener(this::materiaComboActionPerformed);
        add(materiaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 160, -1));

        jLabel4.setText("Materia");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel5.setText("Tarifa");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tarifaSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 50));
        add(tarifaSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel6.setText("CuposMax");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        add(bloqueCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        try {
            fechaField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechaField.addActionListener(this::fechaFieldActionPerformed);
        add(fechaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 100, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstudiantesActionPerformed
        
    }//GEN-LAST:event_BotonEstudiantesActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int fila = tabla.getSelectedRow();
        String id = "";
        String nombre = "";
        String textoFecha = "";
        if (fila != -1) {
            id = tabla.getValueAt(fila, 0).toString();
            nombre = tabla.getValueAt(fila, 1).toString();
            Reserva reserva = sistema.buscarReservaPorId(id);
            LocalDate fecha = reserva.getHorario().getFecha();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            textoFecha = fecha.format(formato);
        }
        Main.getInstance().getReservaModificarPanel().getIdField().setText(id);
        Main.getInstance().getReservaModificarPanel().getNombreField().setText(nombre);
        Main.getInstance().getReservaModificarPanel().getFechaField().setText(textoFecha);
        
        Main.getInstance().cambiarPantalla("ReservaModificar");
        
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

    }//GEN-LAST:event_eliminarActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        Main.getInstance().cambiarPantalla("ReservaRegistrar");
    }//GEN-LAST:event_registrarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        LocalDate fechaFiltro;
        int cuposFiltro = (int) cuposSpinner.getValue();
        int tarifaFiltro = (int) tarifaSpinner.getValue();
        Materias materiaFiltro = (Materias) materiaCombo.getSelectedItem();
        BloquesHorarios bloqueFiltro = (BloquesHorarios) bloqueCombo.getSelectedItem();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        try{
            FiltroCompuesto filtros = new FiltroCompuesto();
            
            if (!fechaField.getText().trim().equals( "/  /") && !fechaField.getText().trim().equals( "00/00/0000")){
               fechaFiltro = LocalDate.parse(fechaField.getText().trim(), formato);
            } else {fechaFiltro = LocalDate.now().minusDays(1);}
            
            
            
            filtros.agregarFiltro(new FiltroFecha(fechaFiltro));
            filtros.agregarFiltro(new FiltroTarifaMax(tarifaFiltro));
            filtros.agregarFiltro(new FiltroMateria(materiaFiltro));
            filtros.agregarFiltro(new FiltroCuposMax(cuposFiltro));
            filtros.agregarFiltro(new FiltroBloque(bloqueFiltro));
            
            List<Reserva> lista = sistema.getGestorReservas().getListaReservas();
            List<Reserva> listaFiltrada = sistema.getGestorReservas().filtrador(lista, filtros);
            modelo.setRowCount(0);
            
            for (Reserva reserva : listaFiltrada){
                String id = reserva.getId();
                String nombre = reserva.getTutorAsociado().getNombre();
                Materias materia = reserva.getMateria();
                int tarifa = reserva.getTarifa();
                int cupos = reserva.getCuposMax() - reserva.getListaEstudiantes().size();
                LocalDate fecha = reserva.getHorario().getFecha();
                BloquesHorarios bloque = reserva.getHorario().getBloqueHorario();
                String estado = reserva.getEstado().toString();
                Object[] list = {id,nombre,materia,tarifa,cupos,fecha,bloque,estado};
                modelo.addRow(list);
                
            }
            tabla.setModel(modelo);
            
        } catch (DateTimeParseException dateE) {
            JOptionPane.showMessageDialog(this,
                "Fecha inválida.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            fechaField.setText("00/00/0000");
                
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,
                    "Fecha ingresada incorrectamente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
           int fila = tabla.getSelectedRow();
           if (fila != -1) {
            String id = tabla.getValueAt(fila, 0).toString();
            Reserva reserva = sistema.buscarReservaPorId(id);
            
            Main.getInstance().cambiarPantalla("ReservaPerfil");
            Main.getInstance().getReservaPerfilPanel().setReserva(reserva);
            Main.getInstance().getReservaPerfilPanel().actualizar();
           } 
        }//GEN-LAST:event_verActionPerformed

    private void materiaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materiaComboActionPerformed

    private void fechaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEstudiantes;
    private javax.swing.JComboBox<BloquesHorarios> bloqueCombo;
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner cuposSpinner;
    private javax.swing.JButton eliminar;
    private javax.swing.JFormattedTextField fechaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<Materias> materiaCombo;
    private javax.swing.JButton modificar;
    private javax.swing.JButton registrar;
    private javax.swing.JTable tabla;
    private javax.swing.JSpinner tarifaSpinner;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables

}
