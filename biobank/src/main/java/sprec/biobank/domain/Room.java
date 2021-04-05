package sprec.biobank.domain;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="room")
public class Room {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@NotNull
	@Size(max=255)
	private String name;
	
	/*
	1) inserire timestamp, capire come impostarli ecc.
	*/
	
	private String createdAt;
	
	private String updatedAt;
	
	private String deletedAt;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
}
