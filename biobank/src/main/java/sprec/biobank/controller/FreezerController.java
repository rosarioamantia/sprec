package sprec.biobank.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sprec.biobank.domain.Freezer;
import sprec.biobank.service.FreezerService;

@Controller
@RequestMapping("/freezer")
public class FreezerController {
	
	@Autowired
	private FreezerService freezerService;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Freezer> getAllFreezers() {
		return freezerService.getAllFreezers();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<Freezer> getFreezerById(@PathVariable int id) {
		return freezerService.getFreezerById(id);
	}
	
	@PostMapping("")
	public @ResponseBody Freezer insertFreezer(@Valid @RequestBody Freezer freezer) {
		return freezerService.addFreezer(freezer);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody String insertFreezer(@Valid @PathVariable int id) {
		return freezerService.deleteFreezer(id);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody String updateFreezer(@PathVariable int id, @Valid @RequestBody Freezer newFreezer) {
		return freezerService.updateFreezer(id, newFreezer);
	}	
	
}

