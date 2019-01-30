package br.com.ufal.iface.menus;

import br.com.ufal.iface.exceptions.InexistingUserException;
import br.com.ufal.iface.systemadmin.UserAdmin;
import br.com.ufal.iface.systemadmin.Utilites;
import br.com.ufal.iface.systemdatas.SystemDatas;
import br.com.ufal.iface.printingclasses.PrintMenus;
import br.com.ufal.iface.systemdatas.User;

import java.util.*;

public class LoginMenu {
    private SystemDatas systemDatas;
    private PrintMenus printMenus;
    private UserAdmin userAdmin;
    Scanner scanner = new Scanner(System.in);

    public LoginMenu(SystemDatas systemDatas) {
        this.systemDatas = systemDatas;
        this.userAdmin = new UserAdmin(systemDatas);
        this.printMenus = new PrintMenus();
    }

    public void loginMenu(){
        int option = 0;

        while(option != 3){
            try{
                printMenus.printLoginMenu();
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        receiveDatasToLogin();
                        break;
                    case 2:
                        userAdmin.receiveDatasToAddUserToSystem();
                        break;
                    default:
                        System.out.println("Escolha apenas entre as opções acima. ");
                        break;
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("Por favor, Informe apenas números.");
            }
        }
    }

    public void receiveDatasToLogin(){
        String email, password;
        scanner.nextLine();

        System.out.println("Seu e-mail: ");
        email = scanner.nextLine();

        System.out.println("Sua senha: ");
        password = scanner.nextLine();

        validateLoginUser(email, password);

    }

    public void validateLoginUser(String email, String password){

        Utilites utilites = new Utilites(systemDatas);
        User user = utilites.checkUserToValidateLogin(email, password);

        try{
            if(user == null){
                throw new InexistingUserException();
            }else{
                MainMenu mainMenu = new MainMenu(systemDatas, user);
                if(!user.isFirstLogin()){
                    userAdmin.completeAdditionalUserDatas(user);
                    user.setFirstLogin(true);
                }
                mainMenu.mainMenu();
            }
        }catch (InexistingUserException e){
            System.out.println(e.getMessage());
        }
    }
}
