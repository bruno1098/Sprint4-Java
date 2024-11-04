package com.analyzer.controller;

import com.analyzer.model.Cliente;
import com.analyzer.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes/clientes";
    }

    @GetMapping("/clientes/novo")
    public String novoClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/novo";
    }

    @PostMapping("/clientes")
    public String salvarCliente(Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editarClienteForm(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id)));
        return "clientes/editar";
    }

    @PostMapping("/clientes/editar/{id}")
    public String atualizarCliente(@PathVariable Long id, Cliente cliente) {
        cliente.setId(id);
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletarPorId(id);
        return "redirect:/clientes";
    }
}
