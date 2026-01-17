package com.github.kevinnowak;

import java.util.NoSuchElementException;

public class LinkedListAddressBook {

    private LinkedListFeu personList;

    public LinkedListAddressBook() {
        personList = new LinkedListFeu();
    }

    public void addPerson(Person p) {
        personList.addLast(p);
    }

    public Person getPersonByLastName(String lastName) {
        LinkedListFeu.ListIterator iterator = personList.listIterator();

        while (iterator.hasNext()) {
            Person p = iterator.next();

            if (p.lastName().equals(lastName)) {
                return p;
            }
        }

        throw new NoSuchElementException();
    }
}
