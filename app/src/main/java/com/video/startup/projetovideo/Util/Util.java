package com.video.startup.projetovideo.Util;

import com.video.startup.projetovideo.Models.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Diogo on 24/04/2017.
 */

public class Util {


    public static String convertUsuariotoJSON(Usuario usuario){
        JSONObject mainObject = new JSONObject();
        try {
            mainObject.put("login",usuario.getLogin());
            mainObject.put("senha",usuario.getSenha());
            mainObject.put("nome",usuario.getNome());
            mainObject.put("email",usuario.getEmail());
            mainObject.put("telefone",usuario.getTelefone());

            return mainObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String webToString(InputStream inputStream) {
        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localString;
    }



}
