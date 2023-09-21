package br.com.alura.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVO {

	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataDaUltimaVenda;

	public RelatorioDeVendasVO(String nomeProduto, Long quantidadeVendida, LocalDate dataDaUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataDaUltimaVenda = dataDaUltimaVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getDataDaUltimaVenda() {
		return dataDaUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVO [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataDaUltimaVenda=" + dataDaUltimaVenda + "]";
	}

}
