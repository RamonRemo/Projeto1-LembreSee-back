package com.projeto.parte1.controllers;

import com.projeto.parte1.LembreteService;
import com.projeto.parte1.data.Lembrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/")
public class LembreteController {

    @Autowired
    private LembreteService ls;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Lembrete>> findAll() {
        List<Lembrete> list = ls.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Lembrete lembrete){
        Lembrete novoLembrete = new Lembrete(null,lembrete.getNome(),lembrete.getDesc());
        System.out.println(novoLembrete.getId());
        novoLembrete = ls.insert(novoLembrete);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Lembrete lembrete, @PathVariable Long id) {
        Lembrete novoLembrete = new Lembrete(id,lembrete.getNome(),lembrete.getDesc());
        ls.update(novoLembrete);
        return ResponseEntity.ok().build();

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ls.delete(id);
        return ResponseEntity.noContent().build();
    }
}
