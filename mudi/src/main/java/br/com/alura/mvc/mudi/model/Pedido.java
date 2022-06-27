package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pedido")
@Data
@AllArgsConstructor
public class Pedido {
	
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column(name="nome")
	private String nomeProduto;
	
	@Column(name="valor")
	private BigDecimal valorNegociado;
	
	@Column(name="data_entrega")
	private LocalDate dataDaEntrega;
	
	@Column(name="url_produto")
	private String urlProduto;
	
	@Column(name="url_imagem")
	private String urlImagem;
	
	@Column(name="descrição")
	private String descricao;
	
	@Column(name="status") 
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	

	public Pedido( String nomeProduto, BigDecimal valorNegociado, LocalDate dataDaEntrega, String urlProduto,
			String urlImagem, String descricao, StatusPedido status) {
		this.nomeProduto = nomeProduto;
		this.valorNegociado = valorNegociado;
		this.dataDaEntrega = dataDaEntrega;
		this.urlProduto = urlProduto;
		this.urlImagem = urlImagem;
		this.descricao = descricao;
		this.status = status;
	}

	public Pedido() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	
	

}
