package br.com.ufal.iface.printingclasses;

import br.com.ufal.iface.systemadmin.UserAdmin;
import br.com.ufal.iface.systemdatas.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintNotifications {
    private User user;

    public PrintNotifications(User user) {
        this.user = user;
    }

    public void printUserMessages(){
        if(user.getListMessages().size() == 0){
            System.out.println(" - Você não possui novas mensagens -\n");
        }else{
            user.getListMessages().forEach((key, value) -> {
                System.out.println("Usuário: " + value.getName());
                System.out.println("Mensagem: " + key);
                System.out.println("-----------------------------");
            });
        }
    }

    public void printFriendshipSolicitation(){

        for(User i: user.getFriendshipSolicitation()){
            System.out.println("Usuário: " + i.getName());
            acceptFriendshipSolicitation(user, i);
        }
        user.getFriendshipSolicitation().clear();
    }

    public void acceptFriendshipSolicitation(User user, User friend){
        Scanner scanner = new Scanner(System.in);
        int option;

        while(true){
            try{
                System.out.println("Deseja aceitar a solicitação? 1 - Sim, 2 - Não");
                option = scanner.nextInt();

                switch (option){
                    case 1:
                        user.getFriends().add(friend);
                        friend.getFriends().add(user);
                        return;
                    case 2:
                        break;
                    default:
                        System.out.println(" - Escolha apenas uma das opções disponíveis. - \n");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(" - Informe apenas números inteiros -\n");
                scanner.nextLine();
            }
        }
    }
}
