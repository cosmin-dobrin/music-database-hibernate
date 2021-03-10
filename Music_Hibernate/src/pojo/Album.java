package pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Album implements java.io.Serializable {
	
	private Integer idalbum;
	private String name;
	private Integer nrsongs;
	private Date releasedate;
	private String awards;
	private String nominations;
	private Set songs = new HashSet(0);
	
	public Album() {}
	
	public Album(String name, Integer nrsongs, Date releasedate, String awards, String nominations, Set songs) {
		this.name = name;
		this.nrsongs = nrsongs;
		this.releasedate = releasedate;
		this.awards = awards;
		this.nominations = nominations;
		this.songs = songs;
	}
	
	public Integer getIdalbum() {
		return this.idalbum;
	}
	public void setIdalbum(Integer idalbum) {
		this.idalbum = idalbum;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getNrsongs() {
		return this.nrsongs;
	}
	public void setNrsongs(Integer nrsongs) {
		this.nrsongs = nrsongs;
	}
	
	public Date getReleasedate() {
		return this.releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
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
	
	public Set getSongs() {
		return this.songs;
	}
	public void setSongs(Set songs) {
		this.songs = songs;
	}
}
