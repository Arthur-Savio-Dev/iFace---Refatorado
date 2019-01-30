package br.com.ufal.iface.printingclasses;

import br.com.ufal.iface.systemdatas.Community;
import br.com.ufal.iface.systemdatas.User;

public class PrintUserDatas {
    private User user;

    public PrintUserDatas(User user) {
        this.user = user;
    }

    public void printUserCommunities(){
        System.out.println(" - Comunidades do Usuário - \n");
        for(Community i: user.getUserCommunities()){
            System.out.println("Nome: " + i.getName());
            System.out.println("Moderador: " + i.getModerator().getName());
            System.out.println("Número de membros: " + i.getMembers().size());
            System.out.println("Descrição: " + i.getDescription());
            System.out.println("-------------------------------------------");
        }
    }

    public void userInformation(){
        PrintNotifications printNotifications = new PrintNotifications(user);

        System.out.println(" - Informações de Usuário -\n");
        System.out.println(" - Informações do perfil: - ");
        System.out.println("    Nome: " + user.getName());
        System.out.println("    E-mail: " + user.getEmail());
        System.out.println("    Idade: " + user.getAge());
        System.out.println("    Status de relacionamento: " + user.getRelationshipStatus());
        System.out.println("    Unidade Acadmêmica: " + user.getSchool());
        System.out.println(" - Seus amigos: - ");
        printUserFriends();
        System.out.println(" - Suas mensagens: -");
        printNotifications.printUserMessages();
        System.out.println(" - Suas comunidades : -");
        printCommunities();
    }

    public void printUserFriends(){
        for(User i: user.getFriends()){
            System.out.println("Nome: " + i.getName());
            System.out.println("----------------------");
        }
    }

    public void printCommunities(){
        for(Community i: user.getUserCommunities()){
            System.out.println("Nome: " + i.getName());
            System.out.println("Descrição: " + i.getDescription());
            System.out.println("-----------------------");
        }
    }
}
