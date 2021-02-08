create table if not exists director
(
	id serial not null
		constraint director_pkey
			primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	birth_date date not null
);

alter table director owner to postgres;

create table if not exists film
(
	id serial not null
		constraint film_pkey
			primary key,
	director_id integer not null
		constraint film_director_id_fkey
			references director
				on delete cascade,
	name varchar(255) not null,
	release_date date not null,
	genre varchar(255) not null
);

alter table film owner to postgres;