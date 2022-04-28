--drop table body, car_ad, color, drive, engine, generation, kitting, model, producer, transmission;

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
       ('5-series', 2),
       ('Passat', 3);

--заполение таблицы generation
insert into generation(name, start_of_production, end_of_production, model_id)
values ('C4', 1994, 1997, 6),
       ('C5', 1997, 2004, 6),
       ('C6', 2004, 2011, 6),
       ('C7', 2011, 2018, 6),
       ('C8', 2018, 2022, 6),
       ('E60', 2003, 2010, 2),
       ('B5', 1997, 2005, 3);

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

--заполение таблицы car_ad
insert into car_ad(price, description, mileage, year, location, body_id, color_id, drive_id, engine_id, generation_id, transmission_id, user_id)
values (10000, 'qwerty', 300000, 1996, 'Postavy', 1, 1, 1, 1, 1, 1, 1),
       (14500, 'qwerty123', 100000, 2004, 'Minsk', 2, 2, 2, 2, 2, 2, 2),
       (19000, 'qwerty12333', 100000, 2006, 'Vitebsk', 3, 3, 2, 2, 3, 2, 1),
       (20000, 'qgwqgqgvqqv', 100000, 2012, 'Brest', 4, 4, 2, 2, 4, 2, 2),
       (36000, 'vhqwiolcvhu wciowq', 100000, 2018, 'Gomel', 5, 1, 2, 2, 5, 2, 1);

