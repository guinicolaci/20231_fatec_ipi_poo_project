import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        ImageIcon icon = new ImageIcon(System.getProperty("user.home") + "/Downloads/ChatGPT.png");

        String input = (String) JOptionPane.showInputDialog(
            null,
            "Selecione uma opção:\n" +
            "1. Tradução\n" +
            "2. Geração de emoji\n" +
            "3. Explicação para crianças\n" +
            "4. Ver membros do grupo\n" +
            "5. Sair",
            "Menu",
            JOptionPane.PLAIN_MESSAGE,
            icon,
            null,
            null
        );
        

    int opcao = Integer.parseInt(input);
    
    var properties = new Properties();
    properties.load(new FileInputStream("src/app.properties"));
    final String OPENAI_API_KEY = properties.getProperty("OPENAI_API_KEY");
    
    var ChatGPTClient = new ChatGPTClient();
    
    switch(opcao) {
    case 1:     /* ================================TRADUZIR UMA PALAVRA OU FRASE================================ */
        JOptionPane.showMessageDialog(null, "Opção de tradução selecionada! :)", "Menu", JOptionPane.INFORMATION_MESSAGE, icon);


        String texto = (String) JOptionPane.showInputDialog(null, "Traduzir", "Tradução", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
        String s = ChatGPTClient.traduzir(OPENAI_API_KEY, texto);

        JOptionPane.showMessageDialog(null, s,"Tradução", JOptionPane.INFORMATION_MESSAGE, icon);
    break;

    /* ================================DEFINIR UM FILME EM TRÊS EMOJIS================================ */
    case 2:
        JOptionPane.showMessageDialog(null, "Opção de gerar emoji selecionada! :)", "Menu", JOptionPane.INFORMATION_MESSAGE, icon);

        String entrada = (String) JOptionPane.showInputDialog(null, "Nome do filme", "Emojis", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
        String e = ChatGPTClient.pedirEmojString(OPENAI_API_KEY, entrada);

        JOptionPane.showMessageDialog(null, e, "Emojis", JOptionPane.INFORMATION_MESSAGE, icon);
    break;

    /* ================================EXPLICAÇÃO PARA CRIANÇAS================================ */
    case 3:
        JOptionPane.showMessageDialog(null, "Opção de explicação para criança selecionado! :)", "Menu", JOptionPane.INFORMATION_MESSAGE, icon);


        String perguntaCrianca = (String) JOptionPane.showInputDialog(null, "Faça uma pergunta", "Perguntar", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
        String perguntarChat = ChatGPTClient.perguntarChat(OPENAI_API_KEY, perguntaCrianca);

        JOptionPane.showMessageDialog(null, perguntarChat, "Perguntar", JOptionPane.INFORMATION_MESSAGE, icon);
    break;

    case 4: 
        JOptionPane.showMessageDialog(null, "Opção ver membros do grupo selecionada! :)", "Menu", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "Grupo composto por:\n" + "Gabriel Hernandes\n" + "Guilherme Nicolaci\n" + "Gustavo Nicolaci\n" + "João Marchette\n" + "Mateus Isidorio", "Membros", JOptionPane.INFORMATION_MESSAGE, icon);
        break;

    case 5:
        JOptionPane.showMessageDialog(null, "Opção sair selecionada! :(", "Sair", JOptionPane.INFORMATION_MESSAGE, icon);
    break;

    default: 
        JOptionPane.showMessageDialog(null, "Opção inválida.", "Menu", JOptionPane.INFORMATION_MESSAGE, icon);
    break;
    }
  }
}