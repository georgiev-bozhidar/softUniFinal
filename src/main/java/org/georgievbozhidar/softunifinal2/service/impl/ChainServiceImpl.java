package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Chain;
import org.georgievbozhidar.softunifinal2.entity.model.Location;
import org.georgievbozhidar.softunifinal2.repository.ChainRepository;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ChainServiceImpl implements ChainService {
    private final ChainRepository chainRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public ChainServiceImpl(ChainRepository chainRepository, ModelMapper modelMapper, UserService userService) {
        this.chainRepository = chainRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    public Optional<Chain> getById(Long id){
        return chainRepository.findById(id);
    }

    @Override
    public Optional<Chain> findByName(String name) {
        return chainRepository.findByName(name);
    }

    public Chain createChain(CreateChainDTO createChainDTO, String owner){
        Chain chain = modelMapper.map(createChainDTO, Chain.class);
        chain.setOwner(userService.findByUsername(owner));
        chainRepository.save(chain);
        return chain;
    }

    @Override
    public void deleteChainById(Long id) {
        Optional<Chain> optChain = chainRepository.findById(id);
        if (optChain.isEmpty()){
            return;
        }

        Chain chain = optChain.get();
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

    @Override
    public void addLocationToChain(Location location, Chain chain) {
        chain.addLocation(location);
    }
}
