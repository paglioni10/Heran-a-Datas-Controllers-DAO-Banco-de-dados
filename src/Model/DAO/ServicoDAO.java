package Model.DAO;

import Model.Servico;
import java.util.ArrayList;

public class ServicoDAO {

    public Servico selectPorId(int id) {
        for (Servico registro : Banco.getServicos()) {
            if (registro.getId() == id) {
                return registro;
            }
        }
        return null;
    }

    public ArrayList<Servico> selectAll() {
        return Banco.getServicos();
    }

    public void insert(Servico servico) {
        Banco.getServicos().add(servico);
    }

    public void update(Servico servico) {
        ArrayList<Servico> servicos = Banco.getServicos();
        for (int i = 0; i < servicos.size(); i++) {
            if (servicos.get(i).getId() == servico.getId()) {
                servicos.set(i, servico);
                return;
            }
        }
    }

    public void delete(int id) {
        Servico servico = selectPorId(id);
        if (servico != null) {
            Banco.getServicos().remove(servico);
        }
    }
}
