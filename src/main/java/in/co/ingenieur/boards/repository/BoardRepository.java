package in.co.ingenieur.boards.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.co.ingenieur.boards.data.Board;

@Repository
public interface BoardRepository extends CrudRepository<Board, Integer>{

}
