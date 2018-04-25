package br.imd.pds.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsável por validar email e CPF
 */
public class ValidationService {

	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);

	/**
	 * Método para validar o email de um usuário
	 * 
	 * @param email string com email a ser verificado
	 * @return true se o email é válido
	 */
	public boolean validationEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public boolean validationCPF(String cpf) {
		
		return true;
	}
	

}