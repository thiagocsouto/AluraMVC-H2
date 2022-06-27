package br.com.alura.mvc.mudi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.service.PedidoService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestPedido {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Test
	void testeParaVerfifcarOSalvarPedido() { 
		Pedido pedido = new Pedido("Samsung A02s", BigDecimal.valueOf(135.69), LocalDate.parse("2022-04-26"), "https://www.amazon.com.br", "https://www.amazon.com.br/imagem", "Celular lacrado", StatusPedido.AGUARDANDO);
		Pedido pedidoSave = pedidoRepository.save(pedido);
		
		assertNotNull(pedidoSave);
	} 
	


	@Test
	void testeParaValidarPedido() throws Exception{ 
		PedidoService pedidoService = new PedidoService();
		Pedido pedido = new Pedido("Samsung A02s", BigDecimal.valueOf(135.69), LocalDate.parse("2022-04-26"), null, "https://www.amazon.com.br/imagem", "Celular lacrado", StatusPedido.AGUARDANDO);
		Exception exception = assertThrows(Exception.class, () -> pedidoService.salvarPedido(pedido));  
				 
	    assertEquals("Nome não pode está branco", exception.getMessage());  
	} 
 
}
