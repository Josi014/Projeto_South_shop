/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.PersistenciaJPA;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Carrinho;
import model.ItemCarrinho;
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
        loadCarrinho();
        updateTotal();
    }

    public void loadProdutos() {
        DefaultListModel<Produto> model = new DefaultListModel<>();
        model.removeAllElements();

        for (Produto p : jpa.getProdutos()) {
            model.addElement(p);
        }

        lstProdutos.setModel(model);
    }

    public void loadCarrinho() {
        List<ItemCarrinho> itens = jpa.getItensDoCarrinhoPorId(carrinho.getId());

        DefaultListModel<ItemCarrinho> model = new DefaultListModel<>();

        carrinho.setItens(itens);
        for (ItemCarrinho item : itens) {
            model.addElement(item);
        }
        lstCarrinho.setModel(model);
    }

    private void updateTotal() {
        double total = 0.0;
        if (carrinho != null && carrinho.getItens() != null) {
            for (ItemCarrinho item : carrinho.getItens()) {
                total += item.getQuantidade() * item.getProduto().getPreco();
            }
        }
        txtTotal.setText(String.format("R$ %.2f", total));
    }

    @SuppressWarnings("unchecked")
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstProdutos = new javax.swing.JList<>();
        btnAdicionar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        btnRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCarrinho = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        btnRemover.setBackground(new java.awt.Color(102, 204, 255));
        btnRemover.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(255, 255, 255));
        btnRemover.setText("REMOVER");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstCarrinho);

        jLabel1.setText("CARRINHO");

        jLabel2.setText("LISTA DE COMPRAS");

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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(87, 87, 87)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 234,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(100, 100, 100))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel1)
                                .addGap(174, 174, 174)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163,
                                                Short.MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        ItemCarrinho itemSel = lstCarrinho.getSelectedValue();
        if (itemSel == null) {
            JOptionPane.showMessageDialog(this, "Selecione um item do carrinho para remover.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Deseja remover o item: " + itemSel.getProduto().getNome() + "?",
                "Confirmação", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (!jpa.conexaoAberta()) {
                    jpa = new PersistenciaJPA();
                }

                carrinho.getItens().remove(itemSel);

                itemSel = jpa.getEntityManager().merge(itemSel);
                jpa.remover(itemSel);

                loadCarrinho();
                updateTotal();

                JOptionPane.showMessageDialog(this, "Item removido com sucesso!");

            } catch (Exception ex) {
                if (jpa.getTransaction().isActive()) {
                    jpa.rollbackTransaction();
                }
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao remover item: " + ex.getMessage());
            }
        }
    }

    private void lstProdutosMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        Produto produtoSel = lstProdutos.getSelectedValue();
        if (produtoSel == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.");
            return;
        }

        int quantidade;
        try {
            quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade?"));
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida.");
            return;
        }

        try {
            carrinho = jpa.buscarCarrinhoPorUsuario(usuarioLogado);
            if (carrinho == null) {
                carrinho = new Carrinho();
                carrinho.setUsuario(usuarioLogado);
            }

            Produto produtoAtual = (Produto) jpa.find(Produto.class, produtoSel.getId());
            if (produtoAtual == null) {
                JOptionPane.showMessageDialog(this, "Produto não encontrado no banco de dados.");
                return;
            }

            if (quantidade > produtoAtual.getQuantidadeEstoque()) {
                JOptionPane.showMessageDialog(this, "Estoque insuficiente para o produto: " + produtoAtual.getNome());
                return;
            }

            carrinho.adicionarProduto(produtoSel, quantidade);

            jpa.beginTransaction();
            jpa.merge(carrinho);
            jpa.commitTransaction();
            
            loadCarrinho();
            updateTotal();
            JOptionPane.showMessageDialog(this, quantidade + "x " + produtoSel.getNome() + " adicionados ao carrinho!");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            if (jpa.getTransaction().isActive()) {
                jpa.rollbackTransaction();
            }
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar o item: " + ex.getMessage());
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
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu jmAcessar;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JList<ItemCarrinho> lstCarrinho;
    private javax.swing.JList<Produto> lstProdutos;
    private javax.swing.JMenuItem minCarrinho;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
