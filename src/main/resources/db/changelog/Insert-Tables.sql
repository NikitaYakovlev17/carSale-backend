--drop table body, car_ad, color, drive, engine, generation, kitting, model, producer, transmission, car_photo, car_ad_like;

--заполение таблицы role
insert into "role"(name)
values ('ADMIN'),
       ('USER');

--заполение таблицы producer
insert into producer(name)
values ('Audi'),
       ('BMW'),
       ('Bugatti'),
       ('Cadillac'),
       ('Chevrolet'),
       ('Chrysler'),
       ('Citroen'),
       ('Dacia'),
       ('Daewoo'),
       ('Dodge'),
       ('Fiat'),
       ('Ford'),
       ('Geely'),
       ('GMC'),
       ('Haval'),
       ('Honda'),
       ('Hummer'),
       ('Hyndai'),
       ('Infiniti'),
       ('Jaguar'),
       ('Jeep'),
       ('Kia'),
       ('Lancia'),
       ('Land Rover'),
       ('Lexus'),
       ('Mazda'),
       ('Mercedes-Benz'),
       ('Nissan'),
       ('Opel'),
       ('Peugeot'),
       ('Renault'),
       ('Saab'),
       ('Seat'),
       ('Skoda'),
       ('Subaru'),
       ('Volkswagen'),
       ('Volvo');

--заполение таблицы model
insert into model(name, producer_id)
values ('A1', 1),
       ('A2', 1),
       ('A3', 1),
       ('A4', 1),
       ('A5', 1),
       ('A6', 1),
       ('A7', 1),
       ('A8', 1),
       ('Q2', 1),
       ('Q3', 1),
       ('Q4', 1),
       ('Q5', 1),
       ('Q6', 1),
       ('Q7', 1),
       ('Q8', 1),
       ('RS3', 1),
       ('RS4', 1),
       ('RS5', 1),
       ('RS6', 1),
       ('RS7', 1),
       ('S1', 1),
       ('S3', 1),
       ('S4', 1),
       ('S5', 1),
       ('S6', 1),
       ('S7', 1),
       ('S8', 1),
       ('TT', 1),
       ('1-series', 2),
       ('2-series', 2),
       ('3-series', 2),
       ('4-series', 2),
       ('5-series', 2),
       ('6-series', 2),
       ('7-series', 2),
       ('M2', 2),
       ('M3', 2),
       ('M4', 2),
       ('M5', 2),
       ('M6', 2),
       ('X1', 2),
       ('X2', 2),
       ('X3', 2),
       ('X4', 2),
       ('X5', 2),
       ('X5M', 2),
       ('X6', 2),
       ('X6M', 2),
       ('X7', 2),
       ('Z4', 2);

--заполение таблицы generation
insert into generation(name, start_of_production, end_of_production, model_id)
values ('C4', 1994, 1997, 6),
       ('C5', 1997, 2004, 6),
       ('C6', 2004, 2011, 6),
       ('C7', 2011, 2018, 6),
       ('C8', 2018, 2022, 6),
       ('B5', 1994, 2001, 4),
       ('B6', 2000, 2006, 4),
       ('B7', 2004, 2009, 4),
       ('B8', 2007, 2015, 4),
       ('B9', 2015, 2020, 4),
       ('E21', 1975, 1984, 30),
       ('E30', 1982, 1994, 30),
       ('E36', 1990, 2000, 30),
       ('E46', 1998, 2007, 30),
       ('E90', 2005, 2014, 30),
       ('F30', 2011, 2015, 30),
       ('F34', 2013, 2022, 30),
       ('E12', 1972, 1981, 32),
       ('E28', 1981, 1988, 32),
       ('E34', 1988, 1996, 32),
       ('E39', 1995, 2004, 32),
       ('E60', 2002, 2010, 32),
       ('F10', 2009, 2017, 32),
       ('F07', 2009, 2017, 32),
       ('G30', 2016, 2022, 32);

--заполение таблицы transmission
insert into transmission(type)
values ('Manual'),
       ('Automatic');

--заполение таблицы body
insert into body(name)
values ('Sedan'),
       ('Wagon'),
       ('Coupe'),
       ('SUV'),
       ('Van'),
       ('Compact'),
       ('Hatchback'),
       ('Pickup');

--заполение таблицы drive
insert into drive(type)
values ('AWD'),
       ('4WD'),
       ('FWD'),
       ('RWD');

--заполение таблицы color
insert into color(name)
values ('black'),
       ('white'),
       ('gray'),
       ('blue');

--заполение таблицы engine
insert into engine(displacement, type)
values (1900, 'diesel'),
       (3000, 'diesel');

--заполение таблицы car_ad_like
insert into car_ad_like(user_id, car_ad_id)
values (1, 5),
       (1, 6),
       (1, 7),
       (2, 5),
       (2, 6),
       (2, 7);

--заполение таблицы car_ad
insert into car_ad(created_on, price, description, mileage, year, location, body_id, color_id, drive_id, engine_id, generation_id, transmission_id, user_id)
values ('2020-04-04', 10000, 'qwerty', 300000, 1996, 'Postavy', 1, 1, 1, 1, 1, 1, 1),
       ('2020-04-04', 14500, 'qwerty123', 100000, 2004, 'Minsk', 2, 2, 2, 2, 2, 2, 2),
       ('2020-04-04', 19000, 'qwerty12333', 100000, 2006, 'Vitebsk', 3, 3, 2, 2, 3, 2, 1),
       ('2020-04-04', 20000, 'qgwqgqgvqqv', 100000, 2012, 'Brest', 4, 4, 2, 2, 4, 2, 2),
       ('2020-04-04', 12345, 'qgwqgqgvqqv', 100000, 2012, 'Polotsk', 4, 4, 2, 2, 11, 2, 2),
       ('2020-04-04', 52352, 'qgwqgqgvqqv', 100000, 2012, 'Voropaevo', 4, 4, 2, 2, 12, 2, 2),
       ('2020-04-04', 15354, 'qgwqgqgvqqv', 100000, 2012, 'Mozyr', 4, 4, 2, 2, 13, 2, 2),
       ('2020-04-04', 3124, 'qgwqgqgvqqv', 100000, 2012, 'Miory', 4, 4, 2, 2, 18, 2, 2),
       ('2020-04-04', 1234, 'qgwqgqgvqqv', 100000, 2012, 'Ilya', 4, 4, 2, 2, 19, 2, 2),
       ('2020-04-04', 56345, 'qgwqgqgvqqv', 100000, 2012, 'Hotily', 4, 4, 2, 2, 20, 2, 2),
       ('2020-04-04', 36000, 'vhqwiolcvhu wciowq', 100000, 2018, 'Gomel', 5, 1, 2, 2, 5, 2, 1);

