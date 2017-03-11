package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ITarefa {
	
	String executa(HttpServletRequest req, HttpServletResponse respo);
	
}
