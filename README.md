# Instrucciones para levantar la aplicación con Cassandra usando Docker Compose

## Requisitos previos

- Tener Docker y Docker Compose instalados en tu máquina.
- Código fuente y archivos `Dockerfile` y `docker-compose.yml` configurados en el proyecto.

---
## Paso 1: Construir y levantar los contenedores

Desde la raíz del proyecto, ejecuta:
```bash
docker-compose up --build
```
Este comando construirá las imágenes Docker y levantará los servicios de Cassandra y la aplicación Spring Boot.

---
## Paso 2: Crear el keyspace y la tabla en Cassandra

Abre una nueva terminal y accede al shell CQL de Cassandra ejecutando:

```bash
docker exec -it cassandra cqlsh
```

Dentro de `cqlsh`, ejecuta las siguientes instrucciones para crear el keyspace y la tabla necesarias para la aplicación:
```sql
CREATE KEYSPACE IF NOT EXISTS medisupply
WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};
```

```sql
CREATE TABLE IF NOT EXISTS medisupply.requests (
id UUID PRIMARY KEY,
temperatura double,
ubicacion text,
tipoSensor text,
timestamp timestamp
);

```
Para salir del shell `cqlsh`, usa:
exit


---

## Paso 3: Reiniciar la aplicación

Luego de crear las estructuras en Cassandra, reinicia el contenedor de la aplicación para que reconozca el keyspace y la tabla:
```bash
docker restart supervision-app

```

## ¡Listo!

Con estos pasos la aplicación estará funcionando correctamente con Cassandra.
