package com.miniProject.subway.member.model.dao;

import com.miniProject.subway.member.model.dto.MemberDTO;

import java.util.List;
import java.util.Map;

public interface MemberDAO {

    MemberDTO selectPwdById(String id);

    List<MemberDTO> IdList();

    int insertMember(MemberDTO memberDTO);


    int updatePoint(MemberDTO memberDTO);

    MemberDTO selectPoint(String id);
}
