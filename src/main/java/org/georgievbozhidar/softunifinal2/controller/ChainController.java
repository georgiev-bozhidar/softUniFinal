package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Chain;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/chain")
public class ChainController {
    private final ChainService chainService;

    public ChainController(ChainService chainService) {
        this.chainService = chainService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chain> getChain(@PathVariable Long id) {
        Optional<Chain> optChain = chainService.getById(id);
        if (optChain.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optChain.get(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Chain>> getAllChains() {
        Set<Chain> chains = chainService.getAllChains();
        return new ResponseEntity<>(chains, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chain> createChain(@RequestBody @Valid CreateChainDTO createChainDTO){
        chainService.createChain(createChainDTO);
        return new ResponseEntity<>(chainService.getByName(createChainDTO.getName()).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChain(@PathVariable Long id) {
        Optional<Chain> optChain = chainService.getById(id);
        if (optChain.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        chainService.deleteChainById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
