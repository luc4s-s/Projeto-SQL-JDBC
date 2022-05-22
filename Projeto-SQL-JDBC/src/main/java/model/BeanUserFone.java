package model;

public class BeanUserFone {

	private String email ;
	private String nome;
	private String numero;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "BeanUserFone [email=" + email + ", nome=" + nome + ", numero=" + numero + "]";
	}
	
	
	
	
}
