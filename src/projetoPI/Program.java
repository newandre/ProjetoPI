package projetoPI;

import java.util.Scanner;

public class Program {

	static int recebeLimpa() {
		
		Scanner scanner = new Scanner(System.in); 
		int retornoDoScanner = scanner.nextInt(); 

		System.out.print("\033\143");

		return retornoDoScanner;
	}

	static void authTipoUsuario(int EscolhaTipousuario) {

		switch(EscolhaTipousuario) {
			case 1:
				AuthSenhaProfessor();
			break;

			case 2:
				System.out.println("B");
			break;
		}

	}

	static void AuthSenhaProfessor() {

		int senha = 123;
		int maxTentativasSenha = 3;

		System.out.println("Digite a senha!");
		System.out.printf("SENHA: %d\n", senha);
		System.out.printf("\nDigite: ");
		int senhaDigitada = recebeLimpa();

		for(int tentativas = 1; tentativas < (maxTentativasSenha + 1); tentativas++) {
							 
			boolean SenhaCheck = senha == senhaDigitada;

			if(SenhaCheck) {
	
				menuProfessor();
				break;
				// PASSAR TRUE SE PRECIAR PARA O MENU DE VOLTAR.

			}else if(!SenhaCheck && tentativas != maxTentativasSenha) {

				int erroTentativas = maxTentativasSenha - tentativas;

				if(erroTentativas > 1) {

					System.out.printf("Senha incorreta, você possue mais %d tentavivas: \n", erroTentativas);
					System.out.printf("SENHA: %d \n", senha);
					System.out.printf("\nDigite: ");

				}else {

					System.out.printf("Senha incorreta, você possue mais %d tentaviva: \n", erroTentativas);
					System.out.printf("SENHA: %d \n", senha);
					System.out.printf("\nDigite: ");
	
				}

				senhaDigitada = recebeLimpa();

			}
			
		}

	}
	
	static void menuProfessor() {

		int numeroEscolhidoProfessor;

		do{

			System.out.println("+-----------------------------------------------+");
			System.out.println("***         MENU DE EDIÇÃO DA PROVA!          ***");
			System.out.println("+-----------------------------------------------+");
			System.out.println("1) QUANTIDADE DE QUESTÕES");
			System.out.println("2) VALOR DAS QUESTÕES");
			System.out.println("3) MODO DE QUESTÕES ALEATÓRIAS");
			System.out.println("4) NÚMERO DE TENTATIVAS");
			System.out.println("+-----------------------------------------------+");
			System.out.println("0) SALVAR E VOLTAR");
			System.out.println("+-----------------------------------------------+");

			numeroEscolhidoProfessor = recebeLimpa();

		}while(numeroEscolhidoProfessor < 0 || numeroEscolhidoProfessor > 4);

		int qtdQuestoes = 0;
		
		switch(numeroEscolhidoProfessor) {
			
			case 1:
				qtdQuestoes = quantidadeQuestoes();
			break;

			case 2:
				controleValorQuestoes();
			break;

			case 3:
				
			break;

			case 4:
				
			break;

			case 0:
				menuInicial();
			break;

		}

		// construtorProva();

	}

	static void construtorProva() {



		// String listaGeral[][] = geralQuestoes(qtdQuestoes);

	}
	
	static boolean voltarMenu() {

		int digitoVoltarContinuar;

		do {

			System.out.println("Digite 1 para continuar ou 0 para voltar ao menu de edição:");
			System.out.println("1) Alterar Resposta");
			System.out.println("0) Voltar Menu");
			digitoVoltarContinuar = recebeLimpa();

		}while(digitoVoltarContinuar != 1 && digitoVoltarContinuar != 0);

		if(digitoVoltarContinuar == 1) {

			return true;

		}else {

			menuProfessor();
			return false;

		}

	}

	static String[][] geralQuestoes(int qtdQuestoes) {

		String listaQuestoesRespostas[][] = new String[3][qtdQuestoes];

		// PERGUNTAS
		listaQuestoesRespostas[0][0] = "Questão  : Qual dos seguintes tipos de dados em Java representa números inteiros sem casas decimais?";
		listaQuestoesRespostas[0][1] = "Questão  : Qual é a saída deste código Java?\n int x = 5;\nSystem.out.println(x++);";
		listaQuestoesRespostas[0][2] = "Questão  : Em Java, qual é a palavra-chave utilizada para definir uma classe?";
		listaQuestoesRespostas[0][3] = "Questão  : Qual é a estrutura de controle em Java utilizada para repetir um bloco de código várias vezes?";
		listaQuestoesRespostas[0][4] = "Questão  : O que o seguinte código Java faz?\n String nome = 'João'\nSystem.out.println(nome.length())";
		listaQuestoesRespostas[0][5] = "Questão  : Em Java, qual é a forma correta de declarar um array de inteiros chamado 'numeros' com tamanho 5?";
		listaQuestoesRespostas[0][6] = "Questão  : O que o seguinte código Java faz?\nint resultado = Math.abs(-10);\nSystem.out.println(resultado);";
		listaQuestoesRespostas[0][7] = "Questão  : Qual é a forma correta de escrever um comentário de várias linhas em Java?";
		listaQuestoesRespostas[0][8] = "Questão  : Em Java, como você chama um método de uma classe 'MinhaClasse'?";
		listaQuestoesRespostas[0][9] = "Questão  : Qual é a saída deste código Java? int[] numeros = {1, 2, 3, 4, 5}\nfor (int i = 0; i < numeros.length; i++) {\nSystem.out.print(numeros[i] + ' ')\n}";
	

		// ALTERNATIVAS
		listaQuestoesRespostas[1][0] = 
		"A) int 1 \n" + /*correta */
		"B) float 2 \n" + 
		"C) double 3 \n" + 
		"D) String 4 \n";
		listaQuestoesRespostas[1][1] = 
		"A)  4 \n" + 
		"B)  5\n" + /*correta*/
		"C)  6 \n" + 
		"D)  O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][2] = 
		"A)  class \n" +/*correta*/
		"B)  public \n" + 
		"C)  static \n" + 
		"D)  void\n";
		listaQuestoesRespostas[1][3] = 
		"A)  if \n" + 
		"B)  switch \n" + 
		"C)  while \n" + 
		"D)  for \n";/*correta*/
		listaQuestoesRespostas[1][4] = 
		"A)  Imprime o nome 'João' \n" + 
		"B)  Retorna o tamanho do nome 'João' \n" + /*correta*/
		"C)  Retorna a posição da letra 'o' no nome 'João' \n" + 
		"D)  O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][5] = 
		"A)  int[] numeros = new int[5];\n" + /*correta*/
		"B)  int[] numeros = {1, 2, 3, 4, 5}; \n" + 
		"C)  int numeros[] = new int[5]; \n" + 
		"D)  int numeros[] = {1, 2, 3, 4, 5}; \n";
		listaQuestoesRespostas[1][6] = 
		"A)  Calcula o valor absoluto de -10\n" + /*correta */
		"B)  Calcula a raiz quadrada de -10 \n" + 
		"C)  Calcula o seno de -10 \n" + 
		"D)  O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][7] = 
		"A)  // Este é um comentário\n" + 
		"B)  /* Este é um comentário / \n" + /*correta*/
		"C)  // Este é um comentário / \n" + 
		"D)  /* Este é um comentário // \n";
		listaQuestoesRespostas[1][8] = 
		"A)  MinhaClasse.metodo();\n" +		/*correta*/								
		"B)  metodo.MinhaClasse();\n" + 
		"C)  MinhaClasse.metodo; \n" + 
		"D)  metodo.MinhaClasse; \n";
		
		listaQuestoesRespostas[1][9] = 
		"A) 1 2 3 4 5\n" + /*correto*/
		"B) 5 4 3 2 1\n" + 
		"C) 1 1 1 1 1\n" + 
		"D) O código resultará em um erro de compilação\n";
		// VALOR DAS QUESTÕES
		listaQuestoesRespostas[2][0] = "1";
		listaQuestoesRespostas[2][1] = "2";
		listaQuestoesRespostas[2][2] = "0.50";
		listaQuestoesRespostas[2][3] = "1";
		listaQuestoesRespostas[2][4] = "0.50";
		listaQuestoesRespostas[2][5] = "2";
		listaQuestoesRespostas[2][6] = "0.75";
		listaQuestoesRespostas[2][7] = "1";
		listaQuestoesRespostas[2][8] = "0.25";
		listaQuestoesRespostas[2][9] = "1";

		return listaQuestoesRespostas;
	}

	static int quantidadeQuestoes() {

		int qtdQuestoes = 0;

		boolean voltarContinuar = true;

		while(voltarContinuar) {

			System.out.println("Digite a quantidade de questões de 1 a 10");
			qtdQuestoes = recebeLimpa();

			while(qtdQuestoes < 1 || qtdQuestoes > 10){

				System.out.println("Opção invalida! digite um valor entre 1 e 10");
				qtdQuestoes = recebeLimpa();

			}
			
			voltarContinuar = voltarMenu();

		}
		// AQUI TEM QUE ARRUMAR ELE ESTÁ CHAMANDO A FUNÇÃO ANTES DE RETORNAR O qtdQuestoes
		return qtdQuestoes;
	}

	static double[] controleValorQuestoes() {


		double controleValorQuestoes[] = new double[10];
		double somaValorQuestoes = 0;

		for(int i = 0; i < controleValorQuestoes.length; i++) {
			
			System.out.printf("Digite a nota de questão de número %d \n", i + 1);
			controleValorQuestoes[i] = recebeLimpa();
			somaValorQuestoes += controleValorQuestoes[i];

		}

		// if(somaValorQuestoes) {
			
		// }

		return controleValorQuestoes;
	}

	static void menuInicial() {

		int numeroEscolhido;

		do {

			System.out.print("\033\143");
			System.out.println("+-----------------------------------------------+");
			System.out.println("|                                               |");
			System.out.println("|                SEJA BEM - VINDO               |");
			System.out.println("|                                               |");
			System.out.println("+-----------------------------------------------+\n");
			
			System.out.println("****** Prova de Lógica a Programação (JAVA) ******\n");

			System.out.println("Selecione a opção correspondente:");

			System.out.println("1) Professor");
			System.out.println("2) Aluno");

			numeroEscolhido = recebeLimpa();

		}while(numeroEscolhido <= 0 || numeroEscolhido > 2);

		authTipoUsuario(numeroEscolhido);
	}

	public static void main(String[] args) {

		menuInicial(); // :) 

	}

}
