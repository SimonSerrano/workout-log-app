CREATE TABLE exercises (
    version integer,
    created_at timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name character varying(200) NOT NULL,
    CONSTRAINT exercises_pkey PRIMARY KEY (name)
);

CREATE TABLE logs (
    version integer,
    created_at timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id uuid NOT NULL,
    name character varying(200) NOT NULL,
    CONSTRAINT logs_pkey PRIMARY KEY (id)
);

CREATE TABLE sets (
    reps integer NOT NULL,
    version integer,
    created_at timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    updated_at timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT sets_reps_check CHECK ((reps >= 1)),
    CONSTRAINT sets_pkey PRIMARY KEY (id)
);


CREATE TABLE trained_exercises (
    version integer,
    created_at timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    updated_at timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    log_id uuid,
    exercise_name character varying(255),
    CONSTRAINT trained_exercises_pkey PRIMARY KEY (id),
    CONSTRAINT trained_exercises_log_fk FOREIGN KEY (log_id) REFERENCES logs(id),
    CONSTRAINT trained_exercises_exercise_fk FOREIGN KEY (exercise_name) REFERENCES exercises(name)
);

CREATE TABLE trained_exercises_sets (
    sets_id bigint NOT NULL,
    trained_exercise_entity_id bigint NOT NULL,
    CONSTRAINT trained_exercises_sets_set_fk FOREIGN KEY (sets_id) REFERENCES sets(id),
    CONSTRAINT trained_exercises_sets_trained_fk FOREIGN KEY (trained_exercise_entity_id) REFERENCES trained_exercises(id),
    CONSTRAINT trained_exercises_sets_sets_id_key UNIQUE (sets_id)
);
