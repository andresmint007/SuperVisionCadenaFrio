#!/bin/bash

# Script pour démarrer Cassandra avec Docker
echo "Démarrage de Cassandra avec Docker..."

# Vérifier si Docker est installé
if ! command -v docker &> /dev/null; then
    echo "Docker n'est pas installé. Veuillez installer Docker d'abord."
    exit 1
fi

# Arrêter et supprimer le conteneur existant s'il existe
docker stop cassandra-medisupply 2>/dev/null || true
docker rm cassandra-medisupply 2>/dev/null || true

# Démarrer Cassandra
echo "Création et démarrage du conteneur Cassandra..."
docker run -d \
  --name cassandra-medisupply \
  -p 9042:9042 \
  -e CASSANDRA_CLUSTER_NAME=medisupply_cluster \
  -e CASSANDRA_DC=datacenter1 \
  -e CASSANDRA_RACK=rack1 \
  cassandra:latest

echo "Cassandra démarre... Attendez environ 30-60 secondes pour qu'il soit complètement prêt."
echo ""
echo "Pour vérifier le status: docker logs cassandra-medisupply"
echo "Pour arrêter: docker stop cassandra-medisupply"
echo "Pour démarrer l'application: mvn spring-boot:run"
echo ""
echo "URLs de test après démarrage de l'application:"
echo "  GET    http://localhost:8081/api/requests"
echo "  POST   http://localhost:8081/api/requests"
echo "         Body: {\"temperature\": 25.5, \"type\": \"TEMPERATURE_SENSOR\"}"
