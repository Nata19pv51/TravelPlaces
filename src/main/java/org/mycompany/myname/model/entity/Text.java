package org.mycompany.myname.model.entity;

public class Text {
    final public static String TEXT_TABLE = "textnode";
    final public static String ID_NOTE = "id_note";
    final public static String TEXT = "text";

    private Note note;
    private String text;

    public Note getNote() throws Exception {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "note=" + note +
                ", text='" + text + '\'' +
                '}';
    }

    public static final class TextBuilder implements IBuilder<Text> {
        private Note note;
        private String text;

        public TextBuilder setNote(Note note){
            this.note = note;
            return this;
        }

        public TextBuilder setText(String text){
            this.text = text;
            return this;
        }

        @Override
        public Text build() {
            Text txt = new Text();
            txt.setNote(note);
            txt.setText(text);
            return txt;
        }
    }
}
