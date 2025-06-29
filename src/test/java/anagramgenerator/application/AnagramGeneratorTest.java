package anagramgenerator.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para o caso de uso de geração de anagramas.
 */
@DisplayName("Testes do caso de uso: Geração de Anagramas")
public class AnagramGeneratorTest {

	private final GenerateAnagramUseCase useCase = new GenerateAnagramUseCase();

	@Test
	@DisplayName("Gera todos os anagramas possíveis de uma string de três letras")
	public void testValidThreeLetterInput() {
		List<String> result = useCase.execute("abc");
		assertEquals(6, result.size());
		assertTrue(result.contains("abc"));
		assertTrue(result.contains("cba"));
	}

	@Test
	@DisplayName("Gera anagramas com letras maiúsculas")
	public void testValidUppercaseInput() {
		List<String> result = useCase.execute("XYZ");
		assertEquals(6, result.size());
		assertTrue(result.contains("XYZ"));
		assertTrue(result.contains("ZYX"));
	}

	@Test
	@DisplayName("Gera dois anagramas a partir de duas letras")
	public void testTwoLetterInput() {
		List<String> result = useCase.execute("ab");
		assertEquals(2, result.size());
		assertTrue(result.contains("ab"));
		assertTrue(result.contains("ba"));
	}

	@Test
	@DisplayName("Lança exceção ao receber apenas uma letra")
	public void testSingleLetterShouldThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			useCase.execute("x");
		});
		assertEquals("A entrada deve conter pelo menos duas letras", exception.getMessage());
	}

	@Test
	@DisplayName("Lança exceção ao receber entrada vazia")
	public void testEmptyInputShouldThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			useCase.execute("");
		});
		assertEquals("A entrada não pode ser vazia ou nula", exception.getMessage());
	}

	@Test
	@DisplayName("Lança exceção ao receber entrada nula")
	public void testNullInputShouldThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			useCase.execute(null);
		});
		assertEquals("A entrada não pode ser vazia ou nula", exception.getMessage());
	}

	@Test
	@DisplayName("Lança exceção ao receber caracteres não alfabéticos")
	public void testInvalidCharactersShouldThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			useCase.execute("a1b");
		});
		assertEquals("A entrada deve conter apenas letras", exception.getMessage());
	}

	@Test
	@DisplayName("Lança exceção ao receber apenas espaços em branco")
	public void testWhitespaceOnlyShouldThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			useCase.execute("   ");
		});
		assertEquals("A entrada não pode ser vazia ou nula", exception.getMessage());
	}

	@Test
	@DisplayName("Lança exceção ao receber letras repetidas em minúsculas")
	public void testDuplicateLowercaseLettersShouldThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			useCase.execute("aab");
		});
		assertEquals("A entrada deve conter apenas letras distintas (sem repetições)", exception.getMessage());
	}

	@Test
	@DisplayName("Lança exceção ao receber letras repetidas em maiúsculas")
	public void testDuplicateUppercaseLettersShouldThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			useCase.execute("AAB");
		});
		assertEquals("A entrada deve conter apenas letras distintas (sem repetições)", exception.getMessage());
	}
}
