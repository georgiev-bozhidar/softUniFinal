package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Chain;

import java.util.Optional;
import java.util.Set;

public interface ChainService {
    public Optional<Chain> findByName(String name);
    public Optional<Chain> getById(Long id);
    public void createChain(CreateChainDTO createChainDTO);

    void deleteChainById(Long id);

    Set<Chain> getAllChains();

    Optional<Chain> getByName(String name);
}
