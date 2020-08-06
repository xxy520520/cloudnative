FROM nat-harbor.daocloud.io/library/openjdk:8u232-jre-debian
ADD ./target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
ADD runboot.sh /app/
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 8088
CMD /app/runboot.sh
