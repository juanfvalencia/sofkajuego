package Views;

import Controllers.CategoriaController;
import Controllers.PreguntaController;
import Models.Categoria;
import Models.Pregunta;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;

public class PreguntasVita extends javax.swing.JInternalFrame {

    private PreguntaController controller;
    private CategoriaController categoriaCtrl;

    public PreguntasVita() {
        initComponents();
        this.controller = new PreguntaController();
        this.categoriaCtrl = new CategoriaController();
        txtId.setVisible(false);
        CargarTabla();
        LlenarOpciones();
        ocultarForm(true);
        
    }
    
    private void LlenarOpciones(){
        DefaultComboBoxModel dataModel = new DefaultComboBoxModel(categoriaCtrl.ListarOpciones());
        cbCategoria.setModel(dataModel);
    }

    private void CargarTabla() {
        gridPreguntas.setModel(this.controller.ListarTodo());
    }

    private void ShowForm() {
        int id = Integer.parseInt(txtId.getText());
        Pregunta dto = this.controller.BuscarPorId(id);
        txtEnunciado.setText(dto.getEnunciado());
        cbCategoria.getModel().setSelectedItem(dto.getCategoria());
        txtOpcionCorrecta.setText(String.valueOf(dto.getOpcionCorrecta()));
        txtOpcion1.setText(dto.getOpciones()[0]);
        txtOpcion2.setText(dto.getOpciones()[1]);
        txtOpcion3.setText(dto.getOpciones()[2]);
        txtOpcion4.setText(dto.getOpciones()[3]);
    }

    private void save() {
        Pregunta dto = new Pregunta();
        dto.setEnunciado(txtEnunciado.getText());
        Categoria cta = (Categoria)cbCategoria.getSelectedItem();
        dto.setIdCategoria(cta.getId());
        dto.setOpcionCorrecta(Integer.parseInt(txtOpcionCorrecta.getText()));
        dto.setOpciones(new String[]{
            txtOpcion1.getText(),
            txtOpcion2.getText(),
            txtOpcion3.getText(),
            txtOpcion4.getText(),});
        if (!txtId.getText().equals("")) {
            dto.setId(Integer.parseInt(txtId.getText()));
        }
        this.controller.Save(dto);
        this.ocultarForm(true);
        this.CargarTabla();
    }

    private void ELiminar() {
        int id = Integer.parseInt(txtId.getText());
        this.controller.Eliminar(id);
        this.ocultarForm(true);
        this.CargarTabla();
    }

    private void LimpiarCampos() {
        txtId.setText("");
        txtEnunciado.setText("");
        txtOpcionCorrecta.setText("");
        txtOpcion1.setText("");
        txtOpcion2.setText("");
        txtOpcion3.setText("");
        txtOpcion4.setText("");
    }

    private void ocultarForm(boolean show) {
        this.LimpiarCampos();
        this.Formulario.setVisible(!show);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Formulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEnunciado = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtOpcionCorrecta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOpcion1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtOpcion2 = new javax.swing.JTextField();
        txtOpcion3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOpcion4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridPreguntas = new javax.swing.JTable();

        setClosable(true);
        setTitle("Administración de Preguntas");
        getContentPane().setLayout(new java.awt.GridLayout(2, 0));

        Formulario.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setText("Seleccionar Categoria:");

        jLabel2.setText("Enunciado de la pregunta:");

        txtEnunciado.setColumns(20);
        txtEnunciado.setRows(5);
        jScrollPane2.setViewportView(txtEnunciado);

        jLabel3.setText("Opcion Correcta (numero del 1 al 4)");

        jLabel4.setText("Opcion de Respuesta A");

        jLabel5.setText("Opcion de Respuesta B");

        jLabel6.setText("Opcion de Respuesta C");

        jLabel7.setText("Opcion de Respuesta D");

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormularioLayout = new javax.swing.GroupLayout(Formulario);
        Formulario.setLayout(FormularioLayout);
        FormularioLayout.setHorizontalGroup(
            FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormularioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2))
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, 246, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOpcionCorrecta, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtOpcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(FormularioLayout.createSequentialGroup()
                            .addComponent(jButton5)
                            .addGap(56, 56, 56)
                            .addComponent(jButton4)
                            .addGap(36, 36, 36)
                            .addComponent(jButton3))
                        .addGroup(FormularioLayout.createSequentialGroup()
                            .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(txtOpcion3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(txtOpcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        FormularioLayout.setVerticalGroup(
            FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormularioLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOpcionCorrecta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOpcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOpcion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOpcion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jButton1.setText("Recargar Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar Pregunta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Formulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Formulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        gridPreguntas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CATEGORIA", "ENUNCIADO", "OPCION CORRECTA", "OPCION 1", "OPCION 2", "OPCION 3", "OPCION 4"
            }
        ));
        gridPreguntas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridPreguntasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gridPreguntas);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.ELiminar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.ocultarForm(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.save();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.ocultarForm(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.CargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void gridPreguntasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridPreguntasMouseClicked
        ocultarForm(false);
        int filaSeleccionada = gridPreguntas.getSelectedRow();
        txtId.setText(gridPreguntas.getModel().getValueAt(filaSeleccionada, 0).toString());
        this.ShowForm();
    }//GEN-LAST:event_gridPreguntasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Formulario;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JTable gridPreguntas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtEnunciado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtOpcion1;
    private javax.swing.JTextField txtOpcion2;
    private javax.swing.JTextField txtOpcion3;
    private javax.swing.JTextField txtOpcion4;
    private javax.swing.JTextField txtOpcionCorrecta;
    // End of variables declaration//GEN-END:variables
}
