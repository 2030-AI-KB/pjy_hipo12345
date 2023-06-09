package com.board.ds;

import com.dto.BoardDTO;
import com.dto.MemberDTO;
import com.member.AppDao;

import java.sql.Connection;
import java.util.List;

import static com.common.JdbcUtil.*;


public class BoardDs {
    private Connection conn;

    private AppDao setDao() {
        AppDao dao = AppDao.getInstance();
        this.conn = getConnection();
        dao.setConnection(this.conn);
        return dao;
    }

    public int selectAccountCountByLoginId(String loginId) {
        AppDao dao = setDao();
        int count = dao.selectAccountCountByLoginId(loginId);
        close(conn);
        return count;
    }

    public boolean insertBoard(BoardDTO dto) {
        AppDao dao = setDao();
        boolean isSuccess = dao.insertBoard(dto);
        if (isSuccess) {
            commit(this.conn);
        } else {
            rollback(this.conn);
        }
        close(conn);
        return isSuccess;
    }
    public List<BoardDTO> selectBoardList(String extraQuery) {
        AppDao dao = setDao();
        List<BoardDTO> list = dao.selectBoardList(extraQuery);
        close(conn);
        return list;
    }

}
