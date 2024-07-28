package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.ChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.UserDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Chain;
import org.georgievbozhidar.softunifinal2.entity.model.Location;
import org.georgievbozhidar.softunifinal2.exception.ChainNotFoundException;
import org.georgievbozhidar.softunifinal2.repository.ChainRepository;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;
import java.util.Set;

@Service
public class ChainServiceImpl implements ChainService {
    private final ModelMapper modelMapper;
    private final RestClient restClient;
    private final UserService userService;
    private final ChainRepository chainRepository;

    public ChainServiceImpl(ModelMapper modelMapper, UserService userService, RestClient restClient, ChainRepository chainRepository) {
        this.modelMapper = modelMapper;
        this.restClient = restClient;
        this.userService = userService;
        this.chainRepository = chainRepository;
    }

    @Override
    public Chain findByName(String name) {
        Optional<Chain> optChain = chainRepository.findByName(name);
        if (optChain.isEmpty()){
            throw new ChainNotFoundException();
        }

        return optChain.get();
    }

    @Override
    public Chain findByOwner(UserDTO owner) {
        Optional<Chain> optChain = chainRepository.findByOwner(userService.findByUsername(owner.getUsername()));
        if (optChain.isEmpty()){
            throw new ChainNotFoundException();
        }
        return optChain.get();
    }

    @Override
    public ChainDTO getByName(String name) {
        Chain chain = this.findByName(name);
        return restClient.get().uri("/chain/{id}", chain.getId()).retrieve().body(ChainDTO.class);
    }

    @Override
    public ChainDTO getByOwner(UserDTO owner) {
        Chain chain = this.findByOwner(owner);
        return restClient.get().uri("/chain/{id}", chain.getId()).retrieve().body(ChainDTO.class);
    }

    public ChainDTO getById(Long id){
        return restClient.get().uri("/chain/{id}", id)
                .retrieve().body(ChainDTO.class);
    }

    @Override
    public ChainDTO createChain(CreateChainDTO createChainDTO, String username){
        createChainDTO.setOwner(userService.getByUsername(username));
        return restClient.post().uri("/chain")
                .body(createChainDTO)
                .retrieve().body(ChainDTO.class);
    }

    @Override
    public ChainDTO updateChain(Long id, UpdateChainDTO updateChainDTO) {
        return restClient.patch().uri("/chain/{id}", id).body(updateChainDTO).retrieve().body(ChainDTO.class);
    }

    @Override
    public void deleteChain(Long id) {
        restClient.delete().uri("/chain/{id}", id);
    }

    @Override
    public Set<ChainDTO> getAllChains() {
//        Set<ChainDTO> chainDTOs = restClient.get().uri("/chain/all").retrieve().body(); //TODO
        return null;
    }

    @Override
    public ChainDTO addLocation(Location location, Chain chain) {
//        Chain chain1 = this.findByName(chain.getName());
//        chain1.addLocation(location);
//        chainRepository.save(chain1);
//        return modelMapper.map(chain1, ChainDTO.class);
        // TODO
        return null;
    }
}
