/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.PersistenciaJPA;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Carrinho;
import model.Produto;
import model.Usuario;

/**
 *
 * @author Josieli
 */
public class PrincipalClienteJF extends javax.swing.JFrame {

    PersistenciaJPA jpa;
    private Carrinho carrinho;
    private Usuario usuarioLogado;

    public PrincipalClienteJF(Usuario usuario) {
        initComponents();
        jpa = new PersistenciaJPA();
        this.usuarioLogado = usuario;
        carrinho = jpa.buscarCarrinhoPorUsuario(usuarioLogado);
        if (carrinho == null) {
            carrinho = new Carrinho();
            carrinho.setUsuario(usuarioLogado);

            try {
                jpa.persist(carrinho);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao criar carrinho: " + ex.getMessage());
            }
        }
        loadProdutos();
    }

    public void loadProdutos() {
        DefaultListModel model = new DefaultListModel();
        model.removeAllElements();

        for (Produto p : jpa.getProdutos()) {
            model.addElement(p);
        }

        lstProdutos.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstProdutos = new javax.swing.JList<>();
        btnAdicionar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAcessar = new javax.swing.JMenu();
        minCarrinho = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstProdutos);

        btnAdicionar.setBackground(new java.awt.Color(102, 204, 255));
        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setText("ADICIONAR AO CARRINHO");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jmAcessar.setText("Acessar");

        minCarrinho.setText("Carrinho");
        jmAcessar.add(minCarrinho);

        jMenuBar1.add(jmAcessar);

        jmAjuda.setText("Ajuda");
        jMenuBar1.add(jmAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(83, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 234,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstProdutosMouseClicked(java.awt.event.MouseEvent evt) {
    }
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        Produto produtoSel = lstProdutos.getSelectedValue();
        if (produtoSel == null) {
            return;
        }

        int quantidade;
        try {
            quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade?"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida.");
            return;
        }

        carrinho.adicionarProduto(produtoSel, quantidade);

        try {
            jpa.persist(carrinho);
            JOptionPane.showMessageDialog(this,
                    quantidade + "x " + produtoSel.getNome() + " adicionados ao carrinho!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar o item: " + ex.getMessage());
        }
    }

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

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmAcessar;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JList<Produto> lstProdutos;
    private javax.swing.JMenuItem minCarrinho;
    // End of variables declaration//GEN-END:variables
}
