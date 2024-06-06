package com.leaolabs.companhias_aereas.controller;

import com.leaolabs.companhias_aereas.controller.dto.VooDto;
import com.leaolabs.companhias_aereas.service.VooService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voos")
@AllArgsConstructor
public class VooController {
  private VooService service;

  @PostMapping
  ResponseEntity<String> cadastrarNovoVoo(@RequestBody VooDto vooDTO) {
    try {
      service.cadastrarNovoVoo(vooDTO.toVoo());
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (RuntimeException e) {
      return ResponseEntity
          .status(HttpStatus.UNPROCESSABLE_ENTITY)
          .body(e.getMessage());
    }
  }
}
