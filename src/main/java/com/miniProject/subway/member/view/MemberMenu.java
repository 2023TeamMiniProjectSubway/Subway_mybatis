package com.miniProject.subway.member.view;

import com.miniProject.subway.member.controller.MemberController;
import com.miniProject.subway.view.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.miniProject.subway.member.controller.MemberController.loginMember;

public class MemberMenu {
    public void loginMenu(){

        MemberController mc = new MemberController();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 👉 주문은 로그인 후 이용 가능합니다                        ");
            System.out.println("                            ▷  1. 로그인                                          ");
            System.out.println("                            ▷  2. 회원가입                                        ");
            System.out.println("                                                                                ");
//            System.out.println("                            ▷  9. 로그아웃                                        ");
            System.out.println("                            ▶  0. 이전 메뉴로                                     ");
            System.out.println("=================================================================================");

            try {
                int loginMenu = sc.nextInt();

                switch (loginMenu) {
                    case 1:                    // 로그인
                        mc.memberLogin();
                        return;
                    case 2:                    // 회원가입
                        mc.memberRegister();
                        break;

                    case 0:                    // 로그인화면 종료
                        System.out.println("                            ▶ 메인화면으로 돌아갑니다.                    ");
                        return;
                    default:
                        System.out.println("                            ▶ 😥️ ️번호를 잘못 입력하였습니다. 다시 입력해주세요.  ");
                        break;
                }

            }catch(InputMismatchException e)
            {
                System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.          ");
                sc.nextLine();
            }
        }
    }
}
