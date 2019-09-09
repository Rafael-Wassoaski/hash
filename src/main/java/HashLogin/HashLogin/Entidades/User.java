package HashLogin.HashLogin.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private String nome;
	private int senha;
	
	public User() {}
	
	public User(String nome, int senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	
	@Id
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
}
