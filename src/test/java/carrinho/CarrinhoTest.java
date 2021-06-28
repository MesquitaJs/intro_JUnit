package carrinho;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;


public class CarrinhoTest {

	private Carrinho cart;
	Produto item1;
    Produto item2;
    Produto item3;
	
	@BeforeEach
	public void inicializa() {
		cart = new Carrinho();
		
		item1 = new Produto("PlayStation 4", 2000.00);
		item2 = new Produto("PlayStation 5", 7000.00);
		item3 = new Produto("Xbox One", 2000.00);
		
		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);				
	}
	
	@DisplayName("Testa recuperar a quantidade de itens no carrinho (tamanho do carrinho )")
	@Test
	public void testTamanhoCarrinho() {		
		int cartSize = cart.getQtdeItems();		
		assertEquals(cartSize, 3);		
	}
	
	@DisplayName("Testa valor total de produtos no carrinho")
	@Test
	public void testValorTotal() {
		double total = cart.getValorTotal();		
		Assertions.assertEquals(11000.00, total);	
	}
		
	@DisplayName("Testa adicionar item no carrinho")
	@Test
	public void testAddItem() {
		Produto item4 = new Produto("Xbox Series X", 7000.00);		
		cart.addItem(item4);		
		assertEquals(cart.getQtdeItems(), 4);		
	}
	
	@DisplayName("Testa remover item no carrinho")
	@Test
	public void testRemoverItem() {	
		try {
			cart.removeItem(item3);
			assertEquals(cart.getQtdeItems(), 2);			
		} catch (ProdutoNaoEncontradoException e) {
			assertTrue(e instanceof ProdutoNaoEncontradoException);
		}		
	}
	
	@DisplayName("Testa esvaziar o carrinho")
	@Test
	public void testEsvaziarCarrinho() {
		cart.esvazia();
		assertEquals(cart.getQtdeItems(), 0);		
	}

}
