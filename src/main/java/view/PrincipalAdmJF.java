/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.PersistenciaJPA;

/**
 *
 * @author Josieli
 */
public class PrincipalAdmJF extends javax.swing.JFrame {

    PersistenciaJPA jpa;

    public PrincipalAdmJF() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        minProduto = new javax.swing.JMenuItem();
        minUsuario = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jMenu1.setText("Cadastrar");

        minProduto.setText("Produto");
        minProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(minProduto);

        minUsuario.setText("Usuário");
        minUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(minUsuario);

        jMenuBar1.add(jMenu1);

        jmAjuda.setText("Ajuda");
        jMenuBar1.add(jmAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minProdutoActionPerformed
        ProdutosJF telaCadastro = new ProdutosJF();
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_minProdutoActionPerformed

    private void minUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minUsuarioActionPerformed
        UsuariosJF telaUsuarios = new UsuariosJF();
        telaUsuarios.setVisible(true);
    }//GEN-LAST:event_minUsuarioActionPerformed

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
                new PrincipalAdmJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenuItem minProduto;
    private javax.swing.JMenuItem minUsuario;
    // End of variables declaration//GEN-END:variables
}
