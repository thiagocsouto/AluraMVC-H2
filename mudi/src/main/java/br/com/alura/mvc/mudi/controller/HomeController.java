package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.service.PedidoService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoService pedidoService;
    
	@GetMapping
	public String home(Model model, Pedido pedido) {		
		List<Pedido> pedidos = pedidoService.listarPedidos(pedido);
		model.addAttribute("pedidos", pedidos);
		return "home"; 
	}  
	
	@GetMapping("/{status}")
	public String status(@PathVariable("status") String status, Model model) {		
		List<Pedido> pedidos = pedidoService.listarStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home"; 
	}
	
	public String onError() {
		return "redirect:/home"; 
	}
	 
}
