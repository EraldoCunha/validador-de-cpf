package entities;

import java.util.ArrayList;
import java.util.List;

public class Cpf {

	private String cpf;

	public Cpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public String removeCaracter(String numero) {

		numero = numero.replace(".", "");

		return numero;
	}

	public boolean validador(String numero) {

		String[] vetor = removeCaracter(numero).split("-");

		List<String> list = new ArrayList<>();

		String[] digitos = vetor[0].split("(?<=.)");
		String[] verificadores = vetor[1].split("(?<=.)");

		for (int i = 0; i < vetor[0].length(); i++) {
			list.add(digitos[i]);
		}

		for (int i = 0; i < vetor[1].length(); i++) {
			list.add(verificadores[i]);
		}

		boolean resultado = resutadoVerificacao(list);
		
		return resultado;

	}

	public Integer primeiraVerificacao(List lista) {

		int multiplicador = 2;
		int soma = 0;
		int primeiroVerificador;

		for (int i = lista.size() - 3; i > -1; i--) {

			int aux = Integer.parseInt((String) lista.get(i));
			aux *= multiplicador++;
			soma += aux;
		}

		int resto = soma % 11;

		if (resto < 2) {
			primeiroVerificador = 0;
		} else {
			primeiroVerificador = (11 - resto);
		}

		return primeiroVerificador;
	}

	public Integer segundaVerificacao(List lista) {

		int multiplicador = 2;
		int soma = 0;
		int segundoVerificador;

		for (int i = lista.size() - 2; i > -1; i--) {

			int aux = Integer.parseInt((String) lista.get(i));
			aux *= multiplicador++;
			soma += aux;
		}

		int resto = soma % 11;

		if (resto < 2) {
			segundoVerificador = 0;
		} else {
			segundoVerificador = (11 - resto);
		}

		return segundoVerificador;
	}
	
	public boolean resutadoVerificacao (List lista) {
		
		if (primeiraVerificacao (lista) == Integer.parseInt((String) lista.get(lista.size() - 2))
				&& segundaVerificacao(lista) == Integer.parseInt((String)lista.get(lista.size() - 1))) {
			return true;
		} else {
			return false;
		}
	}
}
