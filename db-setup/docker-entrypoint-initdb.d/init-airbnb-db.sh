#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER airbnbuser WITH PASSWORD 'airbnbuser';
	CREATE DATABASE airbnb;
	GRANT ALL PRIVILEGES ON DATABASE airbnb TO airbnbuser;
EOSQL