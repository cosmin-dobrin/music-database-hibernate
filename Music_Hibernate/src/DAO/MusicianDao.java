package DAO;

import java.util.List;
import pojo.Song;
import java.util.Date;
import pojo.Musician;
import pojo.Album;

public interface MusicianDao {

	public void addMusician(Musician musician);
	public List<Musician> showMusicians();
	public void modifyMusician(Integer idmusician, String firstname,
									String lastname, Date birthdate,
									Integer age, String musictype);
	public void deleteMusician(Musician musician);
}
