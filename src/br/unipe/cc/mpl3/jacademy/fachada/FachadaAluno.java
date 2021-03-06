/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.mpl3.jacademy.fachada;

import br.unipe.cc.mpl3.jacademy.modelo.Aluno;
import br.unipe.cc.mpl3.jacademy.modelo.ServiceAluno;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author paulo
 */
public class FachadaAluno {

    public static List<Object> buscar(String busca){
        List<Object> lista = new ArrayList<>();
        for (Aluno aluno : ServiceAluno.listar(busca)) {
            lista.add(new Object[]{aluno.getMatricula(),aluno.getNome(), aluno.getCpf()});
        }
        return lista;
    }

    public static void gravar(Map<String, String> dados){//contem problemas
        Aluno aluno = new Aluno();

        aluno.setNome(dados.get("nome"));
        aluno.setCpf(dados.get("cpf"));
        aluno.setProfissao(dados.get("profissao"));
        aluno.setTelefone(dados.get("telefone"));
        aluno.setLogradouro(dados.get("logradouro"));
        aluno.setBairro(dados.get("bairro"));
        aluno.setCep(dados.get("cep"));
        aluno.setEstado(dados.get("estado"));
        aluno.setCidade(dados.get("cidade"));
        aluno.setEmail(dados.get("email"));
        aluno.setObservacao(dados.get("observacao"));

        System.out.println(dados.get("matricula"));
        
        if (dados.get("matricula").isEmpty()){
            ServiceAluno.insert(aluno);
        } else {
            aluno.setMatricula(Integer.parseInt(dados.get("matricula")));
            ServiceAluno.update(aluno);
        }
    }

    public static Map<String, String> carregar(String matricula){
        Aluno aluno = ServiceAluno.get(matricula);
        Map<String, String> map = new HashMap<>();

        map.put("matricula", String.valueOf(aluno.getMatricula()));
        map.put("nome", aluno.getNome());
        map.put("cpf", aluno.getCpf());
        map.put("telefone", aluno.getTelefone());
        map.put("logradouro", aluno.getLogradouro());
        map.put("bairro", aluno.getBairro());
        map.put("cep", aluno.getCep());
        map.put("estado", aluno.getEstado());
        map.put("cidade", aluno.getCidade());
        map.put("email", aluno.getEmail());
        map.put("observacao", aluno.getObservacao());

        return map;
    }

    public static void deletar(String matricula){
        ServiceAluno.remove(matricula);
    }
}
