package br.com.offersall.dto;

public class UsuarioDTO {

	private int id;
	private String funcionarioNome;
	private String funcionarioSobrenome;
	private String login;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFuncionarioNome() {
		return funcionarioNome;
	}
	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}
	public String getFuncionarioSobrenome() {
		return funcionarioSobrenome;
	}
	public void setFuncionarioSobrenome(String funcionarioSobrenome) {
		this.funcionarioSobrenome = funcionarioSobrenome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
}
