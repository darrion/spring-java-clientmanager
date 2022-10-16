FROM postgres:15

COPY init.sql /docker-entrypoint-initdb.d/

RUN chmod 0755 /docker-entrypoint-initdb.d/init.sql