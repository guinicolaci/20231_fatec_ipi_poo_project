import com.google.gson.Gson;

public class TesteGSON {
    public static void main(String[] args) {
        var ChatGPTRequest = new ChatGPTRequest("text-davinci-003", "Por que o céu é azul", 150);
        var gson = new Gson();
        String json = gson.toJson(ChatGPTRequest);
        System.out.println(json);

        var copia = gson.fromJson(json, ChatGPTRequest.class);
        System.out.println(copia.getModel());
    }
}
