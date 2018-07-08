package com.twu.biblioteca.com.twu.biblioteca.items;

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
    private String name;


    public LibraryItem(Materials type, String name){
        this.type = type;
        checkedOut = false;
        dueDate = new GregorianCalendar();
        id = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    public String getCheckoutID(){
        String id = this.id.toString();
        String[] values = id.split("-");
        return values[0];
    }

    public void changeID(UUID id){
        this.id = id;
    }

    public void checkin(){
        this.checkedOut = false;
        this.dueDate = new GregorianCalendar();
    }

    public void checkoutItem(){
        this.checkedOut = true;
    }
}
