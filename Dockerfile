FROM maven
COPY ./ /src
WORKDIR src
EXPOSE 8080
RUN java -cp h2-1.4.197.jar org.h2.tools.RunScript -url jdbc:h2:./titap_test -user 'sa' -password '' -script src/main/resources/schema.sql
RUN java -cp h2-1.4.197.jar org.h2.tools.RunScript -url jdbc:h2:./titap_test -user 'sa' -password '' -script src/main/resources/data.sql
RUN java -cp h2-1.4.197.jar org.h2.tools.RunScript -url jdbc:h2:./titap_test -user 'sa' -password '' -script src/main/resources/resultdata.sql

