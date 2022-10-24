FROM postgres:15

COPY schema.sql /docker-entrypoint-initdb.d/

RUN chmod 0755 /docker-entrypoint-initdb.d/schema.sql