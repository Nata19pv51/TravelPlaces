package org.mycompany.myname.model.dao;

import com.google.gson.Gson;
import org.mycompany.myname.controller.FindAll;
import org.mycompany.myname.model.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class DMMain {

    static class Record {
        private int id;
        private String name;
        private String text;

        public Record(int id, String name, String text){
            this.id = id;
            this.name = name;
            this.text = text;
        }
    }

    public static void main(String[] args) {
//        List<Record> records = new ArrayList<>();
//        records.add(new Record(1, "name_1", "text_1"));
//        records.add(new Record(2, "name_2", "text_2"));
//
//        Gson gson = new Gson();
//
//        String json = gson.toJson(records);
        FindAll getAll = new FindAll();
        List<Note> noteList = getAll.getNote(1);

        String json = new Gson().toJson(noteList);

        System.out.println(json);
    }
}
