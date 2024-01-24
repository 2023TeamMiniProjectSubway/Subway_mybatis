package com.miniProject.subway.view;

import com.miniProject.subway.member.controller.MemberController;
import com.miniProject.subway.member.view.MemberMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.miniProject.subway.member.controller.MemberController.loginMember;

public class Main {                             //메뉴화면

    public static boolean login = false;
    MemberController mc = new MemberController();
    MemberMenu memberMenu = new MemberMenu();
    public void MainMenu() {

        OrderMain order = new OrderMain();
        Scanner sc = new Scanner(System.in);
        int mainMenu = 0;


        //메인 메뉴
        main :
        while(true){
            System.out.println("                    ☆★☆★☆★ 🥙 서브웨이에 어서오세요 🥙 ☆★☆★☆★ ");
            System.out.println("=================================================================================");
            System.out.println("                              ▷  1. 주문하기                                      ");
            System.out.println("                                                                                 ");
            if(login==true)
            {
                System.out.println("                              ▷  9. 로그아웃하기");
            }
            System.out.println("                              ▷  0. 종료                                          ");
            System.out.println("=================================================================================");

            try {
                mainMenu = sc.nextInt();


                switch (mainMenu) {
                    case 1: {
                        sc.nextLine();
                        while (login == false)                   //로그인 안되어있으면
                        {
                            memberMenu.loginMenu();                       //loginMenu()로 이동
                            break;
                        }
                        if (login == true)                      //로그인 되어있으면
                        {
                            System.out.println("                            ▷ 주문을 진행합니다.                    ");
                            order.orderMenu();                  //주문 메뉴로 이동
                        }
                    }
                    break;
                    case 0:

                        sc.nextLine();
                        System.out.println("                            ▶ 메뉴를 종료합니다.                         ");

                        break main;                               //메뉴 종료
                    case 2:
                        System.out.println("                            ▷ 회원 목록을 조회합니다.                    ");
                        mc.memberList();
                        break;
                    case 9:
                        loginMember.setId(null);
                        loginMember.setPwd(null);
                        login=false;

                        break;
                    default:
                        sc.nextLine();
                        System.out.println(mainMenu);
                        System.out.println("                            ▷ 😥️ 번호를 잘못 입력하였습니다. 다시 입력해주세요.     ");

                        break;
                }
            }catch(InputMismatchException e)
            {
                System.out.println("                            ▷ 😥️ 잘못 입력하였습니다. 다시 입력해주세요.");
                sc.nextLine();

            }

        }

    }

}
