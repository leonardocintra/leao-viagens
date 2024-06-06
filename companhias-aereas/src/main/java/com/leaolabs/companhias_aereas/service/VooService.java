package com.leaolabs.companhias_aereas.service;

import com.leaolabs.companhias_aereas.domain.Voo;
import com.leaolabs.companhias_aereas.repository.VoosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VooService {
  private VoosRepository voosRepository;

  public void cadastrarNovoVoo(Voo voo) {
    voosRepository.save(voo);
  }
}
