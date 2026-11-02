package View;

import Controller.MenuPrincipalController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame {

    private final MenuPrincipalController controller;

    private JLabel labelTitulo;
    private JButton botaoAgenda;
    private JButton botaoSair;

    public MenuPrincipal() {
        initComponents();
        this.controller = new MenuPrincipalController(this);
    }

    private void initComponents() {
        setTitle("Barbearia - Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 240);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);

        labelTitulo = new JLabel("Menu Principal");
        labelTitulo.setFont(labelTitulo.getFont().deriveFont(18f));
        labelTitulo.setBounds(130, 20, 200, 30);
        painel.add(labelTitulo);

        botaoAgenda = new JButton("Agenda");
        botaoAgenda.setBounds(110, 80, 190, 35);
        painel.add(botaoAgenda);

        botaoSair = new JButton("Sair");
        botaoSair.setBounds(110, 130, 190, 35);
        painel.add(botaoSair);

        getContentPane().add(painel);

        botaoAgenda.addActionListener(evento -> botaoAgendaActionPerformed());
        botaoSair.addActionListener(evento -> botaoSairActionPerformed());
    }

    private void botaoAgendaActionPerformed() {
        controller.navegarParaAgenda();
    }

    private void botaoSairActionPerformed() {
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja encerrar o sistema?", "Sair", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}
