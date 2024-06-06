package com.leaolabs.companhias_aereas.exceptions;

public class HorarioNoPassadoException extends RuntimeException {
  public static final String MENSAGEM = "Partidas não podem ser feitas no passado";

  public HorarioNoPassadoException() {
    super(MENSAGEM);
  }
}
