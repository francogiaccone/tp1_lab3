package com.example.tp1_lab3.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tp1_lab3.models.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("datos", 0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("dni",(usuario.getDni()));
        editor.putString("apellido",usuario.getApellido());
        editor.putString("nombre",usuario.getNombre());
        editor.putString("email",usuario.getEmail());
        editor.putString("contrasena",usuario.getContrasena());
        editor.commit();
    }

    public static Usuario leer(Context context){
        SharedPreferences sp = conectar(context);
        String dni = sp.getString("dni","-1");
        String apellido = sp.getString("apellido","-1");
        String nombre = sp.getString("nombre","-1");
        String email = sp.getString("email","-1");
        String contrasena = sp.getString("contrasena","-1");

        return new Usuario(dni, nombre, apellido, email, contrasena);
    }

    public static Usuario login(Context context, String mail, String password){
        SharedPreferences sp = conectar(context);
        String dni = sp.getString("dni","-1");
        String apellido = sp.getString("apellido","-1");
        String nombre = sp.getString("nombre","-1");
        String email = sp.getString("email","-1");
        String contrasena = sp.getString("contrasena","-1");

        if (email.equals(mail) && contrasena.equals(password)){
            return new Usuario(dni, nombre, apellido, email, contrasena);
        }

        return null;
    }
}
