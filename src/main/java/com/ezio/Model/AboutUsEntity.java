package com.ezio.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class AboutUsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String header;
	private String image;
	//private byte[] image;
	private String description;

	
	/*
	 * private Blob image;
	 * 
	 * public Blob getImage() { return image; }
	 * 
	 * public void setImage(Blob image) { this.image= image; }
	 */

}
