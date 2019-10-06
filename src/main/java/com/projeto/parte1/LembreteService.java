package com.projeto.parte1;

import com.projeto.parte1.data.Lembrete;
import com.projeto.parte1.repositorys.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lr;

    public Lembrete find(Long id) {
        Optional<Lembrete> obj = lr.findById(id);
        return obj.orElse(null);
    }

    public Lembrete insert(Lembrete obj){
        return lr.save(obj);
    }

    public List<Lembrete> findAll(){
        return lr.findAll();
    }

    public Lembrete update(Lembrete obj){
        Lembrete novo = find(obj.getId());
        updateData(novo,obj);
        return lr.save(novo);
    }

    public void updateData(Lembrete novo, Lembrete obj){
        novo.setNome(obj.getNome());
        novo.setDesc(obj.getDesc());
    }

    public void delete(Long id){
        find(id);
        lr.deleteById(id);
    }
}
