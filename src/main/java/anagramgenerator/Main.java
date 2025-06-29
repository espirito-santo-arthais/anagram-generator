package anagramgenerator;

import anagramgenerator.application.GenerateAnagramUseCase;

import java.util.List;

/**
 * Classe principal que atua como ponto de entrada da aplicação.
 * 
 * Esta classe recebe a entrada do usuário via argumentos de linha de comando e
 * delega a geração de anagramas para a camada de aplicação.
 */
public class Main {

	/**
	 * Método principal (entry point) da aplicação.
	 *
	 * @param args Argumentos passados via linha de comando. Espera-se que o
	 *             primeiro argumento seja uma string de letras distintas.
	 */
	public static void main(String[] args) {
		// Recupera a entrada do primeiro argumento ou usa string vazia como fallback
		String input = args.length > 0 ? args[0] : "";

		// Instancia o caso de uso responsável por gerar os anagramas
		GenerateAnagramUseCase useCase = new GenerateAnagramUseCase();

		// Executa o caso de uso com a entrada fornecida
		List<String> anagrams = useCase.execute(input);

		// Exibe os anagramas gerados
		anagrams.forEach(System.out::println);
	}
}
