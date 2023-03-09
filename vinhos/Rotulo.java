package vinhos;

public class Rotulo {

	private static int quantidadeDeRotulos = 0;

	private String nome;
	private String produtor;
	private String tipo;
	private String regiao;
	private int anoProducao;

	public Rotulo() {

	}

	public Rotulo(String nome, String produtor, String tipo, String regiao, int anoProducao) {
		this.nome = nome;
		this.produtor = produtor;
		this.tipo = tipo;
		this.regiao = regiao;
		this.anoProducao = anoProducao;
		quantidadeDeRotulos++;
	}

	public static int getQuantidadeDeRotulos() {
		return quantidadeDeRotulos;
	}

	public Object criaRotulo(String nome, String produtor, String tipo, String regiao, int anoProducao) {
		Rotulo rt = new Rotulo(nome, produtor, tipo, regiao, anoProducao);
		return rt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public int getAnoProducao() {
		return anoProducao;
	}

	public void setAnoProducao(int anoProducao) {
		this.anoProducao = anoProducao;
	}

	@Override
	public String toString() {
		return "Rótulo{Nome:" + nome + ", \nProdutor: " + produtor + ", \nTipo: " + tipo + ", \nRegião: " + regiao
				+ ", \nAno de Produção: " + anoProducao + "}";

	}

}
