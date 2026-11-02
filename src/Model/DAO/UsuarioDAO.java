package Model.DAO;

import Model.Usuario;
import java.util.ArrayList;

/**
 * Centraliza o acesso aos dados de usuario.
 * O LoginController nao precisa saber se os dados vem de um ArrayList
 * ou de um banco real, apenas chama os metodos desta classe.
 */
public class UsuarioDAO {

    public Usuario selectPorNomeESenha(Usuario usuario) {
        for (Usuario registro : Banco.getUsuarios()) {
            if (registro.getNome().equals(usuario.getNome())
                    && registro.getSenha().equals(usuario.getSenha())) {
                return registro;
            }
        }
        return null;
    }

    public Usuario selectPorId(int id) {
        for (Usuario registro : Banco.getUsuarios()) {
            if (registro.getId() == id) {
                return registro;
            }
        }
        return null;
    }

    public ArrayList<Usuario> selectAll() {
        return Banco.getUsuarios();
    }

    public void insert(Usuario usuario) {
        Banco.getUsuarios().add(usuario);
    }

    public void update(Usuario usuario) {
        ArrayList<Usuario> usuarios = Banco.getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    public void delete(int id) {
        Usuario usuario = selectPorId(id);
        if (usuario != null) {
            Banco.getUsuarios().remove(usuario);
        }
    }
}
