INSERT INTO question_type (id, name) VALUES
    (gen_random_uuid()::text, 'Data Structures & Algorithms'),
    (gen_random_uuid()::text, 'Web Development'),
    (gen_random_uuid()::text, 'Databases & SQL'),
    (gen_random_uuid()::text, 'Operating Systems'),
    (gen_random_uuid()::text, 'Networking & Security'),
    (gen_random_uuid()::text, 'Software Design & Architecture'),
    (gen_random_uuid()::text, 'Programming Languages & Paradigms'),
    (gen_random_uuid()::text, 'DevOps & Cloud Computing')
ON CONFLICT (name) DO NOTHING;
