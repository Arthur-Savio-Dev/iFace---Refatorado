package br.com.ufal.iface.exceptions;

public class InexistingUserException extends RuntimeException{
    public InexistingUserException() {
        super(" - Usuário não existente. Tente novamente. -\n");
    }
}
