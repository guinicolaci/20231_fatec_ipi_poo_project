import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatGPTClient 
{
    /* ================================TRADUZIR UMA PALAVRA OU FRASE================================ */
    public String traduzir(
        String OPENAI_API_KEY,
        String texto
    ) throws Exception {
        
        String prompt = 
        """
            Traduzir o texto %s, dando duas opções de respostas em português.
        """.formatted(
            texto
        );
        var requisicao = new ChatGPTRequest(
            "text-davinci-003",
            prompt,
            100
        );

        var gson = new Gson();
        var requisicaoJSON = gson.toJson(requisicao);

        RequestBody requestBody = RequestBody.create(requisicaoJSON, MediaType.parse("application/json"));

        OkHttpClient httpClient = new OkHttpClient();

        Request request = 
            new Request.Builder()
            .url("https://api.openai.com/v1/completions")
            .addHeader("Media-Typer", "application/json")
            .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
            .post(requestBody)
            .build();

        Response response = httpClient.newCall(request).execute();
        ChatGPTResponse chatGPTResponse =
            gson.fromJson(response.body().string(), ChatGPTResponse.class);
            String completion = chatGPTResponse.getChoices().get(0).getText();

        return completion;
    }

    /* ================================DEFINIR UM FILME EM TRÊS EMOJIS================================ */
    public String pedirEmojString(String OPENAI_API_KEY, String entrada) throws Exception 
    {
        String prompt = 
            """
            Defina o filme %s em APENAS três emojis
            """.formatted(
                entrada
                );

        var requisicao = new ChatGPTRequest(
                "text-davinci-003",
                prompt,
                100);

        var gson = new Gson();
        var requisicaoJSON = gson.toJson(requisicao);

        RequestBody requestBody = // corpo da requisição
                RequestBody.create(
                        requisicaoJSON,
                        MediaType.parse("application/json")
                        );

        OkHttpClient httpClient = new OkHttpClient();

        Request request = // requisição e URL
                new Request.Builder() // construtor da requisição
                        .url("https://api.openai.com/v1/completions") // url do chatgpt
                        .addHeader("Media-Type", "application/json")
                        .addHeader("Authorization", "Bearer " + OPENAI_API_KEY) // Autenticação baseada em token
                        .post(requestBody) // post = tipo de requisição
                        .build();

        Response response = httpClient.newCall(request).execute(); // enviando a requisição ao servidor e aguardando
                                                                   // resposta
        ChatGPTResponse chatGPTResponse = // recebe a resposta do chatgpt
                gson.fromJson(response.body().string(), ChatGPTResponse.class); // converte a resposta do chatgpt de
                String completion = chatGPTResponse.getChoices().get(0).getText();  // json pra gson                                                                        

        // Completion é o retorno/resposta do chatgpt ou de um programa ao usuário
        return completion;
    }

    /* ================================EXPLICAÇÃO PARA CRIANÇAS================================ */
    public String perguntarChat(String OPENAI_API_KEY, String perguntaCriancas) throws Exception 
    {
        String prompt = """
                 %s. Responda em menos de 30 palavras de forma simples.
                """.formatted(
                        perguntaCriancas
                );

        var requisicao = new ChatGPTRequest(
                "text-davinci-003",
                prompt,
                100);

        var gson = new Gson();
        var requisicaoJSON = gson.toJson(requisicao);

        RequestBody requestBody = // corpo da requisição
                RequestBody.create(
                        requisicaoJSON,
                        MediaType.parse("application/json")
                        );

        OkHttpClient httpClient = new OkHttpClient();

        Request request = // requisição e URL
                new Request.Builder() // construtor da requisição
                        .url("https://api.openai.com/v1/completions") // url do chatgpt
                        .addHeader("Media-Type", "application/json")
                        .addHeader("Authorization", "Bearer " + OPENAI_API_KEY) // Autenticação baseada em token
                        .post(requestBody) // post = tipo de requisição
                        .build();

        Response response = httpClient.newCall(request).execute(); // enviando a requisição ao servidor e aguardando
                                                                   // resposta
        ChatGPTResponse chatGPTResponse = // recebe a resposta do chatgpt
                gson.fromJson(response.body().string(), ChatGPTResponse.class); // converte a resposta do chatgpt de
                String completion = chatGPTResponse.getChoices().get(0).getText();  // json pra gson                                                                        

        // Completion é o retorno/resposta do chatgpt ou de um programa ao usuário
        return completion;
    }
}