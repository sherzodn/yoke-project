# ws-yoke-event
MS Yoke Event

#### Step 0. 
```
docker pull postgres
docker pull mongo
docker pull wurstmeister/kafka
docker pull wurstmeister/zookeeper
docker pull obsidiandynamics/kafdrop
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.2.0
docker pull docker.elastic.co/kibana/kibana:7.2.0
docker pull docker.elastic.co/logstash/logstash:7.2.0
docker pull openzipkin/zipkin
```

#### Step 1.
Start postgres: `docker-compose up -d`

Stop postgres: `docker-compose down`

#### Step 2.
Start springboot app and check swagger:
`http://localhost:8083/swagger-ui.html`
play with try out.

#### Step 3.
Check postgres db via DBeaver Community Edition.

#### Step 4.
Start yoke-notify service and check create/delete via swagger-ui.
Check mongo and postgres  

