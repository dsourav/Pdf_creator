package com.example.lenovo.pdf_creator;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText et,et2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et= (EditText) findViewById(R.id.editText);
        et2= (EditText) findViewById(R.id.editText2);
        btn= (Button) findViewById(R.id.button);
    }
    public void click(View view)  {
        try {
            write(et.getText().toString(),et2.getText().toString());
            Toast.makeText(this, "pdf created", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Boolean write(String fname, String fcontent) throws IOException {
        try {
            String fpath = "/sdcard/" + fname + ".pdf";
            File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
// step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsoluteFile()));
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph(fcontent));
            // step 5
            document.close();
            Log.d("Suceess", "Sucess");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

}
