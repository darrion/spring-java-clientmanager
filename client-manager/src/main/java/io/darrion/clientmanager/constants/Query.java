package io.darrion.clientmanager.constants;

public class Query {

    private Query() {}

    public static final String FIND_CLIENT_BY_EMAIL = """
        SELECT
        c.id AS id,
        c.first_name AS first_name,
        c.middle_name AS middle_name,
        c.last_name AS last_name,
        c.email AS email,
        c.created_at AS created_at,
        c.updated_at AS updated_at
        FROM clients c WHERE email=?1
        """; 

    public static final String FIND_ADVISOR_BY_EMAIL = """
        SELECT
        a.id AS id,
        a.first_name AS first_name,
        a.middle_name AS middle_name,
        a.last_name AS last_name,
        a.email AS email,
        a.created_at AS created_at,
        a.updated_at AS updated_at
        FROM advisors a WHERE email=?1
        """;

    public static final String FIND_CLIENTS_BY_ADVISOR_ID = """
        SELECT
        c.id AS id,
        c.first_name AS first_name,
        c.middle_name AS middle_name,
        c.last_name AS last_name,
        c.email AS email,
        c.created_at AS created_at,
        c.updated_at AS updated_at
        FROM clients c WHERE advisor_id=?1
        """;
    }
