package br.com.ufal.iface.printingclasses;

public class PrintMenus {
    public void printLoginMenu(){
        System.out.println("---- LOGIN ----");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Cadastrar-se");
        System.out.println("3 - Sair");
    }

    public void printMainMenu(){
        System.out.println("---- MENU ----");
        System.out.println("1 - Adicionar amigo");
        System.out.println("2 - Participar de uma comunidade");
        System.out.println("3 - Criar uma comunidade");
        System.out.println("4 - Enviar mensagens para um amigo");
        System.out.println("5 - Enviar mensagens para uma comunidade");
        System.out.println("6 - Exibir mensanges");
        System.out.println("7 - Exibir solicitações de amizade");
        System.out.println("8 - Gerenciar minha conta");
        System.out.println("9 - Ver comunidades que participo");
        System.out.println("10 - Sair");
    }

    public void printAdminComunity(){
        System.out.println("--- ADMIN COMUNIDADES ---");
        System.out.println("1 - Participar de uma comunidade");
        System.out.println("2 - Sair de uma comunidade");
        System.out.println("3 - Listar Comunidades que participo");
        System.out.println("4 - Gerenciar comunidade que sou moderador");
        System.out.println("5 - Voltar");
    }

    public void printAdminManagedCommunities(){
        System.out.println("- ADMIN COMUNIDADES QUE SOU MODERADOR -");
        System.out.println("1 - Remover membro da comunidade");
        System.out.println("2 - Editar dados da comunidade");
        System.out.println("3 - Ver todas as mensagens da comunidade");
        System.out.println("4 - Excluir comunidade");
        System.out.println("5 - Voltar");
    }

    public void printUserManagement(){
        System.out.println("--- ADMIN USUÁRIO ---");
        System.out.println("1 - Editar meus dados");
        System.out.println("2 - Excluir um amigo");
        System.out.println("3 - Informações de usuário");
        System.out.println("4 - Excluir minha conta");
        System.out.println("5 - Voltar");
    }
}
