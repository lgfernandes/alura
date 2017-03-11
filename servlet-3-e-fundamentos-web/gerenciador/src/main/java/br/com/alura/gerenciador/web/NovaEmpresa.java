package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

/**
 * @author Leandro
 * @date 28-02-2017
 */

public class NovaEmpresa implements ITarefa{
	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		
		req.setAttribute("empresa", empresa);
		req.setAttribute("nome", nome);
		
		return "WEB-INF/paginas/novaEmpresa.jsp";
	}
	
	

}
