INSERT INTO client (name) VALUES
                              ('Alice'),
                              ('Bob'),
                              ('Charlie'),
                              ('David'),
                              ('Eve'),
                              ('Frank'),
                              ('Grace'),
                              ('Heidi'),
                              ('Ivan'),
                              ('Judy');

INSERT INTO planet (id, name) VALUES
                                  ('MARS', 'Mars'),
                                  ('VEN', 'Venus'),
                                  ('EARTH', 'Earth'),
                                  ('JUP', 'Jupiter'),
                                  ('SAT', 'Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                             (NOW(), 1, 'EARTH', 'MARS'),
                                                                             (NOW(), 2, 'MARS', 'VEN'),
                                                                             (NOW(), 3, 'VEN', 'EARTH'),
                                                                             (NOW(), 4, 'JUP', 'SAT'),
                                                                             (NOW(), 5, 'SAT', 'JUP'),
                                                                             (NOW(), 6, 'EARTH', 'MARS'),
                                                                             (NOW(), 7, 'MARS', 'VEN'),
                                                                             (NOW(), 8, 'VEN', 'EARTH'),
                                                                             (NOW(), 9, 'JUP', 'SAT'),
                                                                             (NOW(), 10, 'SAT', 'JUP');