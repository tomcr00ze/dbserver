package com.dbserver.raw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * opening + closing db files, storing records
 */
public class FileHandler {
    private RandomAccessFile dbFile;
    public FileHandler(final String dbFileName) throws FileNotFoundException { //method for opening db file
        this.dbFile = new RandomAccessFile(dbFileName, "rw"); //rw: read, write
    }
    public boolean add(String name, int age, String address, String carPlateNumber, String description) throws IOException {
        this.dbFile.seek(this.dbFile.length()); //seek to end o fifle
        //length of record
        int length = 4 +
                name.length()
                + 4
                + 4
                + address.length()
                + 4
                + carPlateNumber.length()
                + 4 + description.length();
        //store if deleted
        this.dbFile.writeBoolean(false);
        //store record length
        this.dbFile.writeInt(length);;
        //store name
        this.dbFile.writeInt(name.length());
        this.dbFile.write(name.getBytes());
        //store age
        this.dbFile.writeInt(age);
        //store address
        this.dbFile.writeInt(address.length());
        this.dbFile.write(address.getBytes());
        //store plate
        this.dbFile.writeInt(carPlateNumber.length());
        this.dbFile.write(carPlateNumber.getBytes());
        //store description
        this.dbFile.writeInt(description.length());
        this.dbFile.write(description.getBytes());
        return true;//if were able to store data
    }

    public void close() throws IOException { //for closing DB file
        this.dbFile.close();
    }
}
