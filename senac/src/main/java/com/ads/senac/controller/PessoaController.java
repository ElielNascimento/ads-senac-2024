package com.ads.senac.controller;

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
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Pessoa> getAllPessoas() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        if (pessoaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(id);
        return ResponseEntity.ok(pessoaService.save(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if (pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (funcionarioService.existsByPessoa(pessoa.get())) {
            return ResponseEntity.badRequest().body(null);
        }
        pessoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
