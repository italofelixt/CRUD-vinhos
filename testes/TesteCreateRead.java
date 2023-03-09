package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vinhos.Rotulo;
import vinhos.ListaDeRotulos;

class TesteCreateRead {

	@Test
	void testRead() {

		ListaDeRotulos vetor = new ListaDeRotulos(5);
		Rotulo rt = new Rotulo("Pata negra", "Casillero", "tinto", "chile", 2020);
		Rotulo rt1 = new Rotulo("Pata negra", "Casillero", "tinto", "chile", 2020);
		try {

			vetor.adiciona(rt);
			vetor.adiciona(rt1);

			System.out.println(vetor.toString());

			System.out.println("\n");
			System.out.println("elemento buscado");
			System.out.println(vetor.buscaElementoNaPosicao(0));
			
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
