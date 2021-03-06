package com.estudandoemcasa.cursomg.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudandoemcasa.cursomg.domain.Pedido;
import com.estudandoemcasa.cursomg.services.PedidoService;
/*
 * Controladore REST
 */
@RestController
@RequestMapping(value = "/pedidos")// <- endpoint rest
public class PedidoResource {
	
	@Autowired
	private PedidoService servico;

	@RequestMapping(value="/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {

		Pedido obj = servico.find(id);
		return ResponseEntity.ok().body(obj);
	}	
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
