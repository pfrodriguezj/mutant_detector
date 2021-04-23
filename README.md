# Mutant detector (Mercado Libre Challenge)

### Compiación
mvn install

## Base de datos
Al ejecutar el proyecto se creará (si no existe) el esquema Mutants, para lo cual debe existir una base de datos
mysql en su entorno local, así (puede editar los valores correspondientes en el application.properties): 

###Puerto:
3306
###Usuario:
root
###Password:
PASSWORD (en mayúscula)

## Ejecución
mvn spring-boot:run

## Endpoints
Cuando la aplición este en ejecución, puede acceder a la API, así:

POST /mutant -> http://localhost:5000/mutant
GET /stats -> http://localhost:5000/stats



 
