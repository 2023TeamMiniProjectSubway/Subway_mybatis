package com.miniProject.subway.member.model.service;

import com.miniProject.subway.member.model.dao.MemberDAO;
import com.miniProject.subway.member.model.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.miniProject.subway.common.Template.getSqlSession;

public class MemberService {

    private MemberDAO memberDAO;
    public void insertMember(MemberDTO newMember) {

        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);

        int result = memberDAO.insertMember(newMember);

        if(result > 0){
            sqlSession.commit();
            System.out.println("성공적으로 회원을 등록하였습니다.");
        }
        else{
            sqlSession.rollback();
            System.out.println("회원 등록에 실패하였습니다.");
        }

        sqlSession.close();


    }

    public MemberDTO checkMember(String id) {

        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);

        MemberDTO checkmem =  memberDAO.selectPwdById(id);

        sqlSession.close();

        return checkmem;
    }

    public List<MemberDTO> IdList(){
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);

        List<MemberDTO> memList = memberDAO.IdList();

        sqlSession.close();

        return memList;
    }

    public int updatePoint(MemberDTO memDTO){
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);

        int result = memberDAO.updatePoint(memDTO);

        if(result > 0){
            sqlSession.commit();
        }
        else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public int selectPoint(String id) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);


        int result = memberDAO.selectPoint(id).getPoint();

        return result;
    }
}


