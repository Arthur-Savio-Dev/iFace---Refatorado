package br.com.ufal.iface.menus;

import br.com.ufal.iface.printingclasses.PrintMenus;
import br.com.ufal.iface.printingclasses.PrintUserDatas;
import br.com.ufal.iface.systemadmin.UserAdmin;
import br.com.ufal.iface.systemdatas.SystemDatas;
import br.com.ufal.iface.systemdatas.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserManagementMenu {
    private SystemDatas systemDatas;
    private UserAdmin userAdmin;
    private User user;
    private PrintUserDatas printUserDatas;
    private PrintMenus printMenus = new PrintMenus();
    private Scanner scanner = new Scanner(System.in);

    public UserManagementMenu(SystemDatas systemDatas, User user) {
        this.systemDatas = systemDatas;
        this.userAdmin = new UserAdmin(systemDatas);
        this.user = user;
        this.printUserDatas = new PrintUserDatas(user);
    }

    public void userManagementMenu(){
        int option = 0;

        while(option != 5){
            try{
                printMenus.printUserManagement();
                option = scanner.nextInt();

                switch (option){
                    case 1:
                        break;
                    case 2:
                        userAdmin.deleteFriend(user);
                        break;
                    case 3:
                        printUserDatas.userInformation();
                        break;
                    case 4:
                        userAdmin.deleteAccount(user);
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(" - Informe apenas números inteiros -\n");
            }
        }
    }
}
