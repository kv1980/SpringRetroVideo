insert into films(genreid,titel,voorraad,gereserveerd,prijs) values((select id from genres where naam='testgenre B'),"Titel van testfilm A",1,1,1);
insert into films(genreid,titel,voorraad,gereserveerd,prijs) values((select id from genres where naam='testgenre B'),"Titel van testfilm B",1,1,1);
insert into films(genreid,titel,voorraad,gereserveerd,prijs) values((select id from genres where naam='testgenre A'),"Titel van testfilm C",9,9,9);
