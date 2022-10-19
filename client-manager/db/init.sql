CREATE TABLE IF NOT EXISTS advisors (
    id serial PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL, 
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS clients (
    id serial PRIMARY KEY,
    advisor_id INT,
    first_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL, 
    updated_at TIMESTAMP, 
    CONSTRAINT fk_advisor
        FOREIGN KEY (advisor_id)
            REFERENCES advisors(id)
);

CREATE TABLE IF NOT EXISTS specializations (
    id serial PRIMARY KEY, 
    focus VARCHAR(100) NOT NULL, 
    advisor_id INT NOT NULL, 
    CONSTRAINT fk_advisor  
        FOREIGN KEY (advisor_id)
            REFERENCES advisors(id)
);
