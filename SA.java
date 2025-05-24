package SA;
import java.util.*;
public class SA {
		
		
	public static class Maquina {
	    int id;
	    String setor;
	    int alicatesProduzidos;
	    int martelosProduzidos;
	    int chavesFendaProduzidas;

	    public Maquina(int id, String setor, int alicates, int martelos, int chaves) {
	        this.id = id;
	        this.setor = setor;
	        this.alicatesProduzidos = alicates;
	        this.martelosProduzidos = martelos;
	        this.chavesFendaProduzidas = chaves;
	    }
	    public String identificação() {
	        return "Máquina ID: " + id + " | Alicates: " + alicatesProduzidos +
	               " | Martelos: " + martelosProduzidos +
	               " | Chaves de Fenda: " + chavesFendaProduzidas;
	    }
	}
			static int Qtsetores;
			static int[][] ferramentas = new int [3][Qtsetores]; 
			static ArrayList<String> nomeSetor = new ArrayList<>();
			static ArrayList<Integer> maquinasPSetor = new ArrayList<>();
			public static String op1 (Scanner entrada) {
				
				System.out.println("Quantos Setores vão existir?");
				Qtsetores = entrada.nextInt();
				entrada.nextLine();
				ferramentas = new int [3][Qtsetores];
				
				for(int e = 0; e < Qtsetores; e++) {
					System.out.println("Nome do setor(es): ");
					String nome = entrada.nextLine();
					nomeSetor.add(nome);
					
					System.out.println("Quantas máquinas vão ter no setor?");
					int maquinaPSetor = entrada.nextInt();
					entrada.nextLine();
					maquinasPSetor.add(maquinaPSetor);
					}
				return "Setor(es) Registrado!!";
			}
			static ArrayList<Maquina> listaMaquinas= new ArrayList<>();
			public static String op2(Scanner entrada) {
			    int prodMinm = 0, prodMinc = 0, prodMina = 0;    
			    for (int s = 0; s < Qtsetores; s++) {  
			        String nome = nomeSetor.get(s);
			        int Qtdmaquinas = maquinasPSetor.get(s); 
			        for (int h = 0; h < Qtdmaquinas; h++) {  
			         System.out.println("Registre o número de identificação da máquina: ");
			         int numM = entrada.nextInt();
			         System.out.println("Quantos alicates a máquina produz semanalmente?");
			         int Qtalicates = entrada.nextInt();
			         System.out.println("Quantos martelos a máquina produz semanalmente?");    
			         int Qtmartelos = entrada.nextInt();
			         System.out.println("Quantas chaves de fenda a máquina produz semanalmente?");
			         int Qtchavesdefenda = entrada.nextInt();
			         entrada.nextLine();

			         Maquina novaMaquina = new Maquina(numM, nome, Qtalicates, Qtmartelos, Qtchavesdefenda);
			         listaMaquinas.add(novaMaquina);
			            int indiceSetor = nomeSetor.indexOf(nome);
			            ferramentas[0][indiceSetor] += Qtalicates;
			            ferramentas[1][indiceSetor] += Qtmartelos;
			            ferramentas[2][indiceSetor] += Qtchavesdefenda;
			        }
			    }
			    return "Máquinas Registradas!";
			}
			public static String op3(Scanner entrada) {
				    if (listaMaquinas.isEmpty()) {
				        return "Nenhuma máquina registrada!";
				    }

				    System.out.println("Digite o número da máquina que deseja conferir:");
				    int numMaquina = entrada.nextInt();
				    entrada.nextLine();

				    for (Maquina maquina : listaMaquinas) {
				        if (maquina.id == numMaquina) {
				            System.out.println("Produção da máquina " + numMaquina + ":");
				            System.out.println(maquina.identificação());
				            return "Produção conferida com sucesso!";
				        }
				    }
				    return "Máquina não encontrada!";
				}

			public static String op4(Scanner entrada) {
			  if (nomeSetor.isEmpty()) {
			        return "Nenhum setor registrado";
			    }  
			    System.out.println("Informe o setor que deseja saber sobre as máquinas	");
			    String setorDesejado = entrada.nextLine();
			    int indiceSetor = nomeSetor.indexOf(setorDesejado);
			    if (indiceSetor == -1) {
			        return "Setor não encontrado";
			    }
			    System.out.println("Produção total do setor " + setorDesejado + ":");
			    System.out.println("Total de Alicates: " + ferramentas[0][indiceSetor]);
			    System.out.println("Total de Martelos: " + ferramentas[1][indiceSetor]);
			    System.out.println("Total de Chaves de Fenda: " + ferramentas[2][indiceSetor]);
			    return "Produção conferida com sucesso!";
			}
			public static String op5(Scanner entrada) {
				return "";
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
					System.out.println("4 - Monitorar Produção Máquinas por Setor");
					System.out.println("5 - Monitorar por Tipo de Ferramenta");
					System.out.println("6 - Sair");
					opcao = entrada.nextInt();
					entrada.nextLine();
					switch (opcao) {
						case 1: System.out.println(op1(entrada)); break;
						case 2: System.out.println(op2(entrada)); break;
						case 3: System.out.println(op3(entrada)); break;
						case 4: System.out.println(op4(entrada));break;
						case 5:System.out.println(op5(entrada)); break;
						case 6:;
					}
				}while(opcao != 7);
			}
}
