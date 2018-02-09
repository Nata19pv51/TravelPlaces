package org.mycompany.myname.model.entity;

public class RouteNote {
    final public static String ROUTENOTE_TABLE = "routeNote";
    final public static String ID_ROUTE = "id_route";
    final public static String ID_NOTE = "id_note";

    private Route route;
    private Note note;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public static final class RouteNoteBuilder implements IBuilder<RouteNote>{
        private Route route;
        private Note note;

        public RouteNoteBuilder setRoute(Route route){
            this.route = route;
            return this;
        }

        public RouteNoteBuilder setNote(Note note){
            this.note = note;
            return this;
        }

        @Override
        public RouteNote build() {
            RouteNote routeNote = new RouteNote();
            routeNote.setRoute(route);
            routeNote.setNote(note);
            return routeNote;
        }
    }
}
