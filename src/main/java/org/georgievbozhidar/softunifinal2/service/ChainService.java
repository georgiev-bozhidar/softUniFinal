package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Chain;
import org.georgievbozhidar.softunifinal2.entity.model.Location;
import org.georgievbozhidar.softunifinal2.entity.model.User;

import java.util.Optional;
import java.util.Set;

public interface ChainService {
    public Optional<Chain> findByName(String name);
    public Optional<Chain> getById(Long id);
    public Chain createChain(CreateChainDTO createChainDTO, String owner);
    public void addLocationToChain(Location location, Chain chain);

    void deleteChainById(Long id);

    Set<Chain> getAllChains();

    Optional<Chain> getByName(String name);
}
