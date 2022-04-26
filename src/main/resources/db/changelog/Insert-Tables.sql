--drop table body, car_ad, color, drive, engine, generation, kitting, model, producer, transmission, car_photo;

--заполение таблицы role
insert into "role"(name)
values ('ADMIN'),
       ('USER');

--заполение таблицы producer
insert into producer(name)
values ('Audi'),
       ('BMW'),
       ('Chevrolet'),
       ('Mercedes-Benz'),
       ('Volkswagen');

--заполение таблицы model
insert into model(name, producer_id)
values ('A6', 1),
       ('5 series', 2),
       ('Passat', 3);

--заполение таблицы generation
insert into generation(name, start_of_production, end_of_production, model_id)
values ('C5', 1997, 2004, 1),
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
insert into car_ad(price, description, mileage, year, body_id, color_id, drive_id, engine_id, generation_id, transmission_id, user_id)
values (10000, 'qwerty', 300000, 2000, 1, 1, 1, 1, 1, 1, 1),
       (14500, 'qwerty2222', 100000, 2004, 2, 2, 2, 2, 2, 2, 1);

