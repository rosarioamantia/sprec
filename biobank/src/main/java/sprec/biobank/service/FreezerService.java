package sprec.biobank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprec.biobank.domain.Biobank;
import sprec.biobank.domain.Freezer;
import sprec.biobank.repository.FreezerRepository;

@Service
public class FreezerService {
	
	@Autowired
	private FreezerRepository freezerRepository;
	
	public Iterable<Freezer> getAllFreezers() {
		return freezerRepository.findAll();
	}
	
	public Optional<Freezer> getFreezerById(Integer id){
		return freezerRepository.findById(id);
	}
	
	public Freezer addFreezer(Freezer freezer) {
		return freezerRepository.save(freezer);
	}
	
	public String deleteFreezer(Integer id) {
		Optional<Freezer> obj = getFreezerById(id);
		if(obj.isPresent()) {		
			freezerRepository.deleteById(id);
			return "deleted";
		}
		return "object not found!";
	}
	
	
	/*
	 * public String updateFreezer(Integer id, Freezer newFreezer){
		Optional<Freezer> freezer = freezerRepository.findById(id);
		
		if(freezer.isPresent()) {
			Freezer r = freezer.get(); //conversione Optional<Freezer> in Freezer
			
			r.setName(newFreezer.getName());
			r.setCreatedAt(newFreezer.getCreatedAt());
			r.setDeletedAt(newFreezer.getDeletedAt());
			r.setUpdatedAt(newFreezer.getUpdateAt());
			freezerRepository.save(r); //si salva perchè deve tornare nel db, se no abbiamo solo aggiornato i valori dell'oggetto
			return "elemento aggiornato";
		}
		return "elemento non trovato, aggiornamento non avvenuto";
	}
	*/
	
	/* versione con map */
	public String updateFreezer(Integer id, Freezer newFreezer) {
		return freezerRepository.findById(id).map(freezer -> {
			freezer.setName(newFreezer.getName());
			//freezer.setCreatedAt(newFreezer.getCreatedAt());
			//freezer.setDeletedAt(newFreezer.getDeletedAt());
			//freezer.setUpdatedAt(newFreezer.getUpdateAt());
			freezerRepository.save(freezer);
			return "elemento aggiornato";
		}).orElseGet(() -> {
			return "elemento non trovato, aggiornamento non avvenuto";
		});
	}
	
}
