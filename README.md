## HOW TO RUN
Download the project.

Execute the docker-compose file

`docker-compose -f db-docker-compose.yml up`

Get your service up

`rm -rf ./target && mvn package && java -jar ./target/demo-thorntail.jar`

## Methods Available 

GET: get all the books 

``localhost:8080/library``

POST: inserts a book in the database

``localhost:8080/library``

```json
body {
  "id": 0,
  "name": "name"
}
```


PUT: updates a book in the database

``localhost:8080/library/{bookId}``
```json
body {
  "id": 0,
  "name": "newName"
}
```


DELETE: deletes a book in the database

``localhost:8080/library/{bookId}``
