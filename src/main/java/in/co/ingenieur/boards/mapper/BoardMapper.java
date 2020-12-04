package in.co.ingenieur.boards.mapper;

import org.springframework.stereotype.Component;

import in.co.ingenieur.boards.data.Board;
import in.co.ingenieur.boards.models.BoardDTO;

@Component
public class BoardMapper {
	
	public BoardDTO mapBoardToBoardDTO(Board board){
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(board.getId());
		boardDTO.setName(board.getName());
		boardDTO.setBoardRoomId(board.getBoardRoomId());
		return boardDTO;
	}
	
}
