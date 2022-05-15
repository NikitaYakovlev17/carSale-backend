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
       ('E21', 1975, 1984, 31),
       ('E30', 1982, 1994, 31),
       ('E36', 1990, 2000, 31),
       ('E46', 1998, 2007, 31),
       ('E90', 2005, 2014, 31),
       ('F30', 2011, 2015, 31),
       ('F34', 2013, 2022, 31),
       ('E12', 1972, 1981, 33),
       ('E28', 1981, 1988, 33),
       ('E34', 1988, 1996, 33),
       ('E39', 1995, 2004, 33),
       ('E60', 2002, 2010, 33),
       ('F10', 2009, 2017, 33),
       ('F07', 2009, 2017, 33),
       ('G30', 2016, 2022, 33);

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
values ('Black'),
       ('White'),
       ('Gray'),
       ('Blue');

--заполение таблицы engine
insert into engine(displacement, type)
values (1900, 'Diesel'),
       (3000, 'Diesel');


--заполение таблицы car_ad
insert into car_ad(id, created_on, price, description, mileage, year, location, body_id, color_id, drive_id, engine_id, generation_id, transmission_id, user_id)
values (1, '2021-04-04', 3350, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        300000, 1996, 'Postavy', 1, 1, 1, 1, 1, 1, 2),
       (2, '2020-04-15', 5000, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2004, 'Minsk', 1, 3, 2, 2, 2, 2, 2),
       (3, '2022-05-01', 11400, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2006, 'Vitebsk', 1, 3, 2, 2, 3, 2, 3),
       (4, '2021-04-04', 18000, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2012, 'Brest', 1, 1, 2, 2, 4, 2, 4),
       (5, '2020-05-12', 2500, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2012, 'Polotsk', 3, 3, 2, 2, 11, 2, 2),
       (6, '2021-04-30', 1500, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2012, 'Voropaevo', 3, 1, 2, 2, 12, 2, 2),
       (7, '2022-03-04', 5000, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2012, 'Mozyr', 1, 4, 2, 2, 13, 2, 3),
       (8, '2020-04-19', 1200, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2012, 'Ilya', 1, 4, 2, 2, 19, 2, 4),
       (9, '2022-04-01', 4500, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2012, 'Hotily', 4, 2, 2, 2, 20, 2, 2),
       (10, '2021-04-22', 56300, 'Lorem ipsum dolor sit amet consectetur adipiscing elit suscipit, nisi nostra at ad aliquet tempor eleifend risus, habitant conubia gravida augue ac vitae porttitor. Vehicula libero ipsum integer consequat vitae quisque inceptos proin purus bibendum, lorem vulputate in id curae duis sem vestibulum ultricies orci, tellus tincidunt habitasse maximus habitant vel posuere dolor nulla.',
        100000, 2018, 'Gomel', 2, 1, 2, 2, 5, 2, 3);

--заполение таблицы car_photo
insert into car_photo(path, car_ad_id)
values ('6faaa4fe-df43-47ee-a7e4-e1124a564189.jpg', 1),
       ('45959654-5bcf-47a0-8752-5a2886e318f2.jpg', 1),
       ('c0fdd1ca-8eb9-4efb-aebf-87e4899ee06e.jpg', 1),
       ('08490cae-e624-41de-bef6-af52af54d8ec.jpg', 1),
       ('9054d48c-4b4f-48b4-a80d-c788aeca50a9.jpg', 2),
       ('0a8caf5b-56a8-4953-9e19-25b5c1aab2e2.jpg', 2),
       ('cb38ba01-5de7-42c5-8af1-7152a6294866.jpg', 2),
       ('f578a0f9-64dd-4430-b9d6-601478d49f3f.jpg', 2),
       ('6ab7743a-8691-461a-a466-1709ad4e30ee.jpg', 2),
       ('a9be7b2f-10bd-40a6-a663-2b0efb90a487.jpg', 3),
       ('208acd61-623f-46b7-8531-764e439c2840.jpg', 3),
       ('d4d52a01-75f6-4f85-bc56-d22ff5670ce1.jpg', 3),
       ('893f629e-e9c8-4230-85c1-ef0a9551c484.jpg', 3),
       ('b2420cf3-c232-4247-a53b-fd9f4c1acef2.jpg', 3),
       ('a95700ba-0e39-4d72-a285-c352bc3a014f.jpg', 3),
       ('12552454-117d-4de9-bbc7-4fc68e888d94.jpg', 4),
       ('6d674ac6-9e9e-429d-8fa3-a64426bc2a28.jpg', 4),
       ('fcb4964c-c0c9-4ef9-9b61-0a500288ea77.jpg', 4),
       ('98bc7c08-9934-424e-a1bb-ed0592c18102.jpg', 4),
       ('dabdecc1-c532-48d1-b799-a32c5f552c19.jpg', 5),
       ('ca15876e-1302-4f0d-ac00-b15ee7b7a437.jpg', 5),
       ('f98da0bb-2bf0-428c-ab3e-04e16a15d480.jpg', 5),
       ('9254b80e-13f1-4896-8126-318bd2da6443.jpg', 5),
       ('b63e806b-4054-4394-a867-1c0dc96189fe.jpg', 6),
       ('2e00e3b1-cda9-44ee-bb2f-11f06eee3159.jpg', 6),
       ('b8b20321-a82c-41c9-97e9-18528ede2ac0.jpg', 6),
       ('cd126956-ca3f-4445-89bb-215553b34bc8.jpg', 7),
       ('74ec01bb-3f7d-4142-b7ef-8a9cbdfff265.jpg', 7),
       ('f930e901-c8e2-42db-8627-520f9cf8b175.jpg', 7),
       ('6827c197-cb39-4d63-83ad-f327532aaa59.jpeg', 8),
       ('f2d7ae4c-9ea7-4424-9d7f-0957ab5efb29.jpeg', 8),
       ('99f99dc5-c174-4a9d-9423-57bb5f4a876d.jpg', 9),
       ('1d1c7a38-76c9-4dcd-8686-f442a3874a9e.jpg', 9),
       ('2f245255-0ad3-4660-ac41-8e32f9015710.jpg', 9),
       ('a2512bb9-cf31-4135-9df3-7caeba800a07.jpg', 9),
       ('cb6d4bfd-e6cf-4f52-bd1d-92b4de59e94f.jpg', 9),
       ('7890afbd-3812-4df5-b52a-229963c287c0.jpeg', 10),
       ('bd44f59b-5b5d-4bf5-823f-7801806b6015.jpeg', 10),
       ('3301382b-341e-4b48-8e74-780a8048951b.jpeg', 10);
