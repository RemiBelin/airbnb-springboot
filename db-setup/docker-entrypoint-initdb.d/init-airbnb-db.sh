#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER airbnbuser WITH PASSWORD 'airbnbuser';
	CREATE SCHEMA airbnb;
	GRANT CREATE ON SCHEMA airbnb TO airbnbuser;
  GRANT USAGE ON SCHEMA airbnb TO airbnbuser;
EOSQL