package application;

import java.util.Scanner;

import entities.Cpf;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite seu CPF (xxx.xxx.xxx-xx): ");
		String numeroCpf = sc.next();
		System.out.println();
		
		Cpf cpf = new Cpf(numeroCpf);
		
		System.out.println(cpf.validador(cpf.getCpf()));
		
		sc.close();
	}

}
