package sk.fsa.project.fsaproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.fsa.project.fsaproject.exception.ResourceNotFoundException;
import sk.fsa.project.fsaproject.model.Tim;
import sk.fsa.project.fsaproject.repository.TimRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class TimController {

    @Autowired
    private TimRepository timRepository;

    // get tim
    @GetMapping("/tim")
    public List<Tim> getAllTim(){
        return this.timRepository.findAll();
    }

    // get tim by id
    @GetMapping("/tim/{id}")
    public ResponseEntity<Tim> getTimById(@PathVariable(value = "id") Long timId)
            throws ResourceNotFoundException {
        Tim tim = timRepository.findById(timId)
                .orElseThrow(() -> new ResourceNotFoundException("Tim not found for id: " + timId));
        return ResponseEntity.ok().body(tim);

    }

    // save tim
    @PostMapping("/tim")
    public Tim createTim(@RequestBody Tim tim) {
        return this.timRepository.save(tim);
    }

    // update tim
    @PutMapping("/tim/{id}")
    public ResponseEntity<Tim> updateTim(@PathVariable(value = "id") Long timId,
                                                 @RequestBody Tim timDetails) throws ResourceNotFoundException {
        Tim tim = timRepository.findById(timId)
                .orElseThrow(() -> new ResourceNotFoundException("Tim not found for id: " + timId));

        return ResponseEntity.ok(this.timRepository.save(tim));
    }

    // delete tim
    @DeleteMapping("/tim/{id}")
    public Map<String, Boolean> deleteTim(@PathVariable(value = "id") Long timId)
            throws ResourceNotFoundException {
        Tim tim = timRepository.findById(timId)
                .orElseThrow(() -> new ResourceNotFoundException("Tim not found for id: " + timId));

        timRepository.delete(tim);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    // login
    @PostMapping("/tim/login")
    public Tim getUsers(@RequestBody() Tim tim) throws ResourceNotFoundException{

        //https://jwt.io/#debugger-io?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiSm9obiBEb2UiLCJ1c2VybmFtZSI6ImpvaG5kb2UiLCJyb2xlIjoiQURNSU4ifQ.nukEqK0IjJr1cmzhHe7nqbi-B6_LtCKbJ3ZocWkcVhI
//        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiSm9obiBEb2UiLCJ1c2VybmFtZSI6ImpvaG5kb2UiLCJyb2xlIjoiQURNSU4ifQ.nukEqK0IjJr1cmzhHe7nqbi-B6_LtCKbJ3ZocWkcVhI";
        List<Tim> teams = this.timRepository.findByNazov(tim.getNazov());
        if (teams.isEmpty()) throw new ResourceNotFoundException("Tim not found for id: " + tim.getId());
        Tim loginTim = teams.get(0);
        if (tim.getHeslo().equals(loginTim.getHeslo())) return loginTim;

        return null;
    }
}
