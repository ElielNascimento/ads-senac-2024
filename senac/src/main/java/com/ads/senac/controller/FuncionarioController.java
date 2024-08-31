package com.ads.senac.controller;

import com.ads.senac.model.Funcionario;
import com.ads.senac.model.Pessoa;
import com.ads.senac.service.FuncionarioService;
import com.ads.senac.service.PessoaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.findById(id);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        if (funcionario.getPessoa() != null && funcionario.getPessoa().getId() != null) {
            Optional<Pessoa> pessoa = pessoaService.findById(funcionario.getPessoa().getId());
            if (pessoa.isPresent()) {
                funcionario.setPessoa(pessoa.get());
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        }
        return ResponseEntity.ok(funcionarioService.save(funcionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if (funcionarioService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (funcionario.getPessoa() != null && funcionario.getPessoa().getId() != null) {
            Optional<Pessoa> pessoa = pessoaService.findById(funcionario.getPessoa().getId());
            if (pessoa.isPresent()) {
                funcionario.setPessoa(pessoa.get());
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        }
        funcionario.setId(id);
        return ResponseEntity.ok(funcionarioService.save(funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        if (funcionarioService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
