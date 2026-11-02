package View;

import Model.Agendamento;
import Model.DAO.AgendamentoDAO;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Agenda extends JFrame {

    private JLabel labelTitulo;
    private JTable tabelaAgendamentos;
    private JScrollPane painelTabela;

    public Agenda() {
        initComponents();
        carregarAgendamentos();
    }

    private void initComponents() {
        setTitle("Barbearia - Agenda");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(640, 320);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        labelTitulo = new JLabel("Agendamentos");
        labelTitulo.setFont(labelTitulo.getFont().deriveFont(16f));
        labelTitulo.setBounds(20, 10, 200, 25);
        getContentPane().add(labelTitulo);

        tabelaAgendamentos = new JTable(new DefaultTableModel(
                new Object[]{"Codigo", "Data", "Cliente", "Servico", "Valor"}, 0));
        painelTabela = new JScrollPane(tabelaAgendamentos);
        painelTabela.setBounds(20, 45, 590, 215);
        getContentPane().add(painelTabela);
    }

    private void carregarAgendamentos() {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        DefaultTableModel modelo = (DefaultTableModel) tabelaAgendamentos.getModel();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        modelo.setRowCount(0);
        for (Agendamento agendamento : agendamentoDAO.selectAll()) {
            modelo.addRow(new Object[]{
                agendamento.getId(),
                formato.format(agendamento.getData()),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                String.format("R$ %.2f", agendamento.getValor())
            });
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Agenda().setVisible(true));
    }
}
