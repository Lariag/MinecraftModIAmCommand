package com.alriac.iam;

import net.minecraftforge.fml.common.FMLCommonHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RODLON on 18/11/2016.
 */
public class IamLoader {

    static HashMap<String, String> LoadPlayerNames(){
        HashMap<String, String> playernames = new HashMap<String, String>();

        try {
            File myFile = FMLCommonHandler.instance().getMinecraftServerInstance().getFile("iamNames.txt");
            if(!myFile.exists()){
                myFile.createNewFile();
            }else {
                FileInputStream fstream = new FileInputStream(myFile);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                String strLine;
                while ((strLine = br.readLine()) != null) {
                    int indexSpace = strLine.indexOf(' ');
                    if (indexSpace > 1) {
                        playernames.put(strLine.substring(0, indexSpace), strLine.substring(indexSpace + 1));
                    } else {
                        continue;
                    }
                }
                br.close();
            }
        }catch(Exception e){

        }
        return playernames;
    }

    static void SavePlayerNames(HashMap<String, String> playernames){
        try {
            File myFile = FMLCommonHandler.instance().getMinecraftServerInstance().getFile("iamNames.txt");
            if(!myFile.exists()){
                myFile.createNewFile();
            }
                FileOutputStream fstream = new FileOutputStream(myFile);
                BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fstream));
            for (Map.Entry<String, String> entry : playernames.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue();
                br.write(key+" "+value+"\n\r");
            }
                br.close();

        }catch(Exception e){

        }
    }
}
