/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import model.Produto;
import model.Usuario;
import model.Categoria;
import model.Tipo;
import control.PersistenciaJPA;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestePersistenciaProdutoUsuario {

    PersistenciaJPA jpa;

    public TestePersistenciaProdutoUsuario() {
    }

    @Before
    public void setUp() {
        jpa = new PersistenciaJPA();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void cadastroProdutoEUsuario() {
        try {
            Produto produto = new Produto();
            produto.setNome("Notebook Dell Inspiron");
            produto.setDescricao("Notebook com Intel i7, 16GB RAM, SSD 512GB");
            produto.setPreco(4299.99);
            produto.setQuantidadeEstoque(10);
            produto.setCategoria(Categoria.ELETRONICO); 

            jpa.persist(produto);

            Usuario usuario = new Usuario();
            usuario.setNome("Maria da Silva");
            usuario.setCpf("123.456.789-00");
            usuario.setEndereco("Rua das Flores, 123");
            usuario.setTelefone("(11) 91234-5678");
            usuario.setEmail("maria@example.com");
            usuario.setSenha("senhaSegura123");
            usuario.setTipo(Tipo.CLIENTE); 

            jpa.persist(usuario);

        } catch (Exception ex) {
            System.err.println("Erro ao persistir dados: " + ex);
        }

        ArrayList<Produto> listaProdutos = (ArrayList<Produto>) jpa.getProdutos();
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : listaProdutos) {
                System.out.println(p.getNome() + " - R$" + p.getPreco() +
                        " - Estoque: " + p.getQuantidadeEstoque() +
                        " - Categoria: " + p.getCategoria());
            }
        }

        ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) jpa.getUsuarios();
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : listaUsuarios) {
                System.out.println(u.getNome() + " - Email: " + u.getEmail() +
                        " - Tipo: " + u.getTipo());
            }
        }
    }
}
