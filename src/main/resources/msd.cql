CREATE KEYSPACE msd WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1}; 
USE msd; 


CREATE TABLE msd( id text PRIMARY KEY, name text, description varint );