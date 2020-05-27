# Java EE (JEE) sample REST web application

This application architecture is as follows:

* Maven Project - builds a WAR
* Using JSF 2.2 for web interface, HTML5 facelets page, JSF backing beans, CDI scopes on beans, @Named
* Statelss EJB for services - uses JPA entity beans - exposes appropriate method as REST API using JAX-RS annotations
* JAX-RS Application class
* JPA entity bean to store names - uses H2 in-memory database
* Use EJB Singleton to lookup messaging connection and queue destination and inject into stateless EJB - lookup should only occur once on startup
* Servlet that returns "Hi." - this is a health check - path should be [context]/health
* H2 (embedded in-memory DB) backend

Sample testing and output

* http://localhost:8080/sample-rest/health

Hi.
Date is Wed May 27 09:53:21 EDT 2020 at the server. 

* curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/sample-rest/api/persons --data '{"name":"TC"}'

HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 0
Date: Wed, 27 May 2020 13:56:40 GMT

* curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/sample-rest/api/persons --data '{"name":"TC2"}'

HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 0
Date: Wed, 27 May 2020 13:59:34 GMT

* curl -X GET -i http://localhost:8080/sample-rest/api/persons/

HTTP/1.1 200 OK
Connection: keep-alive
Content-Type: application/json
Content-Length: 44
Date: Wed, 27 May 2020 14:00:00 GMT

[{"id":6,"name":"TC"},{"id":7,"name":"TC2"}]

* curl -X GET -i http://localhost:8080/sample-rest/api/persons/6

HTTP/1.1 200 OK
Connection: keep-alive
Content-Type: application/json
Content-Length: 20
Date: Wed, 27 May 2020 14:00:55 GMT

{"id":6,"name":"TC"}

* curl -X DELETE -H 'Content-Type: application/json' -i http://localhost:8080/sample-rest/api/persons/6

HTTP/1.1 204 No Content
Date: Wed, 27 May 2020 14:02:06 GMT
