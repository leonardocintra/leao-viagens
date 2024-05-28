#!/bin/bash
CONTAINER_NAME="criador-topicos"

remove_container() {
  echo "Removendo conteiner $CONTAINER_NAME..."
  docker rm $CONTAINER_NAME
}

criar_conectores(){
  echo "Instalando conectores no kafka connect..."
  cd cdc-kafka-connect
  ./novos-voos-conector.sh
  cd ..
}

echo "Subindo a infra da aplicação..."
ls -l
docker compose up -d
echo " ---- docker compose up! ----"

while true; do
  if ! docker ps -f "name=$CONTAINER_NAME" --format "{{.Names}}" | grep -q "$CONTAINER_NAME"; then
    remove_container

    echo "Aguarde 40s ..."
    # Contador regressivo de 40 até 0
    for ((i=40; i>=0; i--)); do
      printf "\r%d segundos restantes ..." "$i"
      sleep 1
    done

    echo ""
    echo "Obrigado por aguardar ..."
    criar_conectores
    break
  fi
  sleep 1
done
