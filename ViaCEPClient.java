import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

public class ViaCEPClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String baseUrl = "https://viacep.com.br/ws/";
        String url = "";
        HttpRequest httpRequest;
        HttpResponse<String> httpResponse;

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMinutes(1))
                .build();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Validar um CEP");
            System.out.println("2 - Pesquisar um CEP");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.println("Digite um CEP para validar:");
                String cep = scanner.next();
                cep = cep.replace("-", ""); // trata o erro da pessoa escrever o cep com "-", pois pelo teste o site deu erro
                url = baseUrl + cep + "/json/";

                httpRequest = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(url))
                        .build();

                try {
                    httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                    String responseBody = httpResponse.body();

                    if (responseBody.contains("erro")) {
                        System.out.println("CEP inválido");
                    } else {
                        System.out.println(responseBody);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (opcao == 2) {
                System.out.println("Digite a sigla do estado:");
                String uf = scanner.next();

                System.out.println("Digite o nome da cidade:");
                String cidade = scanner.next();

                scanner.nextLine();
                System.out.println("Digite o nome do logradouro:");
                String logradouro = scanner.nextLine();
                

                url = baseUrl + uf + "/" + cidade + "/" + logradouro + "/json/";
                url = url.replace(" ", "%20");   // gambiarra pq o site não estava entrando com espaços em branco

                httpRequest = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(url))
                        .build();

                try {
                    httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                    String responseBody = httpResponse.body();

                    if (responseBody.contains("erro")) {
                        System.out.println("Não foram encontrados CEPs para o endereço informado");
                    } else {
                        System.out.println(responseBody);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (opcao != 0) {
                System.out.println("Opção inválida");  // finaliza 
            }
        }
    }
}
