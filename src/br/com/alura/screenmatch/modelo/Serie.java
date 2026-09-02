package br.com.alura.screenmatch.modelo;

public class Serie extends Titulo {
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    public Serie(int anoDeLancamento, String nome) {
        super(anoDeLancamento, nome);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodios() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodios(int minutosPorEpisodios) {
        this.minutosPorEpisodio = minutosPorEpisodios;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio ;
    }

    @Override
    public void exibeFichaTecnica() {
        setDuracaoEmMinutos(temporadas * episodiosPorTemporada * minutosPorEpisodio);
        super.exibeFichaTecnica();
    }

    @Override
    public String toString() {
        return ("Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")");
    }
}
