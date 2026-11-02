/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import View.Login;
import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import View.MenuPrincipal;
import java.text.ParseException;

public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void entrarNoSistema() throws ParseException {
        //pegar um usuario da view
        Usuario usuario = helper.obterModelo();

        //pesquisar usuario no banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);

        if (usuarioAutenticado != null) {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else {
            view.exibeMensagem("Usuario ou senha invalidos");
        }
    }

    public void fizTarefa() {
        System.out.println("Tarefa executada pelo LoginController");
        view.exibeMensagem("Tarefa executada pelo LoginController");
    }
}
