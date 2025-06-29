package anagramgenerator.application;

import java.util.List;

/**
 * Caso de uso responsável pela validação e execução da geração de anagramas.
 */
public class GenerateAnagramUseCase {

	/**
	 * Executa a geração de anagramas com validação da entrada.
	 *
	 * @param input String com letras distintas
	 * @return Lista de anagramas
	 * @throws IllegalArgumentException se entrada for inválida
	 */
	public List<String> execute(String input) {
		return null;
	}

	/**
	 * Verifica se a string possui letras repetidas (case-sensitive).
	 *
	 * @param input Texto de entrada
	 * @return true se houver duplicatas
	 */
	private boolean hasDuplicateLetters(String input) {
		return false;
	}
}
