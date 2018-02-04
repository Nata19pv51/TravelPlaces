package org.mycompany.myname.constants;

import javax.print.DocFlavor;

public interface TableParameters {

    interface User{
        String ID_USER = "id_user";
        String LOGIN = "login";
        String PASSWORD = "password";
        String EMAIL = "email";
        String COUNTRY = "country";
    }

    interface Text{
        String ID_NOTE = "id_note";
        String TEXT = "text";
    }

    interface Coordinate{
        String ID_NOTE = "id_note";
        String CORDINATE = "coordinate";
    }

    interface Note{
        String ID_NOTE = "id_note";
        String DATE_CREATION = "dateCreation";
        String ID_USER = "id_user";
    }

    interface Photo{
        String ID_NOTE = "id_note";
        String URL_PHOTO = "url_photo";
    }

    interface Route{
        String ID_ROUTE = "id_route";
        String NAME = "name";
        String DATE_CREATION = "dateCreation";
        String ID_USER = "id_user";
    }

    interface RouteNote{
        String ID_ROUTE = "id_route";
        String ID_NOTE = "id_note";
    }

    interface SharedNote{
        String ID_USER = "id_user";
        String ID_NOTE = "id_note";
    }

    interface SharedRoute{
        String ID_USER = "id_user";
        String ID_ROUTE = "id_route";
    }
}
