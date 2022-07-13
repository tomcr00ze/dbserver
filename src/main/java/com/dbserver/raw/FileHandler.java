package com.dbserver.raw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * currently, just for opening and closing database files
 */
public class FileHandler {
    private RandomAccessFile dbFile;
    public FileHandler(final String dbFileName) throws FileNotFoundException { //method for opening db file
        this.dbFile = new RandomAccessFile(dbFileName, "rw"); //rw: read, write
    }
    public boolean add(String name, int age, String address, String carPlateNumber, String description) throws IOException {
        this.dbFile.seek(this.dbFile.length());
    }

    public void close() throws IOException { //for closing DB file
        this.dbFile.close();
    }
}
