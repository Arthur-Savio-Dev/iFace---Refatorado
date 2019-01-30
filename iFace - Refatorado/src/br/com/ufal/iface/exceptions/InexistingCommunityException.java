package br.com.ufal.iface.exceptions;

public class InexistingCommunityException extends RuntimeException{
    public InexistingCommunityException() {
        super(" - Comunidade não existente. - \n");
    }
}
