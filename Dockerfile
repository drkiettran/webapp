FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

VOLUME /tmp

ARG JAR_FILE

# COPY ${JAR_FILE} app.jar
COPY ./target/webapp-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ \
	"java", "-jar", "app.jar" \
]
