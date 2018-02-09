package org.mycompany.myname.model.entity;

public class Coordinate {
    final public static String COORDINATE_TABLE = "coordinate";
    final public static String ID_NOTE = "id_note";
    final public static String CORDINATE = "coordinate";

    private Note note;
    private double coordinate;

    public Note getNote() throws Exception  {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "note=" + note +
                ", coordinate=" + coordinate +
                '}';
    }


//    Coordinate Builder
    public static final class CoordinateBuilder implements IBuilder<Coordinate>{
        private Note note;
        private double coordinate;

        public CoordinateBuilder setNote(Note note) {
            this.note = note;
            return this;
        }

        public CoordinateBuilder setCoordinate(double coordinate){
            this.coordinate = coordinate;
            return this;
        }

        public Coordinate build(){
            Coordinate coordinatePoint = new Coordinate();
            coordinatePoint.setNote(note);
            coordinatePoint.setCoordinate(coordinate);
            return coordinatePoint;
        }
    }
}
