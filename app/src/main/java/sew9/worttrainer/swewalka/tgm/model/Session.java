package sew9.worttrainer.swewalka.tgm.model;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;


public class Session {

    int SID;
    JSONObject data;
    String path;

    public Session(int SID){
        this.SID = SID;
        this.path = "app/src/main/java/sew9/worttrainer/swewalka/tgm/model/sessions/" + SID + ".json";
        pull();
    }

    public void pull(){
        Path jsonFilePath = Paths.get(path);

        // Check if the file exists
        if (Files.exists(jsonFilePath)) {
            // File exists, proceed to read
            try (FileReader reader = new FileReader(jsonFilePath.toString())) {
                // Read JSON file
                JSONTokener tokener = new JSONTokener(reader);
                JSONObject jsonObject = new JSONObject(tokener);

                this.data = jsonObject;

            } catch (IOException e) {
                //TODO Throw a error message to the User with controller
            }
        } else {
            // File does not exist
            //TODO Throw a error message to the User with controller
        }
    }

    public void push(){
        // Write JSON to file
        try (FileWriter file = new FileWriter(path)) {
            file.write(data.toString());
            System.out.println("Successfully wrote JSON object to file.");
        } catch (IOException e) {
            //TODO Throw a error message to the User with controller
        }
    }

    public void init() {
        data = new JSONObject();
        data.put("wins", 0);
        data.put("losses", 0);
        data.put("currentPosition", 0);
        data.put("path",path);

        // Write JSON to file
        try (FileWriter file = new FileWriter(path)) {
            file.write(data.toString());
            System.out.println("Successfully wrote JSON object to file.");
        } catch (IOException e) {
            //TODO Throw a error message to the User with controller
        }
    }

    public void won(){
        data.put("wins",data.getInt("wins")+1);
        data.put("currentPosition",data.getInt("currentPosition")+1);
    }

    public void lost(){
        data.put("losses",data.getInt("losses")+1);
    }

    public int getWins(){
        return data.getInt("wins");
    }

    public int getLosses(){
        return data.getInt("losses");
    }

    public int getCurrent(){
        return data.getInt("currentPosition");
    }

    public void setWins(int wins){
        data.put("wins",wins);
    }

    public void setLosses(int losses){
        data.put("losses",losses);
    }

    public void setCurrent(int current){
        data.put("currentPosition",current);
    }
}

