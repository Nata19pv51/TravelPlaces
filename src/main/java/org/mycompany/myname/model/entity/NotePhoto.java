package org.mycompany.myname.model.entity;

public class NotePhoto {
    private Note note;
    private String url;

    public NotePhoto() {
    }

    public NotePhoto(Note note, String url) {
        this.note = note;
        this.url = url;
    }

    public Note getNote() throws Exception {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NotePhoto{" +
                "note=" + note +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class NotePhotoBuilder implements IBuilder<NotePhoto>{
        private Note note;
        private String url;

        public NotePhotoBuilder setNote(Note note){
            this.note = note;
            return this;
        }

        public NotePhotoBuilder setUrl(String url){
            this.url = url;
            return this;
        }

        @Override
        public NotePhoto build() {
            NotePhoto notePhoto = new NotePhoto();
            notePhoto.setNote(note);
            notePhoto.setUrl(url);
            return notePhoto;
        }
    }
}
