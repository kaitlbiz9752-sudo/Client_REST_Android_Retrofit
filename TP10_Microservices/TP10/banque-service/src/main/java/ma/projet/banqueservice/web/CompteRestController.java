package ma.projet.banqueservice.web;

import ma.projet.banqueservice.entities.Compte;
import ma.projet.banqueservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque")
public class CompteRestController {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Object listComptes(@RequestHeader(value = "Accept", defaultValue = MediaType.APPLICATION_JSON_VALUE) String accept) {
        List<Compte> comptes = compteRepository.findAll();
        if (accept.contains(MediaType.APPLICATION_XML_VALUE)) {
            return new ma.projet.banqueservice.entities.CompteList(comptes);
        }
        return comptes;
    }

    @GetMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Compte getCompte(@PathVariable Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/comptes", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Compte save(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte update(@PathVariable Long id, @RequestBody Compte compte) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
