package sk.fsa.project.fsaproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.fsa.project.fsaproject.exception.ResourceNotFoundException;
import sk.fsa.project.fsaproject.model.Stanica;
import sk.fsa.project.fsaproject.repository.StanicaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StanicaController {

    @Autowired
    private StanicaRepository stanicaRepository;

    // get stanica
    @GetMapping("/stanica")
    public List<Stanica> getAllStanica(){
        return this.stanicaRepository.findAll();
    }

    // get stanica by id
    @GetMapping("/stanica/{id}")
    public ResponseEntity<Stanica> getStanicaById(@PathVariable(value = "id") Long stanicaId)
            throws ResourceNotFoundException {
        Stanica stanica = stanicaRepository.findById(stanicaId)
                .orElseThrow(() -> new ResourceNotFoundException("Stanica not found for id: " + stanicaId));
        return ResponseEntity.ok().body(stanica);
    }

    // save stanica
    @PostMapping("/stanica")
    public Stanica createStanica(@RequestBody Stanica stanica) {
        return this.stanicaRepository.save(stanica);
    }

    // update stanica
    @PutMapping("/stanica/{id}")
    public ResponseEntity<Stanica> updateStanica(@PathVariable(value = "id") Long stanicaId,
                                          @RequestBody Stanica stanicaDetails) throws ResourceNotFoundException {
        Stanica stanica = stanicaRepository.findById(stanicaId)
                .orElseThrow(() -> new ResourceNotFoundException("Stanica not found for id: " + stanicaId));

        stanica.setNazov(stanicaDetails.getNazov());
        stanica.setVyska(stanicaDetails.getVyska());
        stanica.setZemDlzka(stanicaDetails.getZemDlzka());
        stanica.setZemSirka(stanicaDetails.getZemSirka());

        return ResponseEntity.ok(this.stanicaRepository.save(stanica));
    }

    // delete stanica
    @DeleteMapping("/stanica/{id}")
    public Map<String, Boolean> deleteStanica(@PathVariable(value = "id") Long stanicaId)
            throws ResourceNotFoundException {
        Stanica stanica = stanicaRepository.findById(stanicaId)
                .orElseThrow(() -> new ResourceNotFoundException("Stanica not found for id: " + stanicaId));

        stanicaRepository.delete(stanica);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
