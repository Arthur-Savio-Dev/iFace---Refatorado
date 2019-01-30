package br.com.ufal.iface.exceptions;

public class IllegalRelationshipStatusException extends RuntimeException{
    public IllegalRelationshipStatusException() {
        super(" - Tipo de relacionamento inválido. Tente casado, solteiro ou divorciado. - \n");
    }
}
