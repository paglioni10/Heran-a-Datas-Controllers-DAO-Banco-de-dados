package Model.DAO;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;
import java.util.ArrayList;

/**
 * Banco de dados simulado com ArrayList.
 * Enquanto o projeto nao estiver ligado a um banco real, as listas abaixo
 * fazem o papel das tabelas de usuarios, clientes, servicos e agendamentos.
 */
public class Banco {

    private static final ArrayList<Usuario> USUARIOS = new ArrayList<>();
    private static final ArrayList<Cliente> CLIENTES = new ArrayList<>();
    private static final ArrayList<Servico> SERVICOS = new ArrayList<>();
    private static final ArrayList<Agendamento> AGENDAMENTOS = new ArrayList<>();

    static {
        USUARIOS.add(new Usuario(1, "admin", 'M', "10/05/1990 00:00", "48999110011", "admin@barbearia.com", "4512345", "123", 1));
        USUARIOS.add(new Usuario(2, "barbeiro", 'M', "22/08/1995 00:00", "48999220022", "barbeiro@barbearia.com", "4512346", "123", 2));
        USUARIOS.add(new Usuario(3, "recepcao", 'F', "15/02/1999 00:00", "48999330033", "recepcao@barbearia.com", "4512347", "123", 3));

        CLIENTES.add(new Cliente(1, "Jorge", 'M', "05/03/1988 00:00", "48988110011", "jorge@email.com", "3012345", "Rua Tesla 95", "88130100"));
        CLIENTES.add(new Cliente(2, "Marcos", 'M', "18/07/1992 00:00", "48988220022", "marcos@email.com", "3012346", "Avenida Central 220", "88130200"));
        CLIENTES.add(new Cliente(3, "Rodrigo", 'M', "29/11/2000 00:00", "48988330033", "rodrigo@email.com", "3012347", "Servidao das Palmeiras 40", "88130300"));

        SERVICOS.add(new Servico(1, "Barba", 30));
        SERVICOS.add(new Servico(2, "Corte de cabelo", 45));
        SERVICOS.add(new Servico(3, "Corte e barba", 65));

        AGENDAMENTOS.add(new Agendamento(1, CLIENTES.get(0), SERVICOS.get(0), 30, "03/11/2026 09:00", "Cliente pediu barba desenhada"));
        AGENDAMENTOS.add(new Agendamento(2, CLIENTES.get(1), SERVICOS.get(1), 45, "03/11/2026 10:30", "Primeira vez na barbearia"));
        AGENDAMENTOS.add(new Agendamento(3, CLIENTES.get(2), SERVICOS.get(2), 65, "04/11/2026 14:00", "Confirmar por telefone"));
    }

    public static ArrayList<Usuario> getUsuarios() {
        return USUARIOS;
    }

    public static ArrayList<Cliente> getClientes() {
        return CLIENTES;
    }

    public static ArrayList<Servico> getServicos() {
        return SERVICOS;
    }

    public static ArrayList<Agendamento> getAgendamentos() {
        return AGENDAMENTOS;
    }
}
