package calculadora;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@DisplayName("Inicializando classe para teste da calculadora")
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois numeros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa divisão de dois numeros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa divisão por zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			@SuppressWarnings("unused")
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa divisão por zero com Assert Throws")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a subtração de dois numeros")
	@Test
	public void testSubtracao() {
		int sub = calc.subtracao(5, 5);		
		Assertions.assertEquals(0, sub);		
	}
	
	@DisplayName("Testa a multiplicação de dois numeros")
	@Test
	public void testMultiplicacao() {
		int mult = calc.multiplicacao(5, 5);		
		Assertions.assertEquals(25, mult);		
	}
	
	@DisplayName("Testa a somatoria")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(100);		
		Assertions.assertEquals(5050, somatoria);		
	}
	
	@DisplayName("Testa se o numero é positivo") 
	@Test
	public void testNumeroPositivo() {
		boolean positivo = calc.ehPositivo(100);		
		assertTrue(positivo);
		//assertFalse(positivo); //Failures
		
	}
	
	@DisplayName("Testa se o numero é negativo") 
	@Test
	public void testNumeroNegativo() {
		boolean negativo = calc.ehPositivo(-100);		
		assertFalse(negativo);
		//assertTrue(negativo); //Failures
	}
	
	
	@DisplayName("Testa se nos numeros são iguais")
	@Test
	public void testComparaIguais() {
		int compara = calc.compara(100, 100);		
		Assertions.assertEquals(0, compara);	
	}
	
	@DisplayName("Testa se no numero é maior")
	@Test
	public void testComparaSeEhMaior() {
		int compara = calc.compara(100, 50);		
		Assertions.assertEquals(1, compara);	
	}


	@DisplayName("Testa se o numero é menor")
	@Test
	public void testComparaSeEhMenor() {
		int compara = calc.compara(50, 100);		
		Assertions.assertEquals(-1, compara);	
	}
}
