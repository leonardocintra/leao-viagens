#!/bin/bash
docker images -a | grep "cdc-kafka-connect" | awk '{print $3}'
docker build -t cdc-kafka-connect .