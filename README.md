# dz-13
docker run --name some-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres

CREATE TABLE DataProvider ( id SERIAL PRIMARY KEY, ageData INTEGER, lastName VARCHAR (200) );

INSERT INTO DataProvider (ageData, lastName) VALUES (59, 'Doe'), (60, 'Brown'), (61, null), (64, ' '), (65, 'LASTNAME'), (66, '');

select * from DataProvider
