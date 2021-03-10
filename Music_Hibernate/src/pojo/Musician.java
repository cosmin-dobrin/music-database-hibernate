package pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Musician implements java.io.Serializable{
	
	private Integer idmusician;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private Integer age;
	private String musictype;
	private Set songs = new HashSet(0);
	
	public Musician() {}
	
	public Musician(String firstname, String lastname, Date birthdate, Integer age, String musictype, Set songs) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.age = age;
		this.musictype = musictype;
		this.songs = songs;
	}
	
	public Integer getIdmusician() {
		return this.idmusician;
	}
	public void setIdmusician(Integer idmusician) {
		this.idmusician = idmusician;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Date getBirthdate() {
		return this.birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public Integer getAge() {
		return this.age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getMusictype() {
		return this.musictype;
	}
	public void setMusictype(String musictype) {
		this.musictype = musictype;
	}
	
	public Set getSongs() {
		return this.songs;
	}
	public void setSongs(Set songs) {
		this.songs = songs;
	}
}
