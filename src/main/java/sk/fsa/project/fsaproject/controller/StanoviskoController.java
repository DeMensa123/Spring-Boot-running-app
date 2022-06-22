package sk.fsa.project.fsaproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.fsa.project.fsaproject.exception.ResourceNotFoundException;
import sk.fsa.project.fsaproject.model.Stanovisko;
import sk.fsa.project.fsaproject.repository.StanoviskoRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StanoviskoController {

    @Autowired
    private StanoviskoRepository stanoviskoRepository;

    // get stanovisko
    @GetMapping("/stanovisko")
    public List<Stanovisko> getAllStanovisko(){
        return this.stanoviskoRepository.findAll();

    }

    // get stanovisko by id
    @GetMapping("/stanovisko/{id}")
    public ResponseEntity<Stanovisko> getStanoviskoById(@PathVariable(value = "id") Long stanoviskoId)
            throws ResourceNotFoundException {
        Stanovisko stanovisko = stanoviskoRepository.findById(stanoviskoId)
                .orElseThrow(() -> new ResourceNotFoundException("Stanovisko not found for id: " + stanoviskoId));
        return ResponseEntity.ok().body(stanovisko);
    }

    // save stanovisko
    @Transactional
    @PostMapping("/stanovisko")
    public Stanovisko createStanovisko(@RequestBody Stanovisko stanovisko) {
        return this.stanoviskoRepository.save(stanovisko);
    }

    // update stanovisko
    @PutMapping("/stanovisko/{id}")
    public ResponseEntity<Stanovisko> updateStanovisko(@PathVariable(value = "id") Long stanoviskoId,
                                          @RequestBody Stanovisko stanoviskoDetails) throws ResourceNotFoundException {
        Stanovisko stanovisko = stanoviskoRepository.findById(stanoviskoId)
                .orElseThrow(() -> new ResourceNotFoundException("Stanovisko not found for id: " + stanoviskoId));

        stanovisko.setLekar(stanoviskoDetails.isLekar());
        stanovisko.setObcerstvenie(stanoviskoDetails.isObcerstvenie());

        return ResponseEntity.ok(this.stanoviskoRepository.save(stanovisko));
    }

    // delete stanovisko
    @DeleteMapping("/stanovisko/{id}")
    public Map<String, Boolean> deleteStanovisko(@PathVariable(value = "id") Long stanoviskoId)
            throws ResourceNotFoundException {
        Stanovisko stanovisko = stanoviskoRepository.findById(stanoviskoId)
                .orElseThrow(() -> new ResourceNotFoundException("Stanovisko not found for id: " + stanoviskoId));

        stanoviskoRepository.delete(stanovisko);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
