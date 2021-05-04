CREATE USER "prospring5" WITH ENCRYPTED PASSWORD 'prospring5';

create schema musicdb_schema;
GRANT ALL PRIVILEGES ON DATABASE musicdb TO "prospring5";

--GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA musicdb_schema TO "prospring"
