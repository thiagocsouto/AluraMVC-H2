package br.com.alura.mvc.mudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido salvarPedido(Pedido pedido) { 
		
//		if (pedido.getNomeProduto().length() == null) 
//			throw new IllegalArgumentException("Nome não pode está branco");

		 
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> listarPedidos(Pedido pedido){
		return pedidoRepository.findAll();
	}
	
	public List<Pedido> listarStatus(StatusPedido status){
		return pedidoRepository.findByStatus(status);
	}  

}
 