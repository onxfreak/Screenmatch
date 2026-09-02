package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelo.Filme;
import br.com.alura.screenmatch.modelo.Serie;
import br.com.alura.screenmatch.modelo.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {

    public static void main(String[] args) {
        Filme favorito3 = new Filme(2003,"Hobbit");
        Filme favorito2 = new Filme(1999,"Ovo");
        Filme favorito = new Filme(1979,"Toioto");
        Serie serie = new Serie(1899,"JoJo");
        favorito.avalia(10);
        favorito2.avalia(10);
        serie.avalia(10);
        favorito3.avalia(8);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(favorito);
        lista.add(favorito3);
        lista.add(favorito2);
        lista.add(serie);
        for (Titulo titulo : lista) {
            System.out.println(titulo.getNome());
            if(titulo instanceof Filme filme) {
                System.out.println("Classificação: "+filme.getClassificacao());
            }

        }

        ArrayList<String> lista2 = new ArrayList<>();
        lista2.add("Hobbit");
        lista2.add("Ovo");
        lista2.add("JoJo");
        lista2.add("Joao");


        Collections.sort(lista2);
        System.out.println(lista2);
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
