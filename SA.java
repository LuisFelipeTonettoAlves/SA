package SA;
import java.util.*;
public class A {
		
			//variáveis universais e listas
			static int prodMinm=0;
			static int prodMina=0;
			static int prodMinc=0;
			static int numM;
			static int Qtalicates=0;
			static int Qtchavesdefenda=0;
			static int Qtmartelos=0;
			static int Qtsetores=0;
			static int ferramentas [][] = new int [3][Qtsetores]; 
			static ArrayList<String> nomeSetor = new ArrayList<>();
			static ArrayList<Integer> maquinasPSetor = new ArrayList<>();
			//opção 1
			public static String op1 (Scanner entrada) {
				
				System.out.println("Quantos Setores vão existir?");
				Qtsetores = entrada.nextInt();
				for(int e = 0; e < Qtsetores; e++) {
					System.out.println("Nome do setor(es) ");
					String nome = entrada.nextLine();
					entrada.nextLine();
					nomeSetor.add(nome);
					System.out.println("Quantas máquinas vão ter no setor?");
					int maquinaPSetor = entrada.nextInt();
					maquinasPSetor.add(maquinaPSetor);
			
					}
				return "Setor(es) Registrado!!";
			}
			public static String op2 (Scanner entrada) {
				
			for (int s=0; s < Qtsetores; s++) {
				
				String nome= nomeSetor.get(s);
				int	Qtdmaquinas= maquinasPSetor.get(s);
				
				for(int h=0; h < maquinasPSetor.size(); h++) {
					
				System.out.println("Registre o numero de indentificação da máquina: ");
				numM = entrada.nextInt();
				System.out.println("Quantos alicates a máquina produz semanalmente?");
				Qtalicates = entrada.nextInt();
				System.out.println("Quantos martelos a máquina produz semanalmente?");	
				Qtmartelos = entrada.nextInt();
				System.out.println("Quantas chaves de fenda a máquina produz semanalmente?");
				Qtchavesdefenda = entrada.nextInt();
				System.out.println("Qual o valor de produção mínima semanal de martelo?");
				prodMinm= entrada.nextInt();
				System.out.println("Qual o valor de produção mínima semanal de chave de fenda?");
				prodMinc= entrada.nextInt();
				System.out.println("Qual o valor de produção mínima semanal de alicate?");
				prodMina= entrada.nextInt();
				entrada.nextLine();
				ferramentas[0][s] += Qtalicates;
				ferramentas[1][s] += Qtmartelos;
				ferramentas[2][s] += Qtchavesdefenda;
				}	
			}
			return "Máquina Registrada!";
		}
			public static int op3 (Scanner entrada) {
				System.out.println("Em que setor está a máquina que você deseja saber a produção semanal?");
			
			}
		public static String op4 (Scanner entrada) {
			System.out.println("Selecione o setor que deseja fiscalizar: ");
			int i=0;
			for (int j = 0; j < Qtsetores; j++) {
			System.out.println(nomeSetor.size());
	} int setorselecionado = entrada.nextInt();
	System.out.println(nomeSetor.get(0));
	
			return "Setor conferido!";
			}
			public static void main(String[] args) {
				
				Scanner entrada = new Scanner(System.in);
				System.out.println("Bem-vindo!!");
				int opcao;
				do{
					System.out.println("-----MENU-----");
					System.out.println("1 - Definir setores e máquinas por setor");
					System.out.println("2 - Registrar  Máquina");
					System.out.println("3 - Conferir Produção por Máquina");
					System.out.println("4 - Conferir produção por setor");
					System.out.println("5 - Monitorar Produção Máquinas por Setor");
					System.out.println("6 - Monitorar por Tipo de Ferramenta");
					System.out.println("7 - Sair");
					opcao = entrada.nextInt();
					switch (opcao) {
						case 1: System.out.println(op1(entrada)); break;
						case 2: System.out.println(op2(entrada)); break;
						case 3: break;
						case 4: System.out.println(op4(entrada));break;
					}
				}while(opcao != 7);
			}
