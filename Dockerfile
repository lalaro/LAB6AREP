FROM openjdk:21

WORKDIR /usrapp/bin

ENV PORT=35000

COPY /target/dependency /usrapp/bin/dependency
COPY /target/classes /usrapp/bin/classes

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.app.Application"]