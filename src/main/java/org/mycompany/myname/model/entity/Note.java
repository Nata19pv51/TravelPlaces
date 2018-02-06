package org.mycompany.myname.model.entity;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Note {
    private int idNote;
    private Date dateCreation;
    private User user;


    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public User getUser() throws Exception {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Note{" +
                "idNote=" + idNote +
                ", dateCreation=" + dateCreation +
                ", user=" + user +
                '}';
    }

    public static final class NoteBuilder implements IBuilder<Note>{
        private int idNote;
        private Date dateCreation;
        private User user;

        public NoteBuilder setIdNote(int idNote){
            this.idNote = idNote;
            return this;
        }

        public NoteBuilder setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            return this;
        }

        public NoteBuilder setUser(User user){
            this.user = user;
            return this;
        }
        @Override
        public Note build() {
            Note note = new Note();
            note.setIdNote(idNote);
            note.setDateCreation(dateCreation);
            note.setUser(user);
            return note;
        }
    }
}
