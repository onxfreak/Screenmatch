package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelo.Titulo;
import br.com.alura.screenmatch.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String titulo= "";

        List<Titulo> listao = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        while(!titulo.equalsIgnoreCase("sair")) {
            titulo = sc.nextLine().trim().replace(" ", "+");

            if (titulo.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + titulo + "&apikey=7be323f5";
            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);



                TituloOmdb tituloJson = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloJson);

                Titulo meuTitulo = new Titulo(tituloJson);
                System.out.println(meuTitulo);

                listao.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {

                System.out.println(e.getMessage());
            }

        }
        System.out.println(listao);
        FileWriter fw = new FileWriter("titulos.json");
        fw.write(gson.toJson(listao));
        fw.close();
        sc.close();
    }
}
