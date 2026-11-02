package Model.DAO;

import Model.Agendamento;
import java.util.ArrayList;

public class AgendamentoDAO {

    public Agendamento selectPorId(int id) {
        for (Agendamento registro : Banco.getAgendamentos()) {
            if (registro.getId() == id) {
                return registro;
            }
        }
        return null;
    }

    public ArrayList<Agendamento> selectPorCliente(int idCliente) {
        ArrayList<Agendamento> encontrados = new ArrayList<>();
        for (Agendamento registro : Banco.getAgendamentos()) {
            if (registro.getCliente().getId() == idCliente) {
                encontrados.add(registro);
            }
        }
        return encontrados;
    }

    public ArrayList<Agendamento> selectAll() {
        return Banco.getAgendamentos();
    }

    public void insert(Agendamento agendamento) {
        Banco.getAgendamentos().add(agendamento);
    }

    public void update(Agendamento agendamento) {
        ArrayList<Agendamento> agendamentos = Banco.getAgendamentos();
        for (int i = 0; i < agendamentos.size(); i++) {
            if (agendamentos.get(i).getId() == agendamento.getId()) {
                agendamentos.set(i, agendamento);
                return;
            }
        }
    }

    public void delete(int id) {
        Agendamento agendamento = selectPorId(id);
        if (agendamento != null) {
            Banco.getAgendamentos().remove(agendamento);
        }
    }
}
