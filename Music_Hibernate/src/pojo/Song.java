package pojo;

import java.util.Date;

public class Song implements java.io.Serializable {
	
	private Integer idsong;
	private Musician musician;
	private Album album;
	private String name;
	private Date releasedate;
	private String features;
	private String awards;
	private String nominations;
	
	public Song() {}
	
	public Song(Musician musician, Album album, String name, Date releasedate, String features, 
			String awards, String nominations) {
		this.musician = musician;
		this.album = album;
		this.name = name;
		this.releasedate = releasedate;
		this.features = features;
		this.awards = awards;
		this.nominations = nominations;
	}
	
	public Integer getIdsong() {
		return this.idsong;
	}
	public void setIdsong(Integer idsong) {
		this.idsong = idsong;
	}
	
	public Musician getMusicians() {
		return this.musician;
	}
	public void setMusicians(Musician musician) {
		this.musician = musician;
	}
	
	public Album getAlbums() {
		return this.album;
	}
	public void setAlbums(Album album) {
		this.album = album;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getReleasedate() {
		return this.releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	
	public String getFeatures() {
		return this.features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	
	public String getAwards() {
		return this.awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	
	public String getNominations() {
		return this.nominations;
	}
	public void setNominations(String nominations) {
		this.nominations = nominations;
	}
}
