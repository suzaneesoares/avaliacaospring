package com.projetoLoginSuzane.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.projetoLoginSuzane.entity.Produtos;
import com.projetoLoginSuzane.repository.ProdutosRepository;

@Service
public class ProdutosService {
	final private ProdutosRepository produtosRepository;

	public ProdutosService(ProdutosRepository produtosRepository) {
		this.produtosRepository = produtosRepository;
	}

	public List<Produtos> buscarTodosProdutos() {
		return produtosRepository.findAll();
	}

	public Produtos buscarProdutosPorId(Long id) {
		Optional<Produtos> produto = produtosRepository.findById(id);
		return produto.orElse(null);
	}

	public Produtos salvarProdutos(Produtos atProdutos) {
		return produtosRepository.save(atProdutos);
	}

	public Produtos alterarProdutos(Long id, Produtos alterarP) {
		Optional<Produtos> existeProduto = produtosRepository.findById(id);
		if (existeProduto.isPresent()) {
			Produtos produtos = existeProduto.get();
			BeanUtils.copyProperties(alterarP, produtos, "id");
			return produtosRepository.save(produtos);
		}
		return null;
	}

	public Boolean apagarProduto(Long id) {
		Optional<Produtos> exeProdutos = produtosRepository.findById(id);
		if (exeProdutos.isPresent()) {
			produtosRepository.deleteById(id);
			return true;
		}
		return false;
	}
}