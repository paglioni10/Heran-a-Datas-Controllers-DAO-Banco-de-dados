package View;

import Controller.LoginController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    private final LoginController controller;

    private JLabel labelTitulo;
    private JLabel labelLogin;
    private JLabel labelSenha;
    private JTextField campologin;
    private JPasswordField camposenha;
    private JButton botaoEntrar;
    private JButton botaoLimpar;

    public Login() {
        initComponents();
        this.controller = new LoginController(this);
    }

    private void initComponents() {
        setTitle("Barbearia - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 260);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);

        labelTitulo = new JLabel("Barbearia");
        labelTitulo.setFont(labelTitulo.getFont().deriveFont(20f));
        labelTitulo.setBounds(130, 15, 150, 30);
        painel.add(labelTitulo);

        labelLogin = new JLabel("Usuario:");
        labelLogin.setBounds(40, 70, 70, 25);
        painel.add(labelLogin);

        campologin = new JTextField();
        campologin.setBounds(120, 70, 200, 25);
        painel.add(campologin);

        labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(40, 110, 70, 25);
        painel.add(labelSenha);

        camposenha = new JPasswordField();
        camposenha.setBounds(120, 110, 200, 25);
        painel.add(camposenha);

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.setBounds(120, 160, 95, 30);
        painel.add(botaoEntrar);

        botaoLimpar = new JButton("Limpar");
        botaoLimpar.setBounds(225, 160, 95, 30);
        painel.add(botaoLimpar);

        getContentPane().add(painel);

        botaoEntrar.addActionListener(evento -> botaoEntrarActionPerformed());
        botaoLimpar.addActionListener(evento -> botaoLimparActionPerformed());

        // Enter dentro dos campos tambem faz o login
        getRootPane().setDefaultButton(botaoEntrar);
    }

    private void botaoEntrarActionPerformed() {
        try {
            controller.entrarNoSistema();
        } catch (ParseException erro) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "Erro ao converter data durante o login", erro);
            exibeMensagem("Nao foi possivel validar o login");
        }
    }

    private void botaoLimparActionPerformed() {
        campologin.setText("");
        camposenha.setText("");
    }

    public JTextField getCampologin() {
        return campologin;
    }

    public JTextField getCamposenha() {
        return camposenha;
    }

    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}
