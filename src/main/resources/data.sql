INSERT INTO
  departments(department)
VALUES('office');
INSERT INTO
    departments(department)
VALUES('remote');

INSERT INTO
  workers(first_name, last_name, department_id)
VALUES('ivan', 'ivanov', 1);
INSERT INTO
    workers(first_name, last_name, department_id)
VALUES('petr', 'petrov', 1);
INSERT INTO
    workers(first_name, last_name, department_id)
VALUES('dmitry', 'dmitryev', 2);

INSERT INTO
  hours(worker_id, start_time, end_time)
  VALUES (1, 8, 16);
INSERT INTO
    hours(worker_id, start_time, end_time)
  VALUES (1, 9, 17);
INSERT INTO
    hours(worker_id, start_time, end_time)
  VALUES (2, 9, 17);
INSERT INTO
    hours(worker_id, start_time, end_time)
  VALUES (3, 9, 17);
