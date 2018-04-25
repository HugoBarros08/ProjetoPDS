package br.imd.pds.service;

import java.util.InputMismatchException;
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
	 * @return true se o email é válido, false caso contrário
	 */
	public boolean validationEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * Método para validar um número de cpf pelos dígitos verificadores 
	 * 
	 * @param cpf do usuário a ser verificado 
	 * @return true se o cpf é válido, ou false caso contrário
	 */
	public boolean validationCPF(String cpf) {
		
		if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
			cpf.equals("22222222222") || cpf.equals("33333333333") ||
			cpf.equals("44444444444") || cpf.equals("55555555555") ||
			cpf.equals("66666666666") || cpf.equals("77777777777") ||
			cpf.equals("88888888888") || cpf.equals("99999999999") ||
	       (cpf.length() != 11))
			return(false);
		
		int sm, rest, weight, number;
		char digit10, digit11;
		
		/* Calculando o primeiro dígito verificador */
		try {
			sm = 0;
			weight = 10;
			
			for (int i = 0; i < 9; i++) {
				number = (int)(cpf.charAt(i) - 48);
				sm += (number * weight);
				weight -= 1; 
			}
			
			rest = 11 - (sm % 11);
			if ((rest == 10) || (rest == 11)) {
				digit10 = '0';
			} else {
				digit10 = (char)(rest + 48);
			}
			
			/* Calculando o segundo dígito verificador */
			sm = 0;
		    weight = 11;
		    for(int i=0; i<10; i++) {
		      number = (int)(cpf.charAt(i) - 48);
		      sm += (number * weight);
		      weight -= 1;
		    }

		    rest = 11 - (sm % 11);
		    if ((rest == 10) || (rest == 11))
		       digit11 = '0';
		    else digit11 = (char)(rest + 48);
			
			if ((digit10 == cpf.charAt(9)) && (digit11 == cpf.charAt(10))) {
				return true;
			} else {
				return false;
			}

		} catch(InputMismatchException e) {
			return false;
		}
	}
	
}