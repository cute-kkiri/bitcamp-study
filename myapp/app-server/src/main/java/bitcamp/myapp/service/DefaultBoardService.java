package bitcamp.myapp.service;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import org.apache.ibatis.session.SqlSessionFactory;

public class DefaultBoardService implements BoardService {

  private BoardDao boardDao;
  private SqlSessionFactory sqlSessionFactory;

  public DefaultBoardService(BoardDao boardDao, SqlSessionFactory sqlSessionFactory) {
    this.boardDao = boardDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void add(Board board) throws Exception {
    try {
      boardDao.insert(board);
      if (board.getAttachedFiles().size() > 0) {
        boardDao.insertFiles(board);
      }
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw e;
    }
  }
}
