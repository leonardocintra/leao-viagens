package com.leaolabs.companhias_aereas.domain;

import com.leaolabs.companhias_aereas.exceptions.OrigemEDestinoIguaisException;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voos")
@EqualsAndHashCode(exclude = "id")
public class Voo {
  @Id
  private ObjectId id;
  private Origem origem;
  private Destino destino;
  private CompanhiaAerea companhiaAerea;
  private Preco preco;

  public Voo(Origem origem, Destino destino, CompanhiaAerea companhiaAerea, Preco preco) {
    if (destino.mesmoAeroportoDa(origem)) {
      throw new OrigemEDestinoIguaisException();
    }

    this.companhiaAerea = companhiaAerea;
    this.destino = destino;
    this.preco = preco;
    this.origem = origem;
  }
}
