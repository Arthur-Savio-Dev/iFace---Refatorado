package br.com.ufal.iface.exceptions;

public class ExistingCommunityException extends RuntimeException{
    public ExistingCommunityException() {
        super(" - Já existe uma comunidade com esse nome - \n");
    }
}
