package com.leaolabs.companhias_aereas.exceptions;

public class OrigemEDestinoIguaisException extends RuntimeException {
  public static final String MENSAGEM = "Origem e destino não podem ser o mesmo";

  public OrigemEDestinoIguaisException() {
    super(MENSAGEM);
  }
}
