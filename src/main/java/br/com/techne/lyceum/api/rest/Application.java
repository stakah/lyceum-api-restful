package br.com.techne.lyceum.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@Configuration
//@ComponentScan(  basePackages = {"br.com.techne.lyceum.api.rest", "br.com.techne.lyceum.api.rest.beans"} )
@ComponentScan(basePackages = { "techne.lyceum", "techne.data", "techne.hades", "custom.lyceum", "techne.custom",
		"br.com.techne" })

@ImportResource("classpath*:**/techne.lyceum.bean.xml")
//@EntityScan(basePackages = { "techne.lyceum.nucleo.modelo", "techne.hades.nucleo.modelo", "techne.lyceum.nucleo.tabela",
//		"techne.lyceum.argyros.nucleo.tabela", "techne.hades.nucleo.tabela", "techne.lyceum.integracao.urania.tabela",
//		"custom.lyceum.nucleo.tabela" })
//@ContextConfiguration(locations = {"classpath*:/techne.lyceum.bean.xml"})
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}