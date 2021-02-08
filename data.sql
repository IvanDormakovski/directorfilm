insert into film(director_id, name, release_date, genre)
VALUES ((select id from director where last_name = 'Tarantino'),
        'Django Unchained',
        '2012-12-18',
        'western'),
       ((select id from director where last_name = 'Tarantino'),
        'Inglourious Basterds',
        '2009-05-20',
        'history'),
       ((select id from director where last_name = 'Tarantino'),
        'Kill Bill: Vol. 1',
        '2003-10-10',
        'action'),
       ((select id from director where last_name = 'Spielberg'),
        'Schindler List',
        '1993-11-30',
        'drama'),
       ((select id from director where last_name = 'Spielberg'),
        'Jurassic Park',
        '1993-07-09',
        'adventure'),
       ((select id from director where last_name = 'Weasley'),
        'Private Drive',
        '2015-02-15',
        'fantasy'),
       ((select id from director where last_name = 'Eastwood'),
        'Gran Torino',
        '2008-12-12',
        'drama'),
       ((select id from director where last_name = 'Eastwood'),
        'Sully: Miracle on the Hudson',
        '2016-09-02',
        'drama'),
       ((select id from director where last_name = 'Eastwood'),
        'The Mule',
        '2018-12-10',
        'drama'),
       ((select id from director where last_name = 'Lynch'),
        'The Straight Story',
        '1999-05-01',
        'drama'),
       ((select id from director where last_name = 'Lynch'),
        'Mulholland Drive',
        '2001-05-16',
        'mystery');