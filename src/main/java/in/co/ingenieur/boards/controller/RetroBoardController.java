package in.co.ingenieur.boards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.co.ingenieur.boards.models.BoardDTO;
import in.co.ingenieur.boards.services.BoardService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

@RestController
public class RetroBoardController {
	
	@Autowired BoardService boardService;
	@Autowired FluxProcessor processor;
	@Autowired FluxSink sink;
	int counter = 0;
	
	@RequestMapping( path = "create", produces = {"application/json"}, method = RequestMethod.GET)
	public BoardDTO createBoard( @RequestParam(value = "name", required = true) String name) {
		return boardService.addBoard(name);
	}
	
	/*@RequestMapping( path = "addMember", produces = {"application/json"}, method = RequestMethod.POST)
	public Flux<BoardDTO> addMemberToBoard( @RequestParam(value = "boardRoomId", required = true) String boardRoomId,
			@RequestParam(value = "name", required = true) String name) {
		return boardService.addMemberToBoard(boardRoomId, name);
	}*/
	
	@GetMapping("/send")
    public void test() {
        sink.next("Hello World #" + counter++);
    }
	
	@RequestMapping( path = "stream", produces = { "application/json", "application/stream+json", "text/event-stream" }, method = RequestMethod.GET)
	public Flux<ServerSentEvent<String>> streamEvent() {
		return processor.map(e -> ServerSentEvent.builder(e).build());
	}
}
