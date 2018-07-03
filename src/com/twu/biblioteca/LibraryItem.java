package com.twu.biblioteca;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by Kai on 7/2/2018.
 */
public class LibraryItem {

    private boolean checkedOut;
    private GregorianCalendar dueDate;
    private Materials type;
    private UUID id;


    public LibraryItem(Materials type){
        this.type = type;
        checkedOut = false;
        dueDate = new GregorianCalendar();
        id = UUID.randomUUID();

    }
    public boolean isCheckedout() {
        return this.checkedOut;
    }

    public GregorianCalendar getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(GregorianCalendar date){
        this.dueDate = date;
    }

    public Materials getType() {
        return this.type;
    }

    public UUID getID() {
        return this.id;
    }

    public void changeID(UUID id){
        this.id = id;
    }
}
