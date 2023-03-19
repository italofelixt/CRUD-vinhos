package vinhos;


public class ListaDeRotulos {   //classe que é um vetor de objetos.

	private Object[] elementos;
	private int tamanho; // quantidade de elementos dentro do Vetor.

	public ListaDeRotulos(int capacidade) {
		this.elementos = new Object[capacidade]; // construtor com parametro de capacidade
		this.tamanho = 0;
	}

	public void aumentaCapacidade() {
		if (this.tamanho == this.elementos.length) {
			Object[] elementosNovos = new Object[this.elementos.length * 2]; // em questão de performance é melhor
																				// dobrar a capacidade pois irá diminuir
																				// a quantidade de passos a longo prazo
			for (int i = 0; i < elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}

	public void adiciona(Object elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < elementos.length) {// valida se o número de elementos é menor do que a capacidade
			this.elementos[tamanho] = elemento; // vai add o elemento na index q é referente a última
			this.tamanho++; // incrementa o número de elementos
		}
	}

	public void adicionaEmPosicaoEspecifica(int posicao, Object elemento) throws Exception {
		this.aumentaCapacidade(); // no método ja tem a validação para saber se precisa aumentar a capacidade

		if (posicao >= 0 && posicao < tamanho) {
			for (int i = posicao; i < tamanho - 1; i++) {
				this.elementos[i + 1] = this.elementos[i];
			}

			this.elementos[posicao] = elemento;
			this.tamanho++;

		} else {
			throw new Exception("Posição Inválida");
		}
	}

	public boolean remove(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			for (int i = posicao; i < tamanho - 1; i++) {
				this.elementos[i] = this.elementos[i + 1];
			}
			this.tamanho--;
			return true;
		} else {
			throw new Exception("Posição Inválida");
		}
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public Object[] clonaVetor() {
		Object[] clone = new Object[this.elementos.length];
		for (int i = 0; i < this.tamanho; i++) {
			clone[i] = this.elementos[i];
		}
		return clone;
	}

	public void limpaVetor() { // esvazia o vetor deixando todos os elementos null
		for (int i = 0; i < this.tamanho; i++) {
			this.elementos[i] = null;
		}
	}

	@Override
	public String toString() {
		// return Arrays.toString(elementos); //tranforma em String p/ printar na tela,
		// mas printa inclusive os null

		StringBuilder s = new StringBuilder();
		//s.append("[");

		for (int i = 0; i < this.tamanho - 1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
			s.append("\n");
		}

		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho - 1]);// add o elemento da última posicao;
		}

		return s.toString();// precisa retornar usando o toString pois é o retorno do método que foi
							// sobreescrito
	}

	public String toStringClone(Object[] vetor) {
		String s = "[";

		for (int i = 0; i < tamanho; i++) {
			s += vetor[i];
			if (i < tamanho - 1)
				s += ", ";
		}
		s += "]";

		return s;
	}

	public Object buscaElementoNaPosicao(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho)
			return elementos[posicao];
		else {
			throw new Exception("\n\n\n-------------- Posição Inválida ---------------\n\n");
		}
	}

	public int buscaPosicaoDoElemento(Object elemento) throws Exception {
		for (int i = 0; i < tamanho; i++) {
			if (elementos[i].equals(elemento)) {
				return i;
			} else {
				throw new Exception("\n\n\n-------------- Elemento não Encontrado ---------------\n\n");
			}
		}
		return -1;
	}
}
