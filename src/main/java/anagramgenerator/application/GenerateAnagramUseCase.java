package anagramgenerator.application;

import anagramgenerator.domain.AnagramGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("A entrada não pode ser vazia ou nula");
		}

		if (!input.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("A entrada deve conter apenas letras");
		}

		if (input.length() < 2) {
			throw new IllegalArgumentException("A entrada deve conter pelo menos duas letras");
		}

		if (hasDuplicateLetters(input)) {
			throw new IllegalArgumentException("A entrada deve conter apenas letras distintas (sem repetições)");
		}

		return AnagramGenerator.generate(input);
	}

	/**
	 * Verifica se a string possui letras repetidas (case-sensitive).
	 *
	 * @param input Texto de entrada
	 * @return true se houver duplicatas
	 */
	private boolean hasDuplicateLetters(String input) {
		Set<Character> seen = new HashSet<>();
		for (char c : input.toCharArray()) {
			if (!seen.add(c)) {
				return true;
			}
		}
		return false;
	}
}
