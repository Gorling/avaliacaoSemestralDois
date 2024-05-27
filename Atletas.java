package trabalhoHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Atleta {
	String fone; //chave primária
    String nome;
    String apelido;
    String dataNascimento;
    int pontuacaoAcumulada;
    
	public String getFone() {
		return fone;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}
	
	public void setPontuacaoAcumulada(int pontuacaoAcumulada) {
		this.pontuacaoAcumulada = pontuacaoAcumulada;
	}
	
	public Atleta(String fone, String nome, String apelido, String dataNascimento, int pontuacaoAcumulada) {
		super();
		this.fone = fone;
		this.nome = nome;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.pontuacaoAcumulada = pontuacaoAcumulada;
	}
	
	public Atleta() {
		
	}
	
	@Override
	public String toString() {
		return "Atleta [nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(fone, other.fone);
	}

	
	Map<String, Atleta> listaDeAtletas = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	public void removerAtleta() {
        System.out.println("Digite o nome do atleta que deseja remover: ");
        String nome = sc.nextLine();

        Atleta removido = listaDeAtletas.remove(nome);
        if (removido != null) {
            System.out.println("Atleta removido com sucesso!");
        } else {
            System.out.println("Atleta não encontrado.");
        }
    }

	public void procurarAtleta() {
        System.out.println("Digite o nome do atleta que deseja procurar: ");
        String nome = sc.nextLine();

        Atleta atleta = listaDeAtletas.get(nome);
        if (atleta != null) {
            System.out.println("\nAtleta encontrado: ");
            System.out.println(atleta);
        } else {
            System.out.println("Atleta não encontrado.");
        }
    }

	public void listarAtletas() {
	    ArrayList<Atleta> listaAtletas = new ArrayList<>(listaDeAtletas.values());
	    
	    Collections.sort(listaAtletas, Comparator.comparing(Atleta::getNome));
	
	    System.out.println("\nLista de Atletas:");
	    for (Atleta atleta : listaAtletas) {
	        System.out.println(atleta);
	    }
	}

	public void cadastrarAtleta() {
	    System.out.println("Digite o fone do atleta: ");
	    String fone = sc.nextLine();
	    
	    if (listaDeAtletas.containsKey(fone)) {
	        System.out.println("Atleta já cadastrado com este fone.");
	        return;
	    }
	
	
	    System.out.print("Digite o nome do atleta: ");
	    String nome = sc.nextLine();
	    System.out.print("Digite o apelido do atleta: ");
	    String apelido = sc.nextLine();
	    System.out.print("Digite a data de nascimento do atleta: ");
	    String dataNascimento = sc.nextLine();
	    System.out.print("Digite a pontuação acumulada do atleta: ");
	    int pontuacao = sc.nextInt();
	    sc.nextLine();
	
	
	    Atleta novoAtleta = new Atleta();
	    novoAtleta.setNome(nome);
	    novoAtleta.setApelido(apelido);
	    novoAtleta.setDataNascimento(dataNascimento);
	    novoAtleta.setPontuacaoAcumulada(pontuacao);
	    novoAtleta.setFone(fone);
	
	    listaDeAtletas.put(nome, novoAtleta);
	    System.out.println("Atleta cadastrado com sucesso!");
	}


		public static void main(String[] args) {
			boolean sair = false;
			Atleta goat = new Atleta();
			
	        while (!sair) {
	            System.out.println("\nMenu\n1 - Listar atletas (nome ou por pontuação decrescente)\n2 - Cadastrar atleta\n3 - Procurar por atleta (nome ou apelido)\n4 - Remover atleta (nome ou apelido)\n5 - Sair");
	            System.out.print("Escolha uma opção: ");
	            int opcao = sc.nextInt();
	            sc.nextLine();
	
	            switch (opcao) {
	                case 1:
	                    goat.listarAtletas();
	                    break;
	                case 2:
	                    goat.cadastrarAtleta();
	                    break;
	                case 3:
	                    goat.procurarAtleta();
	                    break;
	                case 4:
	                    goat.removerAtleta();
	                    break;
	                case 5:
	                    sair = true;
	                    break;
	                default:
	                    System.out.println("Opção inválida!");
	                    break;
	            }
	        }
	        sc.close();
		}
}
