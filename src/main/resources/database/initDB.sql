-- TODO: Тут лучше запихать сиквенс внутри таблицы,
--   иначе при каждом запуске у тебя будет вылетать ошибка, что sequence already exists
--   в целом SQL и прочие фреймворки с базами немаловажная вещь для бэкенда так что придется его нормально зашарить
CREATE TABLE IF NOT EXISTS products
(
    id    INTEGER PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    description VARCHAR(254) NOT NULL ,
    price BIGINT  NOT NULL
);
-- CREATE SEQUENCE products_id_seq START WITH 3 INCREMENT BY 1;