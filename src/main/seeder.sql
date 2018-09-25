DROP DATABASE IF EXISTS progression_db;
CREATE DATABASE IF NOT EXISTS progression_db;

insert into projects(id, date, description, title, owner)
  value(1, "09/24/2018", "To make a home with a great curb appeal.",
"Landscaping", 1);

insert into projects (id, date, description, title, owner)
    value (2, "09/25/2018", "Backyard place to entertain guest ", "Outdoor Patio",
2);

insert into tasks (id, description, is_complete, task_order, title,
project) value (1, "Trim shrubs, cut the grass", true, 1, "To Do's",1);

insert into tasks (id, description, is_complete, task_order, title,
project) value (2, "Bag the leaves", true, 2, "To Do's", 1);

insert into tasks (id, description, is_complete, task_order, title,
project) value (3, "Buy all the lumber", true, 1, "Supplies", 2);

insert into tasks (id, description, is_complete, task_order, title,
project) value (4, "Buy bags of cement", true, 2, "Supplies",2);

insert into tasks (id, description, is_complete, task_order, title,
project) values (5, "Buy nails and a hammer", true, 3, "Supplies",2);

insert into users (id, email, first_name, last_name, password, username)
    value (1, "john@gmail.com", "John", "Doe", "codeup", "johnDoe18");

insert into users (id, email, first_name, last_name, password, username)
    value (2, "Sally@gmail.com", "Sally", "Smith", "codeup", "sallysmith19");







