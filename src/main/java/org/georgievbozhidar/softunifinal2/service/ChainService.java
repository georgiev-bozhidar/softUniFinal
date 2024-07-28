package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.ChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.UserDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Chain;
import org.georgievbozhidar.softunifinal2.entity.model.Location;

import java.util.Set;

public interface ChainService {
    public Chain findByName(String name);
    public Chain findByOwner(UserDTO owner);
    public ChainDTO getById(Long id);
    public ChainDTO getByName(String name);
    public ChainDTO getByOwner(UserDTO owner);
    public Set<ChainDTO> getAllChains();

    public ChainDTO createChain(CreateChainDTO createChainDTO, String username);
//    public ChainDTO createChain(CreateChainDTO createChainDTO);

    public ChainDTO updateChain(Long id, UpdateChainDTO updateChainDTO);

    public void deleteChain(Long id);

    public ChainDTO addLocation(Location location, Chain chain);
}
