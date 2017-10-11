package Ex;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class User3 {
    private int id;
    private String email;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return this.id + " " + this.email + " " + this.password;
    }

    public void serializaeXml(String user3_xmlFile) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(user3_xmlFile);
        XMLEncoder encode = new XMLEncoder(fos);
        encode.writeObject(this);
        encode.close();
    }

    public static User3 deserializaeXml(String user3_xmlFile) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(user3_xmlFile);
        XMLDecoder decode = new XMLDecoder(fis);
        User3 user3 = (User3) decode.readObject();
        return user3;
    }
}