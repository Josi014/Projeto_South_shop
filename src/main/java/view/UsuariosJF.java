/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.PersistenciaJPA;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Tipo;
import model.Usuario;

/**
 *
 * @author Josieli
 */
public class UsuariosJF extends javax.swing.JFrame {

    PersistenciaJPA jpa;
    Usuario usuarioLogado;

    public UsuariosJF(Usuario usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        System.out.println("Usuário logado ID: " + (usuarioLogado != null ? usuarioLogado.getId() : "null"));
        jpa = new PersistenciaJPA();
        loadUsuarios(usuarioLogado);
    }

    public UsuariosJF() {
        this(null);
    }

    public void loadUsuarios() {
        loadUsuarios(this.usuarioLogado);
    }

    public void loadUsuarios(Usuario usuarioLogado) {
        DefaultListModel<Usuario> model = new DefaultListModel<>();
        model.removeAllElements();

        for (Usuario u : jpa.getUsuarios()) {
            if (usuarioLogado == null || u.getId() != usuarioLogado.getId()) {
                model.addElement(u);
            }
        }

        lstUsuarios.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstUsuarios.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lstUsuariosAncestorAdded(evt);
            }

            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }

            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(lstUsuarios);
        lstUsuarios.getAccessibleContext().setAccessibleName("");

        btnEditar.setBackground(new java.awt.Color(102, 204, 255));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(102, 204, 255));
        btnRemover.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(255, 255, 255));
        btnRemover.setText("REMOVER");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(102, 204, 255));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("USUÁRIOS CADASTRADOS");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(btnRemover)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60,
                                                        Short.MAX_VALUE)
                                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)
                                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(103, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(100, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        Usuario usuarioSel = lstUsuarios.getSelectedValue();
        if (usuarioSel == null) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para editar");
        } else {

            CadastroUsuarioJD telaCadastro = new CadastroUsuarioJD(this, true);
            telaCadastro.setUsuario(usuarioSel);
            telaCadastro.setVisible(true);
            telaCadastro.ocultarCampoSenha();
            telaCadastro.setVisible(true);

            if (!jpa.conexaoAberta()) {
                jpa = new PersistenciaJPA();
            }
            try {
                jpa.persist(usuarioSel);
            } catch (Exception ex) {
                System.err.println("ERRO AO EDITAR USUÁRIO: " + ex);
            }
            loadUsuarios();
        }

    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRemoverActionPerformed
        Usuario usuarioSel = lstUsuarios.getSelectedValue();
        if (usuarioSel == null) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para remover");
        } else {
            int opDel = JOptionPane.showConfirmDialog(rootPane,
                    "Tem certeza que deseja remover o usuário: " + usuarioSel + "?");
            if (opDel == JOptionPane.YES_OPTION) {
                if (!jpa.conexaoAberta()) {
                    jpa = new PersistenciaJPA();
                }
                try {
                    jpa.remover(usuarioSel);
                    JOptionPane.showMessageDialog(null,
                            "Usuário removida com sucesso");
                } catch (Exception ex) {
                    System.err.println("ERRO AO REMOVER USUÁRIO: " + ex);
                }
                loadUsuarios();
            }
        }
    }// GEN-LAST:event_btnRemoverActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNovoActionPerformed
        String[] opcoes = {"Cliente", "Admin"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de usuário:",
                "Tipo dePessoa",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        if (escolha == JOptionPane.CLOSED_OPTION) {
            return;
        }

        CadastroUsuarioJD tela = new CadastroUsuarioJD(this, true);

        if (escolha == 0) {
            tela.setTipoUsuario(Tipo.CLIENTE);
        }
        if (escolha == 1) {
            tela.setTipoUsuario(Tipo.ADM);
        }

        tela.setVisible(true);

        Usuario novoUsuario = tela.getUsuario();
        if (novoUsuario != null) {
            try {
                if (jpa == null) {
                    jpa = new PersistenciaJPA();
                }
                jpa.persist(novoUsuario);
            } catch (Exception ex) {
                System.err.println("ERRO AO PERSISTIR NOVO USUÁRIO: " + ex);
            }
        }
        loadUsuarios();
    }// GEN-LAST:event_btnNovoActionPerformed

    private void lstUsuariosAncestorAdded(javax.swing.event.AncestorEvent evt) {// GEN-FIRST:event_lstUsuariosAncestorAdded

    }// GEN-LAST:event_lstUsuariosAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuariosJF.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuariosJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Usuario> lstUsuarios;
    // End of variables declaration//GEN-END:variables
}
