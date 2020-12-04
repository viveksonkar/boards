package in.co.ingenieur.boards.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.ingenieur.boards.data.Board;
import in.co.ingenieur.boards.mapper.BoardMapper;
import in.co.ingenieur.boards.models.BoardDTO;
import in.co.ingenieur.boards.repository.BoardRepository;

@Service
public class BoardService {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	Map<String, BoardDTO> boards = new HashMap<String, BoardDTO>();
	
	@Autowired BoardRepository boardRepository;
	@Autowired BoardMapper boardMapper;

	public BoardDTO addBoard(String name) {
		Board board = new Board();
		board.setName(name);
		board.setBoardRoomId(randomAlphaNumeric(32));
		Board createdboard = boardRepository.save(board);
		BoardDTO boardDTO = boardMapper.mapBoardToBoardDTO(createdboard);
		if( null!= createdboard) {
			boards.put(createdboard.getBoardRoomId(), boardDTO);
		}
		return boardDTO;
	}
	
	/*public Flux<BoardDTO> addMemberToBoard(String boardRoomId, String name){
		boards.get(boardRoomId).addUser(name);
		return Flux.<BoardDTO>fromIterable(boards.get(boardRoomId));
	}*/

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public List<Long> getTempList() {
		List<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(2L);
		list.add(3L);
		list.add(4L);
		list.add(5L);
		return list;
	}
}
