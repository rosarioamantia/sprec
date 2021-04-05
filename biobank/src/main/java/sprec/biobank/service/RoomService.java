package sprec.biobank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprec.biobank.domain.Biobank;
import sprec.biobank.domain.Room;
import sprec.biobank.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public Iterable<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	
	public Optional<Room> getRoomById(Integer id){
		return roomRepository.findById(id);
	}
	
	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}
	
	public String deleteRoom(Integer id) {
		Optional<Room> obj = getRoomById(id);
		if(obj.isPresent()) {		
			roomRepository.deleteById(id);
			return "deleted";
		}
		return "object not found!";
	}
	
	
	/*
	 * public String updateRoom(Integer id, Room newRoom){
		Optional<Room> room = roomRepository.findById(id);
		
		if(room.isPresent()) {
			Room r = room.get(); //conversione Optional<Room> in Room
			
			r.setName(newRoom.getName());
			r.setCreatedAt(newRoom.getCreatedAt());
			r.setDeletedAt(newRoom.getDeletedAt());
			r.setUpdatedAt(newRoom.getUpdateAt());
			roomRepository.save(r); //si salva perchè deve tornare nel db, se no abbiamo solo aggiornato i valori dell'oggetto
			return "elemento aggiornato";
		}
		return "elemento non trovato, aggiornamento non avvenuto";
	}
	*/
	
	/* versione con map */
	public String updateRoom(Integer id, Room newRoom) {
		return roomRepository.findById(id).map(room -> {
			room.setName(newRoom.getName());
			room.setCreatedAt(newRoom.getCreatedAt());
			room.setDeletedAt(newRoom.getDeletedAt());
			room.setUpdatedAt(newRoom.getUpdateAt());
			roomRepository.save(room);
			return "elemento aggiornato";
		}).orElseGet(() -> {
			return "elemento non trovato, aggiornamento non avvenuto";
		});
	}
	
}