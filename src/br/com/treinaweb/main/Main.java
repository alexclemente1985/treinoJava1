package br.com.treinaweb.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * System.out.println("Informe o nome:"); String nome = scanner.nextLine();
		 * System.out.println("Seu nome é: "+nome+"!"); scanner.close(); //sempre fechar
		 * scanner!
		 * 
		 * System.out.println("Oĺá mundo!"); System.out.print("Hello");
		 * System.out.println(" World!");
		 * 
		 * System.out.println("Usando o gitflow");
		 */

		/*
		 * System.out.println("Informe o primeiro número: "); int numero1; numero1 =
		 * scanner.nextInt();
		 * 
		 * Scanner scanner2 = new Scanner(System.in);
		 * System.out.println("Informe o segundo número: "); String numeros2 =
		 * scanner2.nextLine(); int numero2 = Integer.parseInt(numeros2);
		 * 
		 * System.out.println("Informe o terceiro número: "); int numero3 =
		 * scanner.nextInt();
		 * 
		 * System.out.println("O primeiro número é: "+numero1+", o segundo é "
		 * +numero2+" e o terceiro é "+numero3+"! ");
		 * 
		 * System.out.println("Informe um caractere aleatório: "); char teste =
		 * scanner.next().charAt(2); //retorna string igual a nextLine, porém encadea
		 * método charAt(index); pega o caractere na posição do index
		 * System.out.println("Informe um texto aleatório: "); String teste2 =
		 * scanner.next(); //só vai pegar até o primeiro espaço vazio no texto
		 * (backspace)
		 * 
		 * 
		 * System.out.println("Caractere: "+teste+". Texto: "+teste2+".");
		 * 
		 * System.out.println(String.format("Você quer fazer a operação %d %c %d"
		 * ,numero1,teste,numero3)); scanner.close(); scanner2.close();
		 */

		Scanner scanner = new Scanner(System.in);

		System.out.println("==== Operação Matemática ====");

		int acao = 1;// 0 = sair, 1 = operação matemática, 2 = histórico

		ArrayList<String> historico = new ArrayList<String>(); // Operador diamante <E>: define que tipo de dado
		// será
		// utilizado no ArrayList
		// inicializado aqui para estar disponível dentro do while e em outras áreas
		while (acao > 0) {
			if (acao == 1) {
				System.out.println("Informe dois números: ");
				
				int num1 = 0;
				try {// captura a seção crítica e tenta executá-la
					num1 = scanner.nextInt();// seção crítica: se usuário digitar letra dará erro
				} catch (InputMismatchException e) {// bloco será executado se erro informado no catch ocorrer no try
					System.out.println(
							String.format("Ocorreu um erro de formato: %s. O primeiro número será 1.", e.getMessage()));
					scanner.nextLine();//permite evitar que a quebra de linha do valor errado atrapalhe o próximo valor
					num1 = 1;
				} catch (Exception e) {//evita problemas com situações imprevistas
					System.out.println("Erro desconhecido.");
				}
				
				int num2 = 0;
				try {
					num2 = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println(
							String.format("Ocorreu um erro de formato: %s. O primeiro número será 1.", e.getMessage()));
					scanner.nextLine();
					num2 = 1;
				} catch (Exception e) {
					System.out.println("Erro desconhecido.");
				}
				
				
				System.out.println("Informe a operação: ");
				char operacao = scanner.next().charAt(0);

				System.out.println(String.format("Você quer fazer a operação %d %c %d", num1, operacao, num2));

				int resultado = 0;

				// IF's aninhados
				/*
				 * if (operacao == '+') { resultado = num1 + num2; } else if (operacao == '-') {
				 * resultado = num1 - num2; } else if (operacao == '*') { resultado = num1 *
				 * num2; } else if (operacao == '/') { resultado = num1 / num2; } else {
				 * System.out.println("Sinal de operação inválido."); }
				 */

				// switch case
				switch (operacao) {
				case '+':
					resultado = num1 + num2;
					break;

				case '-':
					resultado = num1 - num2;
					break;

				case '*':
					resultado = num1 * num2;
					break;

				case '/':
					resultado = num1 / num2;
					break;

				default:
					System.out.println("Sinal de operação inválido.");
					break;

				}

				// collections: ArrayList -> armazena tipos de dados em um array

				String entHist = String.format("%d %c %d = %d ", num1, operacao, num2, resultado);
				historico.add(entHist); // adição da string gerada no ArrayList

				// System.out.println(String.format("%d %c %d = %d
				// ",num1,operacao,num2,resultado));

				System.out.println(entHist);
			} else if (acao == 2) {
				System.out.println("");
				System.out.println("==== Histórico ====");
				System.out.println(String.format("Você já fez %d operações.", historico.size()));
				System.out.println("");

				// uso de foreach(lambda) -> substitui o for abaixo
				historico.forEach(itemHistorico -> System.out.println(itemHistorico));// expressão lambda

				/*
				 * for(int i=0;i<historico.size();i++) {
				 * 
				 * System.out.println(historico.get(i)); //pega o valor de índice i do ArrayList
				 * }
				 */
			}
			System.out.println("");
			System.out.println("==== O que deseja fazer agora? ====");// comando pode ser invocado ao se digitar sysout
																		// e apertar Ctrl + backspace
			System.out.println("1. Operação matemática");
			System.out.println("2. Visualizar histórico");
			System.out.println("0. Sair");

			acao = scanner.nextInt();
			if (acao == 0) {
				System.out.println("Até mais!");
			}
		}
		scanner.close();
	}

}
