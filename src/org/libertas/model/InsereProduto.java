package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.model.dao.ProdutoDao;
import org.libertas.model.pojo.Produto;

public class InsereProduto implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			if (request.getParameter("idProduto")==null) {
				return "idProduto é obrigatório!!!";
			}
			
			if (request.getParameter("descricao")==null) {
				return "Descrição é obrigatório!!!";
			}
			
			Produto p = new Produto();
			p.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));
			p.setDescricao(request.getParameter("descricao"));
			p.setMarca(request.getParameter("marca"));
			p.setCusto(Double.parseDouble(request.getParameter("custo")));
			p.setVenda(Double.parseDouble(request.getParameter("venda")));
			p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			
			ProdutoDao pdao = new ProdutoDao();
			pdao.inserir(p);
			return "Produto inserido com sucesso!!!";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
