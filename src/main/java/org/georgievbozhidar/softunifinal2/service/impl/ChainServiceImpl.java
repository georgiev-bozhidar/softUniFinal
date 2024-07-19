package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Chain;
import org.georgievbozhidar.softunifinal2.repository.ChainRepository;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ChainServiceImpl implements ChainService {
    private final ChainRepository chainRepository;
    private final ModelMapper modelMapper;

    public ChainServiceImpl(ChainRepository chainRepository, ModelMapper modelMapper) {
        this.chainRepository = chainRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<Chain> getById(Long id){
        return chainRepository.findById(id);
    }

    @Override
    public Optional<Chain> findByName(String name) {
        return chainRepository.findByName(name);
    }

    public void createChain(CreateChainDTO createChainDTO){
        Chain chain = modelMapper.map(createChainDTO, Chain.class);
        chainRepository.save(chain);
    }

    @Override
    public void deleteChainById(Long id) {
        Chain chain = chainRepository.findById(id).get();
        chainRepository.delete(chain);
    }

    @Override
    public Set<Chain> getAllChains() {
        return Set.copyOf(chainRepository.findAll());
    }

    @Override
    public Optional<Chain> getByName(String name) {
        return chainRepository.findByName(name);
    }
}
