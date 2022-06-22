package sk.fsa.project.fsaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.fsa.project.fsaproject.exception.ResourceNotFoundException;
import sk.fsa.project.fsaproject.model.Prihlaska;
import sk.fsa.project.fsaproject.repository.PrihlaskaRepository
        ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PrihlaskaController {

    @Autowired
    private PrihlaskaRepository prihlaskaRepository;

    // get prihlaska
    @GetMapping("/prihlaska")
    public List<Prihlaska> getAllPrihlaska(){
        return this.prihlaskaRepository.findAll();
    }

    // get prihlaska by id
    @GetMapping("/prihlaska/{id}")
    public ResponseEntity<Prihlaska> getPrihlaskaById(@PathVariable(value = "id") Long prihlaskaId)
            throws ResourceNotFoundException {
        Prihlaska prihlaska = prihlaskaRepository.findById(prihlaskaId)
                .orElseThrow(() -> new ResourceNotFoundException("Prihlaska not found for id: " + prihlaskaId));
        return ResponseEntity.ok().body(prihlaska);
    }

    // save prihlaska
    @PostMapping("/prihlaska")
    public Prihlaska createPrihlaska(@RequestBody Prihlaska prihlaska) {
        return this.prihlaskaRepository.save(prihlaska);
    }

    // update prihlaska
    @PutMapping("/prihlaska/{id}")
    public ResponseEntity<Prihlaska> updatePrihlaska(@PathVariable(value = "id") Long prihlaskaId,
                                                 @RequestBody Prihlaska prihlaskaDetails) throws ResourceNotFoundException {
        Prihlaska prihlaska = prihlaskaRepository.findById(prihlaskaId)
                .orElseThrow(() -> new ResourceNotFoundException("Prihlaska not found for id: " + prihlaskaId));

        return ResponseEntity.ok(this.prihlaskaRepository.save(prihlaska));
    }

    // delete prihlaska
    @DeleteMapping("/prihlaska/{id}")
    public Map<String, Boolean> deletePrihlaska(@PathVariable(value = "id") Long prihlaskaId)
            throws ResourceNotFoundException {
        Prihlaska prihlaska = prihlaskaRepository.findById(prihlaskaId)
                .orElseThrow(() -> new ResourceNotFoundException("Prihlaska not found for id: " + prihlaskaId));

        prihlaskaRepository.delete(prihlaska);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
