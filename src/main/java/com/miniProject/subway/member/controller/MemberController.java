package com.miniProject.subway.member.controller;

import com.miniProject.subway.member.model.dto.MemberDTO;
import com.miniProject.subway.member.model.service.MemberService;
import com.miniProject.subway.view.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class MemberController{
    public static ArrayList<MemberDTO> memberDTO = new ArrayList<>();
    MemberDTO newMemberDTO = new MemberDTO();

    public static MemberDTO loginMember;
    Scanner sc = new Scanner(System.in);
    MemberService memberService = new MemberService();



    /** 로그인 창 메소드 */
    public void memberLogin(){

        loginMember = new MemberDTO();


        membercheck :
        while(true){

            System.out.println("=================================================================================");
            System.out.println("                            ▷ 🙍‍♂️ 아이디와 비밀번호를 입력해주세요    ");
            System.out.println("=================================================================================");
            System.out.println("                            ▷ ID :                                              ");
            String id = sc.nextLine();
            if(id.equals("")){
                System.out.println("                            ▶ 아이디를 입력해주세요                            ");
                continue;
            }


            System.out.println("                            ▶ Password :                                       ");
            String pwd = sc.nextLine();

            MemberDTO checkMem = memberService.checkMember(id);     //입력한 id에 맞는 pwd 찾아서 MemberDTO에 넣어주기

                if ((checkMem != null) && pwd.equals(checkMem.getPwd())) {      //checkMem이 비어있지않고 비밀번호가 일치할시
                    System.out.println("=================================================================================");
                    System.out.println("                            ▷ 🙆‍♂️ 로그인되었습니다.            ");   //id, pwd 일치할시 로그인
                    System.out.println("=================================================================================");
                    Main.login = true;

                    loginMember.setId(id);
                    loginMember.setPwd(pwd);
                    loginMember.setPoint(memberService.selectPoint(loginMember.getid()));
                    System.out.println("                            ▷ 현재 로그인 중인 유저 정보 : \n" +
                            "                            ▷ ID : " + loginMember.getid() + "\n" +
                            "                            ▷ 현재 보유중인 POINT : " + loginMember.getPoint());

                    return;
                }
                else {
                    incorrect:
                    while (true) {
                        System.out.println("=================================================================================");
                        System.out.println("                            ▶ 🙅️ 회원정보가 일치하지 않습니다.                          ");
                        System.out.println("                            ▷ 회원가입하시겠습니까?                                 ");
                        System.out.println("                            ▷ 1. 예                                              ");
                        System.out.println("                            ▷ 2. 아니오(로그인화면으로 돌아갑니다.)                    ");
                        System.out.println("                                                                                 ");
                        System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
                        System.out.println("=================================================================================");

                        try {
                            int registerSelect = sc.nextInt();

                            switch (registerSelect) {
                                case 1:
                                    sc.nextLine();
                                    memberRegister();
                                    return;
                                case 2:
                                    sc.nextLine();
                                    break incorrect;
                                case 0:
                                    System.out.println("                            ▶ 이전 화면으로 돌아갑니다.     ");
                                    return;
                                default:
                                    System.out.println("                            ▶ 😥 번호를 잘못 입력하였습니다. 다시 입력해주세요. ");
                                    continue;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.             ");
                            sc.nextLine();
                        }
                    }
                }
        }
    }

    /** 회원가입 메소드 */
    public void memberRegister(){
        System.out.println("=================================================================================");
        System.out.println("                            ▷ 🙋‍♂️ 회원 가입을 진행합니다.       ");
        String id = "";

        while(true)
        {
            System.out.println("                            ▷ ID를 입력해주세요.          ");
            System.out.println("                                    ");
            System.out.println("                            ▶ 0. 이전 메뉴로              ");
            System.out.println("=================================================================================");


            id = sc.nextLine();

            if(id.equals("0"))
            {
                System.out.println("=================================================================================");
                System.out.println("                            ▶ 이전 화면으로 돌아갑니다.     ");
                System.out.println("=================================================================================");
                return;
            }
            if(id.equals(""))
            {
                System.out.println("                            ▷ 🤷‍♂️ ID가 입력되지 않았습니다.       ");
                continue;
            }

            List<MemberDTO> idList = memberService.IdList();
            for(int i = 0; i < idList.size(); i++){

                if(idList.get(i).getid().equals(id)== true){
                    System.out.println("=================================================================================");
                    System.out.println("                            ▶ ❗ 이미 가입된 ID입니다. 다시 입력해주세요.                 ");
                    System.out.println("                                                                                 ");
                    System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
                    System.out.println("=================================================================================");

                    String alreadyId = sc.nextLine();
                    id = alreadyId;

                    if(alreadyId.equals("0"))
                    {
                        System.out.println("=================================================================================");
                        System.out.println("                            ▶ 이전 화면으로 돌아갑니다.                              ");
                        System.out.println("=================================================================================");
                        return;
                    }
                    else{
                        i = -1;                     //중복 아이디를 한번 더 입력하면 0부터 다시 검사하도록 i = -1로 설정.
                    }

                    continue;
                }
            }
            break;
        }

        System.out.println("                            ▷ 패스워드를 입력해주세요.      ");
        String pwd = sc.nextLine();
        System.out.println("                            ▷ 이름을 입력해주세요.          ");
        String name = sc.nextLine();
        System.out.println("                            ▷ 이메일을 입력해주세요.          ");
        String email = sc.nextLine();
        System.out.println("                            ▷ 연락처를 입력해주세요.          ");
        String phone= sc.nextLine();

        newMemberDTO.setId(id);
        newMemberDTO.setPwd(pwd);
        newMemberDTO.setName(name);
        newMemberDTO.setEmail(email);
        newMemberDTO.setPhone(phone);

        memberService.insertMember(newMemberDTO);

        System.out.println("                            ▷ 🙆‍♂️ 회원가입이 완료되었습니다.      ");
        System.out.println("=================================================================================");


        return;
    }

    public void memberList(){

        List<MemberDTO> memlist = memberService.IdList();
        for(MemberDTO member : memlist)
        {
            System.out.println(member);
        }

    }
}
