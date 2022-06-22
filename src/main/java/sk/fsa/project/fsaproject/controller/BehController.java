package sk.fsa.project.fsaproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.fsa.project.fsaproject.exception.ResourceNotFoundException;
import sk.fsa.project.fsaproject.model.Beh;
import sk.fsa.project.fsaproject.repository.BehRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class BehController {

    @Autowired
    private BehRepository behRepository;

    // get beh
    @GetMapping("/beh")
    public List<Beh> getAllBeh(){
        return this.behRepository.findAll();
    }

    // get beh by id
    @GetMapping("/beh/{id}")
    public ResponseEntity<Beh> getBehById(@PathVariable(value = "id") Long behId)
            throws ResourceNotFoundException {
        Beh beh = behRepository.findById(behId)
                .orElseThrow(() -> new ResourceNotFoundException("Beh not found for id: " + behId));
        return ResponseEntity.ok().body(beh);

    }

    // save beh
    @PostMapping("/beh")
    public Beh createBeh(@RequestBody Beh beh) {

        return this.behRepository.save(beh);
    }

    // update beh
    @PutMapping("/beh/{id}")
    public ResponseEntity<Beh> updateBeh(@PathVariable(value = "id") Long behId,
                                                 @RequestBody Beh behDetails) throws ResourceNotFoundException {
        Beh beh = behRepository.findById(behId)
                .orElseThrow(() -> new ResourceNotFoundException("Beh not found for id: " + behId));

        beh.setNazov(behDetails.getNazov());
        beh.setDatum(behDetails.getDatum());
        beh.setKapacita(behDetails.getKapacita());
        beh.setPrihlaseni(behDetails.getPrihlaseni());
        beh.setZakladnaCenaBehu(behDetails.getZakladnaCenaBehu());

        return ResponseEntity.ok(this.behRepository.save(beh));
    }

    // delete beh
    @DeleteMapping("/beh/{id}")
    public Map<String, Boolean> deleteBeh(@PathVariable(value = "id") Long behId)
            throws ResourceNotFoundException {
        Beh beh = behRepository.findById(behId)
                .orElseThrow(() -> new ResourceNotFoundException("Beh not found for id: " + behId));

        behRepository.delete(beh);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
