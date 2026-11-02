package Model.DAO;

import Model.Cliente;
import java.util.ArrayList;

public class ClienteDAO {

    public Cliente selectPorId(int id) {
        for (Cliente registro : Banco.getClientes()) {
            if (registro.getId() == id) {
                return registro;
            }
        }
        return null;
    }

    public ArrayList<Cliente> selectPorNome(String nome) {
        ArrayList<Cliente> encontrados = new ArrayList<>();
        for (Cliente registro : Banco.getClientes()) {
            if (registro.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(registro);
            }
        }
        return encontrados;
    }

    public ArrayList<Cliente> selectAll() {
        return Banco.getClientes();
    }

    public void insert(Cliente cliente) {
        Banco.getClientes().add(cliente);
    }

    public void update(Cliente cliente) {
        ArrayList<Cliente> clientes = Banco.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                return;
            }
        }
    }

    public void delete(int id) {
        Cliente cliente = selectPorId(id);
        if (cliente != null) {
            Banco.getClientes().remove(cliente);
        }
    }
}
