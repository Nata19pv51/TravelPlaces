package org.mycompany.myname.model.entity;

public class DisplayNote {
    final public static String NOTE_TABLE = "note";
    final public static String TEXT_TABLE = "textnode";
    final public static String COORDINATE_TABLE = "coordinate";

    final public static String ID_NOTE = "id_note";
    final public static String CORDINATE = "coordinate";
    final public static String DATE_CREATION = "dateCreation";
    final public static String ID_USER = "id_user";
    final public static String TEXT = "text";

    private int noteId;
    private long time;
    private int userId;
    private String text;
    private double coordination;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getCoordination() {
        return coordination;
    }

    public void setCoordination(double coordination) {
        this.coordination = coordination;
    }

}
