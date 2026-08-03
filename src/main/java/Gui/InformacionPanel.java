
package Gui;

public class InformacionPanel extends javax.swing.JPanel {

    public InformacionPanel() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloBienvenido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtextArea = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(502, 260));

        TituloBienvenido.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        TituloBienvenido.setText("Bienvenido!");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jtextArea.setEditable(false);
        jtextArea.setBackground(new java.awt.Color(255, 255, 255));
        jtextArea.setColumns(20);
        jtextArea.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jtextArea.setRows(5);
        jtextArea.setText("Sistema de gestión de reservas. Registre y gestione reservas\nentre estudiantes y tutores.\n\nCon esta herramienta usted podrá: \n\n*Registrar, modificar y visualizar información entre perfiles\n*Visualizar el calendario de reservas de los perfiles\n*Registrar y modificar reservas");
        jtextArea.setAutoscrolls(false);
        jtextArea.setBorder(null);
        jtextArea.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloBienvenido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtextArea;
    // End of variables declaration//GEN-END:variables
}
