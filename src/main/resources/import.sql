INSERT INTO ARTIST (id, nickName, fName, lName, country, city, telephone, e_mail) VALUES (2, 'ArtistA', 'fNameA', 'lNameA', 'countryA', 'cityA', 3763946402, 'e_mailA')

INSERT INTO ARTIST (id, nickName, fName, lName, country, city, telephone, e_mail) VALUES (3, 'ArtistB', 'fNameB', 'lNameB', 'countryB', 'cityB', 3763946403, 'e_mailB')

INSERT INTO ARTIST (id, nickName, fName, lName, country, city, telephone, e_mail) VALUES (4, 'ArtistC', 'fNameC', 'lNameC', 'countryC', 'cityC', 3763946404, 'e_mailC')

INSERT INTO ARTIST (id, nickName, fName, lName, country, city, telephone, e_mail) VALUES (5, 'ArtistD', 'fNameD', 'lNameD', 'countryD', 'cityD', 3763946405, 'e_mailD')

INSERT INTO ARTIST (id, nickName, fName, lName, country, city, telephone, e_mail) VALUES (6, 'ArtistE', 'fNameE', 'lNameE', 'countryE', 'cityE', 3763946406, 'e_mailE')



INSERT INTO REPRODUCTOR (id, name, country, city, adress, house_number, telephone, e_mail) VALUES (2, 'nameA', 'countryA', 'cityA', 'adressA', 'house_numberA', 3763946412, 'e_mailA')

INSERT INTO REPRODUCTOR	(id, name, country, city, adress, house_number, telephone, e_mail) VALUES (3, 'nameB', 'countryB', 'cityB', 'adressB', 'house_numberB', 3763946413, 'e_mailB')



INSERT INTO REPRODUCTOR_ARTIST (MYGROUP_ID, GROUP_ID) VALUES ( 3, 3 )

INSERT INTO REPRODUCTOR_ARTIST (MYGROUP_ID, GROUP_ID) VALUES ( 2, 4 )

INSERT INTO REPRODUCTOR_ARTIST (MYGROUP_ID, GROUP_ID) VALUES ( 3, 5 )

INSERT INTO REPRODUCTOR_ARTIST (MYGROUP_ID, GROUP_ID) VALUES ( 2, 6 )

INSERT INTO REPRODUCTOR_ARTIST (MYGROUP_ID, GROUP_ID) VALUES ( 3, 6 )



INSERT INTO PAINTING (id, name, yoc, cost, ORIGIN_ARTIST_ID, REPRODUCTOR_ID) VALUES (2, 'nameA', 2012, 100, 2, 3)

INSERT INTO PAINTING (id, name, yoc, cost, ORIGIN_ARTIST_ID, REPRODUCTOR_ID) VALUES (3, 'nameB', 2013, 90, 5, 2)

INSERT INTO PAINTING (id, name, yoc, cost, ORIGIN_ARTIST_ID, REPRODUCTOR_ID) VALUES (4, 'nameC', 2014, 89, 2, 3)

































