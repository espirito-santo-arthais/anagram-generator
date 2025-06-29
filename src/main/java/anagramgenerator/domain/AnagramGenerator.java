package anagramgenerator.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe de domínio responsável por gerar todos os anagramas possíveis de uma
 * sequência de letras distintas.
 */
public class AnagramGenerator {

	/**
	 * Gera todos os anagramas possíveis da string de entrada.
	 *
	 * @param input String com letras distintas para gerar anagramas.
	 * @return Lista contendo todas as permutações únicas da entrada.
	 */
	public static List<String> generate(String input) {
		Set<String> result = new HashSet<>();
		permute("", input, result);
		return new ArrayList<>(result);
	}

	/**
	 * Gera todas as permutações possíveis de uma string (anagramas), de forma
	 * recursiva.
	 * 
	 * A cada chamada, uma letra é fixada no prefixo e removida da parte restante.
	 * Quando não restarem letras, a combinação está completa e é adicionada ao
	 * conjunto de resultados.
	 * 
	 * O uso de um Set garante que os anagramas gerados sejam únicos.
	 *
	 * @param prefix    Parte já formada do anagrama
	 * @param remaining Letras restantes que ainda não foram usadas
	 * @param result    Conjunto onde os anagramas gerados são armazenados (sem
	 *                  duplicatas)
	 */
	private static void permute(String prefix, String remaining, Set<String> result) {
		// Verifica quantas letras ainda faltam combinar
		int n = remaining.length();

		// Caso base da recursão: se não há mais letras restantes, adiciona o anagrama
		// ao conjunto
		if (n == 0) {
			result.add(prefix);
		} else {
			// Itera sobre cada letra restante
			for (int i = 0; i < n; i++) {
				// Constrói o novo prefixo com a letra atual
				String newPrefix = prefix + remaining.charAt(i);

				// Remove a letra atual da sequência restante
				String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

				// Chama recursivamente com os novos valores
				permute(newPrefix, newRemaining, result);
			}
		}
	}
}
