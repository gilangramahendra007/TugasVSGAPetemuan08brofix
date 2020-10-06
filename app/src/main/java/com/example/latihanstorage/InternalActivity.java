package com.example.latihanstorage;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String FILENAME="namafile.txt";
    Button buatFile, ubahFile, bacaFile, deleteFile, clearFile;
    TextView textBaca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        buatFile=findViewById(R.id.buttonBuatFile);
        ubahFile=findViewById(R.id.buttonUbahFile);
        bacaFile=findViewById(R.id.buttonBacaFile);
        deleteFile=findViewById(R.id.buttonHapusFile);
        clearFile=findViewById(R.id.buttonClearFile);
        textBaca=findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
        clearFile.setOnClickListener(this);

    }
    void buatFile(){

        String isiFile ="Testing buat file Zilan Entertainment Management";
        File file=new File(getFilesDir(), FILENAME);
        FileOutputStream outputStream = null;
        try{
            file.createNewFile();
            //boolean append = true;
            //outputStream = new FileOutputStream (file, append);
            boolean append;
            outputStream = new FileOutputStream (file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
            Toast.makeText(InternalActivity.this, "File wis digawe jenengane:"+isiFile, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void hapusFile(){
        File file=new File(getFilesDir(), FILENAME);
        if(file.exists()){
            file.delete();
            //Context context;
            //Text text;
            //Toast.makeText(context:this, text: "File terhapus yay!", Toast.LENGTH_LONG).show();
            Toast.makeText(InternalActivity.this, "File wis mbok apus bambank!", Toast.LENGTH_LONG).show();
        }
    }
    void clearFile(){
        textBaca.setText("");
        Toast.makeText(InternalActivity.this, "Text View wis diclear mbalek neng awal", Toast.LENGTH_LONG).show();
    }

    public void show() {
    }

    public void setOnClick(View v) { jalankanPerintah(v.getId()); }

    public void jalankanPerintah(int id){
        switch(id){
            case R.id.buttonBuatFile:
                buatFile();
                break;
            case R.id.buttonBacaFile:
                bacaFile();
                break;
            case R.id.buttonUbahFile:
                ubahFile();
                break;
            case R.id.buttonHapusFile:
                hapusFile();
                break;
            case R.id.buttonClearFile:
                clearFile();
                break;
        }
    }

    public void ubahFile() {
        String ubah = "Update Testing Gilang Rama Hendra Founder Zilan Entertainment Managemement";
        File file = new File(getFilesDir(), FILENAME );
        FileOutputStream outputStream = null ;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubah.getBytes());
            outputStream.flush();
            outputStream.close();
            Toast.makeText(InternalActivity.this, "File wis diubah jenengane:"+ubah, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void bacaFile() {
        //File sdcard = Environment.getExternalStorageDirectory();
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);

        if(file.exists()){
            StringBuilder text = new StringBuilder();
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while (line!=null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
                Toast.makeText(InternalActivity.this, "Mboco file teko direcktory:"+file, Toast.LENGTH_LONG).show();
            } catch (IOException e){
                System.out.println("Error gaess"+ e.getMessage());
            }
            textBaca.setText(text.toString());
        }else {
            Toast.makeText(InternalActivity.this, "Hurung ono file e, mbok digawe ndisik ning menu BUAT FILE!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        jalankanPerintah(v.getId());
    }
}