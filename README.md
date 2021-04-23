# Mutant detector (Mercado Libre Challenge)

### Compiación
mvn clean install

## Base de datos
Al ejecutar el proyecto se creará (si no existen) la tabla history, para lo cual debe existir una base de datos
postgres en su entorno local con nombre db63rpvi4rkm29 
(puede editar los valores correspondientes en el application.properties): 

### Puerto
5432
### Usuario
fxhottexlzdxcz
### Password
a937c75c1b83b94dfdaaa8b35c54fa8c4ae53004d22d8750fdfc3716693a6c04

## Ejecución
mvn spring-boot:run

## Endpoints
Cuando la aplición este en ejecución, puede acceder a la API, así:

POST /mutant -> http://localhost:5000/mutant
GET /stats -> http://localhost:5000/stats

En la nube:
https://cryptic-sea-14639.herokuapp.com/mutant  
https://cryptic-sea-14639.herokuapp.com/stats

La documentación de swagger se puede acceder en:
https://cryptic-sea-14639.herokuapp.com/swagger-ui.html


 
