package com.example.notekeeper;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {

    static DataManager sDataManager;
    @BeforeClass
    public static void classSetup() {
        sDataManager = DataManager.getInstance();
    }

    @Before
    public void setUp() {

        sDataManager.getNotes().clear();
        sDataManager.initializeExampleNotes();
    }
    @Test
    public void createNewNote() {


        final CourseInfo course = sDataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my note";

        int noteIndex = sDataManager.createNewNote();
        NoteInfo newNote = sDataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTitle, compareNote.getTitle());
        assertEquals(noteText,
                compareNote.getText());
    }

    @Test
    public void createNewNoteOneStepCreation() {

        final CourseInfo course = sDataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body of the test note";


        int noteIndex = sDataManager.createNewNote(course, noteTitle, noteText);

        NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTitle, compareNote.getTitle());
        assertEquals(noteText, compareNote.getText());
    }
}