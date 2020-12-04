package in.co.ingenieur.boards.models;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class BoardDTO {
	private Long id;
	private String name;
	private String boardRoomId;
	
	private List<String> users;
	
	public List<String> addUser(String name){
		users.add(name);
		return users;
	}
}
