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
		// numero = numero.replace("-", "");

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

		int multiplicador = 2;
		int soma = 0;
		int primeiroVerificador;


		for (int i = list.size() - 3; i > -1; i--) {

			int aux = Integer.parseInt(list.get(i));
			aux *= multiplicador++;
			soma += aux;
		}

		int resto = soma % 11;

		if (resto < 2) {
			primeiroVerificador = 0;
		} else {
			primeiroVerificador = (11 - resto);
		}

		multiplicador =2;
		soma = 0;
		int segundoVerificador;
		
		for (int i = list.size() - 2; i > -1; i--) {

			int aux = Integer.parseInt(list.get(i));
			aux *= multiplicador++;
			soma += aux;

		}
		
		int resto2 = soma % 11;
		
		if (resto2 < 2) {
			segundoVerificador = 0;
		} else {
			segundoVerificador = (11 - resto2);
		}
			
		if (primeiroVerificador == Integer.parseInt(list.get(list.size() - 2))&&
				segundoVerificador == Integer.parseInt(list.get(list.size() - 1))) {
			return true;
		} else {
			return false;
		}
	}
}
