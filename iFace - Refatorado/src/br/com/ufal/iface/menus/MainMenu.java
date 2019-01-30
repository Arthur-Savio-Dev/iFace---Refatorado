package br.com.ufal.iface.menus;

import br.com.ufal.iface.printingclasses.*;
import br.com.ufal.iface.systemadmin.CommunityAdmin;
import br.com.ufal.iface.systemadmin.UserAdmin;
import br.com.ufal.iface.systemdatas.SystemDatas;
import br.com.ufal.iface.systemdatas.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private SystemDatas systemDatas;
    private PrintMenus printMenus = new PrintMenus();
    private UserAdmin userAdmin;
    private CommunityAdmin communityAdmin;
    private User user;

    public MainMenu(SystemDatas systemDatas, User user) {
        this.systemDatas = systemDatas;
        this.user = user;
        this.userAdmin = new UserAdmin(systemDatas);
        this.communityAdmin = new CommunityAdmin(systemDatas);
    }

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        PrintNotifications printNotifications = new PrintNotifications(user);
        PrintUserDatas printUserDatas = new PrintUserDatas(user);
        UserManagementMenu userManagementMenu = new UserManagementMenu(systemDatas, user);

        int option = 0;

        while(option != 10){
            try{
                printMenus.printMainMenu();
                option = scanner.nextInt();

                switch (option){
                    case 1:
                        userAdmin.sendFriendshipSolicitation(user);
                        break;
                    case 2:
                        userAdmin.joinComunnity(user);
                        break;
                    case 3:
                        communityAdmin.addCommunityToSystem(user);
                        break;
                    case 4:
                        userAdmin.sendMessageToFriend(user);
                        break;
                    case 5:
                        userAdmin.sendMessageToCommunity(user);
                        break;
                    case 6:
                        printNotifications.printUserMessages();
                        break;
                    case 7:
                        printNotifications.printFriendshipSolicitation();
                        break;
                    case 8:
                        userManagementMenu.userManagementMenu();
                        break;
                    case 9:
                        printUserDatas.printCommunities();
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(" - Informe apenas números inteiros. -\n");
                scanner.nextLine();
            }
        }
    }
}
