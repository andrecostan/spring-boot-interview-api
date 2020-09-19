package io.github.andrecostan.springbootinterviewapi.service.impl;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cidade;
import io.github.andrecostan.springbootinterviewapi.domain.repository.CidadeRepository;
import io.github.andrecostan.springbootinterviewapi.helper.CidadeHelper;
import io.github.andrecostan.springbootinterviewapi.rest.dto.request.CidadeRequest;
import io.github.andrecostan.springbootinterviewapi.service.CidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeServiceImpl implements CidadeService {

    private static final Logger log = LoggerFactory.getLogger(CidadeServiceImpl.class);

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public Optional<Cidade> buscarPorId(Integer id) {
        log.info("Buscando cidade para o id: {}", id);
        return cidadeRepository.findById(id);
    }

    @Override
    public List<Cidade> buscarPorNome(String nome) {
        log.info("Buscando cidade(s) para o nome: {}", nome);
        return cidadeRepository.findAllByNome(nome);
    }

    @Override
    public Optional<Cidade> salvar(CidadeRequest cidadeRequest) {
        log.info("Salvando cidade: {}", cidadeRequest);

        Optional<Cidade> cidade = cidadeRepository.findByNomeAndAndEstado(cidadeRequest.getNome(), cidadeRequest.getEstado());

        if(cidade.isPresent()){
            return cidade;
        }

        return Optional.ofNullable(cidadeRepository.save(CidadeHelper.converterDtoParaCidade(cidadeRequest)));
    }

    @Override
    public List<Cidade> buscarPorEstado(String nome) {
        log.info("Buscando cidade(s) para o estado: {}", nome);
        return cidadeRepository.buscarPorEstado(nome);
    }

}
