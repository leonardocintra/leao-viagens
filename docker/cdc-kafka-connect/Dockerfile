FROM confluentinc/cp-kafka-connect-base:7.6.1

ENV KAFKA_CONNECT_PLUGINS_DIR=/etc/confluent/connect
RUN mkdir -p $KAFKA_CONNECT_PLUGINS_DIR

RUN echo ">>>>>>>>>>	Instalando	Plugin	do	mongodb	<<<<<<<<<<<"
RUN wget https://repo1.maven.org/maven2/io/debezium/debezium-connector-mongodb/2.6.1.Final/debezium-connector-mongodb-2.6.1.Final-plugin.tar.gz
RUN	tar	xvfz debezium-connector-mongodb-2.6.1.Final-plugin.tar.gz --directory	$KAFKA_CONNECT_PLUGINS_DIR

RUN echo ">>>>>>>>>> Removendo arquivos de instalação dos conectores <<<<<<<<<"
RUN rm *.gz

# RUN /etc/confluent/docker/run &