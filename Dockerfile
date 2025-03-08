FROM openjdk:21

WORKDIR /usrapp/bin

ENV PORT=8080

COPY /target/classes /usrapp/bin/classes

CMD ["java","-cp","./classes:./dependency/*","com.example.demo.DemoApplication"]