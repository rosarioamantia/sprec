package sprec.biobank.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="freezer")
public class Freezer {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@NotNull 
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room roomId;
	

	//@NotNull
	@Size(max=255)
	private String name;
	/*
	private Integer parentId;
	
	/*
	 * json_details
	 * json_samples
	 
	
	private String createdAt;
		
	private String updatedAt;
		
	private String deletedAt;
	
	public Integer getId() {
		return id;
	}*/
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getUpdateAt() {
		return updatedAt;
	}
	
	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	public String getDeletedAt() {
		return deletedAt;
	}
	
	 */
	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}
	
	public Room getRoomId() {
		return roomId;
	}

}
