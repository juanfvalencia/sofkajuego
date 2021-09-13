package Views;

import Controllers.JuegoController;
import Controllers.UsuarioController;
import Models.Categoria;
import Models.Pregunta;
import Models.Usuario;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Juego extends javax.swing.JInternalFrame {

    private JuegoController controller;
    private UsuarioController userCtrl;

    public Juego() {
        initComponents();
        this.userCtrl = new UsuarioController();
        LllenarOpciones();
        LimpiarTodo();
    }

    private void LimpiarTodo() {
        btnOpcion1.setBackground(Color.gray);
        btnOpcion2.setBackground(Color.gray);
        btnOpcion3.setBackground(Color.gray);
        btnOpcion4.setBackground(Color.gray);
        this.btnOpcion1.setText("");
        this.btnOpcion2.setText("");
        this.btnOpcion3.setText("");
        this.btnOpcion4.setText("");
        lblPregunta.setText("");
        lblUsuario.setText("");
        lblRondaActual.setText("");
        lblPremio.setText("");
    }

    private void IniciarJuego() {
        Usuario user = (Usuario) cbUsuario.getSelectedItem();
        Models.Juego juego = new Models.Juego();
        juego.setIdUsuario(user.getId());
        this.controller = new JuegoController();
        this.controller.Empezar(juego);

        this.ocultarSeleccionUsuario(true);
        this.lblUsuario.setText(user.getNombre());
        this.setPregunta();

    }

    private void ocultarSeleccionUsuario(boolean show) {
        this.SeleccionUserForm.setVisible(!show);
    }

    private void setPregunta() {
        Pregunta pregunta = this.controller.preguntaActual;
        this.lblPregunta.setText(pregunta.getEnunciado());
        this.btnOpcion1.setText("A.  " + pregunta.getOpciones()[0]);
        this.btnOpcion2.setText("B.  " + pregunta.getOpciones()[1]);
        this.btnOpcion3.setText("C.  " + pregunta.getOpciones()[2]);
        this.btnOpcion4.setText("D.  " + pregunta.getOpciones()[3]);

    }

    private void LllenarOpciones() {
        DefaultComboBoxModel dataModel = new DefaultComboBoxModel(userCtrl.ListarOpciones());
        cbUsuario.setModel(dataModel);
    }

    private boolean ValidarRespuesta(int respuesta) {
        boolean estatus = this.controller.ValidarRespuesta(respuesta);
        ActulizarStatus();
        return estatus;
    }

    private void ActulizarStatus() {
        lblPremio.setText("Premio Acumulado: $" + this.controller.premioAcumulado);        
    }

    private void next() {
        btnOpcion1.setBackground(Color.gray);
        btnOpcion2.setBackground(Color.gray);
        btnOpcion3.setBackground(Color.gray);
        btnOpcion4.setBackground(Color.gray);

        if (this.controller.rondaActual == 5) {
            mostrarReSumen("GANASTE");
        }
        this.controller.EmpezarRonda();
        lblRondaActual.setText(this.controller.rondaActual + " / 5");
        this.setPregunta();
    }

    private void mostrarReSumen(String status) {
        String mensage = status;
        mensage += "\n Rondas Realizadas: " + this.controller.rondaActual + " / 5";
        mensage += "\n Premio Ganado: $" + +this.controller.premioAcumulado;
        int input = JOptionPane.showConfirmDialog(null, mensage, "Resumen del Juego", JOptionPane.DEFAULT_OPTION);
        if (input == 0) {
            this.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        SeleccionUserForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblPremio = new javax.swing.JLabel();
        lblRondaActual = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPregunta = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOpcion1 = new javax.swing.JButton();
        btnOpcion3 = new javax.swing.JButton();
        btnOpcion2 = new javax.swing.JButton();
        btnOpcion4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new java.awt.GridLayout(3, 0));

        SeleccionUserForm.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setText("Seleccione el jugador:");

        jButton1.setText("INICIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeleccionUserFormLayout = new javax.swing.GroupLayout(SeleccionUserForm);
        SeleccionUserForm.setLayout(SeleccionUserFormLayout);
        SeleccionUserFormLayout.setHorizontalGroup(
            SeleccionUserFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionUserFormLayout.createSequentialGroup()
                .addGroup(SeleccionUserFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeleccionUserFormLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(SeleccionUserFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SeleccionUserFormLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        SeleccionUserFormLayout.setVerticalGroup(
            SeleccionUserFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionUserFormLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblUsuario.setFont(new java.awt.Font("Engravers MT", 3, 18)); // NOI18N

        lblPremio.setFont(new java.awt.Font("Engravers MT", 3, 14)); // NOI18N

        lblRondaActual.setFont(new java.awt.Font("Engravers MT", 3, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(SeleccionUserForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPremio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRondaActual)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPremio)
                    .addComponent(lblRondaActual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(SeleccionUserForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        lblPregunta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblPregunta)
                .addContainerGap(566, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblPregunta)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);

        btnOpcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcion1ActionPerformed(evt);
            }
        });

        btnOpcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcion3ActionPerformed(evt);
            }
        });

        btnOpcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcion2ActionPerformed(evt);
            }
        });

        btnOpcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcion4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Finalizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setText("Continuar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOpcion2)
                    .addComponent(btnOpcion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpcion3)
                    .addComponent(btnOpcion4))
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpcion1)
                    .addComponent(btnOpcion3))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpcion2)
                    .addComponent(btnOpcion4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.IniciarJuego();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnOpcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcion1ActionPerformed
        if (ValidarRespuesta(1)) {
            btnOpcion1.setBackground(Color.green);
        } else {
            btnOpcion1.setBackground(Color.red);
            mostrarReSumen("PERDISTE");
        }
    }//GEN-LAST:event_btnOpcion1ActionPerformed

    private void btnOpcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcion3ActionPerformed
        if (ValidarRespuesta(3)) {
            btnOpcion3.setBackground(Color.green);
        } else {
            btnOpcion3.setBackground(Color.red);
            mostrarReSumen("PERDISTE");
        }
    }//GEN-LAST:event_btnOpcion3ActionPerformed

    private void btnOpcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcion2ActionPerformed
        if (ValidarRespuesta(2)) {
            btnOpcion2.setBackground(Color.green);
        } else {
            btnOpcion2.setBackground(Color.red);
            mostrarReSumen("PERDISTE");
        }
    }//GEN-LAST:event_btnOpcion2ActionPerformed

    private void btnOpcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcion4ActionPerformed
        if (ValidarRespuesta(4)) {
            btnOpcion4.setBackground(Color.green);
        } else {
            btnOpcion4.setBackground(Color.red);
            mostrarReSumen("PERDISTE");
        }
    }//GEN-LAST:event_btnOpcion4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        next();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //YES=0, NO=1
        int input = JOptionPane.showConfirmDialog(null, "Realmente desea salir del juego?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) {
            mostrarReSumen("TE RETIRATSE");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SeleccionUserForm;
    private javax.swing.JButton btnOpcion1;
    private javax.swing.JButton btnOpcion2;
    private javax.swing.JButton btnOpcion3;
    private javax.swing.JButton btnOpcion4;
    private javax.swing.JComboBox<String> cbUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblPremio;
    private javax.swing.JLabel lblRondaActual;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
