import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioEstudante extends JFrame {
    private DadosEstudantes estudante;
    private JTextField nomeField, idadeField, emailField, enderecoField, cepField, telefoneField, usuarioField, senhaField, observacoesField;
    private JCheckBox ativoCheckBox;
    private JComboBox<String> cursoBox;

    public FormularioEstudante() {
        estudante = new DadosEstudantes();

        nomeField = new JTextField(20);
        idadeField = new JTextField(5);
        emailField = new JTextField(20);
        enderecoField = new JTextField(20);
        cepField = new JTextField(8);
        telefoneField = new JTextField(10);
        usuarioField = new JTextField(10);
        senhaField = new JTextField(10);
        observacoesField = new JTextField(20);
        ativoCheckBox = new JCheckBox("Ativo");

        String[] cursos = { "Curso 1", "Curso 2", "Curso 3", "Curso 4" };
        cursoBox = new JComboBox<>(cursos);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarDadosEstudante();
            }
        });

        setLayout(new GridLayout(12, 2));
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Idade:"));
        add(idadeField);
        add(new JLabel("E-mail:"));
        add(emailField);
        add(new JLabel("Endereço:"));
        add(enderecoField);
        add(new JLabel("CEP:"));
        add(cepField);
        add(new JLabel("Telefone:"));
        add(telefoneField);
        add(new JLabel("Usuário:"));
        add(usuarioField);
        add(new JLabel("Senha:"));
        add(senhaField);
        add(new JLabel("Curso:"));
        add(cursoBox);
        add(new JLabel("Observações:"));
        add(observacoesField);
        add(new JLabel("Ativo:"));
        add(ativoCheckBox);
        add(new JLabel());
        add(salvarButton);

        setTitle("Formulário de Estudante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void salvarDadosEstudante() {
        
        estudante.setNome(nomeField.getText());
        estudante.setIdade(Integer.parseInt(idadeField.getText()));
        estudante.setEmail(emailField.getText());
        estudante.setEndereco(enderecoField.getText());
        estudante.setCep(Integer.parseInt(cepField.getText()));
        estudante.setTelefone(Integer.parseInt(telefoneField.getText()));
        estudante.setUsuario(usuarioField.getText());
        estudante.setSenha(senhaField.getText());
        estudante.setCurso((String) cursoBox.getSelectedItem());
        estudante.setObservacoes(observacoesField.getText());
        estudante.setAtivo(ativoCheckBox.isSelected());

        System.out.println(estudante);

        limparCampos();
    }

    private void limparCampos() {
        nomeField.setText("");
        idadeField.setText("");
        emailField.setText("");
        enderecoField.setText("");
        cepField.setText("");
        telefoneField.setText("");
        usuarioField.setText("");
        senhaField.setText("");
        cursoBox.setSelectedIndex(0);
        observacoesField.setText("");
        ativoCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioEstudante();
            }
        });
    }
}
