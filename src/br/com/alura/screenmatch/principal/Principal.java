package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelo.Episodio;
import br.com.alura.screenmatch.modelo.Filme;
import br.com.alura.screenmatch.modelo.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Filme favorito = new Filme(1999,"The Matrix");
        Serie serie = new Serie(1999,"JoJo");



        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);

        favorito.exibeFichaTecnica();
        favorito.avalia(9);
        favorito.avalia(8);
        favorito.avalia(9);

        System.out.println("Média de avaliações do filme: " +favorito.pegaMedia());


        serie.setDuracaoEmMinutos(135);
        serie.setIncluidoNoPlano(true);
        serie.exibeFichaTecnica();
        serie.avalia(9);
        serie.avalia(8);
        serie.setEpisodiosPorTemporada(12);
        serie.setTemporadas(6);
        serie.setMinutosPorEpisodios(25);
        System.out.println(serie.getDuracaoEmMinutos() + " duracao em minutos");
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(favorito);
        System.out.println(calculadora.getTempoTotal());


        Filme favorito2 = new Filme(1993,"Max");


        favorito2.setDuracaoEmMinutos(138);
        favorito2.setIncluidoNoPlano(true);

        favorito2.exibeFichaTecnica();
        favorito2.avalia(9);
        favorito2.avalia(8);
        favorito2.avalia(9);

        System.out.println("Média de avaliações do filme: " +favorito2.pegaMedia());

        calculadora.inclui(favorito2);
        calculadora.inclui(serie);
        System.out.println(calculadora.getTempoTotal());

        Serie hp = new Serie(2001,"HP");
        hp.setIncluidoNoPlano(true);
        hp.setEpisodiosPorTemporada(8);
        hp.setTemporadas(8);
        hp.avalia(9);
        hp.avalia(8);
        hp.setMinutosPorEpisodios(150);
        hp.exibeFichaTecnica();

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(favorito);
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(hp);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        Filme favorito3 = new Filme(2003,"Hobbit");
        favorito3.setAnoDeLancamento(2003);
        favorito3.avalia(9);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(favorito);
        listaDeFilmes.add(favorito3);
        listaDeFilmes.add(favorito2);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro Filme: " + listaDeFilmes.getFirst().getNome());
        System.out.println("Lista completa: "+ listaDeFilmes);


    }

}