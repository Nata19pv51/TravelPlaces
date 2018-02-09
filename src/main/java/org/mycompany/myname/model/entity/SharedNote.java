package org.mycompany.myname.model.entity;

public class SharedNote {
    final public static String SHARED_NOTE_TABLE = "SharedNode";
    final public static String ID_USER = "id_user";
    final public static String ID_NOTE = "id_note";

    private User receiver;
    private Note note;

    public User getReceiver() throws Exception {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Note getNote() throws Exception {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public static final class SharedNoteBuilder implements IBuilder<SharedNote>{
        private User receiver;
        private Note note;

        public SharedNoteBuilder setReceiver(User receiver){
            this.receiver = receiver;
            return this;
        }

        public SharedNoteBuilder setNote(Note note){
            this.note = note;
            return this;
        }

        @Override
        public String toString() {
            return "SharedNoteBuilder{" +
                    "receiver=" + receiver +
                    ", note=" + note +
                    '}';
        }

        @Override
        public SharedNote build() {
            SharedNote sharedNote = new SharedNote();
            sharedNote.setReceiver(receiver);
            sharedNote.setNote(note);
            return sharedNote;
        }
    }
}
