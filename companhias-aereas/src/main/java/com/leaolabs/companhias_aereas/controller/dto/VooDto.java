package com.leaolabs.companhias_aereas.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leaolabs.companhias_aereas.domain.Aeroporto;
import com.leaolabs.companhias_aereas.domain.CompanhiaAerea;
import com.leaolabs.companhias_aereas.domain.Destino;
import com.leaolabs.companhias_aereas.domain.Origem;
import com.leaolabs.companhias_aereas.domain.Preco;
import com.leaolabs.companhias_aereas.domain.Voo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VooDto {
  @JsonProperty
  private String origem;
  @JsonProperty
  private String partida;
  @JsonProperty
  private String destino;
  @JsonProperty
  private String chegada;
  @JsonProperty
  private String companhiaAerea;

  @JsonProperty
  private BigDecimal precoAdulto;

  @JsonProperty
  private BigDecimal precoCrianca;

  public Voo toVoo() {
    return new Voo(new Origem(Aeroporto.valueOf(origem), LocalDateTime.parse(partida)),
        new Destino(Aeroporto.valueOf(destino), LocalDateTime.parse(chegada)),
        CompanhiaAerea.valueOf(companhiaAerea), new Preco(precoAdulto, precoCrianca));
  }
}
