
import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;
import View.Login;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String nome = "Rodrigo";
        System.out.println(nome);

        Servico servico = new Servico(1, "barba", 30);
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());

        Cliente cliente = new Cliente(1, "Jorge", "Rua tesla 95", "95445866");
        System.out.println(cliente.getNome()); //neste caso getNome vem herdado de Pessoa

        Usuario usuario = new Usuario(1, "barbeiro", "senha");
        System.out.println(usuario);

        //Pessoa pessoa = new Pessoa (1, "Joao"); //ERRO Pessoa da classe abstract nao pode ser instanciado
        //System.out.println(usuario.getNome());

        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "25/03/2024 11:20");
        //Coloque um break point nesta linha para verificar os valores dos objetos
        System.out.println(agendamento.getCliente().getNome());//Retorna o Cliente e o nome

        // Mostra que a String do construtor virou um objeto Date
        System.out.println("Data do agendamento (Date): " + agendamento.getData());
        System.out.println("Data do agendamento formatada: " + formato.format(agendamento.getData()));

        // Cliente com todos os parametros, para testar a conversao da data de nascimento em Pessoa
        Cliente clienteCompleto = new Cliente(2, "Marcos", 'M', "18/07/1992 00:00", "48988220022",
                "marcos@email.com", "3012346", "Avenida Central 220", "88130200");
        System.out.println("Nascimento de " + clienteCompleto.getNome() + ": "
                + formato.format(clienteCompleto.getDataNascimento()));

        // Abre a tela de login para continuar os testes pela interface
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}
